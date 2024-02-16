package Lesson07_Generics.Ex_P11_Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        String name = String.format("%s %s", input[0], input[1]);
        String hood = input[2];
        String city = input[3];
        Threeuple <String, String, String> firstTuple = new Threeuple<>(name, hood, city);
        System.out.println(firstTuple);

        input = scanner.nextLine().split("\\s+");
        String firstName = input[0];
        int litersOfBeer = Integer.parseInt(input[1]);
        String drunkOrNot = input[2];
        Threeuple<String, Integer, Boolean> secondTuple = new Threeuple<>(firstName, litersOfBeer, drunkOrNot.equals("drunk"));
        System.out.println(secondTuple);

        input = scanner.nextLine().split("\\s+");
        firstName = input[0];
        double doubleNumber = Double.parseDouble(input[1]);
        String bankName = input[2];
        Threeuple<String, Double, String> thirdTuple = new Threeuple<>(firstName, doubleNumber, bankName);
        System.out.println(thirdTuple);
    }
}
