import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public abstract class Sorter {
    private HashSet<Integer> selectedIndeces = new HashSet<>();
    private int[] swapIndeces = new int[2];
    /**
     * Should sort an array of integer in ascending order.
     * @param array the array to be sorted.
     */
    public abstract void sort(int[] array);

    /**
     * Swap the elements at indeces a and b in the array.
     * @param array
     * @param a
     * @param b
     */
    public void swap(int[] array, int a, int b) {
        swapIndeces[0] = a;
        swapIndeces[1] = b;

        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public int access(int[] array, int index) {
        selectedIndeces.add(index);
        return array[index];
    }
}
