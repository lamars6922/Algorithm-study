package test;

class BST {
	class Node {
		int data;
		Node left;
		Node right;
		Node parent;
		Node(int data) {
			this.data = data;
		}
	}
	Node root;
	BST(int size) {
		root = makeBST(0, size -1, null);
	}
	Node makeBST(int start, int end, Node parent) {
		if(start > end) return null;
		int mid = (start + end) / 2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid -1, node);
		node.right = makeBST(mid + 1, end, node);
		node.parent = parent;
		return node;
	}
	void findNext(Node node) {
		if(node.right == null) {
			System.out.println(findAbove(node.parent, node).data + " is " +
		node.data + "'s next");
		} else {
			System.out.println(findBelow(node.right).data + " is " + node.data
					+ "'s next");
		}
	}
	Node findAbove(Node root, Node child) {
		if(root == null) return null;
		if(root.left == child) return root;
		return findAbove(root.parent, root);
	}
	Node findBelow(Node root) {
		if(root.left == null) return root;
		return findBelow(root.left);
	}
}
public class NextBSTSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST t = new BST(10);
		/*
		        4
		       / \
		      /   \
		     /     \
		    1       7
		   / \     / \
		  0   2    5  8
		       \    \  \
		       3     6   9
		*/
		t.findNext(t.root.left.right.right);
		t.findNext(t.root.left);
		t.findNext(t.root);
		t.findNext(t.root.left.left);
		t.findNext(t.root.right.left.right);
		t.findNext(t.root.right.right.right);
	}

}
