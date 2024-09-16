package Ders13.home2;

import Ders13.home1.OutOfRangeValueException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        try {
//            System.out.println("try1");
//            try {
//                System.out.println("try2");
//                throw new Exception("excp");
//            }catch (Exception e){
//                System.out.println("catch1"+e.getMessage());
//            }
//        }catch (Exception e){
//            System.out.println("catch2"+e.getMessage());
//        }
        //2
//        try {
//            b();
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
        //3
//        try{
//           throw new NullPointerException("mess");
//        }catch (Exception e){
//            if(e instanceof  ArithmeticException){
//                System.out.println("1");
//                System.out.println(e.getMessage()+"arithmetic");
//            }
//            if(e instanceof  NullPointerException){
//                System.out.println("2");
//                System.out.println(e.getMessage()+"null");
//            }
//            if(e instanceof  ArrayIndexOutOfBoundsException){
//                System.out.println("3");
//                System.out.println(e.getMessage()+"array index");
//            }
//        }
        //4
        try{
//            throw new OutOfRangeValueException(new RuntimeException());
            throw new RuntimeException();
        }catch (RuntimeException ex){
            try{
                throw new OutOfRangeValueException(ex);

            }catch (OutOfRangeValueException e){
                System.out.println(e.getCause());
            }

        }



    }
    public static void b(){
       int c=5/0;
    }

    public static void c() throws IOException{
        throw new IOException();
    }
}
