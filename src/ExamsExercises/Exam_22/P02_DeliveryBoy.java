package ExamsExercises.Exam_22;

import java.util.Scanner;

public class P02_DeliveryBoy {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] field = new String[rows][cols];
        int boyRow = -1;
        int boyCol = -1;

        int startRow = -1;
        int startCol = -1;

        boolean hasLeft = false;

        for (int i = 0; i < rows; i++) {
            String newRow = scanner.nextLine();
            for (int j = 0; j < cols; j++) {
                field[i][j] = String.valueOf(newRow.charAt(j));

                if ("B".equals(field[i][j])) {
                    boyRow = i;
                    boyCol = j;
                    startRow = i;
                    startCol = j;
                }
            }
        }

        while (true) {
            String command = scanner.nextLine();

            if ("left".equals(command)) {
                if (boyCol > 0) {
                    if ("*".equals(field[boyRow][boyCol - 1])) {
                        continue;
                    }

                    if (!"R".equals(field[boyRow][boyCol])) {
                        field[boyRow][boyCol] = ".";
                    }
                    boyCol--;
                } else {
                    if ("-".equals(field[boyRow][boyCol])) {
                        field[boyRow][boyCol] = ".";
                    }
                    hasLeft = true;
                    System.out.println("The delivery is late. Order is canceled.");
                    break;
                }
            }
            // "right" command
            if ("right".equals(command)) {
                if (boyCol < cols - 1) {
                    if ("*".equals(field[boyRow][boyCol + 1])) {
                        continue;
                    }
                    if (!"R".equals(field[boyRow][boyCol])) {
                        field[boyRow][boyCol] = ".";
                    }
                    boyCol++;
                } else {
                    if ("-".equals(field[boyRow][boyCol])) {
                        field[boyRow][boyCol] = ".";
                    }
                    hasLeft = true;
                    System.out.println("The delivery is late. Order is canceled.");
                    break;
                }
            }

// "up" command
            if ("up".equals(command)) {
                if (boyRow > 0) {
                    if ("*".equals(field[boyRow - 1][boyCol])) {
                        continue;
                    }
                    if (!"R".equals(field[boyRow][boyCol])) {
                        field[boyRow][boyCol] = ".";
                    }
                    boyRow--;
                } else {
                    if ("-".equals(field[boyRow][boyCol])) {
                        field[boyRow][boyCol] = ".";
                    }
                    hasLeft = true;
                    System.out.println("The delivery is late. Order is canceled.");
                    break;
                }
            }

// "down" command
            if ("down".equals(command)) {
                if (boyRow < rows - 1) {
                    if ("*".equals(field[boyRow + 1][boyCol])) {
                        continue;
                    }
                    if (!"R".equals(field[boyRow][boyCol])) {
                        field[boyRow][boyCol] = ".";
                    }
                    boyRow++;
                } else {
                    if ("-".equals(field[boyRow][boyCol])) {
                        field[boyRow][boyCol] = ".";
                    }
                    hasLeft = true;
                    System.out.println("The delivery is late. Order is canceled.");
                    break;
                }
            }


            // Check if the delivery boy reached a pizza
            if ("P".equals(field[boyRow][boyCol])) {
                System.out.println("Pizza is collected. 10 minutes for delivery.");
                field[boyRow][boyCol] = "R";
                continue;
            }

            // Check if the delivery boy reached the customer
            if ("A".equals(field[boyRow][boyCol])) {
                field[boyRow][boyCol] = "P";
                System.out.println("Pizza is delivered on time! Next order...");
                break;
            }
        }

        if (hasLeft) {
            field[startRow][startCol] = " ";
        } else {
            field[startRow][startCol] = "B";
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }

        scanner.close();
    }
}