package Lesson01_StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P02_SimpleCalculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        int sign = 1;
        stack.add(0); // Initialize the stack with 0 as the base value

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '+') {
                stack.add(num * sign); // Add the current number to the stack
                num = 0;
                sign = 1;
            } else if (ch == '-') {
                stack.add(num * sign); // Add the current number to the stack
                num = 0;
                sign = -1;
            }
        }

        stack.add(num * sign); // Add the last number to the stack

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop(); // Pop and add the values from the stack
        }

        System.out.println (result);
    }
}