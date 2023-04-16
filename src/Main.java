public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> a = new MyArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(3);
        a.add(531);
        for(Integer temp : a) {
            System.out.print(temp + " ");
        }
    }
}
