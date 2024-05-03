package Lesson07_Generics.Ex_P09_CustomListIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList <T extends Comparable<T>> implements Iterable<T> {

    private class CustomListIterator implements Iterator<T> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < list.size();
        }

        @Override
        public T next() {
            return list.get(index++);
        }
    }

    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    public T remove(int index) {
        return list.remove(index);
    }

    public boolean contains(T element) {
        return list.contains(element);
    }

    public void swap(int indexOne, int indexTwo) {
        Collections.swap(list, indexOne, indexTwo);
    }

    public int countGreaterThan(T element) {
        return (int) list.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return list.stream().max(Comparable::compareTo).get();
    }

    public T getMin() {
        return list.stream().min(Comparable::compareTo).get();
    }

    public int size() {
        return list.size();
    }

    public T get(int index) {
        return list.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomListIterator();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        list.forEach(e -> output.append(e.toString()).append(System.lineSeparator()));
        return output.toString().trim();
    }
}
