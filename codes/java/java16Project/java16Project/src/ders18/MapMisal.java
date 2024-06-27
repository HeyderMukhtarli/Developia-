package ders18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class MapMisal {
    public static void main(String[] args) {
        ArrayList<String> siyahi=new ArrayList<>();
        siyahi.add("Aysu");
        siyahi.add("Inqlab");
        siyahi.add("Emrah");
        siyahi.add("Aysu");
        siyahi.add("Mezahir");
        siyahi.add("Anar");
        siyahi.add("Ulker");
        siyahi.add("Aysu");
        siyahi.add("Emrah");

        TreeMap<String,Integer> adlar=
                new TreeMap<>();

        for (String ad:siyahi) {
            if(adlar.containsKey(ad)){
                Integer say=adlar.get(ad);
                say++;
                adlar.replace(ad,say);
            }else{
                adlar.put(ad,1);
            }
        }
        System.out.println(adlar);
    }
}
