package ders19;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main19Yeni {


    public static void main(String[] args) {

File myFOlder=new File("G:\\Other computers\\Zalman\\mega");

adi(myFOlder.listFiles());



    }


    static void adi(File[] fayllar){
        for (File file:fayllar
             ) {
            if(file.isFile()){
                System.out.println(file.getAbsolutePath());
            }else{
adi(file.listFiles());
            }

        }
    }

}
