package Course04_StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P02_SumBytes {
    public static void main(String[] args) throws IOException {
        //1. всички редове от файл input.txt
        //2. принтираме сумата от ascii кодовете на символите на всички редове

        String pathToFile = "C:\\Users\\terra\\Desktop\\SoftUni\\1. Java\\3. Java Advanced Module\\1. Java Advanced\\JavaAdvanced\\src\\Course04_StreamsFilesAndDirectories\\ExerciseResources\\input.txt";
        long sum = 0; //сума от аски кодовете на всички символи

        //начин 1:
        /*List<String> allLines = Files.readAllLines(Path.of(pathToFile)); //лист с всички редове (текст)

        for (String line : allLines) {
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
        }
        System.out.println(sum);*/

        //начин 2:
        //byte -> -127 до 128
        //sbyte -> 0 до 256
        byte [] allBytes = Files.readAllBytes(Path.of(pathToFile));
        //масив от аски кодовете на всички символи (включително нов ред и carriage return) във файл
        // ascii = 10 -> символ за нов ред
        // ascii = 13 -> символ, обозначаващ начало на нов ред
        for (byte ascii : allBytes) {
            if (ascii != 13 && ascii != 10) {
                sum += ascii;
            }
        }
        System.out.println(sum);
    }
}
