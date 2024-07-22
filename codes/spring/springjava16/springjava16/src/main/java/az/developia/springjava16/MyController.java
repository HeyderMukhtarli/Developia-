package az.developia.springjava16;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/my-controller")
public class MyController {

    @GetMapping("/home")
    public Book sfkldjkjsdl(@RequestParam(name="sorgu",required = false,defaultValue = "Hasan")

                                String sorgu){

        return new Book(10,sorgu);
    }


    @GetMapping( value = "/search")
    public List<Student> search(@RequestParam(name="sorgu",required = false,defaultValue = "Hasan")

                            String sorgu){
List<Student> students=List.of(
        new Student("Ad1","Soyad1"),
        new Student("Ad2","Soyad2"),
        new Student("Ad3","Soyad3")
);
// jackson
        List<Student> studentsFiltered= students.stream().filter(s->s.getName().contains(sorgu))
                .collect(Collectors.toList());

        return studentsFiltered;
    }

}

class Book{
    int price;
    String name;

    public Book(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}