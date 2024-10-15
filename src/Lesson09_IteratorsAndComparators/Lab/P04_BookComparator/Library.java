package Lesson09_IteratorsAndComparators.Lab_P04_BookComparator;

import java.util.Iterator;

public class Library implements Iterable<Book> {

    private class LibIterator implements Iterator<Book> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < books.length;
        }

        @Override
        public Book next() {
            return books[index++];
        }
    }

    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }
}
