package Ders9;

import java.util.Random;

public class Homework2 {
    public static void main(String[] args) {
        char[] c={'a','b','c','d','e'};
        String s=String.copyValueOf(c);
        System.out.println(s);
        int count=0;

         String str="bir iki";
         String str2=" ";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isLetter(ch)) {

            }else {
                count++;
            }

        }
        System.out.println(count);

        if(str2.isBlank()){
            System.out.println("blank");
        }
        if(str2.isEmpty()){
            System.out.println("empty");
        }

        Homework2 hw2=new Homework2();

        System.out.println(hw2.isSubs("MyString1","ing2"));

        Random ran=new Random();
        System.out.println(ran.nextInt(10,30));

        double num=58.499393;
        System.out.println(String.format("%.2f",num));
    }

    public boolean isSubs(String str1,String str2){
        return  str1.endsWith(str2);
    }
}
