
class Node {
	public Object data;
	public Node next;
} 

public class llOrderedList {

    private int listSize;			//the size of the ordered list
    private int numObjects;
  
	private Node first;  			//first element in the linked list
	private Node prev;   			//iterator reference to previous element
	private Node curr;   			//iterator reference to current element
	private boolean tf = false;
	
	public llOrderedList() {
		
		first = null;
		prev = null;
		curr = null;
	
	}
	
	void add(Comparable newObject) {
		
		curr = first;
		prev = null;
		boolean foundPos = false;
		while (!foundPos) {
			if (curr == null) {
				foundPos = true;
			}
			else {
				if (((Comparable) curr.data).compareTo(newObject) > 0) {
					foundPos = true;
				}
				else {
					prev = curr;
					curr = curr.next;
				}
			}	
		}
		
		Node newNode = new Node();
		newNode.data = newObject;
		newNode.next = curr;
		if (prev == null){
		first = newNode;
		}
		else{
		prev.next = newNode;
		}
		numObjects++;
	}
	
	public String toString() {
		String stringFormat = "";																					//for formatting return string
		curr = first;
		while (curr != null) {														//Try (curr.next != null) if error
			stringFormat += String.format("%s\n", curr.data.toString());
			if (!(curr.next == null));																//ERROR
			curr = curr.next;
		}
		return stringFormat;
	}
	
	int size() {
		return numObjects;
	}
	
	boolean isEmpty() {
		return first == null;
	}
	
	void reset() {
		curr = first;
		prev = null;
	}
	
	Comparable next() {
		if (tf == false) {
			curr = curr.next;
			prev = curr;
			return (Comparable) curr.data;
		}
		else {
			tf = false;
			curr = first;
			return (Comparable) curr.data;
		}
    	
	}
	
	boolean hasNext() {
		return true;
	}
	
	void remove(Object searchVal) {
		
		reset();
		//Node curr = first;
		//Node prev = null;
		boolean foundPos = false;
		
		//search for position
		while (!foundPos){
			if (curr == null){
				foundPos = true;
			}
			else{
				if (((Comparable) curr.data).compareTo(searchVal) == 0) {
					foundPos = true;
					if(prev == null) {
						first = first.next;
					}
					else {
					prev.next = curr.next;
					}
				}
				else{
					prev = curr;
					curr = curr.next;
				}
			}
		}
	 numObjects--;
	}
	
}