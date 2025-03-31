package Container;

public class IntContainer {

    private int[] data;
    private int size;

    public IntContainer() {
        data = new int[10];
        size = 0;
    }

    public void add(int element) {
        if (size == data.length)
            resizeArray();
        data[size++] = element;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return data[index];
    }

    public int remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        int removedElement = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return removedElement;
    }

    public int size() {
        return size;
    }

    private void resizeArray() {
        int[] newData = new int[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}
