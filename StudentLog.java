import java.io.*;
import java.util.*;

public class StudentLog {
	private String studentScores; // all previous student scores stored here and sent to teacher
	private boolean result; // see if result was captured by compiler
	private String score; // score of student which will be sent to be encrypted & printed

	/**
	 * Constructor used by teacher class, object created to get the student log with scores to print on screen
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */

	public StudentLog () throws FileNotFoundException, IOException {
		studentScores = "";
		result = false;
		score = "";
		formatStudentLog();
	}

	/**
	 * Constructor used by student class to submit scores
	 * @param a which will be saved as score of student
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public StudentLog(String a) throws FileNotFoundException, IOException {
		studentScores = "";
		score = a;
		result = false;
		addScore();
	}

	/**
	 * Student Scores read from encrypted file and decrypted & stored as String 'studentScores'
	 * @precondition File "EncryptedStudentLog.txt" must exist and be in project folder
	 * @postcondition String studentScores stores decrypted studentScores from file. 
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void formatStudentLog() throws FileNotFoundException, IOException {
		File file = new File ("EncryptedStudentLog.txt");
		// try to take in file.
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				studentScores += scan.nextLine() +"\n";
			}
			scan.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String temp = studentScores; 
		char chars [] = temp.toCharArray(); // char array to shift ascii
		String a = "";
		// for each loop to iterate array
		for (char c:chars) {
			if (String.valueOf(c).matches(".")) {
				c += 1 ;
				a +=c;
			}
			else {
				a += "\n";
			}
		} 
		studentScores = String.valueOf(a); // char [] -- > string conversion
		temp = "";
	}

	/**
	 * Gets the student log.
	 * @precondition fprmatStudentLog must be run and a studentLog must be taken in by file
	 * @postcondition return the student log
	 */
	public String getStudentLog() {
		return studentScores;
	}

	/**
	 * Appends the Student score to the file after encrypting
	 * @precondition the student score cannot be null. student must be done test
	 * @postcondition the student score is encrypted
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void addScore() throws FileNotFoundException, IOException {
		String b = score;
		char chars [] = b.toCharArray(); // encrypting the score
		b = "";
		for (char c:chars) {
			c -= 1;
			b +=c;
		}
		score = b;
		appendToFile(); // adds to file
	}

	/**
	 * Appends the encrypted student score to file
	 * @precondition the student score cannot be null. student must be done test
	 * @postcondition the student score is encrypted & printed to file
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void appendToFile() throws FileNotFoundException, IOException {
		File file = new File("EncryptedStudentLog.txt");
		FileWriter fr = new FileWriter(file, true); // true is for appending, not overwrite.
		fr.write("\n"+ score); // \n so it goes to next line, not print right beside
		fr.close();
		result = true; // if try & catch and all successful and score updated, result now true.
	}

	/**
	 * True or false value sent if the student score is encrypted and in student log file.
	 * @precondition none
	 * @postcondition result is returned true, if successful
	 */
	public boolean didResultsSend () {
		return result;
	}
} 