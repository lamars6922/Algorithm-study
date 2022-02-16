package test;

class LinkedList {
	Node header;
	
	static class Node {
		int data;
		Node next = null;
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
}

public class LinkedListNode {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		System.out.println(ll.header.data);
//		ll.append(1);
//		ll.append(2);
//		ll.append(3);
//		ll.append(4);
//		ll.retrieve();
//		ll.delete(1);
//		ll.retrieve();
	}
}