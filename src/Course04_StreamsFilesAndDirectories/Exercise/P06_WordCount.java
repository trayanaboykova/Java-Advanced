package Course04_StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P06_WordCount {
    public static void main(String[] args) throws IOException {
        //1. да намерим кои думи ще броим
        //words.txt -> думи, които трябва да търсим
        String pathWords = "C:\\Users\\terra\\Desktop\\SoftUni\\1. Java\\3. Java Advanced Module\\1. Java Advanced\\JavaAdvanced\\src\\Course04_StreamsFilesAndDirectories\\ExerciseResources\\words.txt";
        List<String> allLinesWithWords = Files.readAllLines(Path.of(pathWords));
        //дума -> бр. срещанията
        Map<String, Integer> countWords = new HashMap<>();

        for (String line : allLinesWithWords){
            //line = "of which The".split(" ") -> ["of", "which", "The"]
            String [] wordsOnCurrentRow = line.split("\\s+");
            Arrays.stream(wordsOnCurrentRow).forEach(word -> {
                countWords.put(word, 0);
            });
        }

        //2. преброим думите от стъпка 1 колко пъти се срещат във файл text.txt
        // countWords -> кои са думите, които търсим
        String pathText = "C:\\Users\\terra\\Desktop\\SoftUni\\1. Java\\3. Java Advanced Module\\1. Java Advanced\\JavaAdvanced\\src\\Course04_StreamsFilesAndDirectories\\ExerciseResources\\text.txt";
        List<String> allLinesWithText = Files.readAllLines(Path.of(pathText));
        for (String line : allLinesWithText) {
            //line = "There are many variations of passages of Lorem Ipsum available".split(" ")
            //премахваме препинателните знаци -> точка, запетая, ?, !, :
            line = line.replaceAll("[\\.\\,\\?\\!\\:]", "");
            String [] words = line.split("\\s+"); //думите на съответния ред
            for (String word : words) {
                if (countWords.containsKey(word)) {
                    countWords.put(word, countWords.get(word) + 1);
                }
            }
        }

        //3. знаем коя буква колко пъти се среща
        //сортираме записите по броя на срещанията -> sort by value descending order
        //запис: key(дума) -> value (бр. срещанията)
        PrintWriter writer = new PrintWriter("result.txt");
        countWords.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) //сортиран map
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();

        //sorted (число)
        //число е 0 -> не разменя местата на записите
        //число е 1 -> разменя местата на записите
        //число е - 1 -> не разменя местата на записите

        //compareTo -> връща цяло число
        //0 -> първото == второто
        //1 -> първото > второто
        //-1 -> второто > първото

    }
}
