package Ders15;

public class Thread4 extends Thread{
    public void run() {
      for(int i=0;i<=5;i++){
          System.out.println(i);
          try {
              Thread.sleep(1000);

          }catch (Exception e){
              System.out.println(e.getMessage());
          }
      }
    }
}
