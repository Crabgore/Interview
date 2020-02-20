package lesson_3.t3;

import java.util.Iterator;
import java.util.ListIterator;

public class MyLinkedList<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    private class Node<Item> {
        Item value;
        Node next;
        Node prev;

        public Node(Item value) {
            this.value = value;
        }

        public Node(Item value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iter();
    }

    public ListIterator<Item> listIterator() {
        return new ListIter();
    }

    private class Iter implements Iterator<Item> {
        Node current = new Node(null, first, null);

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Item next() {
            current = current.next;
            return (Item) current.value;
        }
    }

    private class ListIter implements ListIterator<Item> {
        Node current = new Node(null, first, last);

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Item next() {
            current = current.next;
            return (Item) current.value;
        }

        @Override
        public boolean hasPrevious() {
            return current.prev != null;
        }

        @Override
        public Item previous() {
            current = current.prev;
            return (Item) current.value;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(Item item) {

        }

        @Override
        public void add(Item item) {

        }
    }

    public void insertFirst(Item item) {
        Node newNode = new Node(item);
        newNode.next = first;
        if (isEmpty()) {
            last = newNode;
        } else {
            first.prev = newNode;
        }
        first = newNode;
        size++;
    }

    public void insertLast(Item item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Список пустой");
        }
        Node oldFirst = first;
        first = first.next;
        if (isEmpty()) {
            last = null;
        } else {
            first.prev = null;
        }
        size--;
        return (Item) oldFirst.value;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Список пустой");
        }
        Node oldLast = last;
        if (last.prev != null) {
            last.prev.next = null;
        } else {
            first = null;
        }
        last = last.prev;
        size--;
        return (Item) oldLast.value;
    }


    public Item getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Список пустой");
        }
        return (Item) first.value;
    }

    public Item getLast() {
        if (isEmpty()) {
            throw new RuntimeException("Список пустой");
        }
        return (Item) last.value;
    }

    public void insert(Item item, int index) {
        if (index <= 0) {
            insertFirst(item);
            return;
        }
        if (index >= size) {
            insertLast(item);
            return;
        }

        Node current = first;
        int i = 0;
        while (i < index - 1) {
            current = current.next;
            i++;
        }
        Node newNode = new Node(item);

        newNode.next = current.next;
        newNode.prev = current;
        current.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    public boolean remove(Item item) {
        if (isEmpty()) {
            return false;
        }
        if (first.value.equals(item)) {
            removeFirst();
            return true;
        }

        Node current = first;
        while (current != null && !current.value.equals(item)) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if (current == last) {
            removeLast();
            return true;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return true;
    }


    public int indexOf(Item item) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.value.equals(item)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(Item item) {
        return indexOf(item) > -1;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.value.toString() + " ");
            current = current.next;
        }
        return sb.toString();
    }
}
