package Ders13;

public class Main {
    public static void main(String[] args) {

        try {
            print();
            System.out.println("3");
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void print(){
        if(5>3){
            throw new IllegalArgumentException("illegall");
        }
        System.out.println("2");
    }
}
