package ders18;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class KolleksiyalarGirisSet {
    public static void main(String[] args) {

        HashSet<Integer> set=new HashSet<>();
        set.add(34);
        set.add(31);
        set.add(38);
        set.add(34);
        System.out.println(set);

        TreeSet<String> treeSet=new TreeSet<String>();
        treeSet.add("Alma");
        treeSet.add("Armud");
        treeSet.add("Alma");
        System.out.println(treeSet);


         ArrayList<Integer> list=new ArrayList<>();
         list.add(2);
         list.add(22);
         list.add(25);
         list.add(26);
         list.add(2);
        System.out.println(list);
        Integer i=26;
        list.remove(i);
        System.out.println(list);
    }
}
