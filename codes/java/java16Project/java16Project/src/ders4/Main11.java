package ders4;

public class Main11 {
    public static void main(String[] args) {
        double a=3,b=5,c=1,x1=0,x2=0;

        double disk=b*b-4*a*c;
        if(disk==0){
            // 1 koku var
            x1=(-1*b)/(2*a);
        }else if(disk<0){
            // 1 koku yox
            System.out.println("koku yoxdur");
        }else{
            // 2 koku var
            x1=(-b-Math.sqrt(disk))/(2*a);
            x2=(-b+Math.sqrt(disk))/(2*a);
        }
        System.out.println(x1);
        System.out.println(x2);
        // kod bloku

    }
}
