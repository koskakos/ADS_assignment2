public class MyArrayList<T extends Comparable<T>> {
    private int size;
    private Object[] hiddenArray;

    public MyArrayList() {
        hiddenArray = new Object[3];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 2) hiddenArray = new Object[2];
        else hiddenArray = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (hiddenArray[i] == o) return true;
        }
        return false;
    }

    //@Override
    public void add(T item) {
        if (size == hiddenArray.length) increaseArray();
        hiddenArray[size++] = item;
    }

    public void add(T item, int index) {
        if (size == hiddenArray.length) increaseArray();
        for (int i = size; i > index; i--) {
            hiddenArray[i] = hiddenArray[i - 1];
        }
        hiddenArray[index] = item;
        size++;
    }

    public boolean remove(T item) {
        int ind = indexOf(item);
        if (ind == -1) return false;
        remove(ind);
        return true;
    }

    public T remove(int index) {
        T removed = (T) hiddenArray[index];
        for (int i = index; i < size; i++) {
            hiddenArray[i] = hiddenArray[i + 1];
        }
        size--;
        return removed;
    }

    public void clear() {
        hiddenArray = new Object[2];
        size = 0;
    }

    public T get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        return (T) hiddenArray[index];
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (hiddenArray[i] == o) return i;
        }
        return -1;
    }

    private void increaseArray() {
        Object[] newArray = new Object[(int) (hiddenArray.length * 1.5)];
        for (int i = 0; i < hiddenArray.length; i++)
            newArray[i] = hiddenArray[i];
        hiddenArray = newArray;
    }
}
