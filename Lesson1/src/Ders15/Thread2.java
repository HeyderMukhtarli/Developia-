package Ders15;

public class Thread2 extends Thread{
    Obj o;
    public Thread2(Obj o) {
        this.o=o;
    }

    public void run() {
     for (int i=1;i<=5;i++){
         o.countNum();
     }
    }
}
