package Lesson08_Generics.Ex_P10_Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        String name = String.format("%s %s", input[0], input[1]);
        String city = input[2];
        Tuple<String, String> firstTuple = new Tuple<>(name, city);
        System.out.println(firstTuple);

        input = scanner.nextLine().split("\\s+");
        String firstName = input[0];
        int litersOfBeer = Integer.parseInt(input[1]);
        Tuple<String, Integer> secondTuple = new Tuple<>(firstName, litersOfBeer);
        System.out.println(secondTuple);

        input = scanner.nextLine().split("\\s+");
        int number = Integer.parseInt(input[0]);
        double doubleNumber = Double.parseDouble(input[1]);
        Tuple<Integer, Double> thirdTuple = new Tuple<>(number, doubleNumber);
        System.out.println(thirdTuple);
    }
}
