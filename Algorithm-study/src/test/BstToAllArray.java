package test;

import java.util.*;
import java.util.LinkedList;

class Tree2 {
	class Node {
		int data;
		Node left;
		Node right;
		Node (int data) {
			this.data = data;
		}
	}
	Node root;
	Tree2 (int size) {
		root = makeBST(0, size-1);
//		root.right.right.right.right = new Node(10); // UnBalanced를 트리를 만들기 위함.
//		root.right.right.left = new Node(11);
//		root.right.right.right.left = new Node(10);
//        this.size++;
	}
	
	Node makeBST(int start, int end) {
		if(start > end) return null;
		int mid = (start + end) / 2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid -1);
		node.right = makeBST(mid + 1, end);
		return node;
	}
}
public class BstToAllArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree2 t = new Tree2(5);
		ArrayList<LinkedList<Integer>> result = allSequences(t.root);
		for(LinkedList<Integer> l : result) {
			for(int data : l) {
				System.out.print(data);
			}
			System.out.println();
		}
	}
	static ArrayList<LinkedList<Integer>> allSequences(Tree2.Node node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		if(node == null) {
			result.add(new LinkedList<Integer>());
			return result;
		}
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.data);
		
		ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
		
		for(LinkedList<Integer> left : leftSeq) {
			for(LinkedList<Integer> right : rightSeq) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveLists(left, right, weaved, prefix);
				result.addAll(weaved);
			}
		}
		return result;
	}
	static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
			ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		if(first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = new LinkedList<Integer>();
			for(int data : prefix) result.add(data);
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
	}
}
