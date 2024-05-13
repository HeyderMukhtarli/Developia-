package ders7;

import java.util.Arrays;

public class MainMassivler2 {
    public static void main(String[] args) {

        int[] m1={2,4};
        int[] m2={2,7,9};
        int[] m3={6,2,4,9};

        int[][] coxOlculu={m1,m2,m3};
        System.out.println(Arrays.toString(coxOlculu));
        coxOlculu[0][1]=333;


    }
}
