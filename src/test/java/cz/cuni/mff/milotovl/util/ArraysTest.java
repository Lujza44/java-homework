package cz.cuni.mff.milotovl.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ArraysTest {

    @Test
    public void testMergeSort() { // toto zmenit treba
        int[] array = {2, 7, 6, 11, 8, 3};
        Arrays.paraMergeSort(array);
        assertArrayEquals(new int[] {2, 3, 6, 7, 8, 11}, array);
    }

    @Test
    public void testMergeSortEmpty() { // aj toto zmenit treba :D
        int[] array = {};
        Arrays.paraMergeSort(array);
        assertArrayEquals(new int[] {}, array);
    }

    @Test
    public void testFindMax() {
        int[] array1 = {5, 3, 8, 4, 2, 7, 1, 6};
        assertEquals(8, Arrays.max(array1));
    }

    @Test
    public void testFindMaxSingle() {
        int[] array2 = {42};
        assertEquals(42, Arrays.max(array2));
    }

    @Test
    public void testFindMaxEmpty() {
        int[] emptyArray = {};
        assertThrows(IllegalArgumentException.class, () -> Arrays.max(emptyArray));
    }

    @Test
    public void testFindMaxNull() {
        int[] nullArray = null;
        assertThrows(IllegalArgumentException.class, () -> Arrays.max(nullArray));
    }
}
