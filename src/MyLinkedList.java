public class MyLinkedList<T extends Comparable<T>> {
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

    public T get(int index) {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
        Node node = head;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }
}
