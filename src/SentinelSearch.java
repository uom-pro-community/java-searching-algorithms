public class SentinelSearch {

    /**
     * Searches an array without changing the original input.
     *
     * @param array the array to search; it may be empty, but not null
     * @param target the value to find
     * @return an index containing the target, or -1 when not found
     */
    public static int search(int[] array, int target) {
        if (array.length == 0) {
            return -1;
        }

        int[] working = array.clone();
        int lastValue = working[working.length - 1];
        working[working.length - 1] = target;

        int index = 0;
        while (working[index] != target) {
            index++;
        }

        working[working.length - 1] = lastValue;
        if (index == working.length - 1 && lastValue != target) {
            return -1;
        }
        return index;
    }

    /** Runs a small example of sentinel search. */
    public static void main(String[] args) {
        int[] numbers = {4, 7, 9, 12, 15};
        System.out.println("Index of 12: " + search(numbers, 12));
    }
}
