package ExamPreparation.Exam;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class P01_OffroadChallenge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the initial fuel, consumption indexes, and quantities needed for altitudes
        String[] fuelStr = scanner.nextLine().split(" ");
        String[] consumptionStr = scanner.nextLine().split(" ");
        String[] neededFuelStr = scanner.nextLine().split(" ");

        if (fuelStr.length != consumptionStr.length || consumptionStr.length != neededFuelStr.length) {
            System.out.println("Input data is invalid. Please provide equal-length input.");
            return;
        }

        int[] fuel = new int[fuelStr.length];
        int[] consumption = new int[consumptionStr.length];
        int[] neededFuel = new int[neededFuelStr.length];

        // Convert input strings to integer arrays
        for (int i = 0; i < fuelStr.length; i++) {
            fuel[i] = Integer.parseInt(fuelStr[i]);
            consumption[i] = Integer.parseInt(consumptionStr[i]);
            neededFuel[i] = Integer.parseInt(neededFuelStr[i]);
        }

        int altitude = 1;
        int reachedAltitudes = 0;

        Stack<Integer> fuelStack = new Stack<>();
        Queue<Integer> consumptionQueue = new ArrayDeque<>();

        // Initialize fuel stack and consumption queue
        for (int i = 0; i < fuel.length; i++) {
            fuelStack.push(fuel[i]);
            consumptionQueue.add(consumption[i]);
        }

        // Iterate through altitudes and calculate if John can reach them
        while (altitude <= neededFuel.length) {
            if (!consumptionQueue.isEmpty()) {
                int consumptionValue = consumptionQueue.poll();
                int remainingFuel = fuelStack.pop() - consumptionValue;

                if (remainingFuel >= neededFuel[altitude - 1]) {
                    System.out.println("John has reached: Altitude " + altitude);
                    altitude++;
                    reachedAltitudes++;
                } else {
                    System.out.println("John did not reach: Altitude " + altitude);
                    break;
                }
            } else {
                System.out.println("John did not reach: Altitude " + altitude);
                break;
            }
        }

        // Check if John reached the top or failed
        if (reachedAltitudes == neededFuel.length) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        } else if (reachedAltitudes > 0) {
            System.out.println("John failed to reach the top.");
            System.out.print("Reached altitudes: ");
            for (int i = 1; i < reachedAltitudes; i++) {
                System.out.print("Altitude " + i + ", ");
            }
            System.out.println("Altitude " + reachedAltitudes);
        } else {
            System.out.println("John failed to reach the top.");
            System.out.println("John didn't reach any altitude.");
        }
    }
}
