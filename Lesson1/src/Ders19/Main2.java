package Ders19;

public class Main2 {

       static   void replaceSpaces(String str,int trueL) {
           int index=trueL+2*2-1;

           char[] chars=str.toCharArray();
           System.out.println(chars);
           System.out.println(chars.length);
           for(int i=trueL-1;i>=0;i--){
               if(chars[i]==' '){
                   chars[index]='0';
                   chars[index-1]='2';
                   chars[index-2]='%';
                   index-=3;
               }else {
                   chars[index]=chars[i];
                   index--;

               }

           }
           System.out.println(new String(chars));

             }

    public static void main(String[] args) {
    String s="Mr John Smith";

       s+=' ';
       s+=' ';
       s+=' ';
       s+=' ';
      replaceSpaces(s,13);
    }
}
