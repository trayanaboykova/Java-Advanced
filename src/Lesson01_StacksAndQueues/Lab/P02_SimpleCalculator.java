package Lesson01_StacksAndQueues.Lab;

import java.util.*;

public class P02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();

        String expression = scanner.nextLine();
        String[] expressionParts = expression.split(" ");
        List<String> partsList = Arrays.asList(expressionParts);


        Collections.reverse(partsList);

        for (String part : partsList) {
            stack.push(part);
        }

        while (stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int second = Integer.parseInt(stack.pop());

            int result;
            switch (operator) {
                case "+": result = first + second;
                break;
                case "-": result = first - second;
                break;
                default:
                    System.out.println("Unknown operation " + operator);
                    return;
            }

            stack.push("" + result);
        }

        System.out.println(stack.peek());
    }
}

