package Lesson07_Generics.Ex_P04_GenericSwapMethodInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> list = new Box<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            list.add(input);
        }

        int indexOne = scanner.nextInt();
        int indexTwo = scanner.nextInt();
        scanner.close();

        list.swapPlace(indexOne, indexTwo);
        System.out.println(list);
    }
}
