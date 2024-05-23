package ders9;

public class Maraqli {
    public static void main(String[] args) {
        String meselen="";
        int i=-1;
        do{
            i=meselen.indexOf('r',i+1);
            if(i==-1)break;
            System.out.println(i);
        }
        while(i!=-1);


    }
}
