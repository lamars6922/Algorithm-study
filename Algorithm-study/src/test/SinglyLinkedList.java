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
	
	Node get(int k) {
		Node n = this;
		int count = 0;
		while(n.next != null) {
			if(k == count) {
				return n;
			} else {
				count++;
				n = n.next;
			}
		}
		return null;
	}
	
	Node addNext(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
		
		return end;
	}
	
	Node addNext(Node i) {
		Node n = this;

		while (n.next != null) {
			n = n.next;
		}
		n.next = i;
		
		return i;
	}
}

public class SinglyLinkedList {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.retrieve();
	}

} 