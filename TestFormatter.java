import java.io.*;
import java.util.Scanner; // read file
import java.lang.Math; // for rounding
public class TestFormatter {

	private String test [] [] = new String [1000] [6]; // array to store test from reading file
	private int index = 0; // stores # of questions
	private String fileName; // stores the file that will be read
	private boolean result; // boolean to determine if file has been encrypted/decrypted
	private int key = 1; // key for encoding decoding ascii shift.
	private String textToWrite; // stores which file will be wrote (useful for encrypt and decrypt in teacher class)

	/**
	 * creates TestFormatter object for decryption from Teacher class and to be able to do test as a Student
	 * @precondition fileName must be sent where the txt will be read from. Also should know if want to print to file or not
	 * @postcondition Object will be created & file will be read from.
	 * @param n is the name of the file that will be read from
	 * @param shouldPrint is to determine if the test should be printed or not
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public TestFormatter (String n, boolean shouldPrint) throws FileNotFoundException, IOException {
		key = -1;
		textToWrite = "DecryptedTest.txt"; 
		fileName = n;  
		result = false;
		getFile(); // file reader

		if (shouldPrint == true)
			printToFile();
	}

	/**
	 * creates TestFormatter object for encrypting a test (from Teacher class)
	 * @precondition fileName must be sent where the txt will be read from.
	 * @postcondition Object will be created & file will be read from.
	 * @param n stores name of file that will be read from
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public TestFormatter (String n) throws FileNotFoundException, IOException {
		fileName = n;
		textToWrite = "EncryptedTest.txt";  
		result = false;
		getFile();
		printToFile();
	}

	/**
	 * Reads the text file & then sends it to get encoded/decoded based on the key.
	 * @precondition file name cannot be null
	 * @postcondition file will be read, and sent to encode decode
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void getFile () throws FileNotFoundException, IOException {
		File file = new File (fileName);
		try {
			Scanner scan = new Scanner(file);
			// while scanner still has more content
			while (scan.hasNextLine()) {
				for (int a = 0; a < 6; a++) {
					test[index][a] = scan.nextLine(); //stores each line as an element
				}
				++index;
			}

			scan.close();

			encodeDecode();

		} catch (Exception e) {
			e.printStackTrace(); // if error occurs such as null text file.
		}    
	}

	/**
	 * Encrypt or decrypts the array based on the key from constructor
	 * @precondition the file had to be able to get read
	 * @postcondition the file is encrypted/decrypted
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void encodeDecode () throws FileNotFoundException, IOException  {
		// C is the code which is +1      --->     encode it to -1
		char [] chars = null;
		String temp ="";
		//nested for loop to traverse array and then traverse its second dimension, and encode/decode it.
		for (int a = 0; a < index; a++) { 
			for (int g = 0; g < 6; g++) {
				chars = test[a][g].toCharArray();
				for (char c: chars) {
					c -= key;
					//System.out.print(c);
					temp += c; // append shifted ascii to temporary string
				}
				test[a][g] = temp; // value of each element of 2d array now shifted 
				//System.out.println(test[0][0]);
				temp =""; // reset temp
			}
		}
	}

	/**
	 * Prints the encoded/decoded array to file
	 * @precondition the boolean shouldPrint needs to be true, the file had to be able to get read.
	 * @postcondition file is printed to
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void printToFile() throws FileNotFoundException, IOException {
		BufferedWriter writer = null;
		writer = new BufferedWriter(new FileWriter(textToWrite)); // printing to file
		//nested for loop in order to print each element in first dimension and the second dimension
		for (int a = 0; a < index; a++) {
			for(int b = 0; b < 6; b++) {
				if (a == index - 1 && b == 5) {
					// if this is last element do not skip line
					writer.write(test[a][b]);
					continue;
				}
				writer.write(test[a][b]+"\n");    
			}
		}
		writer.flush(); // clearing writer 
		writer.close();  
		result = true;  // task completed success
	}

	/**
	 * Getter for the result of printing and encoding / decoding
	 * @precondition none
	 * @postcondition result is returned
	 */
	public boolean getResult() {
		return result;
	}

	/**
	 * Getter for the # of questions
	 * @precondition none
	 * @postcondition # of questions is returned
	 */
	public int getNumQuestions () {
		return index;
	}

	/**
	 * Gets the question
	 * @precondition int a is the current question (cannot be null)
	 * @postcondition the question
	 */
	public String getQuestion (int a) {
		return (test[a][0]);
	}

	/**
	 * Gets the first answer choice
	 * @precondition int a is the current question (cannot be null)
	 * @postcondition the first choice sent
	 */
	public String getChoice1 (int a) {
		return (test[a][1]);
	}

	/**
	 * Gets the second answer choice
	 * @precondition int a is the current question (cannot be null)
	 * @postcondition the second choice sent
	 */
	public String getChoice2 (int a) {
		return (test[a][2]);
	}

	/**
	 * Gets the third answer choice
	 * @precondition int a is the current question (cannot be null)
	 * @postcondition the third choice sent
	 */
	public String getChoice3 (int a) {
		return (test[a][3]);
	}

	/**
	 * Gets the fourth answer choice
	 * @precondition int a is the current question (cannot be null)
	 * @postcondition the fourth choice sent
	 */
	public String getChoice4 (int a) {
		return (test[a][4]);
	}

	/**
	 * Gets the answer
	 * @precondition int a is the current question (cannot be null)
	 * @postcondition the answer sent
	 */
	public String getAnswer (int a) {
		return (test[a][5]);
	}

	/**
	 * Gets the % of result and rounds it
	 * @precondition test must be completed by student
	 * @postcondition the % score of student is returned.
	 * @param numcorrect is the # of questions student got correct
	 * @return the results
	 */
	public int getResults(int numcorrect) {
		double p = (1.00 * numcorrect) / (1.00 * index) * 100 ;
		int score = (int)Math.round(p);
		return score;
	}


}