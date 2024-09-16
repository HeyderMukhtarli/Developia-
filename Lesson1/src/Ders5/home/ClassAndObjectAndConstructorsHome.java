package Ders5.home;

public class ClassAndObjectAndConstructorsHome {
    public static void main(String[] args) {
//        Employee e1=new Employee();
//        Employee e2=new Employee("Heyder");
//        System.out.println(e2.name);
//        Employee e3=new Employee("Heyder","Muxtarli");
//        System.out.println(e3.name+" "+e3.surname);
//        Employee e4=new Employee("Heyder","077864XXX",1000);
//        System.out.println(e4.name+" "+e4.phone+" "+e4.salary);
        Student s1= new Student("Heyder",19);
        Student s2= new Student("Heyder2",20);
        Student s3= s2;
        Student s4= s1;
        System.out.println(s1);
        System.out.println(s4);
        s1=null;
        s4=null;
         s4= new Student("Heyder3",30);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

    }
}
