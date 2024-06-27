package ders18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MainLazimsizMaybe2 {
    public static void main(String[] args) {
        ArrayList<String> meyveler = new ArrayList<>();
        // diamond syntax
        meyveler.add("Nar");
        meyveler.add("Alma");
        meyveler.add("Armud");


        System.out.println(meyveler);
        Collections.sort(meyveler);
        System.out.println(meyveler);
       int index= Collections.binarySearch(meyveler,"Alma");
        System.out.println(index);
        Collections.shuffle(meyveler);
        System.out.println(meyveler);

    }
}
