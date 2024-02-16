package Lesson08_IteratorsAndComparators.Ex_P09_LinkedListTraversal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<Integer> linkedList = new LinkedList<>();
        int numOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfCommands; i++) {
            String input = scanner.nextLine();
            if (input.contains("Add")) {
                linkedList.add(Integer.parseInt(input.split("\\s+")[1]));
            } else if (input.contains("Remove")) {
                linkedList.remove(Integer.parseInt(input.split("\\s+")[1]));
            }
        }

        System.out.println(linkedList.getSize());
        linkedList.forEach(e -> System.out.print(e + " "));
    }
}
