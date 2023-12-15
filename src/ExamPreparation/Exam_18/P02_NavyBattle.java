package ExamsExercises.Exam_18;

import java.util.Objects;
import java.util.Scanner;

public class P02_NavyBattle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        int submarineRow = -1;
        int submarineCol = -1;

        for (int i = 0; i < n; i++) {
            char[] arr = scanner.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = arr[j];
                if (matrix[i][j] == 'S') {
                    submarineRow = i;
                    submarineCol = j;
                }
            }
        }

        int hits = 0;
        int cruisersHit = 0;
        String command = scanner.nextLine();

        while (true){
            matrix[submarineRow][submarineCol] = '-';

            if (Objects.equals(command, "up")) {
                submarineRow--;
            } else if (Objects.equals(command, "down")) {
                submarineRow++;
            } else if (Objects.equals(command, "left")) {
                submarineCol--;
            } else if (Objects.equals(command, "right")) {
                submarineCol++;
            }

            if (matrix[submarineRow][submarineCol] == '-') {
                matrix[submarineRow][submarineCol] = 'S';
            } else if (matrix[submarineRow][submarineCol] == '*') {
                matrix[submarineRow][submarineCol] = 'S';
                hits++;

                if (hits == 3) {
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", submarineRow, submarineCol);
                    break;
                }
            }

            if (matrix[submarineRow][submarineCol] == 'C') {
                matrix[submarineRow][submarineCol] = 'S';
                cruisersHit++;
                if (cruisersHit == 3) {
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    break;
                }
            }
            command = scanner.nextLine();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
