package com.algo.graph;


import java.util.ArrayList;
import java.util.List;

class AdjacencyMatrix<nVertices> implements  Graph {

    int nVertices = 10;
    GraphType graphType = GraphType.UNDIRECTED;
    int[][] a;

    AdjacencyMatrix() {

        a = new int[nVertices][nVertices];

        for (int i = 0; i < nVertices; i++) {
            for (int j = 0; j < nVertices; j++) {
                a[i][j] = 0;
            }
        }
    }

    public void addEdge(int v1, int v2) {
        if(v1 < 0 || v2 < 0 || v1 > nVertices || v2 > nVertices) {
            throw new IllegalArgumentException();
        }

        a[v1][v2] = 1;

        if(graphType == GraphType.UNDIRECTED) {
            a[v2][v1] = 1;
        }
    }

    public List<Integer> getAllVertices(int v) {
        List<Integer> nList = new ArrayList<Integer>();

            for(int j = 0; j < nVertices; j++) {
                if(a[v][j] == 1) {
                    nList.add(j);
                }
            }

        return nList;
    }


    public static void main(String args[]) {
        System.out.println("AdjacencyMatrix");

        AdjacencyMatrix adj = new AdjacencyMatrix();

        adj.addEdge(0,4);
        adj.addEdge(3,4);
        adj.addEdge(1,4);
        adj.addEdge(1,6);
        adj.addEdge(1,2);

        List<Integer> list = adj.getAllVertices(4);
        list.forEach(x -> System.out.println(x));


    }
}


