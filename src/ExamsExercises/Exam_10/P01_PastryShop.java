package ExamsExercises.Exam_10;

import java.util.*;
import java.util.stream.Collectors;

public class P01_PastryShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String biscuit = "Biscuit";
        String cake = "Cake";
        String pie = "Pie";
        String pastry = "Pastry";
        Map<String, Integer> productsMap = new LinkedHashMap<>();
        productsMap.put(biscuit, 0);
        productsMap.put(cake, 0);
        productsMap.put(pie, 0);
        productsMap.put(pastry, 0);
        Deque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(liquids::offer);
        Deque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {

            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            int sum = liquid + ingredient;

            if (sum == 25) {
                productsMap.put(biscuit, productsMap.get(biscuit) + 1);
            } else if (sum == 50) {
                productsMap.put(cake, productsMap.get(cake) + 1);
            } else if (sum == 75) {
                productsMap.put(pastry, productsMap.get(pastry) + 1);
            } else if (sum == 100) {
                productsMap.put(pie, productsMap.get(pie) + 1);
            } else {
                ingredient += 3;
                ingredients.push(ingredient);
            }
        }
        if (productsMap.get("Biscuit") != 0 && productsMap.get("Cake") != 0
                && productsMap.get("Pastry") != 0 && productsMap.get("Pie") != 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        System.out.println(liquids.isEmpty()
                ? "Liquids left: none"
                : String.format("Liquids left: %s", liquids.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        System.out.println(ingredients.isEmpty() ?
                "Ingredients left: none"
                : String.format("Ingredients left: %s", ingredients.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        productsMap.forEach((p, v) -> System.out.printf("%s: %d\n", p, v));
    }
}


