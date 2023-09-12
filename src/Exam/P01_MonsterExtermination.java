package Exam;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P01_MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] armorInput = scanner.nextLine().split(",");
        String[] strikingInput = scanner.nextLine().split(",");

        Deque<Integer> armorQueue = new ArrayDeque<>();
        Deque<Integer> strikingStack = new ArrayDeque<>();

        for (String armor : armorInput) {
            armorQueue.offer(Integer.parseInt(armor));
        }

        for (String striking : strikingInput) {
            strikingStack.push(Integer.parseInt(striking));
        }

        int killedMonsters = 0;

        while (!armorQueue.isEmpty() && !strikingStack.isEmpty()) {
            int currentArmor = armorQueue.peek();
            int currentStriking = strikingStack.pop();

            if (currentStriking >= currentArmor) {
                armorQueue.poll();
                killedMonsters++;
                if (!strikingStack.isEmpty()) {
                    int remainingStriking = strikingStack.pop();
                    strikingStack.push(currentStriking - currentArmor + remainingStriking);
                }
            } else {
                armorQueue.offer(currentArmor - currentStriking);
                armorQueue.offer(armorQueue.poll());
            }
        }

        if (armorQueue.isEmpty()) {
            System.out.println("All monsters have been killed!");
        } else {
            System.out.println("The soldier has been defeated.");
        }

        System.out.println("Total monsters killed: " + killedMonsters);
    }
}