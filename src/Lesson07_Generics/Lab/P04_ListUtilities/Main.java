package Lesson07_Generics.Lab_P04_ListUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        System.out.println(ListUtils.getMax(nums));
        System.out.println(ListUtils.getMin(nums));

        List<String> strings= List.of("a", "Ivan", "j", "n");

        System.out.println(ListUtils.getMax(strings));
        System.out.println(ListUtils.getMin(strings));
    }
}
