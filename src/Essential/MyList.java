package Essential;

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

    public void addByIndex (T temp, int index){
        array[index] = temp;
    }

    public T getByIndex(int index) {
        return (T) array[index];
    }

    public int size() {
        return index;
    }

    @Override
    public String toString() {
        return "MyList{" + Arrays.toString(array) + "}";
    }
}
