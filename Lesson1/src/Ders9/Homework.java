package Ders9;

import java.util.Arrays;

public class Homework {
    public static void main(String[] args) {

        String name="Meherrem";
        System.out.println(name);
        String message="Java dilini oyrenmek Maraqlidir";
        System.out.println(message);
        System.out.println(message.length());
        System.out.println(message.charAt(7));
        System.out.println(message.indexOf('n'));
        System.out.println(message.toLowerCase());
        System.out.println(message.toUpperCase());
        System.out.println(message.contains("n"));
        System.out.println(message.endsWith("r"));
        System.out.println(message.startsWith("r"));
        message="  Ayxan  ";
        System.out.println(message.trim());
        message="Kamil";
        System.out.println(message.substring(0,4));
        message="Huseyn Mehdizade";
        System.out.println(Arrays.toString(message.split(" ")));

    }
}
