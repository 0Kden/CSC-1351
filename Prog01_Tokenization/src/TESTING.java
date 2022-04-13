import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class TESTING {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		try {
			JFileChooser chooser = new JFileChooser();
			Scanner in = null;
			if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File inputFile = chooser.getSelectedFile();
				in = new Scanner(inputFile);
			}
					
			String inputline = in.nextLine();
					
			String[]Tokens = Sorter(inputline);
			int[]TokenCount = WordCounter(Tokens);
			
			String[]finalTokens = resize(Tokens,TokenCount);
			int[]finalTcount = countresize(Tokens,TokenCount);
			
			ignorequest(finalTokens, finalTcount);
			
			//for(int i = 0; i < finalTokens.length; i++){
			//	System.out.println(finalTokens[i] + "," + finalTcount[i]);
			//}
		}
		catch(FileNotFoundException e){
			System.out.println();
			System.out.println("File not Found");
		}
	
	}
	
	public static String[]Sorter(String inputline) throws FileNotFoundException {
		
		String strippedInput = inputline.toLowerCase().replaceAll("[^a-z0-9'$\\s]", "");
		 			
		String[] toksin = strippedInput.split(" ");
		
		for(int i = 0; i < toksin.length; i++){
			for(int j = 1; j < toksin.length-i; j++){
				if(toksin[j-1].compareTo(toksin[j])>0) {
					String temp = toksin[j-1];
					toksin[j-1]=toksin[j];
					toksin[j] = temp;
				}
				
			}
		
		}
		
		return toksin;
		
	}
	
	public static int[]WordCounter(String[]Tokens) throws FileNotFoundException {
		
		int wordc = 1;
		int rAmt = 0;
		String[]arr = Tokens;
		
		int wCount[] = new int [arr.length];
		
		for(int i = 0; i < arr.length; i++){
			for(int j = i+1; j < arr.length; j++){
				if(arr[i].equals(arr[j])){
					wordc = wordc + 1;
					arr[j] = "";
					rAmt++;
				}
				
			}
			if(arr[i]!= "") {	
				wCount[i] = wordc;
				wordc = 1;
			}
			
		}
		
		return wCount;
		
	}
		
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

	public static int[]countresize(String[]Tokens,int[]wCount) throws FileNotFoundException {
		
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
	
	public static String[]ignore(String[]Tokens,int[]wCount) throws FileNotFoundException {
		
		JFileChooser chooser = new JFileChooser();
		Scanner in = null;
		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File inputFile = chooser.getSelectedFile();
			in = new Scanner(inputFile);
		}
		String input = in.nextLine();
	
		return Tokens;	
	}
	
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
}