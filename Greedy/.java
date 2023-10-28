import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class KruskalMST {
    int V;
    List<Edge> edges;

    public KruskalMST(int V) {
        this.V = V;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    public List<Edge> kruskalMST() {
        List<Edge> minimumSpanningTree = new ArrayList<>();

        // Sort the edges in ascending order of weight
        Collections.sort(edges);

        // Create a parent array for disjoint-set union-find
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        int edgeCount = 0;

        for (Edge edge : edges) {
            if (edgeCount >= V - 1)
                break;

            int srcParent = find(parent, edge.src);
            int destParent = find(parent, edge.dest);

            if (srcParent != destParent) {
                minimumSpanningTree.add(edge);
                union(parent, srcParent, destParent);
                edgeCount++;
            }
        }

        return minimumSpanningTree;
    }

    private int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    private void union(int[] parent, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        parent[xRoot] = yRoot;
    }

    public static void main(String[] args) {
        int V = 5;
        KruskalMST graph = new KruskalMST(V);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 3, 7);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 3, 9);
        graph.addEdge(2, 3, 10);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 4, 4);

        List<Edge> minimumSpanningTree = graph.kruskalMST();
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge edge : minimumSpanningTree) {
            System.out.println((edge.src + 1) + " - " + (edge.dest + 1) + " : " + edge.weight);
        }
    }
}
