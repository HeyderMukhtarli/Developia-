package ders18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BasitSiralama {
    public static void main(String[] args) {
        ArrayList<Integer> saylar=new ArrayList<>();
        saylar.add(4);
        saylar.add(43);
        saylar.add(46);
        saylar.add(41);

        System.out.println(saylar);
        Collections.sort(saylar);
        System.out.println(saylar);

        ArrayList<Car> masinlar=new ArrayList<>();
        masinlar.add(new Car(20000,200));
        masinlar.add(new Car(20000,233));
        masinlar.add(new Car(20000,190));
        masinlar.add(new Car(10000,100));
        System.out.println(masinlar);

        Comparator<Car> comparator =
                Comparator.comparing(Car::getPrice).
                        thenComparingInt(Car::getSpeed);

        Collections.sort(masinlar,comparator
                );
        System.out.println(masinlar);
    }
}
