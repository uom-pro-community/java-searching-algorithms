import java.util.HashMap;
import java.util.Map;

public class HashSearch {

    /**
     * Searches an array using a hash map of values to indices.
     *
     * @param array the array to search; it may be empty, but not null
     * @param target the value to find
     * @return the first index containing the target, or -1 when not found
     */
    public static int search(int[] array, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int index = 0; index < array.length; index++) {
            indexMap.putIfAbsent(array[index], index);
        }
        return indexMap.getOrDefault(target, -1);
    }

    /** Runs a small example of hash search. */
    public static void main(String[] args) {
        int[] numbers = {8, 2, 7, 1, 5};
        System.out.println("Index of 7: " + search(numbers, 7));
    }
}
