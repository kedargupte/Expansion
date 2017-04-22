package kedar.linkedList;

public class LinkedList {
	
	Node<?> rootNode = null;
	
	public Node<?> getRootNode() {
		return rootNode;
	}
	
	Integer getSize() {
		if(rootNode == null) {
			return 0;
		}
		Integer size = 0;
		Node<?> temp = rootNode;
		while(temp != null) {
			size++;
			temp = temp.nextNode;
		}
		return size;
	}
	
	void display() {
		if(rootNode == null) {
			System.out.println("List is empty");
		} else {
			Node<?> temp = rootNode;
			while(temp != null) {
				System.out.print(temp.getId() + " ");
				temp = temp.getNextNode();
			}
			System.out.println();
		}
	}
	
	void displayData() {
		if(rootNode == null) {
			System.out.println("List is empty");
		} else {
			Node<?> temp = rootNode;
			while(temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getNextNode();
			}
			System.out.println();
		}
	}
	
	void add(Node<?> node) {
		if(rootNode == null) {
			rootNode = node;
		} else {
			Node<?> temp = rootNode;
			while(temp.nextNode != null)
				temp = temp.nextNode;
			temp.nextNode = node;
		}
	}
	
	void addAfter(Node<?> node, Integer id) throws Exception {
		if(rootNode == null)
			throw new Exception("Unable to add node after ID : " + id + " List is Empty");
		Node<?> temp = rootNode;
		while(temp != null) {
			if(temp.getId().equals(id)) {
				node.setNextNode(temp.getNextNode());
				temp.setNextNode(node);
				return;
			}
			temp = temp.getNextNode();
		}
		throw new Exception("Unable to locate node with ID : " + id);
	}
	
	Node<?> searchNode(Integer id) {
		if(rootNode == null)
			return null;
		Node<?> temp = rootNode;
		while(temp != null) {
			if(temp.getId().equals(id))
				return temp;
			temp = temp.nextNode;
		}
		return null;
	}
	
	Boolean deleteNode(Integer id) throws Exception {
		if(rootNode == null)
			throw new Exception("Unable to delete : Linked List is empty");
		
		if(rootNode.getId().equals(id)) {
			Node<?> temp = rootNode;
			rootNode = temp.nextNode;
			temp = null;
			return true;
		}
		Node<?> temp = rootNode;
		while(temp != null) {
			if(temp.nextNode != null && temp.nextNode.getId().equals(id)) {
				Node<?> nextNode = temp.nextNode;
				temp.nextNode = nextNode.nextNode;
				nextNode = null;
				return true;
			}
			temp = temp.nextNode;
		}
		throw new Exception("Unable to locate node to be deleted with ID : " + id);
	}
	
	void reverse() {
		if(rootNode == null) 
			return;
		Node<?> previousNode = rootNode, nextNode = rootNode.nextNode;
		rootNode.setNextNode(null);
		while(nextNode != null) {
			Node temp = nextNode.getNextNode();
			nextNode.setNextNode(previousNode);
			previousNode = nextNode;
			nextNode = temp;
		}
		rootNode = previousNode;
	}
	
	public static void main(String args[]) {
		LinkedList linkedList = new LinkedList();
		linkedList.add(Node.createNode(1));
		linkedList.add(Node.createNode(2));
		linkedList.add(Node.createNode(3));
		linkedList.add(Node.createNode(4));
		
		linkedList.display();
		System.out.println(linkedList.searchNode(3).getId());
		try {
			System.out.println(linkedList.deleteNode(2));
		} catch (Exception e) {
			System.err.println(e);
		}
		linkedList.display();
		
		try {
			linkedList.addAfter(Node.createNode(5), 1);
			linkedList.addAfter(Node.createNode(6), 4);
			linkedList.addAfter(Node.createNode(7), 3);
		} catch (Exception e) {
			System.err.println(e);
		}
		linkedList.display();
		
		try {
			System.out.println(linkedList.deleteNode(7));
		} catch (Exception e) {
			System.err.println(e);
		}
		linkedList.display();
		linkedList.reverse();
		linkedList.display();
	}

}
