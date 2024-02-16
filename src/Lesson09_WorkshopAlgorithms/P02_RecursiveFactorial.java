package Lesson09_WorkshopAlgorithms;

import java.util.Scanner;

public class P02_RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fact = Integer.parseInt(scanner.nextLine());

        int sum = findFact(fact);
        System.out.println(sum);
    }

    private static int findFact(int fact) {
        if (fact == 1) {
            return fact;
        }

        return fact * findFact(fact - 1);
    }
}
