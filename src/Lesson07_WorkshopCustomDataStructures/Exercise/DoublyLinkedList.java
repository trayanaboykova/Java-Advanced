package Lesson07_WorkshopCustomDataStructures.Exercise;

public class DoublyLinkedList {
    // глава - първият елемент(node) в списъка
    private Node head;
    // опашка - последният елемент(node) в списъка
    private Node tail;
    // размер
    private int size;

    public void addFirst(int value) {
        // добавя елемент(node) в началото на списъка
        // 1. създаваме нов node
        Node newNode = new Node(value);
        // 2. проверка дали списъкът е празен
        if (isEmpty()) {
           // празен
            this.head = newNode;
            this.tail = newNode;
        } else {
            // не е празен
            newNode.next = head;
            this.head.prev = newNode;
            this.head = newNode;
        }
    }

    public void addLast(int value) {
        // добавя елемент(node) в края на списъка
        // проверка дали списъкът е празен
        if (isEmpty()) {
            // празен
            addFirst(value);
        } else {
            // не е празен
            // създаваме нов node
            Node newNode = new Node(value);
        }
    }

    public boolean isEmpty() {
        // true -> ако имаме празен списък
        // false -> ако списъкът не е празен
        return this.size == 0;
    }
}
