import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
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

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (hiddenArray[i] == o) return true;
        }
        return false;
    }

    @Override
    public void add(T item) {
        if (size == hiddenArray.length) increaseArray();
        hiddenArray[size++] = item;
    }

    @Override
    public void add(T item, int index) {
        if (size == hiddenArray.length) increaseArray();
        for (int i = size; i > index; i--) {
            hiddenArray[i] = hiddenArray[i - 1];
        }
        hiddenArray[index] = item;
        size++;
    }

    @Override
    public boolean remove(T item) {
        int ind = indexOf(item);
        if (ind == -1) return false;
        remove(ind);
        return true;
    }

    @Override
    public T remove(int index) {
        T removed = (T) hiddenArray[index];
        for (int i = index; i < size; i++) {
            hiddenArray[i] = hiddenArray[i + 1];
        }
        size--;
        return removed;
    }

    @Override
    public void clear() {
        hiddenArray = new Object[2];
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        return (T) hiddenArray[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (hiddenArray[i] == o) return i;
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (hiddenArray[i] == o) return i;
        }
        return -1;
    }

    @Override
    public void sort() {

    }

    private void increaseArray() {
        Object[] newArray = new Object[(int) (hiddenArray.length * 1.5)];
        for (int i = 0; i < hiddenArray.length; i++)
            newArray[i] = hiddenArray[i];
        hiddenArray = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public T next() {
            return get(cursor++);
        }
    }
}
