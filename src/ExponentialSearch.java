
public class ExponentialSearch {

    /**
     * Searches a sorted array without changing it.
     *
     * @param array an ascending-sorted array; it may be empty, but not null
     * @param target the value to find
     * @return an index containing the target, or -1 when not found
     */
    public static int search(int[] array, int target) {
        if (array.length == 0) {
            return -1;
        }
        if (array[0] == target) {
            return 0;
        }

        int boundary = 1;
        while (boundary < array.length && array[boundary] <= target) {
            if (boundary > array.length / 2) {
                boundary = array.length;
            } else {
                boundary *= 2;
            }
        }

        int left = boundary / 2;
        int right = Math.min(boundary, array.length - 1);
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] == target) {
                return middle;
            }
            if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    /** Runs a small example of exponential search. */
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 8, 10};
        System.out.println("Index of 10: " + search(numbers, 10));
    }
}