import java.util.*;

class Node implements Comparable<Node> {
    int vertex, cost;

    Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    public int compareTo(Node other) {
        return this.cost - other.cost;
    }
}

public class JobMatchDijkstra {

    static void dijkstra(List<List<Node>> graph, int source) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[source] = 0;
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            for (Node neighbor : graph.get(current.vertex)) {
                int newDist = dist[current.vertex] + neighbor.cost;

                if (newDist < dist[neighbor.vertex]) {
                    dist[neighbor.vertex] = newDist;
                    pq.add(new Node(neighbor.vertex, newDist));
                }
            }
        }

        System.out.println("Job Matching Results:");
        for (int i = 1; i < n; i++) {
            System.out.println("Candidate C1 -> Job J" + i +
                    " | Mismatch Cost = " + dist[i]);
        }
    }

    public static void main(String[] args) {

        int vertices = 4; // C1 + J1 + J2 + J3
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Candidate C1 connected to Jobs
        graph.get(0).add(new Node(1, 4)); // J1
        graph.get(0).add(new Node(2, 2)); // J2
        graph.get(0).add(new Node(3, 7)); // J3

        dijkstra(graph, 0);
    }
}