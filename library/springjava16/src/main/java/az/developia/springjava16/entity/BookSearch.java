package az.developia.springjava16.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("BookSearch")
public class BookSearch implements Serializable {

@Id
private int id;
	private String search;

	public BookSearch(String search) {
		this.search = search;
	}
}
