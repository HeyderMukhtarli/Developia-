package d12.d11;

import java.util.Arrays;

public class MainMisal12 {
    public static void main(String[] args) {
        int[] massivim={3,7,11};
        System.out.println(Arrays.toString(massivim));
        massivim=insertToArray(massivim,9,33);
         // 3,7,9,11
        System.out.println(Arrays.toString(massivim));
    }
   static int[] insertToArray(int[] array,int element,int index){
        int[] newArray=new int[array.length+1];
       for (int i = 0; i < index; i++) {
           newArray[i]=array[i];
       }
       newArray[index]=element;
       for (int i = index+1; i < newArray.length; i++) {
           newArray[i]=array[i-1];
       }
       return newArray;
    }

    static int[] deleteFromArray(int[] array,int index){
        int[] newArray=new int[array.length-1];
        for (int i = 0; i < index; i++) {
            if(i==index){

            }else{
                newArray[i]=array[i];
            }


        }
        return newArray;
    }

}
