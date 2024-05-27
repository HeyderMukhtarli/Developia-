package ders10;

public class Main10 {
    public static void main(String[] args) {
        String a=",";
        String b=".";
        System.out.println(a.compareTo(b));

        System.out.println((short)',');
        System.out.println((short)'.');

        for (int i = 1; i <10000; i++) {
            System.out.println(i+" - "+(char)i);
        }
    }
}
