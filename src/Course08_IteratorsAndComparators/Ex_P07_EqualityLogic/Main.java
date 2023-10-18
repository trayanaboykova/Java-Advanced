package Course08_IteratorsAndComparators.Ex_P07_EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> personsTree = new TreeSet<>();
        HashSet<Person> personsHash = new HashSet<>();

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name, age);

            personsTree.add(person);
            personsHash.add(person);
        }

        System.out.println(personsTree.size());
        System.out.println(personsHash.size());
    }
}
