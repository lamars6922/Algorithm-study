package test;

class MyQueue<T> {
	Stack<T> stackNewest, stackOldest;
	
	MyQueue() {
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}
	
	public int size() {
		return stackNewest.size() + stackOldest.size();
	}
	public void add(T value) {
		stackNewest.push(value);
	}
	private void shiftStacks() {
		if (stackOldest.isEmpty()) { // 실제로 꺼내야되는 스택이 모두 비어있어야함.(마지막 스택)
			while(!stackNewest.isEmpty()) { // 마찬가지로 첫 스택이 비워질때까지 반복
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	public T peek() {
		shiftStacks();
		return stackOldest.peek();
	}
	public T remove() {
		shiftStacks();
		return stackOldest.pop();
	}
}
public class TwoStackToQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue<Integer> q = new MyQueue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
	}

}
