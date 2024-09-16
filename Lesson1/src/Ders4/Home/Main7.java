package Ders4.Home;

public class Main7 {
    public static void main(String[] args) {
        boolean a = true;
        int i = 2;
        int number=0;
        boolean isSimple=true;
        while (a) {
            isSimple=true;
            i++;
            for (int j = 2; j < i/2; j++) {
                if (i % j == 0 ){
                   isSimple=false;

                }
            }
            if (isSimple==true){
                System.out.println(i);
                number++;
            }
            if (number==30){
                a=false;
            }

        }
    }
}
