package exercises;

import java.util.Random;

public class Quicksort {
    public static void main(String[] args) {
        
        Random random = new Random();
        var array = generateArray(10, random);
        printArray(array);
        quicksort(array);
        System.out.println();
        printArray(array);
        
    }

    public static int[] generateArray(int length, Random r) {
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = r.nextInt() % 20;
        }

        return array;
    }

    public static void printArray(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length);
    }

    public static void quicksort(int[] arr, int min, int max) {
        int length = max - min;
        if (length <= 1) {
            return;
        }

        int index = partition(arr, min, max, min);
        quicksort(arr, min, index);
        quicksort(arr, index + 1, max);
    }

    public static int partition(int[] arr, int min, int max, int pivotIndex) {
        swap(arr, min, pivotIndex);
        int currPivotIndex = min;
        int pivotValue = arr[pivotIndex];

        for (int i = min; i < max; i++) {
            if (arr[i] >= pivotValue) {
                continue;
            }
            
            swap(arr, i, currPivotIndex);
            swap(arr, i, ++currPivotIndex);
        }

        return currPivotIndex;
    }

    public static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}