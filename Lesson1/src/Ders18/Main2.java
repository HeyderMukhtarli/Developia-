package Ders18;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Main2 {
    public static void main(String[] args) {
        Person p1=new Person(1,"Heyder","Muxtarli","17");
        Person p2=new Person(2,"test","test","20");
        Person p3=new Person(3,"test2","test2","23");
        List<Person> people=new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.stream().filter(x->Integer.parseInt(x.age)>18).forEach(System.out::println);
        OptionalDouble average=people.stream().mapToInt(x->Integer.parseInt(x.age)).average();
        System.out.println(average);
        int sum=people.stream().filter(x->Integer.parseInt(x.age)>18).mapToInt(x->Integer.parseInt(x.age)).sum();
        System.out.println(sum);

    }
}
