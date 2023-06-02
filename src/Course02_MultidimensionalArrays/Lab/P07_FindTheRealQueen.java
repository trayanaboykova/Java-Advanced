package Course02_MultidimensionalArrays.Lab;

import java.util.Scanner;

public class P07_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = readMatrix(scanner);

        String output = checkForAnotherQueen(matrix);

        System.out.println(output);
    }

    private static String checkForAnotherQueen(char[][] matrix) {

        String output = null;
        //Checks for queen in the current row
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'q') {
                    //Checks Up/Down for another queen
                    //Checks Diagonals for another queen
                    if (checksUpDown(row, col, matrix) && checkDiagonals(row, col, matrix)) {
                        return row + " " + col;
                    }
                }
            }
        }

        return null;
    }

    private static boolean checksUpDown(int queenRowPosition, int queenColPosition, char[][] matrix) {

        //Checks for another queen on the Up/Down path by rows, using same column
        for (int row = 0; row < matrix.length; row++) {
            if (row == queenRowPosition) {
                continue;
            }
            if (matrix[row][queenColPosition] == 'q') {
                return false;
            }
        }
        //Checks for another queen on the Left/Right path by columns, using same row
        for (int col = 0; col < matrix.length; col++) {
            if (col == queenColPosition) {
                continue;
            }
            if (matrix[queenRowPosition][col] == 'q') {
                return false;
            }
        }

        return true;
    }
    private static boolean checkDiagonals(int queenRowPosition, int queenColPosition, char[][] matrix) {

        //Checks for another queen on the first diagonal
        int row = queenRowPosition - 1;
        int col = queenColPosition - 1;
        while (col >= 0 && row >= 0) {
            if (matrix[row--][col--] == 'q') {
                return false;
            }
        }
        row = queenRowPosition + 1;
        col = queenColPosition + 1;
        while (col <= matrix.length - 1 && row <= matrix.length - 1) {
            if (matrix[row++][col++] == 'q') {
                return false;
            }
        }

        //Checks for another queen on the second diagonal
        row = queenRowPosition - 1;
        col = queenColPosition + 1;
        while (col <= matrix.length - 1 && row >= 0) {
            if (matrix[row--][col++] == 'q') {
                return false;
            }
        }
        row = queenRowPosition + 1;
        col = queenColPosition - 1;
        while (col >= 0 && row <= matrix.length - 1) {
            if (matrix[row++][col--] == 'q') {
                return false;
            }
        }

        return true;
    }


    private static char[][] readMatrix(Scanner scanner) {

        char[][] matrix = new char[8][8];
        for (int row = 0; row < matrix.length; row++) {
            char[] current = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[row] = current;
        }

        return matrix;
    }
}

