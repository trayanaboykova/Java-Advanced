package Lesson07_WorkshopCustomDataStructures;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

//        list.add(13);
//        list.add(2);
//        list.add(65);
//        list.add(34);
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        list.forEach(System.out::println);

        SmartArray smartArray = new SmartArray();

//        smartArray.add(13);
//        smartArray.add(3);
//        smartArray.add(65);
//        smartArray.add(34);
//
//        for (int i = 0; i < smartArray.size(); i++) {
//            System.out.println(smartArray.get(i));
//        }

        smartArray.forEach(System.out::println);

        SmartStack smartStack = new SmartStack();

        smartStack.push(13);
        smartStack.push(3);
        smartStack.push(65);
        smartStack.push(34);

        smartStack.forEach(System.out::println);
}
    }
