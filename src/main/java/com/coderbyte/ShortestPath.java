package com.coderbyte;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class ShortestPath {

    public static String ShortestPath(String[] strArr) {
        final Graph graph = new Graph();
        // Initialize nodes
        final int totalNodes = Integer.parseInt(strArr[0]);
        for (int i = 1; i < totalNodes + 1; i++) {
            final String nodeName = strArr[i];
            final Node node = new Node(nodeName);
            graph.add(node);
        }
        // Initialize connections
        for (int i = totalNodes + 1; i < strArr.length; i++) {
            final String[] connection = strArr[i].split("-");
            final String nodeA = connection[0];
            final String nodeB = connection[1];
            graph.connect(nodeA, nodeB);
        }
        final Node startNode = graph.getNode(strArr[1]);
        final Node targetNode = graph.getNode(strArr[totalNodes]);

        calculateDistances(startNode);

        final List<Node> path = findPath(startNode, targetNode);
        if (path.isEmpty()) {
            return "-1";
        }
        return path.stream()
                .map(Node::getName)
                .collect(Collectors.joining("-"));
    }

    private static void calculateDistances(final Node startNode) {
        final Queue<Node> queue = new PriorityQueue<>();
        queue.add(startNode);
        startNode.setDistanceFromSource(0);

        while (!queue.isEmpty()) {
            final Node current = queue.poll();

            for (Node neighbor : current.getNeighbors()) {
                final int newDistance = current.getDistanceFromSource() + 1;
                if (newDistance < neighbor.getDistanceFromSource()) {
                    neighbor.setDistanceFromSource(newDistance);
                    neighbor.setPrevious(current);
                    queue.add(neighbor);
                }
            }
        }
    }

    private static List<Node> findPath(final Node startNode, final Node targetNode) {
        if (targetNode.getPrevious() == null) {
            return Collections.emptyList();
        }
        final List<Node> path = new LinkedList<>();
        path.add(targetNode);

        Node current = targetNode;
        do {
            current = current.getPrevious();
            path.add(current);
        } while (!Objects.equals(current, startNode));

        Collections.reverse(path);
        return path;
    }

    static class Graph {
        private final Map<String, Node> nodes = new HashMap<>();

        public void add(Node node) {
            this.nodes.put(node.getName(), node);
        }

        public Node getNode(String name) {
            return this.nodes.get(name);
        }

        public void connect(final String nameA, final String nameB) {
            final Node nodeA = getNode(nameA);
            final Node nodeB = getNode(nameB);
            nodeA.connect(nodeB);
            nodeB.connect(nodeA);
        }
    }

    static class Node implements Comparable<Node> {
        private final String name;
        private final Set<Node> neighbors;
        private int distanceFromSource = Integer.MAX_VALUE;
        private Node previous;

        public Node(final String name) {
            this.name = name;
            this.neighbors = new HashSet<>();
        }

        public void connect(final Node connected) {
            this.neighbors.add(connected);
        }

        public String getName() {
            return this.name;
        }

        public Set<Node> getNeighbors() {
            return this.neighbors;
        }

        public int getDistanceFromSource() {
            return this.distanceFromSource;
        }

        public void setDistanceFromSource(final int distanceFromSource) {
            this.distanceFromSource = distanceFromSource;
        }

        public Node getPrevious() {
            return this.previous;
        }

        public void setPrevious(final Node previous) {
            this.previous = previous;
        }

        @Override
        public int compareTo(final Node other) {
            return Integer.compare(this.getDistanceFromSource(), other.getDistanceFromSource());
        }
    }

}
