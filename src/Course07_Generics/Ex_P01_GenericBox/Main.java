package Course07_Generics.Ex_P01_GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            box = new Box<>(input);
            System.out.println(box);
        }
    }
}
