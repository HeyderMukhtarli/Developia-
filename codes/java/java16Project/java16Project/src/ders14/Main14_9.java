package ders14;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Scanner;

public class Main14_9 {
    public static void main(String[] args) {

        try {
            metod();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("salam");

    }

    static void metod() throws FileNotFoundException {
        File file = new File("nonexistent_file.txt");

        Scanner scanner = new Scanner(file);

    }
}
