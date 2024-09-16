package Ders4;

import static java.lang.Math.pow;

public class Main4 {
    public static void main(String[] args) {
        double a=3,b=5,c=1;
        double x1=0,x2=0;

        double dis=pow(b,2)-4*a*c;
        if(dis==0){
            x1=-1*b/(2*a);
            //1 kok
        }else if(dis<0){
            System.out.println("kok yoxdur");
        }else {
            x1=(-1*b-Math.sqrt(dis))/(2*a);
            x2=(-1*b+Math.sqrt(dis))/(2*a);
        }
        System.out.println(x1);
        System.out.println(x2);
    }
}
