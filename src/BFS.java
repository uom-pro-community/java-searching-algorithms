import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {

    /**
     * Searches a graph level by level from {@code start}.
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
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            if (vertex == target) {
                return vertex;
            }

            if (graph[vertex] == null) {
                continue;
            }
            for (int neighbor : graph[vertex]) {
                if (neighbor >= 0 && neighbor < graph.length && !visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return -1;
    }
}