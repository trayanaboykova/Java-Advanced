package Course08_IteratorsAndComparators.Ex_P04_Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Lake lake = new Lake(numbers);
        List<String> result = new ArrayList<>();

        for (Integer number : lake) {
            result.add(String.valueOf(number));
        }

        System.out.println(String.join(", ", result));
    }
}
