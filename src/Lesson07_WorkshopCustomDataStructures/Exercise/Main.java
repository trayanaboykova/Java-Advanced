package Lesson07_WorkshopCustomDataStructures.Exercise;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addLast(4);

        System.out.println(linkedList.get(2));

        linkedList.removeFirst();
    }
}
