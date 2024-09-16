package Ders13.home1;

public class Main {
    public static void main(String[] args) {

        int a=10;
        int b=0;
        int c;
        int d=-7;
//        try {
//            c=a/b;
//            System.out.println(c);
//        }catch (ArithmeticException e){
//            System.out.println(e.getMessage());
//        }catch (NumberFormatException e){
//            System.out.println(e.getMessage());
//
//        }finally {
//            System.out.println("Final");
//        }


//        try {
//            if(d<0){
//                throw new IllegalArgumentException("less than zero");
//            }
//        }catch (IllegalArgumentException ex){
//            System.out.println(ex.getMessage());
//        }
     try {
         if(d>5&&d<10){

         }else{
             throw new OutOfRangeValueException("out of range");
         }
     }catch (OutOfRangeValueException ex){
         System.out.println(ex.getMessage());
        }

    }
}
