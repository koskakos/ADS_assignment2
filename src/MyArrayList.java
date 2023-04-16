public class MyArrayList<T extends Comparable<T>>{
    private int size;
    private Object[] hiddenArray;

    public MyArrayList() {
        hiddenArray = new Object[3];
    }

    public MyArrayList(int initialCapacity) {
        if(initialCapacity < 2) hiddenArray = new Object[2];
        else hiddenArray = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    //@Override
    public void add(T item) {
        if(size == hiddenArray.length) increaseArray();
        hiddenArray[size++] = item;
    }

    public T get(int index) {
        if(index >= size) throw new IndexOutOfBoundsException();
        return (T) hiddenArray[index];
    }

    private void increaseArray() {
        Object[] newArray = new Object[(int) (hiddenArray.length * 1.5)];
        for(int i = 0; i < hiddenArray.length; i++)
            newArray[i] = hiddenArray[i];
        hiddenArray = newArray;
    }
}
