package lesson_3.t1;

public class MyArrayList<Item extends Comparable> {
    private Item[] list;
    private int size = 0;
    private int capacity;

    MyArrayList(int capacity) {
        this.capacity = capacity;
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <=0" + capacity);
        }
        list = (Item[]) new Comparable[capacity];
    }

    MyArrayList() {
        int DEFAULT_CAPACITY = 10;
        list = (Item[]) new Comparable[DEFAULT_CAPACITY];
    }

    public void add(Item item) {
        if (size > 0 && size > (0.75*capacity)) expand(size*2);
        list[size] = item;
        size++;
    }

    public void add(int index, Item item) {
        if (size > 0 && size > 0.75*capacity) expand(size*2);
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index " + index);
        }
        System.arraycopy(list, index, list, index + 1, size - index);
        list[index] = item;
        size++;
    }

    public boolean remove(Item item) {
        int i = 0;
        while (i < size && !list[i].equals(item)) {
            i++;
        }
        if (i == size) {
            return false;
        }
        remove(i);
        return true;
    }

    final boolean remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index " + index);
        }
        if (size - 1 - index >= 0) System.arraycopy(list, index + 1, list, index, size - 1 - index);
        size--;
        list[size] = null;
        return true;
    }

    Item get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index " + index);
        }
        return list[index];
    }

    public void set(int index, Item item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index " + index);
        }
        list[index] = item;
    }

    int size() {
        return size;
    }

    private void expand(int newCapacity) {
        Item[] temp = (Item[]) new Comparable[newCapacity];
        System.arraycopy(list, 0, temp, 0, size);
        list = temp;
    }

    void ensureCapacity(int newSize) {
        if (newSize > size) expand(newSize);
        else throw new IndexOutOfBoundsException(newSize + " > " + size);
    }

    void trimToSize() {
        expand(size);
    }

    int indexOf(Item item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    private boolean less(int index1, int index2) {
        return list[index1].compareTo(list[index2]) < 0;
    }

    private void swap(int index1, int index2) {
        Item temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    void selectionSort() {
        int iMin;
        for (int i = 0; i < size - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (less(j, iMin)) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
    }

    void insertionSort() {
        Item key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];
            while (j > 0 && key.compareTo(list[j-1]) < 0){
                list[j]= list[j-1];
                j--;
            }
            list[j] = key;
        }
    }

    void bubbleSort(){
        boolean isSwap;
        for (int i = size - 1; i > 0; i--) {
            isSwap = false;
            for (int j = 0; j <i ; j++) {
                if(less(j+1, j)){
                    swap(j+1, j);
                    isSwap = true;
                }
            }
            if(!isSwap){
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(list[i] + " ");
        }
        return sb.toString();
    }
}
