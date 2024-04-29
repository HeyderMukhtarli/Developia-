package ders3;

public class MainTernary {
    public static void main(String[] args) {
        int myAge=12;

        //String message="";
//        if(myAge>=18){
//            message="sene ev olar";
//            System.out.println("salam");
//
//        }else{
//            message="diplom al";
//        }
        //System.out.println(message);

        String message = myAge>=18?"sene ev olar":"diplom al";
        System.out.println(message);

    }
}
