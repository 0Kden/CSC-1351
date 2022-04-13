import java.util.Arrays;

public class aOrderedList {

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

