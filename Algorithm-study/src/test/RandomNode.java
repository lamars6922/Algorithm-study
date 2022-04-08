package test;

import java.util.Random;

class Tree4 {
	class Node {
		int data;
		Node left; 
		Node right;
		int size = 0;
		Node (int data) {
			this.data = data;
			this.size = 1;
		}
		void insert(int data) {
			if(data <= this.data) {
				if(left == null) {
					left = new Node(data);
				} else {
					left.insert(data);
				}
			} else {
				if (right == null) {
					right = new Node(data);
				} else {
					right.insert(data);
				}
			}
			size++;
		}
		int size() { return size; }
		Node find(int data) {
			if(data == this.data) {
				return this;
			} else if (data < this.data) {
				return left != null? left.find(data) : null;
			} else if (data > this.data) {
				return right != null? right.find(data) : null;
			} else {
				return null;
			}
		}
		Node getIthNode(int i) {
			int leftSize = left == null? 0 : left.size();
			if(i < leftSize) {
				return left.getIthNode(i);
			}else if(i == leftSize) {
				return this;
			} else {
				return right.getIthNode(i - (leftSize+1));
			}
		}
	}
	
	Node root;
	
	int size() {
		return root == null ? 0 : root.size();
	}
	
	void insert(int data) {
		if(root == null) root = new Node(data);
		else root.insert(data);
	}
	Node getRandomNode() {
		if (root == null) return null;
		Random random = new Random();
		int i = random.nextInt(size());
		return root.getIthNode(i);
	}
}
public class RandomNode {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		        4
		       / \
		      /   \
		     /     \
		    0       5
		    \        \
		     1        7
		      \      / \
		       2    6   8
		        \        \
		         3        9
		*/
		Tree4 t = new Tree4();
		t.insert(4);
		t.insert(0);
		t.insert(1);
		t.insert(2);
		t.insert(5);
		t.insert(7);
		t.insert(8);
		t.insert(3);
		t.insert(6);
		t.insert(9);
		System.out.println(t.getRandomNode().data);
	}
}
