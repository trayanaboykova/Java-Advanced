package Course08_IteratorsAndComparators.Ex_P08_PetClinics;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfCommands = Integer.parseInt(scanner.nextLine());
        Map<String, Pet> petsMap = new LinkedHashMap<>();
        Map<String, Clinic> clinicsMap = new LinkedHashMap<>();

        for (int i = 0; i < numOfCommands; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            String clinicName;
            switch (command) {
                case "Create":
                    if (input[1].equals("Pet")) {
                        String name = input[2];
                        int age = Integer.parseInt(input[3]);
                        String kind = input[4];
                        Pet pet = new Pet(name, age, kind);
                        petsMap.put(name, pet);
                    } else if (input[1].equals("Clinic")) {
                        String name = input[2];
                        int capacity = Integer.parseInt(input[3]);
                        try {
                            Clinic clinic = new Clinic(name, capacity);
                            clinicsMap.put(name, clinic);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Add":
                    String petName = input[1];
                    clinicName = input[2];
                    System.out.println(clinicsMap.get(clinicName).add(petsMap.get(petName)));
                    break;
                case "Release":
                    clinicName = input[1];
                    System.out.println(clinicsMap.get(clinicName).release());
                    break;
                case "HasEmptyRooms":
                    String name = input[1];
                    System.out.println(clinicsMap.get(name).hasEmptyRooms());
                    break;
                case "Print":
                    if (input.length == 2) {
                        clinicName = input[1];
                        clinicsMap.get(clinicName).printAllRooms();
                    } else {
                        clinicName = input[1];
                        int room = Integer.parseInt(input[2]);
                        clinicsMap.get(clinicName).printRoom(room);
                    }
                    break;
            }
        }
    }
}
