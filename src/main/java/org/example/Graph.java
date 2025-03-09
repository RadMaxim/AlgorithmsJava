package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Graph {
    private List<Edge> edges;
    private int vertices;

    public Graph(int vertices) {
        this.vertices = vertices;
        edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    public List<Edge> kruskalMST() {
        List<Edge> mst = new ArrayList<>();
        Collections.sort(edges, Comparator.comparingInt(edge -> edge.weight));

        DisJoinSet dsu = new DisJoinSet(vertices);

        for (Edge edge : edges) {
            int root1 = dsu.find(edge.src);
            int root2 = dsu.find(edge.dest);

            if (root1 != root2) {
                mst.add(edge);
                dsu.union(root1, root2);
            }
        }

        return mst;
    }
}