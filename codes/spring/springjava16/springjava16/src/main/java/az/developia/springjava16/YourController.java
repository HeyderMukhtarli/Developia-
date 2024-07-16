package az.developia.springjava16;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/your-controller")
public class YourController {

    @GetMapping("/home")
    public Book sfkldjkjsdl(){
        return new Book(10,"java");
    }

}
