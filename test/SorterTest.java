import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public abstract class SorterTest {
    private Sorter sorter;
    private int[] emptyArray;
    private int[] singleElementArray;

    @Before
    public void setup() {
        sorter = getSorter();

        emptyArray = new int[0];
        singleElementArray = new int[] {1};
    }

    protected abstract Sorter getSorter();

    @Test
    public void sortingEmptyArrayShouldNotDoAnything() {
        int[] copy = copyArray(emptyArray);

        sorter.sort(emptyArray);

        assertThat(emptyArray, equalTo(copy));
    }

    @Test
    public void sortingArrayWithOnlyOneElementShouldNotDoAnything() {
        int[] copy = copyArray(singleElementArray);

        sorter.sort(singleElementArray);

        assertThat(singleElementArray, equalTo(copy));
    }

    private int[] copyArray(int[] target) {
        return Arrays.copyOf(target, target.length);
    }
}