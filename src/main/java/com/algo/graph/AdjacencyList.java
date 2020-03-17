package com.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



class Node {
    int vertexId;
    List<Integer> nodeList;

    Node(int vertexId) {
        this.vertexId = vertexId;
        nodeList = new ArrayList<>();
    }

    public int getVertexId() {
        return vertexId;
    }

    @Override
    public int hashCode() {
        return vertexId;
    }
}


public class AdjacencyList implements Graph {

    GraphType graphType = GraphType.DIRECTED;
    HashMap<Integer,Node> adjList = new HashMap<>();


    AdjacencyList() { }

    @Override
    public void addEdge(int v1, int v2) {
        if(!adjList.containsKey(v1)) {
            adjList.put(v1, new Node(v1));
        }
        adjList.get(v1).nodeList.add(v2);

        if(graphType == GraphType.UNDIRECTED) {

            if(!adjList.containsKey(v2)) {
                adjList.put(v2, new Node(v2));
            }
            adjList.get(v2).nodeList.add(v1);
        }
    }

    @Override
    public List<Integer> getAllVertices(int v) {
        if(adjList.containsKey(v)) {
            return adjList.get(v).nodeList;
        }
        return null;
    }

    public void dfs(int vertex , boolean visited[]) {

        if(visited[vertex] == true) {
            return;
        }

        visited[vertex] = true;
        if(adjList.containsKey(vertex)) {
            adjList.get(vertex).nodeList.forEach(x -> {
                dfs(x, visited) ;
            });
        }
    }

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

        adjList.dfs(1, visited);

        for(int i = 0; i < visited.length; i++) {
            if(visited[i] == true) {
                System.out.print(" -> " + i);
            }
        }
    }
}
