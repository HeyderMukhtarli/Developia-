package ders7;

public class Sadeler {
    public static void main(String[] args) {
        int[] massivim={33,7,13,77,88,94};

        for (int ededim:
                massivim) {
            if(sadedirmi(ededim)){
                System.out.println(ededim);
            }

        }

    }

    static boolean sadedirmi(int eded){
        boolean netice=true;

        for (int i = 2; i <eded; i++) {
            if(eded%i==0){
                netice=false;
                break;
            }
        }

        return netice;
    }
}
