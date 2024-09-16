package Ders15;

public class Obj {
    int count;

    public Obj(int count) {
        this.count = count;
    }

    public synchronized void countNum(){
        count++;
        System.out.println(count);
    }
}
