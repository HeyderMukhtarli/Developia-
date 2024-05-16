package ders8;

public class Person {
      int  salary;
      String name;

      public Person(){
        this(1000);
      }

      public Person(int salary){
this(salary,"Adil");
      }

      public Person(int salary,String name){
            this.salary=salary;
            this.name=name;
      }

void  m1(final int a){
      System.out.println(a);
}

}
