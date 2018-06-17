import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class SorterTest {
    private Sorter sorter;
    private int[] emptyArray;

    @Before
    public void setup() {
        sorter = new Sorter();

        emptyArray = new int[0];
    }

    @Test
    public void sortingEmptyArrayShouldNotDoAnything() {
        int[] copy = copyArray(emptyArray);

        sorter.sort(emptyArray);

        assertThat(emptyArray, equalTo(copy));
    }

    private int[] copyArray(int[] target) {
        return Arrays.copyOf(target, target.length);
    }
}