package Essential;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MyList<T> {

    private final int DEF_SIZE = 5;
    private final int GROW = 2;
    private int index = 0;
    Object[] array = new Object[DEF_SIZE];

    public void addElement(T temp) {
        if (index == array.length - 1) {
            Object[] newArray = new Object[array.length + GROW];
            System.arraycopy(array, 0, newArray, 0, index);
            array = newArray;
        }
        array[index++] = temp;
    }

    public void addByIndex(T temp, int index) {
        array[index] = temp;
    }

    public T getByIndex(int index) {
        return (T) array[index];
    }

    public int size() {
        return index;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size(); i++) {
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        Object[] newArray = new Object[DEF_SIZE];
        array = newArray;
    }

    public void remove(int index) {
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        this.index--;
    }

    @Override
    public String toString() {
        return "MyList{" + Arrays.toString(array) + "}";
    }

}
