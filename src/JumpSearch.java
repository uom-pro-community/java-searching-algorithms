
public class JumpSearch {

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

        int jumpSize = Math.max(1, (int) Math.sqrt(length));
        int blockStart = 0;
        int blockEnd = jumpSize;

        while (blockStart < length && array[Math.min(blockEnd, length) - 1] < target) {
            blockStart = blockEnd;
            blockEnd += jumpSize;
        }

        for (int index = blockStart; index < Math.min(blockEnd, length); index++) {
            if (array[index] == target) {
                return index;
            }
        }
        return -1;
    }

    /** Runs a small example of jump search. */
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 8, 10};
        System.out.println("Index of 8: " + search(numbers, 8));
    }
}