package az.developia.springjava16;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class YourController {

	@Autowired
	private StudentRepo repo;

	@GetMapping("/home")
	public Book sfkldjkjsdl() {
		return new Book(10, "java");
	}

	@GetMapping("/save/{id}")
	public Student saveStudent(@PathVariable Long id) {

		Student s = new Student("Adil33", "Adilov33");

		repo.save(s);

		Optional<Student> result = repo.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new OurException("telebe tpilmadi id = " + id, "student not found");
		}

	}

	@ExceptionHandler
	public ErrorResponse handleOurException(OurException exc) {
		ErrorResponse resp = new ErrorResponse();
		resp.setMessage(exc.getMessage());
		resp.setInternalMessage(exc.getInternalMessage());
		return resp;
	}

	@GetMapping("/search")
	public List<Student> search(@RequestParam(name = "q") String q) {
		List<Student> students = repo.findSearch(q);
		return students;

	}

}
