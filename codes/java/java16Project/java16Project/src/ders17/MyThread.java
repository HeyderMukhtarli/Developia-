package ders17;

public class MyThread implements  Runnable {
    @Override
    public void run() {
        for (int i = 1; i <=10; i++) {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(i);
        }
    }
}
