package ExamsExercises.Exam_12;

import java.util.Scanner;

public class P02_ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int dimensions = Integer.parseInt(scanner.nextLine());
        String[][] matrix = fillMatrix(scanner, dimensions);
        int currentRow = findRow(matrix);
        int currentCol = findCol(matrix);
        matrix[currentRow][currentCol] = "-";

        while (true) {

            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            int spartanRow = Integer.parseInt(input[1]);
            int spartanCol = Integer.parseInt(input[2]);
            matrix[spartanRow][spartanCol] = "S";

            switch (command) {
                case "up":
                    if (isInBounds(currentRow - 1, currentCol, matrix)) {
                        currentRow--;
                        energy--;
                    } else {
                        energy--;
                    }
                    break;
                case "down":
                    if (isInBounds(currentRow + 1, currentCol, matrix)) {
                        currentRow++;
                        energy--;
                    } else {
                        energy--;
                    }
                    break;
                case "left":
                    if (isInBounds(currentRow, currentCol - 1, matrix)) {
                        currentCol--;
                        energy--;
                    } else {
                        energy--;
                    }
                    break;
                case "right":
                    if (isInBounds(currentRow, currentCol + 1, matrix)) {
                        currentCol++;
                        energy--;
                    } else {
                        energy--;
                    }
                    break;
            }

            if (matrix[currentRow][currentCol].equals("S")) {
                energy -= 2;
                if (energy <= 0) {
                    matrix[currentRow][currentCol] = "X";
                    System.out.printf("Paris died at %d;%d.\n", currentRow, currentCol);
                    printMatrix(matrix);
                    return;
                }
                matrix[currentRow][currentCol] = "-";
            } else if (matrix[currentRow][currentCol].equals("H")) {
                matrix[currentRow][currentCol] = "-";
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d\n", energy);
                printMatrix(matrix);
                return;
            } else if (energy <= 0) {
                matrix[currentRow][currentCol] = "X";
                System.out.printf("Paris died at %d;%d.\n", currentRow, currentCol);
                printMatrix(matrix);
                return;
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] current : matrix) {
            System.out.println(String.join("", current));
        }
    }

    private static boolean isInBounds(int row, int col, String[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int findCol(String[][] matrix) {
        for (String[] strings : matrix) {
            for (int col = 0; col < strings.length; col++) {
                if (strings[col].equals("P")) {
                    return col;
                }
            }
        }
        return -1;
    }

    private static int findRow(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("P")) {
                    return row;
                }
            }
        }
        return -1;
    }

    private static String[][] fillMatrix(Scanner scanner, int dimension) {
        String[][] matrix = new String[dimension][dimension];
        for (int row = 0; row < matrix.length; row++) {
            String[] current = scanner.nextLine().split("");
            matrix[row] = current;
        }
        return matrix;
    }
}
