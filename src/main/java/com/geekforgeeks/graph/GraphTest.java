package com.geekforgeeks.graph;

public class GraphTest {

    public static void main(String[] args) {

        Graph g = new AdjacenyList(Graph.GraphType.UNDIRECTED);

        g.addEdge(0, 1);

        g.addEdge(2, 3);
        g.addEdge(2, 4);

        g.addEdge(5, 5);

        g.display();

        g.bfs();

        System.out.println(" Num Of Connected Components via DFS " + g.dfs());

    }
}
