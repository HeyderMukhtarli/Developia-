package ders7;

public class MainVarArgs {
    public static void main(String[] args) {
        doIt(3,6,8,6,4,33,9);
    }


    static void doIt(int ...a){

        int result=0;

        for ( int m:a) {
            result+=m;
        }
        System.out.println(result);

    }

}
