package Lesson07_WorkshopCustomDataStructures.Exercise;

// всеки елемент в нашия свързан списък
public class Node {
    // текуща целочислена стойност
    public int currentValue;
    // предишния елемент
    public Node next;
    // следващия елемент (node)
    public Node prev;

    // конструктор -> създава елемент по текуща стойност
    public Node(int currentValue) {
        this.currentValue = currentValue;
    }

    // node (елемент) -> string
    @Override
    public String toString() {
        return "" + this.currentValue;
    }
}
