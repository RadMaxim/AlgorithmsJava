package org.example;

import java.util.List;

public class KruskalAlgorithm {
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 6);
        graph.addEdge(2, 3, 8);
        graph.addEdge(3, 4, 9);
        graph.addEdge(2, 4, 10);
        graph.addEdge(4, 5, 5);
        graph.addEdge(3, 5, 7);

        List<Edge> mst = graph.kruskalMST();

        System.out.println("Edges in MST:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
    }
}