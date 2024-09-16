package Ders3;

public class Casting {
    public static void main(String[] args) {
        short k=200;
        byte t=(byte) k;
        System.out.println(t);  //overflow  -56

        short a=-130;
        byte b=(byte) a;
        System.out.println(b);  //underflow  126
    }
}
