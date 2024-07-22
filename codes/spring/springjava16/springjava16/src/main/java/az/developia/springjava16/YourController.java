package az.developia.springjava16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/your-controller")
public class YourController {

    @Autowired
    private StudentRepo repo;



    @GetMapping("/home")
    public Book sfkldjkjsdl(){
        return new Book(10,"java");
    }

    @GetMapping("/save")
    public List<Student> saveStudent(){

        Student s=new Student("Adil","Adilov");
        repo.save(s);
       return repo.findAll();
    }


}
