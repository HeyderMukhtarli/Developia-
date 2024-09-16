package Ders21;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class A {

      public   void doIt(){
        System.out.println("do 1");
    }
    public static void main(String[] args) {
        List<Objects> lists=new ArrayList<>();
        System.out.println(lists.get(0));
    }
}

class B extends A{
    public  void doIt(){
        System.out.println("do 2");
    }
}

