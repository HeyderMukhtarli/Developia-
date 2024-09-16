package Ders16.home;

import java.util.*;

public class Homework {
    public static void main(String[] args) {
//        Queue<String> q=new LinkedList<>();
//        q.add("a");
//        q.add("b");
//        q.add("c");
//        q.add("s");
//        System.out.println(q);
//        q.poll();
//        q.poll();
//        System.out.println(q);
        ///////////////////////////////////
//        ArrayList<String> al=new ArrayList<>();
//        al.add("s");
//        al.add("f");
//        al.add("s");
//        for(String s:al){
//            System.out.println(s);
//        }
//        al.remove(0);
//        System.out.println("check"+   al.contains(new String("w")));
//        System.out.println(al);
        //////////////////////////////////
//        PriorityQueue<Integer> pq=new PriorityQueue<>();
//        pq.add(1);
//        pq.add(5);
//        pq.add(3);
//        pq.add(7);
//        pq.add(2);
//        System.out.println(pq);
//        pq.remove();
//        pq.remove();
//        System.out.println(pq);
        ///////////////////////////////////////////
//        HashMap<String,String> hm=new HashMap<>();
//        HashMap<String,String> hm2=new HashMap<>();
//        HashSet<String> hset=new HashSet<>();
//        hm.put("Azerbaycan","Baku");
//        hm.put("TUrkey","Ankara");
//        System.out.println(hm);
//        System.out.println(hm.get("Azerbaycan"));
//        HashSet<Map.Entry<String,String>> hashSet=new HashSet<>();
//        for(Map.Entry<String,String> map:hm.entrySet()){
//            hashSet.add(map);
////            if(map.getKey().startsWith("A")){
////                hm2.put(map.getKey(),map.getValue());
////        }
//            hset.add(map.getKey());
//        }
//        System.out.println(hashSet);


//        System.out.println(hset);
//
//            System.out.println(hm2);
        ////////////////////////////////////////
//          HashSet<Integer> hs=new HashSet<>();
//          hs.add(1);
//          hs.add(4);
//          hs.add(3);
//          ArrayList<Integer> al=new ArrayList<>(hs);
//        System.out.println(al);
        //////////////////////////////////////////////
//        HashSet<Integer> hs=new HashSet<>();
//          hs.add(1);
//          hs.add(4);
//          hs.add(3);
//        HashSet<Integer> hs2=new HashSet<>();
//        hs2.add(1);
//        hs2.add(4);
//        hs2.add(3);
//        HashSet<Integer> intersection=hs;
//       intersection.retainAll(hs2);
//        System.out.println(intersection);
//        System.out.println(hs.containsAll(hs2));
        ///////////////////////////
//        Queue<Integer> q=new ArrayDeque<>();
//        q.add(1);
//        q.add(3);
//        q.add(2);
//        System.out.println(q);
//        int x=q.poll();
//        System.out.println(q);
//        q.add(x);
//        System.out.println(q);
        /////////////////////////////////////
        Queue<Integer> q=new ArrayDeque<>();
        q.add(1);
        q.add(3);
        q.add(2);
        Queue<Integer> q2=new ArrayDeque<>();
        q2.add(1);
        q2.add(3);
        q2.add(2);
        boolean x=q.equals(q2);
        System.out.println(x);
        /////////////////////////////////////////
//        ArrayList<Integer> al=new ArrayList<>();
//        al.add(1);
//        al.add(1);
//        al.add(2);
//        al.add(3);
//        HashSet<Integer> hset=new HashSet<>(al);
//        System.out.println(al);
//        System.out.println(hset);
//        PriorityQueue<Integer> pq=new PriorityQueue<>(hset);
//        System.out.println(hset);
        ////////////////////////////////
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(3);
//        list.add(5);
//        list.add(7);
//        list.add(9);
//        list.add(11);
//
//        // Element to be searched
//        int target = 7;
//
//        // Performing binary search using Collections.binarySearch
//        int index = Collections.binarySearch(list, target);
//
//        // Printing the result
//        if (index >= 0) {
//            System.out.println("Element " + target + " found at index " + index);
//        } else {
//            System.out.println("Element " + target + " not found in the list");
//        }


    }
}
