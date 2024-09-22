package az.developia.springjava16.repository;

import az.developia.springjava16.entity.BookSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Repository
public class RedisSearchRepository {
    private final RedisTemplate<String, Object> template;
    private final HashOperations<String, String, BookSearch> hashOps;
    private final ListOperations<String, Object> listOps;  // Use String for keys

    @Autowired
    public RedisSearchRepository(RedisTemplate<String, Object> template) {
        this.template = template;
        this.hashOps = template.opsForHash();
        this.listOps = template.opsForList();  // Correctly set as ListOperations<String, String>
    }

    public BookSearch saveSearch(BookSearch bookSearch) {
        String key = "BookSearch";

        // Check if the search already exists
        List<BookSearch> existingSearches = getLatestSearches();
        if (!existingSearches.stream().anyMatch(existing -> existing.getSearch().equals(bookSearch.getSearch()))) {
            // Generate a new key for the search
            String searchKey = UUID.randomUUID().toString();

            // Add new search to hash
            hashOps.put(key, searchKey, bookSearch);
            // Add the search key to the list for ordering
            listOps.leftPush("BookSearchOrder", searchKey);
            System.out.println("Saved search: " + bookSearch);

            // Trim the list to a maximum of 7 entries
            trimSearches();
        } else {
            System.out.println("Search already exists: " + bookSearch.getSearch());
        }

        return bookSearch;
    }

    private void trimSearches() {
        while (listOps.size("BookSearchOrder") > 7) {
            // Remove the oldest entry
           Object oldestKey = listOps.rightPop("BookSearchOrder");
            if (oldestKey != null) {
                hashOps.delete("BookSearch", oldestKey);
                System.out.println("Removed oldest search: " + oldestKey);
            }
        }
        System.out.println("Current count after trimming: " + listOps.size("BookSearchOrder"));
    }

    public List<BookSearch> getLatestSearches() {
        System.out.println("Fetching latest searches...");
        List<BookSearch> objects = hashOps.values("BookSearch");

        List<BookSearch> bookSearches = new ArrayList<>();
        for (Object obj : objects) {
            if (obj instanceof BookSearch) {
                bookSearches.add((BookSearch) obj);
            } else {
                System.out.println("Unexpected object type: " + obj.getClass());
            }
        }
        return bookSearches;
    }
}
