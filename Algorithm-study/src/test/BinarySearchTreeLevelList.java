package test;

import java.util.ArrayList;
import java.util.LinkedList;

class BinaryTree {
	class Node {
		int data;
		Node left;
		Node right;
		Node (int data) {
			this.data = data;
		}
	}
	Node root;
	
	BinaryTree (int size) {
		root = makeBST(0, size-1);
		root.right.right.right.right = new Node(10); // UnBalanced를 트리를 만들기 위함.
		root.right.right.left = new Node(11);
	}
	
	Node makeBST(int start, int end) {
		if(start > end) return null;
		int mid = (start + end) / 2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid -1);
		node.right = makeBST(mid + 1, end);
		return node;
	}
	//이진트리 레벨별 리스트 만들기
	ArrayList<LinkedList<Node>> BSTtoList() { //  첫번째 방법 레벨인수를 전달하는 방법.
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		BSTtoList(root, lists, 0);
		return lists;
	}
	void BSTtoList(Node root, ArrayList<LinkedList<Node>> lists, int level) { 
		if(root == null) return;
		LinkedList<Node> list = null;
		if(lists.size() == level) {
			list = new LinkedList<Node>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root); // 자기 자신
		BSTtoList(root.left, lists, level +1);
		BSTtoList(root.right, lists, level + 1);
	}
	ArrayList<LinkedList<Node>> BSTtoList2() {
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		LinkedList<Node> current = new LinkedList<Node>();
		if(root != null) {
			current.add(root);
		}
		while (current.size() > 0) {
			result.add(current);
			LinkedList<Node> parents = current;
			current = new LinkedList<Node>();
			for (Node parent : parents) {
				if (parent.left != null) current.add(parent.left);
				if (parent.right != null) current.add(parent.right);
			}
		}
		return result;
	}
	void printList(ArrayList<LinkedList<Node>> arr) {
		for(LinkedList<Node> list : arr) {
			for(Node node : list) {
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
	}
	//Tree의 Balance 확인하기
	boolean isBalanced(Node root) { // 왼쪽, 오른쪽 가장 긴 서브트리끼리의 차이가 1초과가 나는지 체크 1
		if(root == null) return true;
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if(Math.abs(heightDiff) > 1) {
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
	int getHeight(Node root) { // 함수가 벗겨지면서 레벨을 올림.
		if (root == null) return -1;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	int checkHeight(Node root) {
		if (root == null) return -1;
		int leftHeight = checkHeight(root.left);
		if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		int rightHeight = checkHeight(root.right);
		if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftHeight, rightHeight) +1;
		}
	}
	boolean isBalanced2 (Node root) { // 왼쪽, 오른쪽 가장 긴 서브트리끼리의 차이가 1초과가 나는지 체크 2
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	boolean isBalanced3(Node root) { // 어느 서브트리든 차이가 1초과가 안나는지 체크(더 엄격) 3
		Level obj = new Level();
		checkBalanced(root, obj, 0);
		if(Math.abs(obj.min - obj.max) > 1) return false;
		else return true;
	}
	void checkBalanced(Node node, Level obj, int level) {
		if(node == null) {
			if(level < obj.min) obj.min = level;
			else if (level > obj.max) obj.max = level;
			return;
		}
		checkBalanced(node.left, obj, level + 1);
		checkBalanced(node.right, obj, level + 1);
	}
	
}
public class BinarySearchTreeLevelList {
	public static void main(String[] args) {
		BinaryTree t = new BinaryTree(10);
		t.printList(t.BSTtoList2());
	}
}
