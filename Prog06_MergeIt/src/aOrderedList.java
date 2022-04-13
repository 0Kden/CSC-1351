import java.util.Arrays;

public class aOrderedList {

	final int SIZEINCREMENTS = 20; 	//size of increments for increasing ordered list
    private Comparable[] oList;		//the ordered list
    private Comparable[] List1;
    private Comparable[] List2;
    private int olistSize;			//the size of the ordered list
    private int list1Size;
    private int list2Size;
    private int numObjects;			//the number of objects in the ordered list
    private int list1Objects;
    private int list2Objects;
    private int curr; 				//index of current element accessed via
    								//iterator methods
	//Initializations
    public aOrderedList() {			//Constructor that sets numObjects to 0, sets listSize to the value of SIZEINCREMENTS,
    								//and instantiates the array oList to an array of size SIZEINCREMENTS
	    numObjects = 0;
	    olistSize = SIZEINCREMENTS;
	    oList = new Movie[SIZEINCREMENTS];
	    curr = numObjects;
    
    }
    
    //Adds elements to the array
    void add1(Comparable newObject) {
    	
    	if(numObjects == olistSize) {
			List1 = aOrderedList.reSize(List1);
		}
    	
    	oList[numObjects] = newObject;
    	list1Objects++; 
    	
    }
    
    void add2(Comparable newObject) {
    	
    	if(numObjects == olistSize) {
			List2 = aOrderedList.reSize(List2);
		}
    	
    	List1[numObjects] = newObject;
    	list2Objects++; 
    }
    
    void merge () {
    	if(numObjects == olistSize) {
			oList = aOrderedList.reSize(oList);
			
			
		}
    }
    	
    
    //Formats the output
    public String toString() {
    	int i;
    	String print = "";
    	for(i = 0;i<numObjects;i++) 
    	print += String.format("\nMake: %s\nYear: %d\nPrice: %d\n", ((Movie) oList[i]).getTitle(),((Movie) oList[i]).getYear(),((Movie) oList[i]).getRating());
    	return print;
    
    }
    
    //Provides the size of the array
    public int size(){
		return numObjects;
    	
    }
    
    //Get the specified element
    public Comparable get(int index){
		return (Movie) oList[index];
    	
    }
    
    //Test to see if the array is empty
    public boolean isEmpty() {
    	return false ;
    }
    
    //Removes element from the array
    public void remove(Movie remove) {
    	for(int i = 0; i<numObjects; i++) {
    		if(((Movie) oList[i]).getTitle().equals(remove.getTitle()) && ((Movie) oList[i]).getYear()== remove.getYear())
    	      oList[i] = oList[i-1];
    	    }
    	    numObjects = numObjects-1;
    }
    
    public void remove2(Movie remove) {
    	for(int i = 0; i<numObjects; i++) {
    		if(((Movie) oList[i]).getTitle().equals(remove.getTitle()) && ((Movie) oList[i]).getYear()== remove.getYear())
    	      oList[i] = oList[i-1];
    	    }
    	    numObjects = numObjects-1;
    }
    
    //Resizes the array
    public static Movie[] reSize(Object[]List) {
    	Object[] newValues = Arrays.copyOf(List, 2 * List.length); 
    	List = newValues;
    	
		return (Movie[]) List;
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
    
}

