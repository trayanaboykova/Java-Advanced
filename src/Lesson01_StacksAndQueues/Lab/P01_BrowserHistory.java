package Lesson01_StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String currentURL = null;
        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (stack.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }else{
                    currentURL = stack.pop();
                }

            } else {
                if (currentURL != null) {
                    stack.push(currentURL);
                }
                currentURL = input;
            }

            System.out.println(currentURL);

            input = scanner.nextLine();
        }

    }
}


