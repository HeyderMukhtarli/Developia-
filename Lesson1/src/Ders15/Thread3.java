package Ders15;

public class Thread3 extends Thread{
    Obj o;
    public Thread3(Obj o) {
        this.o=o;
    }

    public void run() {
        for (int i=1;i<=5;i++){
            o.countNum();
        }
    }
}
