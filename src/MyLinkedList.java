import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T>{
    class Node {
        private T data;
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

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        Node temp = head;
        for(int i = 0; i < size; i++) {
            if(temp.data.equals(o)) return true;
            temp = temp.next;
        }
        return false;
    }

    @Override
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

    @Override
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

    @Override
    public boolean remove(T item) {
        int index = indexOf(item);
        if(index == -1) return false;
        remove(index);
        return true;
    }

    @Override
    public T get(int index) {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
        Node node = head;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    @Override
    public int indexOf(Object o) {
        Node node = head;
        for(int i = 0; i < size; i++) {
            if(node.data.equals(o)) return i;
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node node = tail;
        for(int i = size - 1; i >= 0; i--) {
            if(node.data.equals(o)) return i;
            node = node.prev;
        }
        return -1;
    }

    @Override
    public void sort() {
        for(Node i = tail; i.prev != null; i = i.prev) {
            for(Node j = head; j != i; j = j.next) {
                if(j.data.compareTo(j.next.data) > 0) {
                    T data = j.data;
                    j.data = j.next.data;
                    j.next.data = data;
                }
            }
        }
    }

    @Override
    public void sort(boolean ascending) {
        for(Node i = tail; i.prev != null; i = i.prev) {
            for(Node j = head; j != i; j = j.next) {
                if((ascending == false ? -1 : 1 ) * j.data.compareTo(j.next.data) > 0) {
                    T data = j.data;
                    j.data = j.next.data;
                    j.next.data = data;
                }
            }
        }
    }

//    public void sort(boolean ascending) {
//        quickSort(head, tail, ascending);
//    }


//    private void quickSort(Node start, Node end, boolean ascending) {
//        //if(start >= end) return;
//        if(end != null && start != end && start != end.next) {
//            Node rightStart = partOfQuickSort(start, end, ascending);
//            quickSort(start, rightStart.prev, ascending);
//            quickSort(rightStart.next, end, ascending);
//        }
//    }
//
//    private Node partOfQuickSort(Node left, Node right, boolean ascending) {
//        T pivot = left.data;
//        Node node = left.prev;
//
//        for(Node i = left; i != right; i = i.next) {
//            if(i.data.compareTo(pivot) <= 0) {
//                node = (node == null ? left : node.next);
//                T temp = node.data;
//                node.data = i.data;
//                i.data = temp;
//            }
//        }
//        node = (node == null ? left : node.next);
//        T temp = node.data;
//        node.data = right.data;
//        right.data = temp;
//        return left;
//    }

    @Override
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

    @Override
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
