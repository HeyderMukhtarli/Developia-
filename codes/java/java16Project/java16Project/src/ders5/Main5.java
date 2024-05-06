package ders5;

public class Main5 {
    public static void main(String[] args) {
/*
        // local vars
          int a=3;
        // System.out.println(a);
        a=5;



        bmw.price=20_000;
        bmw.maxSpeed=300;
        bmw.model="X34";
        //bmw.start();
        System.out.println(bmw.speed);
*/
        Car bmw=new Car(15);

        Car kia=new Car();
        kia.model="RIO";
        kia.maxSpeed=220;
        kia.price=12_000;
        kia.start(30);

        bmw=kia;

       kia.model="nese";
        System.out.println(bmw.model);




    }
}

class Person{

}
