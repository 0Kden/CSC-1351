import java.util.Arrays;

public class OrderedList {

}

class aOrderedList implements List{

	final int SIZEINCREMENTS = 20; 	//size of increments for increasing ordered list
    private Comparable[] oList;		//the ordered list
    private int listSize;			//the size of the ordered list
    private int numObjects;			//the number of objects in the ordered list
    private int curr; 				//index of current element accessed via
    								//iterator methods
	//Initializations
    public aOrderedList() {			//Constructor that sets numObjects to 0, sets listSize to the value of SIZEINCREMENTS,
    								//and instantiates the array oList to an array of size SIZEINCREMENTS
	    numObjects = 0;
	    listSize = SIZEINCREMENTS;
	    oList = new Car[SIZEINCREMENTS];
	    curr = numObjects;
    
    }
    
    //Adds elements to the array
    void add(Comparable newObject) {
    	
    	if(numObjects == listSize) {
			oList = aOrderedList.reSize(oList);
		}
    	
    	oList[numObjects] = newObject;
    	numObjects++; 
    	
    }
    
    //Formats the output
    public String toString() {
    	int i;
    	String print = "";
    	for(i = 0;i<numObjects;i++) 
    	print += String.format("\nMake: %s\nYear: %d\nPrice: %d\n", ((Car) oList[i]).getMake(),((Car) oList[i]).getYear(),((Car) oList[i]).getPrice());
    	return print;
    
    }
    
    //Provides the size of the array
    public int size(){
		return numObjects;
    	
    }
    
    //Get the specified element
    public Comparable get(int index){
		return (Car) oList[index];
    	
    }
    
    //Test to see if the array is empty
    public boolean isEmpty() {
    	return false ;
    }
    
    //Removes element from the array
    public void remove(String make,int year) {
    	for(int i = 0; i<numObjects; i++) {
    		if(((Car) oList[i]).getMake().equals(make) && ((Car) oList[i]).getYear()== year)
    	      oList[i] = oList[i-1];
    	    }
    	    numObjects = numObjects-1;
    }
    
    //Resizes the array
    public static Car[] reSize(Object[]oList) {
    	Object[] newValues = Arrays.copyOf(oList, 2 * oList.length); 
    	oList = newValues;
    	
		return (Car[]) oList;
    }
    
    //Sorts the array in by make then by year if the makes are the same
    public Car[] sort() {
    	for(int i = 0; i < numObjects; i++){												//bubble sort for sorting the array into alphabetical order
			for(int j = 1; j < numObjects-i; j++){											//	|
				if(((Car) oList[j-1]).compareTo(oList[j])>0) {								//	|
					Car temp = (Car) oList[j-1];											//	|
					oList[j-1]=oList[j];													//	|
					oList[j] = temp;														//	_
				}
				
			}
		
		}
		return (Car[]) oList;
    	
    }
    
    //Resets "curr" to the first elements in the array
    void reset() {
    	curr = 0;
    }
    
    //Gets the next element in the array
    public Comparable next() {
		return curr++;
    	
    }
    
    //Test to see if the array has another elements
    public boolean hasNext(){
    	if(curr < numObjects) {
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }
    
    //removes the last element returned by the next method
    void remove() {
    	
    }
    
}

class Node {
	public Object data;
	public Node next;
} 

class llOrderedList implements List{

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

class bstOrderedList {
	
	class Node {
		public Comparable data;
		public Node leftChild;
		public Node rightChild;
		
		public void addNode(Node newNode) {
			int comp = newNode.data.compareTo(data);
			if (comp > 0) {
				if (leftChild == null)
					leftChild = newNode;
				else
					leftChild.addNode(newNode);
			}
			else if (comp < 0) {
				if (rightChild == null)
					rightChild = newNode;
				else
					rightChild.addNode(newNode);
			}
		}
	
	} 
	
	private Node root;
	private Comparable[] array = null;	
	private int index;
	
	public bstOrderedList ()  {	//Constructor that sets sets root to null.
		root = null;
	}
	
	void add(Comparable newObject) {
		Node newNode = new Node();
		newNode.data = newObject;
		newNode.rightChild = null;
		newNode.leftChild = null;
		if (root == null)
			root = newNode;
		else
			root.addNode(newNode);
			
	}
	
	void remove(Comparable newObject) {
		
		 Node toBeRemoved = root;
	     Node parent = null;
	 
	       boolean found = false;
	       while (!found && toBeRemoved != null){
	          int d = toBeRemoved.data.compareTo(newObject);
	          if (d == 0) { found = true; }
	          else {
	             parent = toBeRemoved;
	             if (d > 0) { toBeRemoved = toBeRemoved.leftChild; }
	
	             else { toBeRemoved = toBeRemoved.rightChild; }
	          }
	 
	       }
	
	       if (!found) { return; }
	 
	       if (toBeRemoved.leftChild == null || toBeRemoved.rightChild == null){
	          Node newChild;
	 
	          if (toBeRemoved.leftChild == null) {
	             newChild = toBeRemoved.rightChild;
	          }
	          else {
	             newChild = toBeRemoved.leftChild;
	          }
	          if (parent == null){
	             root = newChild;
	          }
	          else if (parent.leftChild == toBeRemoved){
	             parent.leftChild = newChild;
	          }
	          else {
	             parent.rightChild = newChild;
	          }

	          return;
	
	       }

	       Node smallestParent = toBeRemoved;
	       Node smallest = toBeRemoved.rightChild;

	       while (smallest.leftChild != null){
	          smallestParent = smallest;
	          smallest = smallest.leftChild;
	       }

	       toBeRemoved.data = smallest.data;
	 
	       if (smallestParent == toBeRemoved){
	          smallestParent.rightChild = smallest.rightChild;
	       }
	       else{
	          smallestParent.leftChild = smallest.rightChild;
	       }
	
	}
	
	
	int size() {
		return size(root);	//Returns the number of elements in this list.
		
	}
	
	 int size(Node node) { 
	        if (node == null) 
	            return 0; 
	        else
	            return(size(node.leftChild) + 1 + size(node.rightChild)); 
	    }
	
	boolean isEmpty() {
		return root == null; //Returns true if the list is empty and false otherwise
		
	}
	
	Comparable[] toArray(String sorting) {
    																															//array to be returned
    	if(sorting.equals("inOrder")) {
    		index = 0;
    		inOrder(root);
    	}
    	if(sorting.equals("preOrder")) {
    		index = 0;
    		preOrder(root);
    	}
    	if(sorting.equals("postOrder")) {
    		index = 0;
    		postOrder(root);
    	}
    	return array;
  
   }
	
	void inOrder(Node stringNode) {
		
		if (stringNode != null) {
			preOrder(stringNode.leftChild);
	  		array[index] = stringNode.data;
	  		index++;
	  		  
	  		preOrder(stringNode.rightChild);
	  	}
	}
	
	void preOrder(Node stringNode) {
		   																														//for formatting return statement
	  	   if (stringNode != null) {
	  		   array[index] = stringNode.data;
	  		   index++;
	  		   preOrder(stringNode.leftChild);
	  		   preOrder(stringNode.rightChild);
	  	   }
	  			
	  	  
	   }
	
	 void postOrder(Node stringNode) {
		 
		 if(stringNode != null) {
			 postOrder(stringNode.leftChild);
			 postOrder(stringNode.rightChild);
			 array[index] = stringNode.data;
			 index++;
		 }
		   
	   }
	
	public String toString() {
	     Node curr = root;
	     if (isEmpty()){
	      return "";
	     }
	     return ("[" + returnString(curr) + "]");
	    }
	    
	    String returnString(Node stringNode) {
	     String returnString = ""; 
	     if (stringNode == null)
	      return returnString;
	     returnString = String.format(" %s %s %s",  returnString(stringNode.rightChild), stringNode.data.toString() , returnString(stringNode.leftChild));
	     return returnString;
	   }
	
	    
}
