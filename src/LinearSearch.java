/**
 * Demonstrates linear search, which checks each array element from left to right.
 *
 * <p>The input array does not need to be sorted. An empty array returns -1.
 * Time complexity is O(1) best case, O(n) average and worst case. Space
 * complexity is O(1).</p>
 */
public class LinearSearch {

    /**
     * Finds the first occurrence of {@code target} in {@code array}.
     *
     * @param array the array to search; it may be empty, but not null
     * @param target the value to find
     * @return the index of the first matching value, or -1 when not found
     */
    public static int search(int[] array, int target) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == target) {
                return index;
            }
        }
        return -1;
    }

    /** Runs a small example of linear search. */
    public static void main(String[] args) {
        int[] numbers = {8, 3, 7, 1, 5};
        System.out.println("Index of 1: " + search(numbers, 1));
    }
}