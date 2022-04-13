import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Prog03_llOrderedList {

	public static void main(String[] args) {

			
		try {
				
				llOrderedList mList = new llOrderedList();
				Scanner input = getInputFile();
				readInputFile(input,mList);
				getOutputFile(mList);
				
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
	* is read in the method fills the aOrdedList array with the car objects.
	*
	* CSC 1351 Programming Project No 02 
	* Section 002
	*
	* @author Kaden Wyble
	* @since 02/25/19
	*
	*/
	public static void readInputFile(Scanner input, llOrderedList mList) throws FileNotFoundException{
			
			Scanner in = input;					//Initializes the Scanner object created in readInputfile
			
		while(in.hasNextLine()) {			//While loop that takes all the data and fills or removes data
			String m = in.nextLine();
			String[] arr = m.split(",");
			String action = arr[0];
			String Make = null;
			int Year = 0;
			int Price = 0;
				
			if(action.equals("A")){			//Adds to the aOrderedList array
				Make = arr[1];
				Year = Integer.parseInt(arr[2]);
				Price = Integer.parseInt(arr[3]);
					
				Car newCar = new Car(Make, Year, Price);
				mList.add(newCar);
					
			}
			else if(action.equals("D")){ 	//Removes data from the aOrderedList array
				String make = arr[1];
				int year = Integer.parseInt(arr[2]);
				int price = 0;
				
				Car removeCar = new Car(make, year, price);
				mList.remove(removeCar);
			}
				
		}
			
			
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
	public static PrintWriter getOutputFile(llOrderedList mList) throws FileNotFoundException{
					
		Scanner in = new Scanner(System.in);			//Scanner initialization
			
		System.out.print("Enter output filename: ");	//Prompts the user to choose the output file
		String UserPromptout = in.nextLine();
		System.out.println();
		File fileOut = new File(UserPromptout);
		PrintWriter out = new PrintWriter(fileOut);			
		
	
		System.out.println("Number of cars: " + mList.size()); 
		System.out.println(mList.toString());
			
		in.close();
		out.close();
		return null;
		
	}

}