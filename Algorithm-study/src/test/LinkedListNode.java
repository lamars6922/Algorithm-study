package test;

import test.LinkedList.Node;

class LinkedList {
	Node header;
	
	static class Node {
		int data;
		Node next = null;
		
		Node() {
			
		}
		
		Node(int d) {
			this.data = d;
		}
	}
	
	LinkedList() {
		header = new Node();
	}
	
	void append(int d) {
		Node n = header;
		Node end = new Node();
		end.data = d;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	void delete(int d) {
		Node n = header;
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}
	
	void retrieve() {
		Node n = header.next;
		while (n.next != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println(n.data);
	}
	//중복제거 함수(0이 없을 경우)
	void removeDups() {
		Node n = header;
		while(n != null && n.next != null) {
			Node r = n;
			while(r.next != null) {
				if(n.data == r.next.data) {
					r.next = r.next.next;
				} else {
					r = r.next;
				}
			}
			n = n.next;
		}
	}

	Node getFirst() {
		return header.next;
	}
	
	Node get(int k) {
		Node n = header;
		int count = 0;
		
		while (n.next != null) {
			count++;
			n = n.next;
		}
	
		n = header;
		
		if(count < k) {
			n = null;
			return n;
		} else {
			for(int i = 0; i < k; i++) {
				n = n.next;
			}
			return n;
		}
	}
}

class Reference {
	public int count;
}

class Storage {
	int carry = 0;
	Node result = null;
}

public class LinkedListNode {
	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		l1.append(9);
		l1.append(1);
		l1.retrieve();
		
		LinkedList l2 = new LinkedList();
		l2.append(6);
		l2.append(4);
		l2.retrieve();
	}
}