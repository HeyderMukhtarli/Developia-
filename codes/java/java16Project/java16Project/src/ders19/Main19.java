package ders19;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main19 {


    public static void main(String[] args) {
        File f=new File("C:\\Users\\devsys\\Desktop\\j16\\java16.txt");
if(!f.exists()){
    try {
        f.createNewFile();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
        try {
            FileWriter myWriter = new FileWriter(f);
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

}
