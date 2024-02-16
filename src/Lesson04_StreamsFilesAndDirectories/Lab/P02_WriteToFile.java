package Lesson04_StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P02_WriteToFile {
    public static void main(String[] args) throws IOException {
        String pathRead = "C:\\Users\\terra\\Desktop\\SoftUni\\1. Java\\3. Java Advanced Module\\1. Java Advanced\\JavaAdvanced\\src\\Course04_StreamsFilesAndDirectories\\LabResources\\input.txt";
        String pathWrite = "C:\\Users\\terra\\Desktop\\SoftUni\\1. Java\\3. Java Advanced Module\\1. Java Advanced\\JavaAdvanced\\src\\Course04_StreamsFilesAndDirectories\\LabResources\\02.WriteToFileOutput.txt";

        FileInputStream inputStream = new FileInputStream(pathRead);
        FileOutputStream outputStream = new FileOutputStream(pathWrite);

        int currentByte = inputStream.read(); //ascii кода на прочетения символ
        while (currentByte >= 0) {
            char currentSymbol = (char) currentByte;
            if (currentSymbol != '.' && currentSymbol != ',' && currentSymbol != '!' && currentSymbol != '?') {
                outputStream.write(currentSymbol);
            }

            currentByte = inputStream.read();
        }

        inputStream.close();
        outputStream.close();
    }
}
