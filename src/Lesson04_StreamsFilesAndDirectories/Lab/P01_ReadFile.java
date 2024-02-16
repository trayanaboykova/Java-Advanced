package Lesson04_StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;

public class P01_ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\terra\\Desktop\\SoftUni\\1. Java\\3. Java Advanced Module\\1. Java Advanced\\JavaAdvanced\\src\\Course04_StreamsFilesAndDirectories\\LabResources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);

        int currentByte = inputStream.read();
        while (currentByte >= 0) {
            //79 -> двоична бройна система ("1001111")
            System.out.print(Integer.toBinaryString(currentByte) + " ");
            currentByte = inputStream.read();
        }

        inputStream.close();
    }
}

