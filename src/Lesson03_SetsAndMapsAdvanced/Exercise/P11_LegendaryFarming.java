package Lesson03_SetsAndMapsAdvanced.Exercise;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P11_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> legendaryMaterials = new HashMap<>();
        HashMap<String, Integer> junkMaterials = new HashMap<>();

        legendaryMaterials.put("shards", 0);
        legendaryMaterials.put("fragments", 0);
        legendaryMaterials.put("motes", 0);

        boolean isCollected = false;
        while (!isCollected) {
            String[] tokens = scanner.nextLine().toLowerCase().split("\\s+");
            for (int i = 0; i < tokens.length && !isCollected; i += 2) {
                String materials = tokens[i + 1];
                int amount = Integer.parseInt(tokens[i]);

                if ("shards".equals(materials) || "fragments".equals(materials) || "motes".equals(materials)) {
                    amount += legendaryMaterials.get(materials);
                    if (amount >= 250) {
                        amount -= 250;
                        isCollected = true;
                        switch (materials) {
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                break;
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                break;
                        }
                    }
                    legendaryMaterials.put(materials, amount);
                } else {
                    if (junkMaterials.containsKey(materials)) {
                        junkMaterials.put(materials, junkMaterials.get(materials) + amount);
                    } else {
                        junkMaterials.put(materials, amount);
                    }
                }
            }
        }

        legendaryMaterials.entrySet().stream().sorted((e1, e2) -> {
                    if (e2.getValue().compareTo(e1.getValue()) == 0){
                        return e1.getKey().compareTo(e2.getKey());
                    }
                    return e2.getValue().compareTo(e1.getValue());
                })
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        junkMaterials.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
    }
}
