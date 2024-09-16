package Ders9;

public class Main {
    public static void main(String[] args) {
        char[] charArray={'a','b','c','d','e'};
        String s=String.valueOf(charArray);
        System.out.println(s);
         s=String.valueOf(charArray,2,3);
        System.out.println(s);

        String a="text";
        String d="text";
        String b=new String("text");
        String c=new String("text");
        System.out.println(a.equals(d));

        String s2="Hello";
        char[] chars={'d','d','d','d','d'};
        s2.getChars(2,4,chars,2);
        System.out.println(chars);

        String b1="Developia";
        String b2="Developir";
        System.out.println(b1.regionMatches(0,b2,0,9));

        String s3="  ";
        System.out.println(s3.isEmpty());
        System.out.println(s3.isBlank());

        String s4="int double";
        String s5=s4.replace("double","bool");
        String s6=s4.replace("double","bool");
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s4.substring(1,5));

        double d3=54.57885;
        System.out.println(String.format("%.2f",d3));

    }
}
