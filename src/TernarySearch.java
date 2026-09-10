
public class TernarySearch {

    /**
     * Searches a sorted array without changing it.
     *
     * @param array an ascending-sorted array; it may be empty, but not null
     * @param target the value to find
     * @return an index containing the target, or -1 when not found
     */
    public static int search(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int third = (right - left) / 3;
            int firstMiddle = left + third;
            int secondMiddle = right - third;

            if (array[firstMiddle] == target) {
                return firstMiddle;
            }
            if (array[secondMiddle] == target) {
                return secondMiddle;
            }

            if (target < array[firstMiddle]) {
                right = firstMiddle - 1;
            } else if (target > array[secondMiddle]) {
                left = secondMiddle + 1;
            } else {
                left = firstMiddle + 1;
                right = secondMiddle - 1;
            }
        }
        return -1;
    }

    /** Runs a small example of ternary search. */
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 8, 10};
        System.out.println("Index of 3: " + search(numbers, 3));
    }
}