class adjMatrix
{
    private int V;
    private int E;
    private int[][] adjMatrix;
    public adjMatrix(int nodes){
        this.V = nodes;
        this.E = 0;
        this.adjMatrix = new int[nodes][nodes];
    }
    public void addEdge(int u, int v){
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
        E++;
    }
    // public void display() {
    //     for (int i = 0; i < V; i++) {
    //         for (int j = 0; j < V; j++) {
    //             System.out.print(adjMatrix[i][j] + " ");
    //         }
    //         System.out.println();
    //     }
    // }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(V + "vartices" +E+ "edges" + "\n");
        for(int v = 0; v < V; v++){
            sb.append(v + " ");
            for (int w : adjMatrix[v]){
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        adjMatrix graph = new adjMatrix(5);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,0);
        // graph.display();
        System.out.println(graph);
    }
}
