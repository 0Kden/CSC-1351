import java.io.FileNotFoundException;

/**
* This program will read text files and tokenize the contents of that file,
* ask the user if there are any words they would like to remove from the output
* and then put the contents of the file into arrays.
*
* CSC 1351 Programming Project No 01
* Section 002
*
* @author Kaden Wyble
* @since 02/01/19
*
*/
public class Prog01_Tokenization {

	public static void main(String[] args) throws FileNotFoundException {
		
		try {
			String inputline = Tokenizer.input();		 					//calls the input method
			String[]Tokens = Tokenizer.Sorter(inputline); 					//calls the sorter method 
			int[]TokenCount = Tokenizer.WordCounter(Tokens); 				//calls the word counting method 
			String[]finalTokens = Tokenizer.resize(Tokens,TokenCount);		//calls the resizing method 
			int[]finalTcount = Tokenizer.countresize(Tokens,TokenCount);	//calls the resizing method that mimics "resize" to keep the int array 
			Tokenizer.output(finalTokens,finalTcount);						//calls the method for output and printing to the file
		}
		catch(FileNotFoundException e){
			System.out.println();
			System.out.println("File not Fount");
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println();
			System.out.println("Array Error");
		}
		
	}
	
}
