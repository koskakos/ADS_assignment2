public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> a = new MyLinkedList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(3);
        a.add(531);
        a.add(3);
        a.remove(1);
        for(Integer temp : a) {
            System.out.print(temp + " ");
        }
    }
}
