package test;

class Level {
	int min = Integer.MAX_VALUE;
	int max = Integer.MIN_VALUE;
}
public class TreeBalanceCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree t = new BinaryTree(10);
		System.out.println(t.isBalanced(t.root));
		System.out.println(t.isBalanced2(t.root));
		System.out.println(t.isBalanced3(t.root));
	}

}
