import java.util.*;

public class dfs {
    public static void main(String[] args) {
        int n = 6;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        int edges[][] = {
                { 0, 1 },
                { 0, 2 },
                { 1, 2 },
                { 3, 4 },
                { 3, 5 }
        };
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        ArrayList<int[]> nodes = new ArrayList<>();
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                System.out.print("Current source -> ");
                int[] component = new int[] { 0, 0 };
                nodes.add(component);
                solve(visited, graph, i, component);
                component[1] /= 2;
                System.out.println();
            }
        }
        for (int[] node : nodes)
            System.out.println("Vertices: " + node[0] + ", Edges: " + node[1]);
    }

    private static void solve(boolean[] visited, List<Integer>[] graph, int source, int[] component) {
        if (visited[source]) return;
        visited[source] = true;
        System.out.print(source + " -> ");
        component[0]++;
        component[1] += graph[source].size();
        for (int vertex : graph[source]) {
            if (!visited[vertex]) {
                solve(visited, graph, vertex, component);
            }
        }
    }
}
