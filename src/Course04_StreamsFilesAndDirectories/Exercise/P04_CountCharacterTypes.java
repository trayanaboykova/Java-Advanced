package Course04_StreamsFilesAndDirectories.Exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P04_CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        //гласни: a, e, i, o, u
        //пунктуационни знаци: ! , . ?
        //съгласни: всичко останало
        int vowelsCount = 0; //броя на гласните букви
        int punctCount = 0; //броя на пунктуационните знаци
        int consonantsCount = 0; //броя на съгласните букви

        Set<Character> vowels = getVowels(); //всички възможни главни букви
        Set<Character> punctuationalMarks = getPuntMarks(); //всички възможни пунктуационни знаци

        String path = "C:\\Users\\terra\\Desktop\\SoftUni\\1. Java\\3. Java Advanced Module\\1. Java Advanced\\JavaAdvanced\\src\\Course04_StreamsFilesAndDirectories\\ExerciseResources\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));

        for (String line : allLines) {
            //"On January 1 , 1533 , "
            for (int index = 0; index < line.length(); index++) {
                char currentSymbol = line.charAt(index);
                if (currentSymbol == ' ') {
                    continue;
                }
                //проверка на символа
                if (vowels.contains(currentSymbol)) { //гласна буква
                    vowelsCount++;
                } else if (punctuationalMarks.contains(currentSymbol)) { //пунктуационен знак
                    punctCount++;
                } else { //съгласна буква
                    consonantsCount++;
                }
            }
        }
        //знаем броят на символите във всяка категория
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\terra\\Desktop\\SoftUni\\1. Java\\3. Java Advanced Module\\1. Java Advanced\\JavaAdvanced\\src\\Course04_StreamsFilesAndDirectories\\ExerciseResources\\Exercises Resources\\output-task-4.txt"));
        writer.write("Vowels: " + vowelsCount);
        writer.newLine();
        writer.write("Other symbols: " + consonantsCount);
        writer.newLine();
        writer.write("Punctuation: " + punctCount);
        writer.close();

    }

    private static Set<Character> getPuntMarks() {
        Set<Character> marks = new HashSet<>();
        marks.add('!');
        marks.add('?');
        marks.add('.');
        marks.add(',');
        return marks;
    }

    private static Set<Character> getVowels() {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        return vowels;
    }
}
