package Ders5.home;

public class ClassAndObjectHome {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age = 19;
        p1.id = 1;
        p1.name = "Heyder";
        p1.surname = "Muxtarli";
        p1.phone = "077864XXXX";

        Person p2 = new Person();
        p2.age = 20;
        p2.id = 2;
        p2.name = "Heyder2";
        p2.surname = "Muxtarl2";
        p2.phone = "077864XXXX2";

        System.out.println(p1.age+p1.name+p1.surname);
        System.out.println(p2.age+p2.name+p2.surname);
    }


}
