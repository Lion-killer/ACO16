package sorting;

import java.util.Arrays;

/**
 * Created by bilousyv on 10.11.2016.
 */
public class MergeSort {

    public static int[] sort(int[] array){

        int length = array.length;
        if (length == 1) return array;
        int middle = length / 2;

        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, length);

        return merge(sort(left), sort(right));

    }

    private static int[] merge(int[] left, int[] right) {

        int resLength = left.length + right.length;
        int leftIndex = 0, rightIndex = 0;
        int[] result = new int[resLength];

        for (int resIndex = 0; resIndex < resLength; resIndex++) {

            if (leftIndex < left.length && rightIndex < right.length){
                if (left[leftIndex] < right[rightIndex])
                    result[resIndex] = left[leftIndex++];
                else
                    result[resIndex] = right[rightIndex++];
            } else if (leftIndex < left.length){
                result[resIndex] = left[leftIndex++];
            } else {
                result[resIndex] = right[rightIndex++];
            }

        }
        return result;
    }

}
