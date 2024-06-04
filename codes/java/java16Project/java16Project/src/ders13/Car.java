package ders13;

import java.util.Objects;

public class Car implements  Cloneable{
    String color;
    int price;

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Car){
            Car car=(Car)o;
            if(this.price==car.price && this.color.equals(car.color)){
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }

    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("men gediremm");
    }
}
