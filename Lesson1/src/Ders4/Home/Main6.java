package Ders4.Home;

public class Main6 {
    public static void main(String[] args) {
        boolean a=true;
        double b=1;
        int day=0;
        double length=0;
            while (a){
                length+=b*15;
                if(length>=1000){
                    a=false;
                }
                day++;
                System.out.println(b+"  "+length);
                b*=1.5;

            }
        System.out.println(day);
    }
}
