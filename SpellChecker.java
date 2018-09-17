package Module3Assignment;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Rich Saavedra
 *
 */
public class SpellChecker {

	private static Scanner keyboard; //Use a Scanner object for all user input.

	public static void main(String[] args) {


		Scanner fileScanner = null;
		ArrayList<String> states = null;
		ArrayList<String> dictionary = null;


		System.out.print("Enter word file to be checked: ");
		keyboard = new Scanner(System.in);
		String inputFile = keyboard.nextLine();
		/*
		 * File reading code modified from https://stackoverflow.com/questions/5343689/java-reading-a-file-into-an-arraylist
		 * and http://testingpool.com/compare-two-arraylists-in-java/
		 */
		fileScanner = new Scanner(inputFile);
		//					try 
		//					{
		File statesFile = new File(inputFile);
		try
		{
			states = get_arraylist_from_file(statesFile);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		fileScanner.close();

		System.out.print("Enter the dictionary file to be used: ");
		keyboard = new Scanner(System.in);
		inputFile = keyboard.nextLine();
		fileScanner = new Scanner(inputFile);
		File dictionaryFile = new File(inputFile);
		try{
			dictionary = get_arraylist_from_file(dictionaryFile);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		fileScanner.close();
		keyboard.close();
		
		System.out.println("\nThe results of the spell check are:");
		for (int index = 0; index < states.size(); index++) 
		{
			if (!dictionary.contains(states.get(index)))
			{
				System.out.println(states.get(index).toString() + " is an unknown word.");
			}

		}
	}
	
	/*
	 * Code modified from https://stackoverflow.com/questions/5343689/java-reading-a-file-into-an-arraylist
	 */
		public static ArrayList<String> get_arraylist_from_file(File f) throws FileNotFoundException 
		{
			Scanner s;
			ArrayList<String> list = new ArrayList<String>();
			s = new Scanner(f);
			while (s.hasNext()) {
				list.add(s.next());
			}
			s.close();
			return list;
		}

}
