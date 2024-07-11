package az.developia.springjava16;

import org.springframework.stereotype.Component;

@Component
// computer
public class Computer {
    private  int price;
    private String brand;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Computer(){
        brand="dell";
        price=200;
    }
}
