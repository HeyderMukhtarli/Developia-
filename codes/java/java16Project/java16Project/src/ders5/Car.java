package ders5;

public class Car {
    // global vars
     int price;
     String model;
     int maxSpeed;

    int speed;



     void start(int i){
         speed=i;
     }

    void stop(){
        speed=0;
    }


    Car(int speed ){ // 15
        System.out.println("salam");
         this.speed=speed;
    }
    Car(  ){
        System.out.println("salam");
    }
}
