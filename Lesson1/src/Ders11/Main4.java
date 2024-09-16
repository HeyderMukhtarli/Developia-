package Ders11;


public class Main4 {
    public static void main(String[] args) throws CloneNotSupportedException {
//        System.out.println("Main begin");
//        Book java =new Book();
//        java=new Book();
//        System.gc();
//        System.out.println(java);
//        System.out.println("Main end");

//                Book java =new Book("java");
//                Book java2=java;
//                java.name="test";
//        System.out.println(java.name);
//        System.out.println(java2.name);

        Book java3 =new Book("java");
        Book java4=(Book) java3.clone();
        java3.name="test";
        System.out.println(java3.name);
        System.out.println(java4.name);

    }
}
