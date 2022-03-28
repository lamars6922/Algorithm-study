package test;

import java.util.*;

import test.BST.Node;

class Tree1 {
	static class Node {
		int data;
		Node left;
		Node right;
		Node parent;
		Node (int data) {
			this.data = data;
		}
	}
	Node root;
	HashMap<Integer, Node> rootMap;
	Tree1 (int size) {
		rootMap = new HashMap<Integer, Node>();
		root = makeBST(0, size -1, null);
	}
	Node makeBST(int start, int end, Node parent) {
		if(start > end) return null;
		int mid = (start + end) / 2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid -1, node);
		node.right = makeBST(mid + 1, end, node);
		node.parent = parent;
		rootMap.put(mid, node);
		return node;
	}
	Node getNode(int data) {
		return rootMap.get(data);
	}
	Node commonAncestor1(int d1, int d2) {
		Node p = getNode(d1);
		Node q = getNode(d2);
		int diff = depth(p) - depth(q);
		Node first = diff > 0? q : p; // 짧은거
		Node second = diff > 0? p : q; // 긴거
		second = goUpBy(second, Math.abs(diff));
		while (first != second && first != null && second != null) {
			first = first.parent;
			second = second.parent;
		}
		return first == null || second == null ? null : first;
	}
	Node goUpBy(Node node, int diff) {
		while(diff > 0 && node != null) {
			node = node.parent;
			diff--;
		}
		return node;
	}
	int depth(Node node) {
		int depth = 0;
		while (node != null) {
			node = node.parent;
			depth++;
		}
		return depth;
	}
	
	boolean covers(Node root, Node node) {
		if(root == null) return false;
		if(root == node) return true;
		return covers(root.left, node) || covers(root.right, node);
	}
	Node commonAncestor2(int d1, int d2) {
		Node p = getNode(d1);
		Node q = getNode(d2);
		if(!covers(root, p) || !covers(root, q)) {
			return null;
		} else if (covers(p, q)) {
			return p;
		} else if(covers(q, p)) {
			return q;
		}
		Node sibling = getSibling(p);
		Node parent = p.parent;
		while (!covers(sibling, q)) {
			sibling = getSibling(parent);
			parent = parent.parent;
		}
		return parent;
	}
	Node getSibling(Node node) {
		if(node == null || node.parent == null) {
			return null;
		}
		Node parent = node.parent;
		return parent.left == node? parent.right : parent.left;
	}
	Node commonAncestor3(int d1, int d2) {
		Node p = getNode(d1);
		Node q = getNode(d2);
		if(!covers(root,p) || !covers(root, q)) {
			return null;
		}
		return ancestorHelper(root, p, q);
	}
	Node ancestorHelper(Node root, Node p, Node q) {
		if(root == null || root == p || root == q) {
			return root;
		}
		boolean pIsOnLeft = covers(root.left, p);
		boolean qIsOnLeft = covers(root.left, q);
		if(pIsOnLeft != qIsOnLeft) {
			return root;
		}
		Node childSide = pIsOnLeft? root.left : root.right;
		return ancestorHelper(childSide, p, q);
	}
}
public class SearchCommonNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree1 t = new Tree1(10);
		Tree1.Node fa1 = t.commonAncestor1(3, 5);
		Tree1.Node fa2 = t.commonAncestor2(6, 7);
		Tree1.Node fa3 = t.commonAncestor3(2, 8);
		System.out.println("The first common ancestor is " + fa1.data);
		System.out.println("The first common ancestor is " + fa2.data);
		System.out.println("The first common ancestor is " + fa3.data);
	}

}
