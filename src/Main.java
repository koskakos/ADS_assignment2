public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> a = new MyLinkedList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(3);
        a.add(531);
        a.add(400);
        a.add(327, 5);
        for(Integer temp : a) {
            System.out.print(temp + " ");
        }
        System.out.println(a.size());
        System.out.println(a.contains(400));
    }
}
