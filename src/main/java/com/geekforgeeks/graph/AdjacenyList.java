package com.geekforgeeks.graph;

import java.util.*;

interface Graph {

    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }

    public void addEdge(int v1, int v2);

    public void display();

    public void bfsCrawl();

}

public class AdjacenyList implements Graph {

    HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
    GraphType graphType = GraphType.DIRECTED;

    final int v = 10;

    AdjacenyList(GraphType graphType) {
        this.graphType = graphType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(adj, graphType, v);
    }

    @Override
    public void addEdge(int v1, int v2) {

        if ((v1 < 0 || v1 > v) || (v2 < 0 || v2 > v)) {
            System.out.println("Invalid");
        }

        System.out.println(" ===> " + adj.containsKey(v1));
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
    public void bfsCrawl() {
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < adj.size(); i++) {
            if (adj.containsKey(i)) {
                addToQueue(i, q);
                bfs(q, visited);
            }
            System.out.println();
        }

    }

    public void bfs(Queue<Integer> q, boolean[] visited) {

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

    public static void main(String args[]) {
        Graph g = new AdjacenyList(GraphType.UNDIRECTED);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(3, 4);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(7, 8);


        g.display();

        g.bfsCrawl();

    }
}
