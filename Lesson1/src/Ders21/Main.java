package Ders21;

import java.util.Arrays;

public class Main {
    public static String convert(String s, int numRows) {
        int cols;
        int a=s.length()%(numRows+numRows-2);
        int b=s.length()/(numRows+numRows-2);
        int c=0;
        int d=0;
        if(a>numRows){
             c=a%numRows;
            d=numRows;
        }else {
            d=a;
        }
        if(d>0){
            cols=b*(numRows+numRows-2)+1+c;
        }else {
            cols=b*(numRows+numRows-2)+c;
        }

        System.out.println(cols);
       char[][] arr=new char[numRows][cols];
       int col=0;
       int row=0;
       boolean next=false;
       for(int i=0;i<s.length();i++){

    arr[row][col]=s.toCharArray()[i];
    if ((row!=0&&numRows-row==1)||(row==1&&numRows==2)) {
        next=true;
    }

    if(!next){
        row++;
    }else{
        col++;
        row--;
    }
    if(row==0){
        next=false;
    }


}


       StringBuilder sb=new StringBuilder();
       for(int i=0;i<numRows;i++){
           for(int j=0;j<cols;j++){

                   if(arr[i][j]!='\u0000'){
                       sb.append(arr[i][j]);
                   }

           }
       }
        System.out.println(Arrays.deepToString(arr));
        System.out.println(sb.toString());
       return sb.toString();


       }


    public static void main(String[] args) {
         convert("ABCD",  5);
    }
}
