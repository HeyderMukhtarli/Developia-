package az.developia.springjava16;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my-controller")
public class MyController {

    @GetMapping("/home")
    public Book sfkldjkjsdl(@RequestParam(name="sorgu",required = false,defaultValue = "Hasan") String sorgu){

        return new Book(10,sorgu);
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