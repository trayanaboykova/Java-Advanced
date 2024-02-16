package Lesson02_MultidimensionalArrays.Lab;

import java.util.Scanner;

public class P03_IntersectionOfTwoMatrices1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstArray = new char[rows][cols];
        initializeArray(scanner, firstArray);

        char[][] secondArray = new char[rows][cols];
        initializeArray(scanner, secondArray);

        char[][] outputArray = compareArrays(firstArray, secondArray);

        for (char[] row : outputArray) {
            for (char symbol : row) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }

    private static char[][] compareArrays(char[][] firstArray, char[][] secondArray) {
        int numRows = firstArray.length;
        int numCols = findMaxColumns(firstArray);

        char[][] output = new char[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (col < firstArray[row].length && col < secondArray[row].length
                        && firstArray[row][col] == secondArray[row][col]) {
                    output[row][col] = firstArray[row][col];
                } else {
                    output[row][col] = '*';
                }
            }
        }

        return output;
    }

    private static int findMaxColumns(char[][] array) {
        int maxColumns = 0;
        for (char[] row : array) {
            maxColumns = Math.max(maxColumns, row.length);
        }
        return maxColumns;
    }

    private static void initializeArray(Scanner scanner, char[][] array) {
        for (int row = 0; row < array.length; row++) {
            char[] current = scanner.nextLine().replaceAll(" ", "").toCharArray();
            array[row] = current;
        }
    }
}


