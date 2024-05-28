package d11;

import d111.Ust;

public class Alt extends Ust {
    int salary;
    public Alt(){
super(3);
        System.out.println("Alt obj created");
 super.name="Hesen";

        System.out.println(name);
    }

    @Override
    public  void doIt(){
        System.out.println("Ogul is gorur");
    }

}
