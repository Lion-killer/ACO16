package sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by bilousyv on 10.11.2016.
 */
public class MergeSortTest {

    @Test
    public void testSorting() {

        int[] array = createRandomArray(100, 0, 100);

        int[] actual = MergeSort.sort(array);
        int[] expected = Arrays.copyOf(array, array.length);
        Arrays.sort(expected);

        Assert.assertArrayEquals(expected, actual);

    }

    private static int[] createRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = getRandomValue(min, max);
        }

        return array;
    }

    private static int getRandomValue(int min, int max) {
        return (int) (min + Math.random() * (max - min));
    }
}
