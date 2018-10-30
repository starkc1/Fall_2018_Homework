import java.util.Random;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class SortingComparisons {
    
    public static int mergeComparesValue;
    public static int quickComparesValue;

    public static void main(String[] args) {

        Random rand = new Random();
        String[] bubbleCompares = new String[4];
        String[] mergeCompares = new String[4];
        String[] quickCompares = new String[4];
        String[] arraySizes = new String[4];
        for (int i = 1; i < 5; i++) {
            mergeComparesValue = 0;
            quickComparesValue = 0;
            int arraySize = (int)Math.pow(10, i);
            int[] array = new int[arraySize];
            for (int j = 0; j < arraySize; j++) {
                array[j] = rand.nextInt(arraySize);
            }


            arraySizes[i - 1] = Integer.toString(arraySize);
            bubbleCompares[i-1] = bubbleSort(array);
            //System.out.println(bubbleCompares[i-1]);
            mergeSort(array);
            mergeCompares[i - 1] = Integer.toString(mergeComparesValue);
            //System.out.println(mergeCompares[i -1]);
            quickSort(array, 0, arraySize - 1);
            quickCompares[i - 1] = Integer.toString(quickComparesValue);
            //System.out.println(quickCompares[i - 1]);
        }
        
        Object[][] table  = new String[5][];
        table[0] = new String[] {
            "Number of Elements",
            "Bubble Sort",
            "Merge Sort",
            "Quick Sort"
        };
        for (int i = 1; i < 5; i++) {
           table[i] = new String[] {
               arraySizes[i-1],
               bubbleCompares[i-1],
               mergeCompares[i-1],
               quickCompares[i-1]
           };
        }
        
        for (Object[] row: table) {
            System.out.format("%15s %15s %15s %15s\n", row);
        }
    }

    public static String bubbleSort(int[] array) {
        int compares = 0;
        int length = array.length;

        for (int i = 0; i < length-1; i++ ){ 
            for (int j = 0; j < length-i-1; j++) {
                if (array[j] > array[j+1]) {
                    int tempValue = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tempValue;
                }
                compares++;
            }
        }

        return Integer.toString(compares);
    }

    public static int[] mergeSort(int[] array) {
        
        int size = array.length;

        if (size <= 1) {
            return array;
        }

        int[] leftArray = new int[size / 2];
        int[] rightArray = new int[size - size / 2];

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = array[i];
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = array[i + size/2];
        }

        return mergeArray(mergeSort(leftArray), mergeSort(rightArray));
    }


    public static int[] mergeArray(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];

        int i = 0;
        int j = 0;

        for (int k = 0; k < merged.length; k++) {
            if (i >= left.length) {
                merged[k] = right[j++];
            } else if (j >= right.length) {
                merged[k] = left[i++];
            } else if (left[i] <= right[j]) {
                merged[k] = left[i++];
            } else {
                merged[k] = right[j++];
            }
            mergeComparesValue++;
        }
        return merged;
    } 

    public static void quickSort(int[] array, int low, int high) {
        if (array == null || array.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int pivot = array[middle];

        int i = low;
        int j = high;

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            
            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
            quickComparesValue++;
        }

        if (low < j) {
            quickSort(array, low, j);
        }

        if (high > i) {
            quickSort(array, i, high);
        }
    }
}