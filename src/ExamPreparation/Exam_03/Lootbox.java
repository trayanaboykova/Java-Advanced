package ExamsExercises.Exam_03;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Integer> firstBoxQueue = new ArrayDeque<>();
        Stack<Integer> secondBoxStack = new Stack<>();

        String[] firstBox = scanner.nextLine().split(" ");
        String[] secondBox = scanner.nextLine().split(" ");

        for (String box : firstBox) {
            firstBoxQueue.offer(Integer.parseInt(box));
        }

        for (String box : secondBox) {
            secondBoxStack.push(Integer.parseInt(box));
        }

        int sumOfClaimedItems = 0;

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {

            int firstNumber = firstBoxQueue.peek();
            int secondNumber = secondBoxStack.peek();

            int currentSum = firstNumber + secondNumber;

            if (currentSum % 2 == 0) {
                sumOfClaimedItems += currentSum;
                firstBoxQueue.poll();
                secondBoxStack.pop();
            } else {
                firstBoxQueue.offer(secondNumber);
                secondBoxStack.pop();
            }
        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else if (secondBoxStack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (sumOfClaimedItems >= 90) {
            System.out.printf("Your loot was epic! Value: %d%n", sumOfClaimedItems);
        } else {
            System.out.printf("Your loot was poor... Value: %d%n", sumOfClaimedItems);
        }
    }
}
