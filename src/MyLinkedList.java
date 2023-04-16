import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList<T extends Comparable<T>> implements Iterable<T> {
    class Node {
        private final T data;
        private Node prev;
        private Node next;

        public Node (T data) {
            this.data = data;
        }

        public Node (T data, Node prev) {
            this(data);
            this.prev = prev;
        }

        public Node (T data, Node prev, Node next) {
            this(data, prev);
            this.next = next;
        }
    }
    private int size;
    private Node head;
    private Node tail;

    public int size() {
        return size;
    }

    public boolean contains(Object o) {
        Node temp = head;
        for(int i = 0; i < size; i++) {
            if(temp.data.equals(o)) return true;
            temp = temp.next;
        }
        return false;
    }

    public void add(T item) {
        Node newNode = new Node(item);
        if(head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    public void add(T item, int index) {
        if(index > size || index < 0) throw new IndexOutOfBoundsException();

        Node newNode = new Node(item);

        if(index == 0) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            return;
        }

        if(index == size) {
            add(item);
            return;
        }

        Node temp = head;
        for(int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node nextNode = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        nextNode.prev = newNode;
        newNode.next = nextNode;
        size++;
    }

    public T get(int index) {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
        Node node = head;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    public T remove(int index) {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();

        if(index == 0) {
            T data = head.data;
            head = head.next;
            return data;
        }

        if(index == size - 1) {
            T data = tail.data;
            tail = tail.prev;
            tail.next = null;
            return data;
        }

        Node node = head;
        for(int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        T data = node.data;
        node.next = node.next.next;
        size--;
        return data;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int cursor;
        private Node node = head;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            T data = node.data;
            node = node.next;
            return data;
        }
    }
}
