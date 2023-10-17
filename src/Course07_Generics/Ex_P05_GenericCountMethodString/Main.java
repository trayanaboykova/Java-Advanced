package Course07_Generics.Ex_P05_GenericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<String> list = new Box<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            list.add(input);
        }

        String element = scanner.nextLine();

        System.out.println(list.countOfGreaterItems(element));
    }
}
