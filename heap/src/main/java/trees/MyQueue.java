package trees;

class MyQueue {
	private Node[] data;
	private int front=-1, rear=-1, top=-1;
	public MyQueue() {
	 data = new Node[100];
	}
	public void add(Node n) {
		top=++rear;
		if(front<0) {
			front=rear;
		}
		
		data [rear]=n;
	}
//	public Node remove(){
//		if(front<0) {
//			return null;
//		}
//		Node n = data[front];
//		if(front == rear) {
//			rear=-1;
//		} 
//		front--;
//		return n;
//	}
	public boolean isEmpty() {
		if(front<0) return true;
		else 
			return false;
	}
	
	public Node pop () {
		if(top<0)
			return null;
		Node n = data[top];
		if(front ==rear) {
			front=rear=-1;
		} 
		rear=--top;
		return n;
	}
	
} 