import java.util.*;

public class Graph {
    private int V;
    private List<List<Node>> adj;

    public static void main(String[] args) {
        long start = System.nanoTime();
        int V = 5;
        Graph graph = new Graph(V);

        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 3, 7);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 3, 9);
        graph.addEdge(2, 3, 10);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 4, 4);

        int startVertex = 0;
        graph.dijkstra(startVertex);

        long end = System.nanoTime();
        System.out.println("Execution Time is: " + (end - start) / 1000000 + " ms");
    }

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Node newNode = new Node(destination, weight);
        adj.get(source).add(newNode);
    }

    public void dijkstra(int startVertex) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(V, new Node());
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        priorityQueue.add(new Node(startVertex, 0));
        distance[startVertex] = 0;

        while (!priorityQueue.isEmpty()) {
            int currentVertex = priorityQueue.poll().node;
            List<Node> adjacentNodes = adj.get(currentVertex);

            for (Node node : adjacentNodes) {
                int dest = node.node;
                int newDist = distance[currentVertex] + node.cost;

                if (newDist < distance[dest]) {
                    priorityQueue.add(new Node(dest, newDist));
                    distance[dest] = newDist;
                }
            }
        }

        System.out.println("Shortest Path from the starting vertex:");

        for (int i = 0; i < distance.length; i++) {
            System.out.println("Vertex " + startVertex + " to Vertex " + i + " is " + distance[i]);
        }
    }

    class Node implements Comparator<Node> {
        private int node;
        private int cost;

        public Node() {
        }

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node node1, Node node2) {
            if (node1.cost < node2.cost) {
                return -1;
            }
            if (node1.cost > node2.cost) {
                return 1;
            }
            return 0;
        }
    }
}