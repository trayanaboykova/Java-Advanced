package Course08_IteratorsAndComparators.Ex_P02_Collection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListyIterator listyIterator = null;
        String input;
        while (!(input = scanner.nextLine()).equals("END")) {

            String[] line = input.split("\\s+");

            switch (line[0]) {
                case "Create":
                    if (line.length > 1) {
                        String[] collection = new String[line.length - 1];
                        System.arraycopy(line, 1, collection, 0, line.length - 1);
                        listyIterator = new ListyIterator(collection);
                    } else {
                        listyIterator = new ListyIterator();
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println("Invalid Operation!");
                    }
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;

            }
        }
    }
}
