package az.developia.springjava16;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentRepo extends JpaRepository<Student, Long> {

	@Query(value = "select * from students where name like %?1%", nativeQuery = true)
	public List<Student> findSearch(String name);

	public List<Student> findAllByName(String name);

}
