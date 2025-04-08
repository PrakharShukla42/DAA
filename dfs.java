import java.util.*;

public class dfs {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        dfsTraversal(0, adj, V);
    }

    static void dfsTraversal(int start, ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        visited[start] = true;
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            System.out.print(node + " ");

            for (int i = 0; i < adj.get(node).size(); i++) {
                int neighbour = adj.get(node).get(i);
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    stack.push(neighbour);
                }
            }
        }
    }
}
