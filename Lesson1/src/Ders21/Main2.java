package Ders21;

public class Main2 {
    public static long reverse(int x) {
       String s=Integer.toString(x);
       char[] chars=s.toCharArray();
       char[] chars1=new char[chars.length];
       if(chars[0]=='-'){
           chars1[0]='-';
       }
       for(int i=chars.length-1;i>=0;i--){
           if(chars[i]=='-'){
               continue;
           }
           if(chars1[0]=='-'){
               chars1[chars.length-i]=chars[i];
           }else{
               chars1[chars.length-1-i]=chars[i];
           }

       }
       String y=new String(chars1);
       Long b=Long.parseLong(y);
        System.out.println(b);
       return b.longValue();
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
