package ders18;

import java.util.PriorityQueue;
import java.util.Queue;

public class Novbe {
    public static void main(String[] args) {
        Queue<Integer> novbe=new PriorityQueue<>();
        novbe.add(23);
        novbe.add(4);
        novbe.add(455);
        novbe.add(2);
        System.out.println(novbe);
        novbe.poll();

        System.out.println(novbe);
    }
}
