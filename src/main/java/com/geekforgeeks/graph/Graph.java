package com.geekforgeeks.graph;

public interface Graph {

    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }

    public void addEdge(int v0, int v2);

    public void display();

    public void bfs();

    // finds dfs, and also returns the connected components
    public int dfs();


}
