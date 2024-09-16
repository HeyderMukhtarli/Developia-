package Ders19;

public class Main {
    public static void main(String[] args) {
        int[] i1={1,3,4};
        int[] i2={2,5,};
        Solution s=new Solution();
       double arr=s.findMedianSortedArrays(i1,i2);
        System.out.println(arr);

    }
}
