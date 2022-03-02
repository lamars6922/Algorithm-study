package test;
/*
       (1) 
 	 /     \
 	 (2)   (3)
 	 / \
 	(4)(5)
 	Inorder(Left, Root, Right) : 4 2 5 1 3
 	Preorder(Root, Left, Right) : 1 2 4 5 3
 	Postorder(Left, Right, Root) : 4 5 2 3 1
*/
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
}

class Tree {
	public TreeNode root;
	
	public void setRoot(TreeNode node) {
		this.root = node;
	}
	
	public TreeNode getRoot() {
		return root;
	}
	public TreeNode makeNode(TreeNode left, int data, TreeNode right) {
		TreeNode node = new TreeNode();
		node.data = data;
		node.left = left;
		node.right = right;
		return node;
	}
	public void inorder(TreeNode node) {
		if(node != null) {
			inorder(node.left);
			System.out.println(node.data);
			inorder(node.right);
		}
	}
	public void preorder(TreeNode node) {
		if(node != null) {
			System.out.println(node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}
	public void postorder(TreeNode node) {
		if(node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.println(node.data);
		}
	}
	
}

public class BinaryTreeCircuit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree t = new Tree();
		TreeNode n4 = t.makeNode(null, 4, null);
		TreeNode n5 = t.makeNode(null, 5, null);
		TreeNode n2 = t.makeNode(n4, 2, n5);
		TreeNode n3 = t.makeNode(null, 3, null);
		TreeNode n1 = t.makeNode(n2, 1, n3);
		t.setRoot(n1);
//		t.inorder(t.getRoot());
//		t.preorder(t.getRoot());
		t.postorder(t.getRoot());
	}

}
