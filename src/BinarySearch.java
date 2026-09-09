
public class BinarySearch {

    /**
     * Searches a sorted array for {@code target} without changing the array.
     *
     * @param array an ascending-sorted array; it may be empty, but not null
     * @param target the value to find
     * @return an index containing the target, or -1 when not found
     */
    public static int search(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

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

    /** Runs a small example of iterative binary search. */
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 8};
        System.out.println("Index of 5: " + search(numbers, 5));
    }
}