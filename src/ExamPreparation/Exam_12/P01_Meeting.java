package ExamsExercises.Exam_12;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(males::push);
        Deque<Integer> females = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(females::offer);
        int matchesCount = 0;

        while (!males.isEmpty() && !females.isEmpty()) {

            int male = males.peek();
            int female = females.peek();

            if (male <= 0 || female <= 0) {
                if (male <= 0) {
                    males.pop();
                }
                if (female <= 0) {
                    females.poll();
                }
                continue;
            }

            if (male % 25 == 0 || female % 25 == 0) {
                if (male % 25 == 0) {
                    males.pop();
                    males.pop();
                }
                if (female % 25 == 0) {
                    females.poll();
                    females.poll();
                }
                continue;
            }

            if (male == female) {
                matchesCount++;
                males.pop();
                females.poll();
            } else {
                male = males.pop() - 2;
                males.push(male);
                females.poll();
            }
        }

        System.out.printf("Matches: %s\n", matchesCount);
        System.out.println(males.isEmpty() ? "Males left: none" : String.format("Males left: %s", males.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        System.out.println(females.isEmpty() ? "Females left: none" : String.format("Females left: %s", females.stream().map(String::valueOf).collect(Collectors.joining(", "))));
    }
}