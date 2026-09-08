# Java Searching Algorithms

This repository teaches seven classic searching algorithms through small,
readable Java implementations. Every algorithm returns the index of a matching
target or `-1` when the target is absent. No built-in search methods are used.

## Implemented Algorithms

- Linear Search
- Binary Search
- Recursive Binary Search
- Jump Search
- Interpolation Search
- Exponential Search
- Ternary Search

## How the Algorithms Work

- **Linear Search** checks every element from left to right. The input does not need to be sorted.
- **Binary Search** compares the target with the middle element and repeatedly halves a sorted search range.
- **Recursive Binary Search** applies the same halving strategy through recursive calls.
- **Jump Search** jumps through blocks of a sorted array, then linearly scans the block that may contain the target.
- **Interpolation Search** estimates a target's position using the values at the ends of a sorted range. It is strongest for evenly distributed values.
- **Exponential Search** doubles a boundary until it passes the target, then performs binary search in the discovered range.
- **Ternary Search** compares two middle points and removes two-thirds of a sorted range at each step.

## Complexity Comparison

| Algorithm | Best | Average | Worst | Space | Sorted Required |
|---|---:|---:|---:|---:|:---:|
| Linear Search | O(1) | O(n) | O(n) | O(1) | No |
| Binary Search | O(1) | O(log n) | O(log n) | O(1) | Yes |
| Recursive Binary Search | O(1) | O(log n) | O(log n) | O(log n) | Yes |
| Jump Search | O(1) | O(sqrt(n)) | O(sqrt(n)) | O(1) | Yes |
| Interpolation Search | O(1) | O(log log n)* | O(n) | O(1) | Yes |
| Exponential Search | O(1) | O(log n) | O(log n) | O(1) | Yes |
| Ternary Search | O(1) | O(log n) | O(log n) | O(1) | Yes |

`*` Interpolation search's average bound assumes a fairly uniform data distribution.

## Requirements

- Java Development Kit (JDK) 17 or newer
- JUnit 5 Console Launcher for running tests
- No Maven, Gradle, Spring Boot, or other framework is required

## Compile and Run

From the repository root, compile the algorithms into `out`:

```text
mkdir out
javac -d out src\*.java
```

Run any example, such as:

```text
java -cp out BinarySearch
```

Expected output:

```text
Index of 5: 2
```

To run the JUnit 5 tests, download the JUnit Platform Console Standalone JAR
from the official JUnit release page and place it outside the repository (for
example, as `junit-platform-console-standalone.jar`). Then run:

```text
javac -cp junit-platform-console-standalone.jar -d out src\*.java tests\SearchingAlgorithmsTest.java
java -jar junit-platform-console-standalone.jar execute --class-path out --scan-class-path
```

## Example Usage

```java
int[] numbers = {1, 3, 5, 7, 9};
int index = BinarySearch.search(numbers, 7);
System.out.println(index); // 3
```

Sorted-array algorithms require ascending input. None of the algorithms changes
the original array, and all safely handle empty and single-element arrays.

## Learning Objectives

- Understand how sequential and divide-and-conquer searches differ.
- Practice reasoning about time and space complexity.
- Learn why sorted data enables faster searches.
- Compare recursive and iterative implementations.
- Test algorithms against boundary cases and duplicate values.

## Contribution Guidelines

1. Keep implementations from scratch and beginner-friendly.
2. Follow standard Java naming and formatting conventions.
3. Add or update JUnit 5 tests for behavior changes.
4. Keep documentation and examples synchronized with the code.
5. Explain the purpose of a change clearly in the pull request.

## License

This project is released under the [MIT License](LICENSE).