import java.io.*;
import java.util.*;

public class Password { 
	private String currentPassword; // stores the password to see if the other password the same
	private int key; // key is used to encode / decode the text file
	private boolean result; // used to tell the teacher class if password change successful.

	public Password () throws FileNotFoundException, IOException {
		currentPassword = "";
		key = 0; 
		decryptPass(); 
		result = false;
	}

	/** 
	 * Decrypts previous password in order to check it.
	 * @precondition The file must have an encrypted password and be in project folder. 
	 * @postcondition Password is decrypted.
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void decryptPass() throws FileNotFoundException, IOException {
		File file = new File ("EncryptedPassword.txt"); // relative location of file
		if (file.length() == 0) {
			currentPassword = "najieh786"; // if file empty (which means someone tampered with it
			encodeDecode(false); // , reverted to default password
			printToFile();
			return;     
		} 
		try {
			Scanner scan = new Scanner(file);
			currentPassword = scan.nextLine(); // reads first line of file for password.
			scan.close();
		} catch (Exception e) {
			e.printStackTrace(); }
	}

	/** 
	 * Encodes or decodes the password based on boolean.
	 * @precondition the file must be read & password cannot be null.
	 * @postcondition Password is encrypted/decrypted.
	 * @param de if it its true, the function decrypts, if false, encrypts.
	 */
	private void encodeDecode (boolean de) {
		if (de == true) {
			key = 3;
		}

		if (de == false) {
			key = -3;
		}

		char [] chars = currentPassword.toCharArray(); // char array conversion for ascii shift.
		String temp =""; // temp created to append shifted ascii chars.
		for (char c: chars) {
			c -= key;
			//System.out.print(c);
			temp += c;
		}
		currentPassword = temp; // 
		temp = "";
	}

	/** 
	 * Prints the new password to file.
	 * @precondition 
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void printToFile() throws FileNotFoundException, IOException {
		BufferedWriter writer = null;
		writer = new BufferedWriter(new FileWriter("EncryptedPassword.txt"));
		writer.write(currentPassword);
		writer.flush();
		writer.close();  
		result = true;       
	}

	/**
	 * Getter for seeing if the print out was successful
	 * @precondition constructor must have been created, password needed to be checked
	 * @postcondition return true, if successful
	 */
	public boolean result() {
		return result;
	} 

	/**
	 * Sets the password to the new Password.
	 * @precondition the 
	 * @param newPassword which is the suggested password.
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void setPass(String newPassword) throws FileNotFoundException, IOException {
		currentPassword = newPassword;
		encodeDecode(false); // encode new password
		printToFile(); 
	}

	/**
	 Getter for seeing if the print out was successful
	 * @precondition the password must have been brought from file and decoded
	 * @postcondition return password.
	 */
	public String getPass() {
		encodeDecode(true); // decode current
		return currentPassword;
	}

} 