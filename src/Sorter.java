import java.util.HashSet;
import java.util.Set;

public abstract class Sorter {
    public int selectedA;
    public int selectedB;
    public int[] swapIndeces = new int[2];
    public int delayMillis = 0;
    public int delayNanos = 0;
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

        int temp = access(array, a);
        array[a] = access(array, b);
        array[b] = temp;
    }

    public int access(int[] array, int index) {
        try {
            Thread.sleep(delayMillis, delayNanos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return array[index];
    }

    public int[] getSwapIndeces() {
        return swapIndeces;
    }
}
