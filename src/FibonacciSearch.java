public class FibonacciSearch {

    /**
     * Searches a sorted array without changing it.
     *
     * @param array an ascending-sorted array; it may be empty, but not null
     * @param target the value to find
     * @return an index containing the target, or -1 when not found
     */
    public static int search(int[] array, int target) {
        int length = array.length;
        if (length == 0) {
            return -1;
        }

        int fibMm2 = 0;
        int fibMm1 = 1;
        int fibM = fibMm2 + fibMm1;

        while (fibM < length) {
            fibMm2 = fibMm1;
            fibMm1 = fibM;
            fibM = fibMm2 + fibMm1;
        }

        int offset = -1;
        while (fibM > 1) {
            int index = Math.min(offset + fibMm2, length - 1);

            if (array[index] < target) {
                fibM = fibMm1;
                fibMm1 = fibMm2;
                fibMm2 = fibM - fibMm1;
                offset = index;
            } else if (array[index] > target) {
                fibM = fibMm2;
                fibMm1 = fibMm1 - fibMm2;
                fibMm2 = fibM - fibMm1;
            } else {
                return index;
            }
        }

        if (fibMm1 == 1 && offset + 1 < length && array[offset + 1] == target) {
            return offset + 1;
        }
        return -1;
    }

    /** Runs a small example of Fibonacci search. */
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9, 11, 13, 15};
        System.out.println("Index of 11: " + search(numbers, 11));
    }
}
