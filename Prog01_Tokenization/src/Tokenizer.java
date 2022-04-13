import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JFileChooser;

 public class Tokenizer {
	
	/**
	* Allows the user to select a input file and then puts all the contents in a string.
	*
	* CSC 1351 Programming Project No 1 
	* Section 002
	*
	* @author Kaden Wyble
	* @since 02/01/19
	*
	*/ 
	public static String input() throws FileNotFoundException {
			
			
			JFileChooser chooser = new JFileChooser(); 							//input file chooser
			Scanner in = null;													//	|
			if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {	//	|
				File inputFile = chooser.getSelectedFile();						//	|
				in = new Scanner(inputFile);									//	_
			}
			
			String lineinput = in.nextLine();									//sets all the content of the file to the string
			
			return lineinput;													//returns string
		}
	
	/**
	* Takes the inputed string and puts it into a string array, then sorts the 
	* array into alphabetical order.
	*
	* CSC 1351 Programming Project No 1 
	* Section 002
	*
	* @author Kaden Wyble
	* @since 02/01/19
	*
	*/ 
	public static String []Sorter(String inputline) throws FileNotFoundException {
	
		String strippedInput = inputline.toLowerCase().replaceAll("[^a-z0-9'$\\s]", "");	//strips the string of all special and upper case characters
		String[] toksin = strippedInput.split(" ");											//inputs the string into the array using the split function
		
		for(int i = 0; i < toksin.length; i++){												//bubble sort for sorting the array into alphabetical order
			for(int j = 1; j < toksin.length-i; j++){										//	|
				if(toksin[j-1].compareTo(toksin[j])>0) {									//	|
					String temp = toksin[j-1];												//	|
					toksin[j-1]=toksin[j];													//	|
					toksin[j] = temp;														//	_
				}
				
			}
		
		}
		
		return toksin;																		//returns sorted array
	}
	
	/**
	* Takes the newly sorted array, counts the duplicates and replaces them with null.
	*
	* CSC 1351 Programming Project No 1 
	* Section 002
	*
	* @author Kaden Wyble
	* @since 02/01/19
	*
	*/ 
	public static int[]WordCounter(String[]Tokens) throws FileNotFoundException {
		
		int wordc = 1;									//initializes the variable that keeps count of the amount of word occurrences.
		String[]arr = Tokens;							//initializes the array used in the computation to the inputed array.
		int wCount[] = new int [arr.length];
		
		for(int i = 0; i < arr.length; i++){
			for(int j = i+1; j < arr.length; j++){
				if(arr[i].equals(arr[j])){				//if the words being compared 
					wordc = wordc + 1;					//adds 1 to wordc
					arr[j] = "";						//sets the duplicate word to null
				}
			}
			if(arr[i]!= "") {							//if the index being tested doesn't equal null	
				wCount[i] = wordc;						//wordc equals 1
				wordc = 1;								//makes sure wordc goes back to 1
			}
		}
		
		return wCount;
	}
	
	/**
	* Searches through the array and puts the indexes into a smaller array while a null 
	* isn't presen
	*
	* CSC 1351 Programming Project No 1 
	* Section 002
	*
	* @author Kaden Wyble
	* @since 02/01/19
	*
	*/ 
	public static String[]resize(String[]Tokens,int[]wCount) throws FileNotFoundException {
		
		int dups = 0; 
	
	    for (int i = 1; i < Tokens.length; i++){
	        if (Tokens[i].equals("")){
	            dups++;
	        }
	    }
		
		String[] rArray = new String[Tokens.length - dups];

		rArray[0] = Tokens[0]; 

		int count = 1; 

		for (int i = 1; i < Tokens.length; i++){        
			if (!Tokens[i].equals("")){
				rArray[count] = Tokens[i]; 
		        count++; 
		    }
		}
		    
		return rArray;
	}

	/**
	* Mimics the "resize" are so the two arrays stay parallel.
	*
	* CSC 1351 Programming Project No 1 
	* Section 002
	*
	* @author Kaden Wyble
	* @since 02/01/19
	*
	*/ 
	public static int[] countresize(String[]Tokens,int[]wCount) throws FileNotFoundException {
		
		int dups = 0; 
	
	    for (int i = 1; i < Tokens.length; i++){
	        if (Tokens[i].equals("")){
	            dups++;
	        }
	    }
		
		String[] rArray = new String[Tokens.length - dups];
		int[]tCount = new int [wCount.length - dups];

		rArray[0] = Tokens[0]; 
		tCount[0] = wCount[0];
		

		int count = 1; 

		for (int i = 1; i < Tokens.length; i++){        
			if (!Tokens[i].equals("")){
				tCount[count] = wCount[i]; 
		        count++; 
		    }
		}
		    
		return tCount;
	}	

	/**
	* Outputs the final arrays to the selected location.
	*
	* CSC 1351 Programming Project No 1 
	* Section 002
	*
	* @author Kaden Wyble
	* @since 02/01/19
	*
	*/ 
	public static void output (String[]finalToken,int[]finalTcount) throws FileNotFoundException {
		
		//File chooser
		JFileChooser chooser = new JFileChooser();
		if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File outFile = chooser.getSelectedFile();
			PrintWriter out = new PrintWriter(outFile);
			
			//Goes through the array list and prints out each data value on separate lines
			for (int i = 0; i < finalToken.length; i++) {
				out.println(finalToken[i] +"," + finalTcount[i]);
			}
			//Closes PrintWriter out
			out.close();
		}
		
	}

	/**
	*Ask the user if they want to select a ignore file
	*
	* CSC 1351 Programming Project No 1 
	* Section 002
	*
	* @author Kaden Wyble
	* @since 02/01/19
	*
	*/ 
	public static void ignorequest(String[]finalTokens,int[]finalTconunt) throws FileNotFoundException{
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Would you like to select a ingore file? y/n ");
		String search = in.nextLine();
		
		while(true) {
			
			if(search.toLowerCase().equals("y")) {
				ignorefile(finalTokens, finalTconunt);
				break;
			}
			else if(search.toLowerCase().equals("n")){
				break;
			}
			
		}
	}
	
	/**
	* Method called but "ignorequest" to remove the contents of the ignore file from the final product
	*
	* CSC 1351 Programming Project No 1 
	* Section 002
	*
	* @author Kaden Wyble
	* @since 02/01/19
	*
	*/ 
	public static String[] ignorefile(String[]finalTokens,int[]finalTcount) throws FileNotFoundException{
		
		String desktop = System.getProperty ("user.home") + "/Desktop/";
		File myFile = new File (desktop + "ignore file.txt");
	
		Scanner in = new Scanner(myFile);
				
		String inputline = in.nextLine();
		String strippedInput = inputline.toLowerCase().replaceAll("[^a-z0-9'$\\s]", "");
		String[] ignorearr = strippedInput.split(" ");
		
		for(int i = 0; i < ignorearr.length; i++){
			for(int j = 1; j < ignorearr.length-i; j++){
				if(ignorearr[j-1].compareTo(ignorearr[j])>0) {
					String temp = ignorearr[j-1];
					ignorearr[j-1]=ignorearr[j];
					ignorearr[j] = temp;
				}	
			}
		}
		
		System.out.println();
		
		for (int j = 1; j < ignorearr.length; j++){
			String remove = ignorearr[j];
			int dups = 0; 
			
		    for (int i = 1; i < finalTokens.length; i++){
		        if (finalTokens[i].equals(ignorearr[j])){
		            dups++;
		        }
		    }
			
			String[] rArray = new String[finalTokens.length - dups];
	
			rArray[0] = finalTokens[0]; 
	
			int count = 1; 
	
			for (int i = 1; i < finalTokens.length; i++){        
				if (!finalTokens[i].equals(ignorearr[j])){
					rArray[count] = finalTokens[i]; 
			        count++; 
			    }
			
			}   
			
			for(int i = 0; i < rArray.length; i++){
				System.out.println(rArray[i]);
			}
			
		}
		
		return ignorearr;
	}
}
