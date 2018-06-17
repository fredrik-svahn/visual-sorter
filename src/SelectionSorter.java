public class SelectionSorter extends Sorter{
    @Override
    public void sort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int minimumIndex = minimumInRange(array, i, array.length - 1);
            swap(array, i, minimumIndex);
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
            if(access(array, i) < access(array, currentMinimum)) {
                currentMinimum = i;
            }
        }

        return currentMinimum;
    }
}
