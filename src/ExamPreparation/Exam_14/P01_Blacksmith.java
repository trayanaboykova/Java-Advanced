package ExamsExercises.Exam_14;

import java.util.*;
import java.util.stream.Collectors;

public class P01_Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String gladius = "Gladius";
        String katana = "Katana";
        String sabre = "Sabre";
        String shamshir = "Shamshir";
        Map<String, Integer> swordsMap = new TreeMap<>(Map.of(
                gladius, 0,
                katana, 0,
                sabre, 0,
                shamshir, 0
        ));
        int swordsCount = 0;
        Deque<Integer> steel = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(steel::offer);
        Deque<Integer> carbon = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(carbon::push);

        while (!steel.isEmpty() && !carbon.isEmpty()) {
            int currentSteel = steel.poll();
            int currentCarbon = carbon.pop();
            int product = currentSteel + currentCarbon;

            if (product == 70) {
                swordsMap.put(gladius, swordsMap.get(gladius) + 1);
                swordsCount++;
            } else if (product == 80) {
                swordsMap.put(shamshir, swordsMap.get(shamshir) + 1);
                swordsCount++;
            } else if (product == 90) {
                swordsMap.put(katana, swordsMap.get(katana) + 1);
                swordsCount++;
            } else if (product == 110) {
                swordsMap.put(sabre, swordsMap.get(sabre) + 1);
                swordsCount++;
            } else {
                currentCarbon += 5;
                carbon.push(currentCarbon);
            }
        }

        System.out.println(swordsCount > 0
                ? String.format("You have forged %d swords.", swordsCount)
                : "You did not have enough resources to forge a sword.");
        System.out.println(steel.isEmpty()
                ? "Steel left: none"
                : String.format("Steel left: %s", steel.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "))));
        System.out.println(carbon.isEmpty()
                ? "Carbon left: none"
                : String.format("Carbon left: %s", carbon.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "))));
        swordsMap.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));
    }
}
