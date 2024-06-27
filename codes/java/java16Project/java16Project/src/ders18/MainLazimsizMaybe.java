package ders18;

import java.util.ArrayList;
import java.util.Iterator;

public class MainLazimsizMaybe {
    public static void main(String[] args) {
        ArrayList<String> meyveler = new ArrayList<>();
        // diamond syntax
        meyveler.add("Alma");
        meyveler.add("Armud");
        meyveler.add("Nar");

        System.out.println(meyveler);

        Iterator<String> iterator=meyveler.iterator();

        while(iterator.hasNext()){
            String novbeti=iterator.next();
            if(novbeti.startsWith("A")){
                iterator.remove();
            }

        }
        System.out.println(meyveler);


    }
}
