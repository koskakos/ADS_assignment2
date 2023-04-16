public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> a = new MyArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(3);
        a.add(531);
        System.out.println(a.get(1));
        System.out.println(a.get(2));
        System.out.println(a.get(4));
    }
}
