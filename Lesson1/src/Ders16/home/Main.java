package Ders16.home;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hawk");
        list.add("robin");
        Object[] objectArray = list.toArray();
        String[] stringArray = list.toArray(new String[5]);
        list.clear();
        System.out.println(objectArray.length);
        System.out.println(stringArray.length);


        TreeSet<Integer> s=new TreeSet<>();
        s.add(1);
        s.add(3);
        s.add(2);
        s.add(12);
        s.add(14);
        s.add(3);
        System.out.println(s);
    }
}
