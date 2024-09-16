package Ders15;

public class Main {
    public static void main(String[] args) {
//        Thread1 t1=new Thread1("Hello");
//        Thread1 t2=new Thread1("World");
//        t1.start();
//        t2.start();
        //2
//        Obj o=new Obj(0);
//        Thread2 t1=new Thread2(o);
//        Thread3 t2=new Thread3(o);
//        t1.start();
//        t2.start();
        //3
//           Thread4 t4=new Thread4();
//           t4.start();
        //5
        Demo obj = new Demo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    if (Thread.interrupted()) {
                        System.out.println("Thread was interrupted");
                        break;
                    }
                    System.out.println("Running...");
                    try {
                        Thread.sleep(1000); // Sleep for 1 second to simulate work
                    } catch (InterruptedException e) {
                        // If sleep is interrupted, set the interrupted status and break the loop
                        Thread.currentThread().interrupt();
                        System.out.println("Thread was interrupted during sleep");
                        break;
                    }
                }
            }
        });



        t1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Interrupt the infinite loop thread
       t1.interrupt();
    }
}
