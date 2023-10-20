package ExamsExercises.Exam_20;

import java.util.*;

public class P01_RubberDuckDebbugers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] programmersString = scanner.nextLine().split("\\s+");
        String[] tasksString = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> programmers = new ArrayDeque<>();
        Stack<Integer> tasks = new Stack<>();
        Map<String, Integer> givenDucks = new LinkedHashMap<>();
        givenDucks.put("Darth Vader Ducky", 0);
        givenDucks.put("Thor Ducky", 0);
        givenDucks.put("Big Blue Rubber Ducky", 0);
        givenDucks.put("Small Yellow Rubber Ducky", 0);

        Arrays.stream(programmersString)
                .mapToInt(Integer::parseInt)
                .forEach(programmers::offer);

        Arrays.stream(tasksString)
                .mapToInt(Integer::parseInt)
                .forEach(tasks::push);

        while (!programmers.isEmpty() && !tasks.isEmpty()){
            int currentProgrammer = programmers.peek();
            int currentTask = tasks.peek();
            int timeTaken = currentProgrammer * currentTask;

            if (timeTaken > 0 && timeTaken <= 60){
                givenDucks.put("Darth Vader Ducky", givenDucks.get("Darth Vader Ducky") + 1);
                programmers.poll();
                tasks.pop();
            }else if(timeTaken > 60 && timeTaken <= 120){
                givenDucks.put("Thor Ducky", givenDucks.get("Thor Ducky") + 1);
                programmers.poll();
                tasks.pop();
            }else if(timeTaken > 120 && timeTaken <= 180){
                givenDucks.put("Big Blue Rubber Ducky", givenDucks.get("Big Blue Rubber Ducky") + 1);
                programmers.poll();
                tasks.pop();
            }else if(timeTaken > 180 && timeTaken <= 240){
                givenDucks.put("Small Yellow Rubber Ducky", givenDucks.get("Small Yellow Rubber Ducky") + 1);
                programmers.poll();
                tasks.pop();
            }else{
                programmers.offerLast(programmers.poll());
                tasks.push(tasks.pop() - 2);
            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded: ");

        for (Map.Entry<String, Integer> entry : givenDucks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}
