package Ders7;

import java.util.Arrays;

public class ArraysDemoHome {
    public static void main(String[] args) {
        int[] numbers=new int[7];
        numbers[0]=1;
        numbers[1]=5;
        numbers[2]=4;
        numbers[3]=6;
        numbers[4]=2;
        numbers[5]=3;
        numbers[6]=7;
        for (int a=0;a<numbers.length;a++){
//            System.out.println(numbers[a]);
        }
        for (int num:numbers){
//            System.out.println(num);
        }
        String x="text";
//        System.out.println(x.length());
        //2
        double sum=0;
        for (int num:numbers){
            sum+=num;
        }
//        System.out.println(sum/(double) numbers.length);
        //3
        int min=numbers[0];
        int max=numbers[0];
        for (int a=1;a<numbers.length;a++){
            if(numbers[a]>numbers[a-1]){
                max=numbers[a];
            }
            if(numbers[a]<numbers[a-1]){
                min=numbers[a];
            }
        }
//        System.out.println(max);
//        System.out.println(min);
        //4
        for (int num:numbers){
            if(num%2==1){
//                System.out.println(num);
            }
        }
        for (int num:numbers){
            if(num%2==0){
//                System.out.println(num);
            }
        }
        //5
        for (int num:numbers){
            boolean sade=true;

            if(num>2){
                for(int a=2;a<num;a++){
                    if(num%a==0){
                        sade=false;
                    }
                }
                if (sade==true){
//                    System.out.println(num);
                }
                sade=true;
            }
        }
        //6
       Arrays.sort(numbers);
       for(int a=numbers.length-1;a>0;a--){
           System.out.println(numbers[a]);
       }
       int[] z=new int[]{1,2,3};
       int[] v={1,2,3};
    }
}
