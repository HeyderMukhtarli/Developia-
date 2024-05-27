package ders10;

public class Main10_5 {
    public static void main(String[] args) {

StringBuilder s=new StringBuilder();
s.append("java");
       s.insert(2,"James");
       s.delete(2,7);
       s.reverse();
        System.out.println(s);
        s.ensureCapacity(20);

    }
}
