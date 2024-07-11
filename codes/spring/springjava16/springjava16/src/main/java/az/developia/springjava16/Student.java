package az.developia.springjava16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {
    private String name;
    private int age;

     @Autowired
      // @Qualifier(value = "computer")
    private   Computer computer;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Student(){
        name="Adil";
        age=30;
    }


    public Computer getComputer() {
        return computer;
    }


    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
