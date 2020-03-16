package com.algo.graph;

import java.util.List;

public class dfs {
    public static void main(String args[]) {
        AdjacencyList adjList = new AdjacencyList();

        adjList.addEdge(0,4);
        adjList.addEdge(3,4);
        adjList.addEdge(1,4);
        adjList.addEdge(1,6);
        adjList.addEdge(1,2);

        List<Integer> list = adjList.getAllVertices(1);
        list.forEach(x -> System.out.println(x));

        boolean visited[] = new boolean[10];
        for(int i = 0 ; i < visited.length; i++) {
            visited[i] = false;
        }

        adjList.dfs(3, visited);

        for(int i = 0; i < visited.length; i++) {
            if(visited[i] == true) {
                System.out.print(" -> " + i);
            }
        }
    }
}
