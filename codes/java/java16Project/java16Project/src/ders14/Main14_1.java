package ders14;

public class Main14_1 {
    public static void main(String[] args) {

        int a=1;
int[] massivim={4,7,8};
        int b=0;
        int c=0;
        try{
            c=a/b;
            System.out.println(massivim[10]);

        }catch (  ArithmeticException | ArrayIndexOutOfBoundsException exception){
            System.out.println("0a bolunme olmur");
        }
         finally {

        }

        System.out.println(c);

        System.out.println("salam");
    }
}
