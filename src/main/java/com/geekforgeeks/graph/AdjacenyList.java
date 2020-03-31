package com.geekforgeeks.graph;

import java.util.*;

public class AdjacenyList implements Graph {

    HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
    GraphType graphType = GraphType.DIRECTED;
    final int nVertices = 10;

    AdjacenyList(GraphType graphType) {
        this.graphType = graphType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(adj, graphType, nVertices);
    }

    @Override
    public void addEdge(int v1, int v2) {

        if ((v1 < 0 || v1 > nVertices) || (v2 < 0 || v2 > nVertices)) {
            System.out.println("Invalid");
        }

        if (!adj.containsKey(v1)) {
            adj.put(v1, new ArrayList<>());
        }

        if (!adj.get(v1).contains(v2)) {
            adj.get(v1).add(v2);
        }

        if (graphType == GraphType.UNDIRECTED) {
            if (!adj.containsKey(v2)) {
                adj.put(v2, new ArrayList<>());
            }
            if (!adj.get(v2).contains(v1)) {
                adj.get(v2).add(v1);
            }
        }
    }

    @Override
    public void display() {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(" V [" + i + "] => ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" " + adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public void addToQueue(int index, Queue<Integer> q) {
        ArrayList<Integer> qList = null;

        if (adj.containsKey(index)) {
            qList = adj.get(index);
            for (Integer v : qList) {
                q.add(v);
            }
        }
    }

    @Override
    public void bfs() {
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < adj.size(); i++) {
            if (adj.containsKey(i)) {
                addToQueue(i, q);
                bfsEachAdjList(q, visited);
            }
            System.out.println();
        }

    }

    public void bfsEachAdjList(Queue<Integer> q, boolean[] visited) {

        while (!q.isEmpty()) {
            int ele = q.poll();
            if (visited[ele] == true) {
                continue;
            } else {
                System.out.print(" " + ele + " ");
                addToQueue(ele, q);
                visited[ele] = true;
            }
        }

    }

    public void dfsRec(HashMap<Integer, ArrayList<Integer>> adj, int v, boolean[] visited) {

        visited[v] = true;

        System.out.print(" " + v + " ");

        if (!adj.containsKey(v)) {
            return;
        }

        for (int ele : adj.get(v)) {
            if (!visited[ele]) {
                dfsRec(adj, ele, visited);
            }
        }
    }

    @Override
    public int dfs() {

        boolean[] visited = new boolean[adj.size()];
        int count = 0;

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        System.out.println(" DFS => : ");

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                dfsRec(adj, i, visited);
                count++;
                System.out.println();
            }
        }
        return count;
    }

    public static void main(String args[]) {

    }
}
