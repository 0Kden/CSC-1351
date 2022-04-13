import java.util.Comparator;

public class bstOrderedList {
	
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
