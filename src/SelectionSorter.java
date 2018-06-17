public class SelectionSorter extends Sorter{
    @Override
    public void sort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            selectedA = i;
            int minimumIndex = minimumInRange(array, i, array.length - 1);
            swap(array, i, minimumIndex);
            swapIndeces[0] = i;
            swapIndeces[1] = minimumIndex;
        }
    }

    /**
     * Return the index that contains the smallest value in the array between start and stop (both inclusive).
     * @param array
     * @param start
     * @param stop
     * @return
     */
    private int minimumInRange(int[] array, int start, int stop) {
        int currentMinimum = start;

        for(int i = start; i <= stop; i++) {
            selectedB = i;
            if(access(array, i) < access(array, currentMinimum)) {
                currentMinimum = i;
            }
        }

        return currentMinimum;
    }
}
