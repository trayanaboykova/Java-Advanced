package Exam;

import java.util.Scanner;

public class P02_DeliveryBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        char[][] matrix = new char[rows][cols];
        int startRow = -1, startCol = -1;

        for (int i = 0; i < rows; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = row.charAt(j);
                if (matrix[i][j] == 'B') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        boolean pizzaCollected = false;
        boolean pizzaDelivered = false;

        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            int newRow = startRow;
            int newCol = startCol;

            if (command.equals("up")) {
                newRow--;
            } else if (command.equals("down")) {
                newRow++;
            } else if (command.equals("left")) {
                newCol--;
            } else if (command.equals("right")) {
                newCol++;
            }

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || matrix[newRow][newCol] == '*') {
                System.out.println("The delivery is late. Order is canceled.");
                return;
            }

            matrix[startRow][startCol] = '.';

            if (matrix[newRow][newCol] == 'P') {
                pizzaCollected = true;
                matrix[newRow][newCol] = 'R';
                System.out.println("Pizza is collected. 10 minutes for delivery.");
            } else if (matrix[newRow][newCol] == 'A') {
                if (!pizzaCollected) {
                    System.out.println("The delivery is late. Order is canceled.");
                    return;
                }
                pizzaDelivered = true;
                matrix[newRow][newCol] = 'P';
                System.out.println("Pizza is delivered on time! Next order...");
            } else {
                matrix[newRow][newCol] = '-';
            }

            startRow = newRow;
            startCol = newCol;

            if (pizzaCollected && pizzaDelivered) {
                break;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}