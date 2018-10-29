import java.util.Random;

public class SortingComparisons {
    
    public static void main(String[] args) {

        Random rand = new Random();
        String[] bubbleCompares = new String[4];
        String[] mergeCompares = new String[4];
        //String[] quickCompares = new String[4];
 
        for (int i = 1; i < 5; i++) {
            int arraySize = (int)Math.pow(10, i);
            int[] array = new int[arraySize];
            for (int j = 0; j < array.length; j++) {
                array[j] = rand.nextInt(arraySize);
            }

            bubbleCompares[i-1] = bubbleSort(array);
            //System.out.println(bubbleCompares[i-1]);
            mergeCompares[i -1] = mergeSort(array, array.length);
            System.out.println(mergeCompares[i-1]);
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

    public static String mergeSort(int[] array, int n) {
        int compares = 0;

        int current_size;

        int left_start;

        for (current_size = 1; current_size <= n-1; current_size = 2*current_size) {
            for (left_start = 0; left_start < n -1; left_start += 2*current_size) {
                int middle = left_start + current_size - 1;

                int right_end = Math.min(left_start + 2 * current_size - 1, n - 1);

                compares = compares + merge(array, left_start, middle, right_end);
            }
        }
        return Integer.toString(compares);
    }


    public static int merge(int[] array, int left, int middle, int right) {
        int compares = 0;
        int i, j, k;

        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] Left = new int[n1];
        int[] Right = new int[n2];

        for (i = 0; i < n1; i++) {
            Left[i] = array[left + i];
        }
        
        for (j = 0; j < n2; j++) {
            Right[j] = array[middle + 1 + j];
        }

        i = 0;
        j = 0;
        k = left;

        while (i < n1 && j < n2) {
            if (Left[i] <= Right[j]) {
                array[k] = Left[i];
            } else {
                array[k] = Right[j];
                j++;
            }
            k++;
            compares++;
        }

        while (i < n1) {
            array[k] = Left[j];
            i++;
            k++;
        }

        while(j < n2) {
            array[k] = Right[j];
            j++;
            k++;
        }

        return compares;
    }


    

    public static String[] quickSort() {
        String[] compValue = new String[1];

        return compValue;
    }
}