import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SearchingAlgorithmsTest {

    private static Stream<Arguments> searchAlgorithms() {
        return Stream.of(
            Arguments.of("Linear Search", (BiFunction<int[], Integer, Integer>) LinearSearch::search),
            Arguments.of("Binary Search", (BiFunction<int[], Integer, Integer>) BinarySearch::search),
            Arguments.of("Recursive Binary Search", (BiFunction<int[], Integer, Integer>) RecursiveBinarySearch::search),
            Arguments.of("Jump Search", (BiFunction<int[], Integer, Integer>) JumpSearch::search),
            Arguments.of("Interpolation Search", (BiFunction<int[], Integer, Integer>) InterpolationSearch::search),
            Arguments.of("Exponential Search", (BiFunction<int[], Integer, Integer>) ExponentialSearch::search),
            Arguments.of("Ternary Search", (BiFunction<int[], Integer, Integer>) TernarySearch::search)
        );
    }

    @ParameterizedTest(name = "{0} finds targets at boundaries and middle")
    @MethodSource("searchAlgorithms")
    void findsTargetsAtBeginningMiddleAndEnd(String name, BiFunction<int[], Integer, Integer> search) {
        int[] input = {1, 3, 5, 7, 9};
        assertEquals(0, search.apply(input, 1), name);
        assertEquals(2, search.apply(input, 5), name);
        assertEquals(4, search.apply(input, 9), name);
    }

    @ParameterizedTest(name = "{0} handles missing and empty input")
    @MethodSource("searchAlgorithms")
    void handlesMissingAndEmptyInput(String name, BiFunction<int[], Integer, Integer> search) {
        assertEquals(-1, search.apply(new int[] {1, 3, 5, 7}, 4), name);
        assertEquals(-1, search.apply(new int[] {}, 4), name);
    }

    @ParameterizedTest(name = "{0} handles a single element")
    @MethodSource("searchAlgorithms")
    void handlesSingleElement(String name, BiFunction<int[], Integer, Integer> search) {
        assertEquals(0, search.apply(new int[] {42}, 42), name);
        assertEquals(-1, search.apply(new int[] {42}, 7), name);
    }

    @ParameterizedTest(name = "{0} handles duplicates")
    @MethodSource("searchAlgorithms")
    void handlesDuplicateValues(String name, BiFunction<int[], Integer, Integer> search) {
        int[] input = {1, 2, 2, 2, 4};
        int result = search.apply(input, 2);
        assertTrue(result >= 1 && result <= 3 && input[result] == 2, name);
    }

    @ParameterizedTest(name = "{0} preserves input")
    @MethodSource("searchAlgorithms")
    void doesNotModifyInput(String name, BiFunction<int[], Integer, Integer> search) {
        int[] input = {1, 3, 5, 7, 9};
        int[] original = input.clone();
        search.apply(input, 7);
        assertEquals(java.util.Arrays.toString(original), java.util.Arrays.toString(input), name);
    }
}