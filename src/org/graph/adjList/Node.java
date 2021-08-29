package org.graph.adjList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Node<T> {
    T val;
    LinkedList<Node<T>> adjList;
    
    public Node(T val) {
    	this.val = val;
    	this.adjList = new LinkedList<>();
    }
}
