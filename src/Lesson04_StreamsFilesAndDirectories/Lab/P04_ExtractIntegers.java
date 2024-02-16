package Lesson04_StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class P04_ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String pathRead = "C:\\Users\\terra\\Desktop\\SoftUni\\1. Java\\3. Java Advanced Module\\1. Java Advanced\\JavaAdvanced\\src\\Course04_StreamsFilesAndDirectories\\LabResources\\input.txt";
        FileInputStream inputStream = new FileInputStream(pathRead);
        Scanner scanner = new Scanner(inputStream);

        String pathWrite = "C:\\Users\\terra\\Desktop\\SoftUni\\1. Java\\3. Java Advanced Module\\1. Java Advanced\\JavaAdvanced\\src\\Course04_StreamsFilesAndDirectories\\LabResources\\04.ExtractIntegersOutput.txt";
        FileOutputStream outputStream = new FileOutputStream(pathWrite);
        PrintWriter writer = new PrintWriter(outputStream);

        //hasNext -> true: не сме стигнали до края на файла
        //hasNext -> false: сме стигнали до края на файла
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                writer.println(number);
            }
            scanner.next();
        }

        writer.close();
    }
}

