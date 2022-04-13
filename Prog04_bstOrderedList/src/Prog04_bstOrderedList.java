import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Prog04_bstOrderedList {

	public static void main(String[] args) {
		
		
		try {
				
				bstOrderedList list = new bstOrderedList();
				Scanner input = getInputFile();
				readInputFile(input,list);
				getOutputFile(list);
				
		}
		catch(FileNotFoundException e) {
				
		}
	}
		
	/**
	* This method lets the user choose the file they would like to pull the
	* data from.
	*
	* CSC 1351 Programming Project No 02 
	* Section 002
	*
	* @author Kaden Wyble
	* @since 02/25/19
	*
	*/
	public static Scanner getInputFile() throws FileNotFoundException{

		Scanner in = new Scanner(System.in); 				//Scanner for user input
			
		System.out.print("Enter input filename: ");			//Prompts the user to enter a filename to get input
		String UserPrompt = in.nextLine();
		System.out.println();
		File file = new File(UserPrompt);
			
		while(!file.isFile()){								//While loop that prompts the user to reenter a file name
			System.out.print("File specified <" + UserPrompt + "> does not exist. Would you like to continue? <Y/N> ");
			String cont = in.nextLine();
			if(cont.toLowerCase().equals("y")) {            //runs if the user would like to continue
				System.out.print("Enter input filename: ");
			File tempfile = new File(in.nextLine());
				file = tempfile;
				break;
			}
			else if(cont.toLowerCase().equals("n")){		//runs if the users wouldn't like to continue
				break;
			}
	}
			
			
		Scanner sFile = new Scanner(file);					//Updates the file to a Scanner object to be passed on
			
			
		return sFile;
	}
		
	/**
	* This method reads the scanner object that the method getInputfile created, after all the data 
	* is read in the method fills the aOrdedList array with the Movie objects.
	*
	* CSC 1351 Programming Project No 02 
	* Section 002
	*
	* @author Kaden Wyble
	* @since 02/25/19
	*
	*/
	public static void readInputFile(Scanner input, bstOrderedList list) throws FileNotFoundException{
			
			Scanner in = input;				//Initializes the Scanner object created in readInputfile
			
		while(in.hasNextLine()) {			//While loop that takes all the data and fills or removes data
			String m = in.nextLine();
			String[] arr = m.split(",");
			String action = arr[0];
			String Title = null;
			int Year = 0;
			String Rating = null;
			int Review = 0;
				
			if(action.equals("A")){			//Adds to the aOrderedList array
				Title = arr[1];
				Year = Integer.parseInt(arr[2]);
				Rating = arr[3];
				Review = Integer.parseInt(arr[4]);
				
				Movie newMovie = new Movie(Title,Year, Rating, Review);
				list.add(newMovie);
					
			}
			else if(action.equals("D")){ 	//Removes data from the aOrderedList array
				String title = arr[1];
				int year = Integer.parseInt(arr[2]);
				String rating = null;
				int review = 0;
				
				Movie removeMovie = new Movie(title, year, rating, review);
				list.remove(removeMovie);
			}
				
		}
			
			
	}
	
	public static String sorting() {
		String sort = null;
		Scanner in = new Scanner(System.in);
		System.out.print("Please select a print method: <preOrder/inOrder/postOrder> ");
		sort = in.nextLine();
		
		if(sort.equals("inOrder")) {
			System.out.println("Please select compact or pretty print style: ");
			sort = in.nextLine();
			if(sort.equals("compact")) {
				return sort;
			}
			else if(sort.equals("pretty")) {
				return sort;
			}
		
		}
		return sort;
	}
		
	/**
	* This method writes the final product of aOrderdedList after all of the manipulation from 
	* other methods
	*
	* CSC 1351 Programming Project No 02 
	* Section 002
	*
	* @author Kaden Wyble
	* 	
	* @since 02/25/19
	*
	*/
	public static PrintWriter getOutputFile(bstOrderedList list) throws FileNotFoundException{
					
		Scanner in = new Scanner(System.in);			//Scanner initialization
			
		System.out.print("Enter output filename: ");	//Prompts the user to choose the output file
		String UserPromptout = in.nextLine();
		System.out.println();
		File fileOut = new File(UserPromptout);
		PrintWriter out = new PrintWriter(fileOut);			
		
	
		out.println("Number of Movies: " + list.size()); 
		out.println(list.toString());
			
		in.close();
		out.close();
		return null;
		
	}

}


