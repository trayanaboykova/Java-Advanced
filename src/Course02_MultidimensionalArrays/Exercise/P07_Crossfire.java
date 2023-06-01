package Course02_MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P07_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<List<Integer>> matrix = readMatrix(scanner);

        String input;
        while (!(input = scanner.nextLine()).equals("Nuke it from orbit")) {
            int positionRow = Integer.parseInt(input.split("\\s+")[0]);
            int positionCol = Integer.parseInt(input.split("\\s+")[1]);
            int radius = Integer.parseInt(input.split("\\s+")[2]);

            deleteFromUpToDown(matrix, positionRow, positionCol, radius);

            deleteFromRightToLeft(matrix, positionRow, positionCol, radius);

            matrix.removeIf(List::isEmpty);
        }

        printResult(matrix);
    }

    private static void printResult(List<List<Integer>> matrix) {

        for (List<Integer> currentRow : matrix) {
            for (int currentNum : currentRow) {
                System.out.print(currentNum + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> deleteFromRightToLeft(List<List<Integer>> matrix, int positionRow, int positionCol, int radius) {

        for (int i = positionCol + radius; i >= positionCol - radius; i--) {
            if (isIndexesInBounds(matrix, positionRow, i)) {
                matrix.get(positionRow).remove(i);
            }
        }

        return matrix;
    }

    private static List<List<Integer>> deleteFromUpToDown(List<List<Integer>> matrix, int positionRow, int positionCol, int radius) {

        for (int i = positionRow - radius; i <= positionRow + radius; i++) {
            if (isIndexesInBounds(matrix, i, positionCol) && i != positionRow) {
                matrix.get(i).remove(positionCol);
            }
        }

        return matrix;
    }

    private static boolean isIndexesInBounds(List<List<Integer>> matrix, int row, int col) {

        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static List<List<Integer>> readMatrix(Scanner scanner) {

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();
        int count = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(count++);
            }
        }
        scanner.nextLine();

        return matrix;
    }
}