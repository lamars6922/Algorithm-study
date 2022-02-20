package test;

import test.LinkedList.*;
import test.LinkedList.Node;

public class LinkedListBackCount {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
//		System.out.println(ll.header.data);
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.retrieve();
		///////////////////////////////////////////////////////////////////////////////////////////		
		//int k = 2;
		//Node kth = KthToLast(ll.getFirst(), k);
		//System.out.println("Last k(" + k + ")th data is " + kth.data);
		///////////////////////////////////////////////////////////////////////////////////////////		
		//int k = 2;
		//KthToLast(head, k);
		///////////////////////////////////////////////////////////////////////////////////////////		
		int k = 4;
		Reference r = new Reference();
		Node found = KthToLast(ll.getFirst(), k, r);
		System.out.println(found.data);
		///////////////////////////////////////////////////////////////////////////////////////////		
		//int k = 2;
		//Node found = KthToLast(ll.getFirst(), k);
		//System.out.println(found.data);
	}
	
	// 뒤에서부터 k번째 노드 찾기
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
			private static int KthToLast(Node n, int k) { //재귀호출 사용(값 출력)
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
			
			private static Node KthToLast(Node n, int k, Reference r) { //재귀호출 사용(노드 출력)
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
			
			/*
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
			*/
}
