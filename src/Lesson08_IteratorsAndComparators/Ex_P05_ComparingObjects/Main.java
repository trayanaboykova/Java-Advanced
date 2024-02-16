package Lesson08_IteratorsAndComparators.Ex_P05_ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personsList = new ArrayList<>();
        String input;
        while (!(input = scanner.nextLine()).equals("END")) {

            String[] peopleData = input.split("\\s+");
            String name = peopleData[0];
            int age = Integer.parseInt(peopleData[1]);
            String town = peopleData[2];

            Person person = new Person(name, age, town);
            personsList.add(person);
        }

        int searchedIndex = Integer.parseInt(scanner.nextLine());
        int matchPeopleCount = 0;
        int differentPeopleCount = 0;
        Person mainPerson = personsList.get(searchedIndex - 1);

        for (Person person : personsList) {
            if (person.equals(mainPerson)) {
                matchPeopleCount++;
            } else {
                differentPeopleCount++;
            }
        }

        System.out.println(matchPeopleCount != 1
                ? String.format("%d %d %d", matchPeopleCount, differentPeopleCount, personsList.size())
                : "No matches");
    }
}
