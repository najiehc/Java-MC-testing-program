import java.awt.event.*; // needed for buttons
import java.awt.*; // needed for buttons
import javax.swing.*; // needed for JComponents
import java.io.*; // needed for exceptions for file take in

public class Teacher implements ActionListener{

	private JFrame frame = new JFrame(); // frame
	private JTextField title = new JTextField(); // top bar
	private JTextArea warningMessage = new JTextArea(); // dynamic message to inform user (for ex. if pass change successful)
	private JTextArea studentLogInfo = new JTextArea(); // where student log stored
	private JButton optionA = new JButton(); // option button for changing pass
	private JButton optionB = new JButton(); // option button for encrypting test
	private JButton optionC = new JButton(); // option button for decrypting test
	private JButton optionD = new JButton(); // option button for viewing student log
	private JLabel oldPasswordLabel = new JLabel(); // this was where it says enter old Password 
	private JLabel newPasswordLabel = new JLabel(); // this was where it says enter new Password 
	private JTextField oldPasswordEntry = new JTextField(); // text boxes for user entry
	private JTextField newPasswordEntry = new JTextField();

	private JButton changePassword = new JButton(); // button to change pass
	private JButton selectFileEncrypt = new JButton(); // button for choosing file to encrypt
	private JButton selectFileDecrypt = new JButton(); // button for choosing file to decrypt

	private JButton goBack = new JButton();
	private JButton goBackMain = new JButton(); // goes back to MainPage
	private JButton quit = new JButton(); // leaves program
	private JLabel optionLabelA = new JLabel(); // text for what button A does
	private JLabel optionLabelB = new JLabel(); // -------------------- B ---- 
	private JLabel optionLabelC = new JLabel(); // -------------------- C ---- 
	private JLabel optionLabelD = new JLabel(); // -------------------- D ---- 
	private JLabel genericLabel = new JLabel(); // asks which file should be encrypted/decrypted
	private Password p; // used to check old password and for changing new password so it is updated
	private StudentLog studentLog; // used to get student log info to add to text area.

	/**
	 * Instantiates a new Teacher and creates JFrame. Sets up JComponents
	 * @precondition on login page the Teacher must have had the correct username and password
	 * @postcondition JFrame created and function displays options
	 */
	public Teacher() {
		frame.setTitle("JAVA MC TESTING PROGRAM TEACHER PAGE");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,800); 
		frame.getContentPane().setBackground(new Color(255,254,251)); 
		frame.setLayout(null);
		frame.setResizable(false);

		title.setBounds(0,0,1000,100); 
		title.setBackground(new Color(50,0,0));
		title.setForeground(new Color(250,250,250));
		title.setFont(new Font("Arial",Font.BOLD,65));
		title.setText("Teacher Options");
		title.setBorder(BorderFactory.createBevelBorder(1));
		title.setHorizontalAlignment(JTextField.CENTER);
		title.setEditable(false);

		warningMessage.setBounds(25,625,600,25); 
		warningMessage.setBackground(new Color(211,211,211)); 
		warningMessage.setForeground(new Color(24,41,88));  
		warningMessage.setLineWrap(true);
		warningMessage.setOpaque(true); 
		warningMessage.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
		warningMessage.setEditable(false);

		studentLogInfo.setBounds(25,125,950,550); 
		studentLogInfo.setBackground(new Color(211,211,211)); 
		studentLogInfo.setForeground(new Color(24,41,88));  
		studentLogInfo.setLineWrap(true);
		studentLogInfo.setEditable(false);
		studentLogInfo.setOpaque(true); 
		studentLogInfo.setFont(new Font("Trebuchet MS",Font.PLAIN,35));

		optionA.setBounds(25,125,140,140); 
		optionA.setFont(new Font("Trebuchet MS",Font.BOLD,35));
		optionA.setOpaque(true);
		optionA.setForeground(new Color(250,250,250));
		optionA.setBackground(new Color(24,41,88));
		optionA.setBorder(BorderFactory.createBevelBorder(1)); 
		optionA.setFocusable(false);
		optionA.addActionListener(this);
		optionA.setText("A");

		optionB.setBounds(25,275,140,140);
		optionB.setFont(new Font("Trebuchet MS",Font.BOLD,35));
		optionB.setOpaque(true);
		optionB.setForeground(new Color(250,250,250));
		optionB.setBackground(new Color(24,41,88));
		optionB.setBorder(BorderFactory.createBevelBorder(1)); 
		optionB.setFocusable(false);
		optionB.addActionListener(this);
		optionB.setText("B");

		optionC.setBounds(25,425,140,140); 
		optionC.setFont(new Font("Trebuchet MS",Font.BOLD,35));
		optionC.setOpaque(true);
		optionC.setForeground(new Color(250,250,250));
		optionC.setBackground(new Color(24,41,88));
		optionC.setBorder(BorderFactory.createBevelBorder(1)); 
		optionC.setFocusable(false);
		optionC.addActionListener(this);
		optionC.setText("C");

		optionD.setBounds(25,575,140,140);
		optionD.setFont(new Font("Trebuchet MS",Font.BOLD,35));
		optionD.setOpaque(true);
		optionD.setForeground(new Color(250,250,250));
		optionD.setBackground(new Color(24,41,88));
		optionD.setBorder(BorderFactory.createBevelBorder(1)); 
		optionD.setFocusable(false);
		optionD.addActionListener(this);
		optionD.setText("D");

		genericLabel.setBounds(25,300,600,100); 
		genericLabel.setBackground(new Color(24,41,88)); 
		genericLabel.setForeground(new Color(24,41,88)); 
		genericLabel.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
		genericLabel.setText("Old Password:");

		oldPasswordLabel.setBounds(25,300,500,100); 
		oldPasswordLabel.setBackground(new Color(24,41,88)); 
		oldPasswordLabel.setForeground(new Color(24,41,88)); 
		oldPasswordLabel.setFont(new Font("Trebuchet MS",Font.PLAIN,45));
		oldPasswordLabel.setText("Old Password:");

		newPasswordLabel.setBounds(25,400,500,100); 
		newPasswordLabel.setBackground(new Color(24,41,88)); 
		newPasswordLabel.setForeground(new Color(24,41,88));  
		newPasswordLabel.setFont(new Font("Trebuchet MS",Font.PLAIN,45));
		newPasswordLabel.setText("New Password:");

		oldPasswordEntry.setBounds(520,300,400,100);
		oldPasswordEntry.setBackground(new Color(211,211,211));
		oldPasswordEntry.setForeground(new Color(24,41,88));
		oldPasswordEntry.setFont(new Font("Trebuchet MS",Font.PLAIN,45));

		newPasswordEntry.setBounds(520,400,400,100);
		newPasswordEntry.setBackground(new Color(211,211,211));
		newPasswordEntry.setForeground(new Color(24,41,88));
		newPasswordEntry.setFont(new Font("Trebuchet MS",Font.PLAIN,45));

		quit.setBounds(900,700,75,50); 
		quit.setFont(new Font("Trebuchet MS",Font.BOLD,20));
		quit.setOpaque(true);
		quit.setBorder(BorderFactory.createBevelBorder(1)); 
		quit.setBackground(new Color(50,0,0)); 
		quit.setForeground(new Color(250,250,250)); 
		quit.setFocusable(false); 
		quit.addActionListener(this); 
		quit.setText("Quit");

		changePassword.setBounds(740,500,175,30); 
		changePassword.setFont(new Font("Trebuchet MS",Font.BOLD,20));
		changePassword.setOpaque(true);
		changePassword.setForeground(Color.WHITE);
		changePassword.setBackground(new Color(0,20,13));
		changePassword.setOpaque(true);
		changePassword.setBorder(BorderFactory.createLineBorder(Color.BLUE)); 
		changePassword.setFocusable(false);
		changePassword.addActionListener(this);
		changePassword.setText("Change Password");

		selectFileEncrypt.setBounds(740,330,175,50); 
		selectFileEncrypt.setFont(new Font("Arial",Font.BOLD,20));
		selectFileEncrypt.setOpaque(true);
		selectFileEncrypt.setForeground(Color.WHITE);
		selectFileEncrypt.setBackground(new Color(0,20,13));
		selectFileEncrypt.setOpaque(true);
		selectFileEncrypt.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		selectFileEncrypt.setFocusable(false);
		selectFileEncrypt.addActionListener(this);
		selectFileEncrypt.setText("Select a File");

		selectFileDecrypt.setBounds(740,330,175,50); 
		selectFileDecrypt.setFont(new Font("Arial",Font.BOLD,20));
		selectFileDecrypt.setOpaque(true);
		selectFileDecrypt.setForeground(Color.WHITE);
		selectFileDecrypt.setBackground(new Color(0,20,13));
		selectFileDecrypt.setOpaque(true);
		selectFileDecrypt.setBorder(BorderFactory.createLineBorder(Color.BLUE)); 
		selectFileDecrypt.setFocusable(false);
		selectFileDecrypt.addActionListener(this);
		selectFileDecrypt.setText("Select a File");

		goBack.setBounds(775,700,100,50); 
		goBack.setFont(new Font("Trebuchet MS",Font.BOLD,20));
		goBack.setOpaque(true); 
		goBack.setBorder(BorderFactory.createBevelBorder(1)); 
		goBack.setBackground(new Color(50,0,0)); 
		goBack.setForeground(new Color(250,250,250)); 
		goBack.setFocusable(false); 
		goBack.addActionListener(this); 
		goBack.setText("Go Back");

		goBackMain.setBounds(775,700,100,50);
		goBackMain.setFont(new Font("Trebuchet MS",Font.BOLD,20));
		goBackMain.setOpaque(true); 
		goBackMain.setBorder(BorderFactory.createBevelBorder(1));
		goBackMain.setBackground(new Color(50,0,0));
		goBackMain.setForeground(new Color(250,250,250)); 
		goBackMain.setFocusable(false); 
		goBackMain.addActionListener(this); 
		goBackMain.setText("Go Back");

		optionLabelA.setBounds(185,125,750,150); 
		optionLabelA.setBackground(new Color(24,41,88)); 
		optionLabelA.setForeground(new Color(24,41,88));
		optionLabelA.setFont(new Font("Trebuchet MS",Font.PLAIN,50));
		optionLabelA.setText("Change Password");

		optionLabelB.setBounds(185,275,750,150);
		optionLabelB.setBackground(new Color(24,41,88));
		optionLabelB.setForeground(new Color(24,41,88));
		optionLabelB.setFont(new Font("Trebuchet MS",Font.PLAIN,50));
		optionLabelB.setText("Encrypt Test");

		optionLabelC.setBounds(185,425,750,150);
		optionLabelC.setBackground(new Color(24,41,88));
		optionLabelC.setForeground(new Color(24,41,88));
		optionLabelC.setFont(new Font("Trebuchet MS",Font.PLAIN,50));
		optionLabelC.setText("Decrypt Test");

		optionLabelD.setBounds(185,575,750,150);
		optionLabelD.setBackground(new Color(24,41,88));
		optionLabelD.setForeground(new Color(24,41,88));
		optionLabelD.setFont(new Font("Trebuchet MS",Font.PLAIN,50));
		optionLabelD.setText("View Student Log");

		teacherOptions();
	}

	/**
	 * Displays a list of options on JFrame that the teacher has that they can execute
	 * @precondition none
	 * @postcondition the teacher can select what option they want to do and buttons can lead them there
	 */
	private void teacherOptions () {
		frame.getContentPane().removeAll();
		frame.revalidate();
		frame.repaint(); 
		frame.add(optionA); // change pin
		frame.add(optionB); // encrypt
		frame.add(optionC); //decrypt
		frame.add(optionD); //student log
		frame.add(title);
		frame.add(quit);
		frame.add(goBackMain); // sends to MainPage class
		frame.add(optionLabelA);
		frame.add(optionLabelB);
		frame.add(optionLabelC);
		frame.add(optionLabelD);
		frame.setVisible(true);
	}

	/**
	 * Creates password object in order to check & update password
	 * @precondition the change password button must be clicked.
	 * @postcondition the current password can be compared with entered password and if it is the same, new password can be taken as current password
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void createPassword() throws FileNotFoundException, IOException {
		p = new Password();
	}

	/**
	 * Opens the password changing page. It reorganizes the JFrame to display how to change password
	 * @precondition the change password button must be clicked.
	 * @postcondition the password is changed if the password is correct, and if not an incorrect message is displayed
	 */
	private void changePass() {
		frame.getContentPane().removeAll(); // this takes all out from frame      
		frame.revalidate();
		frame.repaint();

		title.setText("Change Password Settings");
		frame.add(title);
		frame.add(quit);
		frame.add(goBack);
		frame.add(oldPasswordEntry);
		frame.add(newPasswordEntry);
		frame.add(oldPasswordLabel);
		frame.add(newPasswordLabel);
		frame.add(changePassword);
	}

	/**
	 * Opens the encrypting test page. It reorganizes the JFrame to display how to encrypt test
	 * @precondition the encrypt test option must be selected
	 * @postcondition The user is able to select a file through a Jfilechooser and then encrypt it
	 */
	private void encryptTest() {
		frame.getContentPane().removeAll(); // this takes all out from frame      
		frame.revalidate();
		frame.repaint();

		title.setText("Encrypt Test");
		genericLabel.setText("Select the .txt File you would like to encrypt");

		frame.add(title);
		frame.add(quit);
		frame.add(goBack);
		frame.add(genericLabel);
		frame.add(selectFileEncrypt);
		frame.setVisible(true);
	}

	/**
	 * Opens the decrypting test page. It reorganizes the JFrame to display how to decrypt test
	 * @precondition the decrypt test option must be selected
	 * @postcondition The user is able to select a file through a Jfilechooser and then decrypt it
	 */
	private void decryptTest() {
		frame.getContentPane().removeAll(); // this takes all out from frame      
		frame.revalidate();
		frame.repaint();

		title.setText("Decrypt Test");
		genericLabel.setText("Select the .txt File you would like to decrypt");

		frame.add(title);
		frame.add(quit);
		frame.add(goBack);
		frame.add(genericLabel);
		frame.add(selectFileDecrypt);
		frame.setVisible(true);
	}

	/**
	 * Opens the view student log page. It reorganizes the JFrame to display the student score
	 * @precondition the view student log button must be clicked, the encryptedstudent log file cannot be null
	 * @postcondition The user is able to select a file through a Jfilechooser and then decrypt it
	 */
	private void viewStudentLog() {
		try {

			studentLog = new StudentLog(); // for getting student results

		} catch (Exception abc) {
			abc.printStackTrace();
		}
		frame.getContentPane().removeAll(); // this takes all out from frame      
		frame.revalidate();
		frame.repaint();

		frame.add(title);
		frame.add(quit);
		frame.add(goBack);

		String getStudentResults = studentLog.getStudentLog();
		studentLogInfo.setText("Here are the student scores below:\n"+ getStudentResults); // adds student scores to text area
		JScrollPane scroll = new JScrollPane(studentLogInfo); // scroll bar added to the text area
		scroll.setBounds(25,125,950,550); // 
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // scroll bar always showing
		frame.add(scroll);
		studentLogInfo.setCaretPosition(0); // the text area is started to show from the top
		scroll.getViewport().setViewPosition( new Point(0, 0) ); // the scroll starts at the top
		frame.setVisible(true);
	}

	/**
	 * Tries to change the password to the new password designated by teacher
	 * @precondition the Teacher must enter both the old password and new password. new password cannot be null or empty.
	 * @postcondition the password is changed if password is correct and the new password is not empty, and if not password incorrect shown and password encrypted and printed to file
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void tryPasswordChange () throws FileNotFoundException, IOException {
		try {
			createPassword(); // make password object to compare to user entered password
		} catch (Exception abc) {
			abc.printStackTrace(); }
		if(oldPasswordEntry.getText().equals(p.getPass()) && !newPasswordEntry.getText().equals("")) {
			// if old password = entered password AND the new password is not empty
			p.setPass(newPasswordEntry.getText());  // new password entry set as current pass and encrypted
			boolean b = p.result(); // this will see if the password change successful
			if(b == true) {
				warningMessage.setText("Password change successful!");
				frame.add(warningMessage);
				frame.revalidate();
				frame.repaint();
				return;
			}
			if (b == false) {
				warningMessage.setText("An error has occured");
				frame.add(warningMessage);
				frame.revalidate();
				frame.repaint();
			}
		}
		else {
			warningMessage.setText("Password Incorrect");
			frame.add(warningMessage);
			frame.revalidate();
			frame.repaint();
		}
		// if password entry is empty
		if (newPasswordEntry.getText().equals("")) {
			warningMessage.setText("Blank Password is not allowed");
			frame.add(warningMessage);
			frame.revalidate();
			frame.repaint();
		}
	}   

	/**
	 * Tries to encrypt the test by taking the user selected file and shifting its ascii and printing into new file (EncryptedTest.txt)
	 * @precondition the user must choose a file which is txt and follows the rules of how the test should be formatted
	 * @postcondition the test is encrypted in the project folder under the name EncryptedTest.txt or file is denied if not formatted correctly or if it is not .txt
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void tryTestEncrypt() throws FileNotFoundException, IOException {
		JFileChooser fileChooser = new JFileChooser(); // helps pick the file with menu
		fileChooser.setCurrentDirectory(new File(".")); // file directory starts from project folder
		int pick = fileChooser.showOpenDialog(null); // select file if they do it should be 0, and will be approved
		File file = null;
		// if a file is chosen
		if (pick == JFileChooser.APPROVE_OPTION) {
			file = new File(fileChooser.getSelectedFile().getAbsolutePath()); // getting absolute path just incase file from outside folder
		} 
		// if cancel button clicked
		if (pick == JFileChooser.CANCEL_OPTION) {
			encryptTest();
			return; // do not do rest, go back to encrypt test page
		}
		String fileName = file.toString(); // got string to send to TestFormatter
		// if the string is not txt it returns back to encrypt test page
		if (! fileName.contains(".txt")) {
			return;
		}

		TestFormatter ed = new TestFormatter(fileName); // testformatter object for encrypting
		boolean a = ed.getResult(); // sees if file encrypted

		if (a == true) {
			warningMessage.setText("Your file has been encrypted and it is in the test folder");
			frame.add(warningMessage);
			frame.revalidate();
			frame.repaint();  
		}

		else {
			warningMessage.setText("Your file could not be encrypted");
			frame.add(warningMessage);
			frame.revalidate();
			frame.repaint();  
		}
	}

	/**
	 * Tries to decrypt the test by taking the user selected file and shifting its ascii and printing into new file (DecryptedTest.txt)
	 * @precondition the user must choose a file which is txt and follows the rules of how the test should be formatted
	 * @postcondition the test is decrypted in the project folder under the name DecryptedTest.txt or file is denied if not formatted correctly or if it is not .txt
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void tryTestDecrypt () throws FileNotFoundException, IOException {
		JFileChooser fileChooser = new JFileChooser(); // helps pick the file with menu    
		fileChooser.setCurrentDirectory(new File(".")); // file directory starts from project folder
		int pick = fileChooser.showOpenDialog(null); // select file if they do it should be 0, and will be approved
		File file = null;
		// if a file is chosen
		if (pick == JFileChooser.APPROVE_OPTION) {
			file = new File(fileChooser.getSelectedFile().getAbsolutePath()); // getting absolute path just incase file from outside folder
		} 
		// if cancel button clicked
		if (pick == JFileChooser.CANCEL_OPTION) {
			decryptTest();
			return;
		}
		String fileName = file.toString(); // got string to send to TestFormatter
		if (! fileName.contains(".txt")) {
			return;
		}
		TestFormatter ed = new TestFormatter(fileName,true); // testformatter object created to decrypt + print test
		boolean a = ed.getResult(); // sees if test was able to be decrypted

		if (a == true) {
			warningMessage.setText("Your file has been decrypted and it is in the test folder");
			frame.add(warningMessage);
			frame.revalidate();
			frame.repaint();  
		}

		else {
			warningMessage.setText("No File was decrypted");
			frame.add(warningMessage);
			frame.revalidate();
			frame.repaint();  
		}
	}

	/**
	 * Goes back to MainPage and closes current page
	 * @precondition the user must click the go back button in the main page
	 * @postcondition the frame is deleted and the MainPage object is created
	 */
	private void goBackToMain() {
		frame.dispose(); // delete frame
		MainPage mp = new MainPage();
	}

	/**
	 * If button is pressed, then the task is started based on the button
	 * @precondition a button must be clicked and have an actionlistener programmed to execute a task
	 * @postcondition the button executes its task.
	 * @param e is the 'action' that happens, in this case button pressed.
	 */
	public void actionPerformed(ActionEvent e) {
		// if change pass option clicked
		if(e.getSource()==optionA) {
			changePass();
		}
		// if encrypt test button clicked
		if(e.getSource()==optionB) {
			encryptTest();
		}
		// if decrypt test button clicked
		if(e.getSource()==optionC) {
			decryptTest();
		}
		// if view student log button clicked
		if(e.getSource()==optionD) {
			viewStudentLog();
		}
		// if quit button clicked
		if(e.getSource()==quit) {
			System.exit(0); // leaves program
		}
		// if the go back button goes back to main teacher options
		if(e.getSource()==goBack) {
			title.setText("Teacher Options");
			warningMessage.setBounds(25,625,600,25);
			teacherOptions();
		}
		// back to main button clicked
		if(e.getSource()==goBackMain) {
			goBackToMain();
		}
		// this button is the one that confirms password change
		if(e.getSource()==changePassword) {
			try {
				tryPasswordChange();
			} catch (Exception abc) {
				abc.printStackTrace();
			}
		}
		// if the choosing which file to encrypt button is clicked
		if(e.getSource() == selectFileEncrypt) {
			try {
				tryTestEncrypt();  
			}
			catch (Exception abc) {
				abc.printStackTrace();
			}       
		}
		// if the choosing which file to decrypt button is clicked
		if(e.getSource() == selectFileDecrypt) {
			try {
				tryTestDecrypt();
			} catch (Exception abc) {
				abc.printStackTrace();

			}
		}
	}
}
