package test;

import java.util.LinkedList;

//BFS : 큐 , DFS : 스택
class Graph {
	class Node {
		int data;
		LinkedList<Node> adjacent; //인접한 노드
		boolean marked;
		Node (int data) {
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>();
		}
	}
	Node[] nodes;
	Graph(int size) {
		nodes = new Node[size];
		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	void dfs() {
		dfs(0);
	}
	void dfs(int index) {
		Node root = nodes[index];
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		root.marked = true;
		while (!stack.isEmpty()) {
			Node r = stack.pop();
			for (Node n : r.adjacent) {
				if(n.marked == false) {
					n.marked = true;
					stack.push(n);
				}
			}
			visit(r);
		}
	}
	
	void bfs() {
		bfs(0);
	}
	void bfs(int index) {
		Node root = nodes[index];
		Queue<Node> queue = new Queue<Node>();
		queue.add(root);
		root.marked = true;
		while(!queue.isEmpty()) {
			Node r = queue.remove();
			for (Node n : r.adjacent) {
				if(n.marked == false) {
					n.marked = true;
					queue.add(n);
				}
			}
			visit(r);
		}
	}
	void dfsR(Node r) {
		if(r == null) return;
		
		r.marked = true;
		visit(r);
		for(Node n : r.adjacent) {
			if(n.marked == false) {
				dfsR(n);
			}
		}
	}
	void dfsR(int index) {
		Node r = nodes[index];
		dfsR(r);
	}
	void dfsR() {
		dfsR(0);
	}
	void visit(Node n) {
		System.out.print(n.data + " ");
	}
	
	void initMarks() {
		for (Node n : nodes) {
			n.marked = false;
		}
	}
	
	boolean search(int i1, int i2) {
		return search(nodes[i1], nodes[i2]);
	}
	
	boolean search(Node start, Node end) {
		initMarks();
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(start);
		while(!q.isEmpty()) {
			Node root = q.removeFirst();
			if(root == end) {
				return true;
			}
			for (Node n : root.adjacent) {
				if(n.marked == false) {
					n.marked = true;
					q.add(n);
				}
			}
		}
		return false;
	}
	
}
/*
 ---------------------------------------
        0
       /
      1 -- 3    7
      |   /|\  /
      |  / |  5
      2 -- 4   \
               6 -- 8
 */
public class DfsAndBfsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
//		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
//		g.dfs();
//		g.bfs();
//		g.dfsR(3);
		System.out.println(g.search(1, 8));
	}

}
