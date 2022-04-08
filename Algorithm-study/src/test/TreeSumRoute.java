package test;

import java.util.ArrayList;
import java.util.HashMap;

import test.Tree2.Node;

class Tree5 {
	class Node {
		int data;
		Node left;
		Node right;
		Node (int data) {
			this.data = data;
		}
	}
	Node root;
	Tree5 (int size) {
		root = makeBST(0, size-1);
	}
	
	Node makeBST(int start, int end) {
		if(start > end) return null;
		int mid = (start + end) / 2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid -1);
		node.right = makeBST(mid + 1, end);
		return node;
	}
	
	int countPathsWithSum1(int targetSum) {
		return countPathsWithSum1(root, targetSum);
	}
	
	int countPathsWithSum1(Node root, int targetSum) {
		if(root == null) return 0;
		int pathsFromRoot = countPathsWithSumFromNode1(root, targetSum, 0);
		int pathsOnLeft = countPathsWithSum1(root.left, targetSum);
		int pathsOnRight = countPathsWithSum1(root.right, targetSum);
		return pathsFromRoot + pathsOnLeft + pathsOnRight;
	}
	int countPathsWithSumFromNode1(Node node, int targetSum, int currSum) {
		if (node == null) return 0;
		currSum += node.data;
		int totalPaths = 0;
		if(currSum == targetSum) {
			totalPaths++;
		}
		totalPaths += countPathsWithSumFromNode1(node.left, targetSum, currSum);
		totalPaths += countPathsWithSumFromNode1(node.right, targetSum, currSum);
		return totalPaths;
	}
	int countPathsWithSum2(int targetSum) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		return countPathsWithSum2(root, targetSum, array);
	}
	int countPathsWithSum2(Node root, int targetSum, ArrayList<Integer> array) {
		if (root == null) return 0;
		int totalPaths = 0;
		addValue(array, root.data);
		totalPaths = countPaths(array, targetSum);
		totalPaths += countPathsWithSum2(root.left, targetSum, array);
		totalPaths += countPathsWithSum2(root.right, targetSum, array);
		removeLast(array);
		return totalPaths;
	}
	void addValue(ArrayList<Integer> array, int value) {
		for(int i = 0; i < array.size(); i++) {
			array.set(i, array.get(i) + value);
		}
		array.add(value);
	}
	void removeLast(ArrayList<Integer> array) {
		int value = array.remove(array.size() -1);
		for(int i = 0; i < array.size(); i ++) {
			array.set(i, array.get(i) - value);
		}
	}
	int countPaths(ArrayList<Integer> array, int targetSum) {
		int totalPaths = 0;
		for(int i = 0; i < array.size(); i++) {
			if(array.get(i) == targetSum) totalPaths++;
		}
		return totalPaths;
	}
	int countPathsWithSum3(int targetSum) {
		HashMap<Integer, Integer> hashTable = new HashMap<Integer, Integer>(); // 노드의 값을 키
		hashTable.put(0, 1);
		return countPathsWithSum3(root, targetSum, 0, hashTable);
	}
	int countPathsWithSum3(Node node, int targetSum, int currSum, HashMap<Integer, Integer> hashTable) {
		if (node == null) return 0;
		
		currSum += node.data;
		int sum = currSum - targetSum;
		int totalPaths = hashTable.getOrDefault(sum, 0);
		incrementHashTable(hashTable, currSum, 1);
		totalPaths += countPathsWithSum3(node.left, targetSum, currSum, hashTable);
		totalPaths += countPathsWithSum3(node.right, targetSum, currSum, hashTable);
		incrementHashTable(hashTable, currSum, -1);
		return totalPaths;
	}
	void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int val) {
		int newCount = hashTable.getOrDefault(key, 0) + val;
		if(newCount == 0) {
			hashTable.remove(key);
		} else {
			hashTable.put(key, newCount);
		}
	}
}
public class TreeSumRoute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree5 tree = new Tree5(10);
		System.out.println(tree.countPathsWithSum1(3));
		System.out.println(tree.countPathsWithSum2(3));
		System.out.println(tree.countPathsWithSum3(3));
	}

}
