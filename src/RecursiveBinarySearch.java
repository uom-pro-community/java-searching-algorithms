
public class RecursiveBinarySearch {

    /**
     * Searches a sorted array recursively without changing the array.
     *
     * @param array an ascending-sorted array; it may be empty, but not null
     * @param target the value to find
     * @return an index containing the target, or -1 when not found
     */
    public static int search(int[] array, int target) {
        return search(array, target, 0, array.length - 1);
    }

    private static int search(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int middle = left + (right - left) / 2;
        if (array[middle] == target) {
            return middle;
        }
        if (array[middle] < target) {
            return search(array, target, middle + 1, right);
        }
        return search(array, target, left, middle - 1);
    }

    /** Runs a small example of recursive binary search. */
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 8};
        System.out.println("Index of 7: " + search(numbers, 7));
    }
}