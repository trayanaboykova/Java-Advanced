package Exam;

import java.util.Scanner;

public class P02_FishingCompetition {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] fishingArea = new char[n][n];
        int fishCaught = 0;
        int startRow = 0;
        int startCol = 0;


        for (int i = 0; i < n; i++) {
            String row = scanner.nextLine();
            fishingArea[i] = row.toCharArray();
            if (row.contains("S")) {
                startRow = i;
                startCol = row.indexOf("S");
            }
        }


        boolean hasReachedQuota = false;

        while (true) {
            String command = scanner.nextLine();
            // Update the matrix before moving the ship
            fishingArea[startRow][startCol] = '-';
            switch (command) {
                case "up":
                    startRow = (startRow - 1 + n) % n;
                    break;
                case "down":
                    startRow = (startRow + 1) % n;
                    break;
                case "left":
                    startCol = (startCol - 1 + n) % n;
                    break;
                case "right":
                    startCol = (startCol + 1) % n;
                    break;
                case "collect the nets":
                    if (fishCaught >= 20) {
                        hasReachedQuota = true;
                    }
                    if (hasReachedQuota) {
                        System.out.println("Success! You managed to reach the quota!");
                    } else {
                        int lackOfFish = 20 - fishCaught;
                        System.out.println("You didn't catch enough fish and didn't reach the quota! You need " + lackOfFish + " tons of fish more.");
                    }
                    if (fishCaught > 0){
                        System.out.println("Amount of fish caught: " + fishCaught + " tons.");
                    }
                    fishingArea[startRow][startCol] = 'S';
                    printMatrix(fishingArea);
                    return;
            }

            char currentSymbol = fishingArea[startRow][startCol];

            if (currentSymbol == 'W') {
                System.out.println("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [" + startRow + "," + startCol + "]");
                break;
            } else if (Character.isDigit(currentSymbol)) {
                int fishQuantity = Integer.parseInt(String.valueOf(currentSymbol));
                fishCaught += fishQuantity;
                fishingArea[startRow][startCol] = '-';
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}