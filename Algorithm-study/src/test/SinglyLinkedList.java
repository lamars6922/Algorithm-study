package test;

class Node {
	int data;
	Node next = null;
	
	Node(int d) {
		this.data = d;
	}
	
	void append(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	void delete(int d) {
		Node n = this;
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}
	
	void retrieve() {
		Node n = this;
		while (n.next != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println(n.data);
	}
}

class Reference {
	public int count;
}

public class SinglyLinkedList {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.retrieve();
		
//		int k = 2;
//		Node kth = KthToLast(head, k);
//		System.out.println("Last k(" + k + ")th data is " + kth.data);
///////////////////////////////////////////////////////////////////////////////////////////		
//		int k = 2;
//		KthToLast(head, k);
///////////////////////////////////////////////////////////////////////////////////////////		
//		int k = 2;
//		Reference r = new Reference();
//		Node found = KthToLast(head, k, r);
//		System.out.println(found.data);
///////////////////////////////////////////////////////////////////////////////////////////		
		int k = 2;
		Node found = KthToLast(head, k);
		System.out.println(found.data);
	}
/*	
	private static Node KthToLast(Node first, int k) { //재귀호출 사용하지 않고
		Node n = first;
		int total = 1;
		while(n.next != null) {
			total++;
			n = n.next;
		}
		n = first;
		for(int i = 1; i < total - k + 1; i++) {
			n = n.next;
		}
		return n;
	}
	*/
	/*
	private static int KthToLast(Node n, int k, Reference r) { //재귀호출 사용(값 출력)
		if (n == null) {
			return 0;
		}
		
		int count = KthToLast(n.next, k) + 1;
		if (count == k) {
			System.out.println(k + "th to last node is " + n.data);
		}
		return count;
	}
	*/
	/*
	private static Node KthToLast(Node n, int k, Reference r) { //재귀호출 사용(값 출력)
		if (n == null) {
			return null;
		}
		
		Node found = KthToLast(n.next, k, r);
		r.count++;
		if (r.count == k) {
			return n;
		}
		return found;
	}
	*/
	private static Node KthToLast(Node first, int k) { // 포인터사용
		Node p1 = first;
		Node p2 = first;
		
		for(int i = 0; i < k; i++) {
			if(p1 == null) return null;
			p1 = p1.next;
		}
		
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
}