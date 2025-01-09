package cz.cuni.mff.milotovl.util;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

public class Arrays {
    public static void paraMergeSort(int[] array) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.invoke(new MergeSortTask(array, 0, array.length - 1));
        pool.close();
    }

    private static class MergeSortTask extends RecursiveAction {
        private int[] array;
        private int left, right;

        // sort casti pola od left do right
        MergeSortTask(int[] array, int left, int right) {
            this.array = array;
            this.left = left;
            this.right = right;
        }

        @Override
        protected void compute() {
            if (left < right) {
                int middle = (left + right) / 2; // index na ktorom sa rozdeli pole na dve
                invokeAll(new MergeSortTask(array, left, middle),
                        new MergeSortTask(array, middle + 1, right)); // sort polovic pola
                merge(array, left, middle, right); // merge zosortenych polovic
            }
        }

        // merge dvoch casti pola array
        private void merge(int[] array, int left, int middle, int right) {
            int n1 = middle - left + 1; // velkost lavej casti pola
            int n2 = right - middle; // velkost pravej casti pola

            int[] leftArray = new int[n1];
            int[] rightArray = new int[n2];

            System.arraycopy(array, left, leftArray, 0, n1);
            System.arraycopy(array, middle + 1, rightArray, 0, n2);

            int i = 0, j = 0;

            int k = left;
            while (i < n1 && j < n2) {
                if (leftArray[i] <= rightArray[j]) {
                    array[k] = leftArray[i];
                    i++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                }
                k++;
            }

            while (i < n1) {
                array[k] = leftArray[i];
                i++;
                k++;
            }

            while (j < n2) {
                array[k] = rightArray[j];
                j++;
                k++;
            }
        }
    }

    public static int max(int[] array){
        if (array == null || array.length == 0){
            throw new IllegalArgumentException("Pole nemoze byt nulove");
        }
        return java.util.Arrays.stream(array)
                .parallel() // tu nejde spravit parallelStream lebo je to Arrays a nie List
                .max()
                .orElseThrow();
    }
}