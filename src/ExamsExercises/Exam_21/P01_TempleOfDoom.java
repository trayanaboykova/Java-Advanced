package ExamsExercises.Exam_21;

import java.util.*;
import java.util.stream.Collectors;

public class P01_TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Integer> tools = new LinkedList<>(Arrays.stream(scanner.nextLine().split(" ", -1))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList()));

        Stack<Integer> substances = new Stack<>();
        Arrays.stream(scanner.nextLine().split(" ", -1))
                .mapToInt(Integer::parseInt)
                .forEach(substances::push);

        List<Integer> challenges = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ", -1))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList()));

        while (true) {
            int tool = tools.peek();
            int substance = substances.peek();

            if (challenges.contains(tool * substance)) {
                challenges.remove(Integer.valueOf(tool * substance));
                tools.poll();
                substances.pop();

                if (challenges.isEmpty()) {
                    System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
                    break;
                }

            } else {
                tools.offer(tools.poll() + 1);
                substances.push(substances.pop() - 1);

                if (substances.peek() == 0) {
                    substances.pop();
                }

                if (substances.isEmpty()) {
                    System.out.println("Harry is lost in the temple. Oblivion awaits him.");
                    break;
                }
            }
        }

        if (!tools.isEmpty()) {
            System.out.println("Tools: " + tools.stream().map(Object::toString).collect(Collectors.joining(", ")));
        }
        if (!substances.isEmpty()) {
            System.out.println("Substances: " + substances.stream().map(Object::toString).collect(Collectors.joining(", ")));
        }
        if (!challenges.isEmpty()) {
            System.out.println("Challenges: " + challenges.stream().map(Object::toString).collect(Collectors.joining(", ")));
        }

        scanner.close();
    }
}

