package Ders21;

import java.util.Arrays;

public class Main3 {
    public static String getSpreadsheetNotation(long n) {
        // Write your code here
     String[] arr=new String[703];
        int index = 1;
        arr[0]=null;
        for (char i = 'A'; i <= 'Z'; i++) {
            arr[index++] = String.valueOf(i);
        }

        for (char i = 'A'; i <= 'Z'; i++) {
            for (char j = 'A'; j <= 'Z'; j++) {
                arr[index++] = String.valueOf(i) + j;
            }
        }

        long row=n/702+1;
        long x=n%702;
        if(x==0){
            x=702;
            row--;
        }
        System.out.println(row+arr[(int) x]);
        return row+arr[(int) x];


    }

    public static void main(String[] args) {
        getSpreadsheetNotation(703);
    }
}
