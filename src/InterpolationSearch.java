
public class InterpolationSearch {

    /**
     * Searches a sorted array without changing it.
     *
     * @param array an ascending-sorted array; it may be empty, but not null
     * @param target the value to find
     * @return an index containing the target, or -1 when not found
     */
    public static int search(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high && target >= array[low] && target <= array[high]) {
            if (array[low] == array[high]) {
                return array[low] == target ? low : -1;
            }

            long numerator = ((long) target - array[low]) * (high - low);
            long denominator = (long) array[high] - array[low];
            int position = low + (int) (numerator / denominator);
            if (array[position] == target) {
                return position;
            }
            if (array[position] < target) {
                low = position + 1;
            } else {
                high = position - 1;
            }
        }
        return -1;
    }

    /** Runs a small example of interpolation search. */
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("Index of 40: " + search(numbers, 40));
    }
}