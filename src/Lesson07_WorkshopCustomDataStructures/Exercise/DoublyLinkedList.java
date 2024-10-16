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
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
            this.size++;
        }
    }

    public int get (int index) {
        // стойността на съответния индекс в списъка
        int result = 0; // елементът на дадения индекс
        // 1. проверка дали индексът е валиден
        checkValidIndex(index);
        // 2. проверка дали индексът ми е в началото (от нулевия до средния индекс)
        if (index <= this.size / 2) {
            Node currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            // елементът на дадения индекс
            result = currentNode.currentValue;
        } // индексът е в края (от средния до последния)
        else {
            Node currentNode = this.tail;
            for (int i = size - 1; i > index ; i--) {
                currentNode = currentNode.prev;
            }
            // елементът на дадения индекс
            result = currentNode.currentValue;
        }
        return result;
    }

    private void checkValidIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("The index " + index + " is out of bounds!");
        }
    }

    public boolean isEmpty() {
        // true -> ако имаме празен списък
        // false -> ако списъкът не е празен
        return this.size == 0;
    }
}
