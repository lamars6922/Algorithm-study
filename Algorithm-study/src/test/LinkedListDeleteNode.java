package test;

import test.LinkedList.Node;

public class LinkedListDeleteNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		
		deleteNode(ll.get(2));
		ll.retrieve();
	}
	
	private static boolean deleteNode(Node n) { // 중간노드 삭제(처음과 끝노드는 삭제 불가라는데... 첫번째는 왜 못지우지?) 
		if (n == null || n.next == null) {
			return false;
		}
		Node Next = n.next;
		n.data = Next.data;
		n.next = Next.next;
		
		return true;
	}

}
