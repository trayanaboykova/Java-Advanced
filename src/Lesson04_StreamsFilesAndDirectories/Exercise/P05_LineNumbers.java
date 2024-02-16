package Lesson04_StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P05_LineNumbers {
    public static void main(String[] args) throws IOException {
        //1. прочитам всички редове от файл inputLineNumbers.txt
        //2. обхождаме всеки ред -> записваме в нов файл с пореден номер отпред
        String path = "C:\\Users\\terra\\Desktop\\SoftUni\\1. Java\\3. Java Advanced Module\\1. Java Advanced\\JavaAdvanced\\src\\Course04_StreamsFilesAndDirectories\\ExerciseResources\\Exercises Resources\\inputLineNumbers.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));

        PrintWriter writer = new PrintWriter("C:\\Users\\terra\\Desktop\\SoftUni\\1. Java\\3. Java Advanced Module\\1. Java Advanced\\JavaAdvanced\\src\\Course04_StreamsFilesAndDirectories\\ExerciseResources\\Exercises Resources\\output_line_numbers.txt");
        int lineNumber = 1;
        for (String line : allLines) {
            writer.println(lineNumber + ". " + line);
            lineNumber++;
        }

        writer.close(); //спирам да пиша във файла и файлът се затваря
    }
}
