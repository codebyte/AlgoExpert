package com.algo.graph;

import java.util.List;

public interface Graph {
    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }

    public void addEdge(int v1, int v2);

    public List<Integer> getAllVertices(int v);
}



