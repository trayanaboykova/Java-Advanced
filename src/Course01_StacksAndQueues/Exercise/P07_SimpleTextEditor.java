package Course01_StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()); //брой команди
        StringBuilder currentText = new StringBuilder();
        ArrayDeque<String> textStack = new ArrayDeque<>();
        //• "1 {string}" - appends [string] to the end of the text.
        //• "2 {count}" - erases the last [count] elements from the text.
        //• "3 {index}" - returns the element at position [index] from the text.
        //• "4" - undoes the last not-undone command of type 1 or 2 and returns the text to the state before that operation.
        for (int commandNumber = 1; commandNumber <= n; commandNumber++) {
            String command = scanner.nextLine(); //текст на команда
            if (command.startsWith("1")) {
                //преди модификация съхраняваме текущото състояние преди промяната
                textStack.push(currentText.toString());
                //command = "1 {string}".split(" ") -> ["1", "{string}"]
                String textToAppend = command.split("\\s+")[1];
                currentText.append(textToAppend);
            } else if (command.startsWith("2")) {
                //преди модификация съхраняваме текущото състояние преди промяната
                textStack.push(currentText.toString());
                //command = "2 5".split(" ") -> ["2", "5"]
                int count = Integer.parseInt(command.split("\\s+")[1]);
                //изтрием последните count на брой символа
                //"Desislava" -> count = 2 -> "Desisla"
                //"table" -> count = 3 -> "ta"
                int startIndexForDelete = currentText.length() - count;
                currentText.delete(startIndexForDelete, currentText.length());
            } else if (command.startsWith("3")) {
                //command = "3 7".split(" ") -> ["3", "7"]
                int position = Integer.parseInt(command.split("\\s+")[1]); //мястото на буквата в думата
                System.out.println(currentText.charAt(position - 1));
            } else if (command.equals("4")) {
                //command = "4"
                //!!!!!!!!
                if (!textStack.isEmpty()) {
                    String last = textStack.pop();
                    currentText = new StringBuilder(last);
                }
            }
        }
    }
}
