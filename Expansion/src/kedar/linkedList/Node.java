package kedar.linkedList;

public class Node<T> {
	
	Integer id = null;
	Node<?> nextNode = null;
	T data = null;
	
	public static <T> Node<T> createNode(Integer id) {
		Node<T> node = new Node<>(id);
		return node;
	}
	
	public static <T> Node<T> createNode(Integer id, T data) {
		Node<T> node = new Node<>(id);
		node.setData(data);
		return node;
	}
	
	private Node() throws Exception {
		throw new Exception("Invalid call : Need id as mandatory");
	}

	private Node(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<?> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
}
