
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