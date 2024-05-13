package ders7;

public class Car {
    static {
        System.out.println("static 1");
    }
    static {
        System.out.println("static 2");
    }

    {
        System.out.println("adi 1");
    }

    {
        System.out.println("adi 2");
    }
}
