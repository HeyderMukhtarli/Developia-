package Ders19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[]  array=new int[nums1.length+nums2.length];
        for (int i=0;i<(nums1.length+nums2.length);i++){
           if(i<nums1.length){
               array[i]=nums1[i];
           }else{
               array[i]=nums2[i-nums1.length];
           }
        }
        Arrays.sort(array);
     if(array.length%2==0){
         return (double) (array[array.length/2-1]+array[array.length/2])/2;
     }else {
         return array[(int) Math.floor( array.length/2)];
     }
    }
}