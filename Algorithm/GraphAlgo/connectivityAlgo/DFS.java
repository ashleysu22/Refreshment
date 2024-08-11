import java.util.*;

class GfG {

    static void addEdge(List<List<Integer>> adj, int s, int t) {
        adj.get(s).add(t);
        adj.get(t).add(s); // Remove this line for directed graphs
    }

    // Helper function for DFS
    static void dfsRec(List<List<Integer>> adj, 
                       boolean[] visited, int s) {
        // Mark s as visited and print it
        visited[s] = true;
        System.out.print(s + " ");

        // Recursively call for all adjacent
        // vertices that are not visited yet
        for (int i : adj.get(s)) {
            if (!visited[i]) {
                dfsRec(adj, visited, i);
            }
        }
    }

    // The main DFS function. This function 
    // mainly calls dfsRec()
    static void dfs(List<List<Integer>> adj, int s) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        dfsRec(adj, visited, s);
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices in the graph
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 3);

        System.out.println("Following is Depth"
                           + " First Traversal (starting"
                           + " from vertex 2):");

        dfs(adj, 2);
    }
}
//Output: 2 0 1 3 
