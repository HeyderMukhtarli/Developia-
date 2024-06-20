package ders17;

public class Main_17 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("salam");
         Thread t1=new  Thread(new MyThread());
t1.start();

        System.out.println("sagol");


    }
}
