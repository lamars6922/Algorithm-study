package test;

public class CheckBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree t = new BinaryTree(10);
		System.out.println("Solution 1 - using inorder: " +t.isValidateBST1());
		System.out.println("Solution 2 - without array: " +t.isValidateBST2());
		System.out.println("Solution 2 - min/max: " +t.isValidateBST3());
	}

}
