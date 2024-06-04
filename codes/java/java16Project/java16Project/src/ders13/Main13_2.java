package ders13;

public class Main13_2 {
    public static void main(String[] args) {

      Car kia=new Car();
      kia.color="red";
      kia.price=20;

        Car ford=new Car();
        ford.color="red";
        ford.price=20;

String s="";
        System.out.println(kia.equals(s));
        ford=kia;
System.gc();

    }

}
