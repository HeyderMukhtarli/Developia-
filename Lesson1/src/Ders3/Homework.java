package Ders3;
import static org.junit.Assert.*;
public class Homework {
    public static void main(String[] args) {
//        int a=10;
//        int b=7;
//        if(++a ==11 || ++b>7){
//            System.out.println(true);
//        }else if(a==10){
//            System.out.println("10");
//        }else {
//            System.out.println("false");
//        }
//        System.out.println(b);
        int c=60;    //0011 1100
        int d=13;    //0000 1101


        String binaryString = Integer.toBinaryString(c);
        System.out.println("Binary representation of " + c + " is: " + binaryString);
        String binaryString2 = Integer.toBinaryString(d);
        System.out.println("Binary representation of " + d + " is: " + binaryString2);
        int f=c|d;   // 0011 1101
        String binaryString3 = Integer.toBinaryString(f);
        System.out.println("Binary representation of " + f + " is: " + binaryString3);

    }



}
