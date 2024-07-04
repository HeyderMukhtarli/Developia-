package ders_21;

import java.util.ArrayList;

public class MainRunner2 {
    public static void main(String[] args) {

         metod1((g)->  System.out.println("edirem nese"+g));


    }

    static void metod1(Doable doable){
        doable.doIt(3);
    }


}
