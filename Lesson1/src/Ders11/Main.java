package Ders11;

public class Main {
    public static void main(String[] args) {
            // Create an array of Strings with 9 elements
            String[] array = new String[9];

            // Assign values to the first 5 elements
            array[0] = "Item1";
            array[1] = "Item2";
            array[2] = "Item3";
            array[3] = "Item4";
            array[4] = "Item5";

            // Print the elements of the array
            for (int i = 0; i < array.length; i++) {
                System.out.println("Element at index " + i + ": " + array[i]);
            }
        }


}
