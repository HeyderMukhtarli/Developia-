package ders3;

public class Mentiqi {
    public static void main(String[] args) {
        boolean hasJob=false;
        boolean hasHome=true;
        boolean hasDayday=true;
        int a=2;

        if(!hasJob || hasHome && a++==5){
            System.out.println("buyur kec");
        }else{
            System.out.println("Olmaz");
        }
        System.out.println(a);
    }
}
