package Course05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        // Reverse the list
        Collections.reverse(numbers);

        // Create a StringBuilder to construct the output string
        StringBuilder output = new StringBuilder();

        // Filter out the numbers not divisible by n and append them to the StringBuilder
        Predicate<Integer> checkDivision = number -> number % n != 0;
        numbers.stream()
                .filter(checkDivision)
                .forEach(number -> output.append(number).append(" "));

        // Remove the trailing space if there are any numbers
        if (output.length() > 0) {
            output.setLength(output.length() - 1);
        }

        // Print the final output string
        System.out.println(output);
    }
}
