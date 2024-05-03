package Lesson08_IteratorsAndComparators.Ex_P03_StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomStack<Integer> customStack = new CustomStack<>();

        String input;
        while (!(input = scanner.nextLine()).trim().equals("END")) {
            if (input.contains("Push")) {
                input = input.replace("Push ", "");
                String[] data = input.split(",\\s+");
                for (String num : data) {
                    customStack.push(Integer.valueOf(num));
                }
            } else if (input.contains("Pop")) {
                try {
                    customStack.pop();
                } catch (IllegalArgumentException e) {
                    System.out.println("No elements");
                }
            }
        }

        customStack.forEach(System.out::println);
        customStack.forEach(System.out::println);
    }
}
