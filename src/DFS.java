import java.util.ArrayDeque;
import java.util.Deque;

public class DFS {

    /**
     * Searches a graph by exploring one branch as deeply as possible first.
     *
     * @param graph an adjacency-list graph where each row is a vertex ID
     * @param start the vertex at which to begin searching
     * @param target the vertex to find
     * @return the target vertex ID, or -1 when it is not reachable
     */
    public static int search(int[][] graph, int start, int target) {
        if (graph == null || start < 0 || start >= graph.length) {
            return -1;
        }

        boolean[] visited = new boolean[graph.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (visited[vertex]) {
                continue;
            }
            visited[vertex] = true;

            if (vertex == target) {
                return vertex;
            }

            if (graph[vertex] == null) {
                continue;
            }
            for (int neighborIndex = graph[vertex].length - 1; neighborIndex >= 0; neighborIndex--) {
                int neighbor = graph[vertex][neighborIndex];
                if (neighbor >= 0 && neighbor < graph.length && !visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
        return -1;
    }
}