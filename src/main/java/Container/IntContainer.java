package Container;

/**
 * Класс контейнера для хранения целых чисел на основе массива.
 */
public class IntContainer {

    private int[] data;
    private int size;

    /**
     * Конструктор создает пустой контейнер с начальным размером 10.
     */
    public IntContainer() {
        data = new int[10];
        size = 0;
    }

    /**
     * Добавляет элемент в контейнер.
     * @param element Добавляемый элемент.
     */
    public void add(int element) {
        if (size == data.length)
            resizeArray();
        data[size++] = element;
    }

    /**
     * Извлекает элемент по индексу.
     * @param index Индекс элемента.
     * @return Элемент по заданному индексу
     * @throws IndexOutOfBoundsException Если индекс выходит за границы.
     */
    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return data[index];
    }

    /**
     * Удаляет элемент по индексу.
     * @param index Индекс удаляемого элемента.
     * @return Удаленный элемент.
     * @throws IndexOutOfBoundsException Если индекс выходит за границы.
     */
    public int remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        int removedElement = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return removedElement;
    }

    /**
     * Возвращает количество элементов в контейнере.
     * @return Размер контейнера.
     */
    public int size() {
        return size;
    }

    /**
     * Увеличивает размер массива вдвое.
     */
    private void resizeArray() {
        int[] newData = new int[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}
