package ExamsExercises.Exam_19;

import java.util.*;
import java.util.stream.Collectors;

public class P01_ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Integer> textiles = new ArrayDeque<>(
                Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));

        Stack<Integer> medicaments = new Stack<>();
        Stack<Integer> reverseMedicaments = new Stack<>();

        String[] medicamentsArray = scanner.nextLine().split("\\s+");


        for (int i = 0; i < medicamentsArray.length; i++) {
            medicaments.add(Integer.parseInt(medicamentsArray[i]));
        }

        Map<Integer, String> table = new HashMap<>();
        table.put(30, "Patch");
        table.put(40, "Bandage");
        table.put(100, "MedKit");

        Map<String, Integer> items = new HashMap<>();

        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int sum = textiles.peek() + medicaments.peek();

            if (table.containsKey(sum)) {
                if (!items.containsKey(table.get(sum))) {
                    items.put(table.get(sum), 0);
                }

                items.put(table.get(sum), items.get(table.get(sum)) + 1);

                textiles.poll();
                medicaments.pop();
            } else {
                if (sum > 100) {
                    if (!items.containsKey("MedKit")) {
                        items.put("MedKit", 0);
                    }

                    items.put("MedKit", items.get("MedKit") + 1);

                    sum -= 100;
                    medicaments.pop();
                    medicaments.push(medicaments.pop() + sum);
                    textiles.remove();
                } else {
                    medicaments.push(medicaments.pop() + 10);
                    textiles.remove();
                }
            }
        }

        if (textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }

        List<Map.Entry<String, Integer>> orderedItems =
                new ArrayList<>(items.entrySet());
        Collections.sort(orderedItems,
                Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed().
                        thenComparing(Map.Entry<String, Integer>::getKey));

        for (Map.Entry<String, Integer> item : orderedItems) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }

        if (!textiles.isEmpty()) {
            System.out.println("Textiles left: " + String.join(", ", textiles.toString()).replace("[", "").replace("]", "").trim());
        } else if (!medicaments.isEmpty()) {
            for (int i = 0; i < medicaments.size(); i++) {
                reverseMedicaments.add(medicaments.get(i));
            }
            ArrayList<String> result = new ArrayList<>();

            while (!reverseMedicaments.isEmpty()) {
                String temp = String.valueOf(reverseMedicaments.pop());
                result.add(temp);
                if (reverseMedicaments.isEmpty()) {
                    break;
                }
                temp = "";
            }
            System.out.print("Medicaments left: ");
            String joined = String.join(", ", result);

            System.out.println(joined);
        }
    }
}
