package test;

import test.LinkedList.Node;

public class LinkedListDigitSum {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l1 = new LinkedList(); // 419
		l1.append(9);
		l1.append(1);
		l1.append(4);
		
		LinkedList l2 = new LinkedList(); // 534
		l2.append(4);
		l2.append(3);
		l2.append(5);
		
//		Node n = BacksumLists(l1.get(1), l2.get(1), 0);
		Node n = sumLists(l1.get(1), l2.get(1));
		while (n.next != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println(n.data);
		
	}
	
	private static Node BacksumLists(Node l1, Node l2, int carry) { // 자릿수 거꾸로 된 노드의 합계 구하기
		if(l1 == null && l2 == null && carry == 0) {
			return null;
		}
		
		Node result = new Node();
		int value = carry;
		
		if(l1 != null) {
			value += l1.data;
		} 
		
		if(l2 != null) {
			value += l2.data;
		}
		result.data = value % 10;
		
		if(l1 != null || l2 != null) {
			Node next = BacksumLists(l1 == null? null : l1.next,
								l2 == null? null : l2.next,
								value / 10);
			result.next = next;
		}
		return result;
	}
	
	private static Node sumLists(Node l1, Node l2) {
		int len1 = getListLength(l1);
		int len2 = getListLength(l2);
		
		if(len1 < len2) {
			l1 = LPadList(l1, len2 - len1);
		} else {
			l2 = LPadList(l2, len1 - len2);
		}
		
		Storage storage = addList(l1, l2);
		if(storage.carry == 0) {
			return storage.result;
		} else {
			storage.result = insertBefore(storage.result, storage.carry);
		}
		
		return storage.result;
	}
	
	private static Storage addList(Node l1, Node l2) {
		if(l1 == null && l2 == null) {
			Storage storage = new Storage();
			return storage;
		}
		
		Storage storage = addList(l1.next, l2.next);
		int value = l1.data + l2.data + storage.carry;
		int data = value % 10;
		storage.result = insertBefore(storage.result, data);
		storage.carry = value / 10;
		return storage;
	}
	
	private static int getListLength(Node l) {
		int total = 0;
		while(l.next != null) {
			total++;
			l = l.next;
		}
		return total;
	}
	
	private static Node insertBefore(Node l, int data) {
		Node before = new Node(data);
		
		if(l != null) {
			before.next = l;
		}
		return before;
	}
	
	private static Node LPadList(Node l, int length) {
		Node head = l;
		for(int i = 0; i < length; i++) {
			head = insertBefore(head, 0);
		}
		
		return head;
	}
}
