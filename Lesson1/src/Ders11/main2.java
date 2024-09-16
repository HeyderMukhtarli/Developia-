package Ders11;

public class main2 {
    public static void main(String[] args) {
        int[]  nums={3,2,4};
        int[] arr2=twoSum(nums,6);
        for (int num:arr2){
            System.out.println(num);
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] myArr=new int[2];
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length;j++){
               if(nums[i]+nums[j]==target&&i!=j){
                   myArr[0]=i;
                   myArr[1]=j;
                   System.out.println("true");
                   return myArr;
               }
            }
        }
        return myArr;
    };
}
