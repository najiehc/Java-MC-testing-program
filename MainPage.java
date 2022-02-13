import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class MainPage implements ActionListener{
	private String name; // stores either teacher or student name
	private String pass; // teacher password

	private JFrame frame = new JFrame(); // frame
	private JTextField title = new JTextField(); // top bar
	private JTextField subtitle = new JTextField(); // below top bar
	private JButton optionStudent = new JButton(); // mainPage button to select S/T
	private JButton optionTeacher = new JButton();// mainPage button to select S/T
	private JButton startTest = new JButton(); // sign in button which needs to say start test
	private JButton teacherLogin = new JButton(); // sign in button which says login and re-directs to Teacher if password correct
	private JLabel usernameLabel = new JLabel(); // this was where it says enter usernameLabel 
	private JLabel passwordLabel = new JLabel(); // this is where it says enter password
	private JTextField usernameEntry = new JTextField(); 
	private JTextField passwordEntry = new JTextField(); //TextField for inputting name/pass
	private JTextArea warningMessage = new JTextArea(); // indicates dynamic message to user
	private JButton goBack = new JButton(); 
	private JButton quit = new JButton(); // leave program
	private Password p; // used to check password

	/**
	 * Instantiates a new main page and sets values for all JComponents
	 * @precondition none
	 * @postcondition the frame and its components will be created
	 */
	public MainPage() {
		frame.setTitle("JAVA MC TESTING PROGRAM MAIN PAGE");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,800); // L * W
		frame.getContentPane().setBackground(new Color(255,254,251)); // light cream color
		frame.setLayout(null);
		frame.setResizable(false);

		title.setBounds(0,0,1000,100);
		title.setBackground(new Color(50,0,0));
		title.setForeground(new Color(250,250,250));
		title.setFont(new Font("Arial",Font.BOLD,65));
		title.setText("Java MC Testing Program");
		title.setBorder(BorderFactory.createBevelBorder(1));
		title.setHorizontalAlignment(JTextField.CENTER);
		title.setEditable(false);

		subtitle.setBounds(0,100,1000,100); 
		subtitle.setBackground(new Color(50,0,0));
		subtitle.setForeground(new Color(250,250,250));
		subtitle.setFont(new Font("Arial",Font.PLAIN,35));
		subtitle.setText("Please select Teacher/Student by clicking the button");
		subtitle.setBorder(BorderFactory.createBevelBorder(1));
		subtitle.setHorizontalAlignment(JTextField.CENTER);
		subtitle.setEditable(false);

		optionStudent.setBounds(12,225,475,450); 
		optionStudent.setFont(new Font("Trebuchet MS",Font.BOLD,35));
		optionStudent.setOpaque(true);
		optionStudent.setForeground(new Color(250,250,250));
		optionStudent.setBackground(new Color(24,41,88));
		optionStudent.setBorder(BorderFactory.createBevelBorder(1));
		optionStudent.setFocusable(false);
		optionStudent.addActionListener(this);
		optionStudent.setText("Student");

		optionTeacher.setBounds(512,225,475,450);
		optionTeacher.setFont(new Font("Trebuchet MS",Font.BOLD,35));
		optionTeacher.setOpaque(true);
		optionTeacher.setForeground(new Color(250,250,250));
		optionTeacher.setBackground(new Color(24,41,88));
		optionTeacher.setBorder(BorderFactory.createBevelBorder(1)); 
		optionTeacher.setFocusable(false);
		optionTeacher.addActionListener(this);
		optionTeacher.setText("Teacher");

		startTest.setBounds(775,400,140,30); 
		startTest.setFont(new Font("Trebuchet MS",Font.BOLD,20));
		startTest.setOpaque(true);
		startTest.setForeground(Color.WHITE);
		startTest.setBackground(new Color(0,20,13));
		startTest.setOpaque(true);
		startTest.setBorder(BorderFactory.createLineBorder(Color.BLUE)); 
		startTest.setFocusable(false);
		startTest.addActionListener(this);
		startTest.setText("Start Test");

		teacherLogin.setBounds(775,500,140,30); 
		teacherLogin.setFont(new Font("Trebuchet MS",Font.BOLD,20));
		teacherLogin.setOpaque(true);
		teacherLogin.setForeground(Color.WHITE);
		teacherLogin.setBackground(new Color(0,20,13));
		teacherLogin.setOpaque(true);
		teacherLogin.setBorder(BorderFactory.createLineBorder(Color.BLUE)); 
		teacherLogin.setFocusable(false);
		teacherLogin.addActionListener(this);
		teacherLogin.setText("Login");

		quit.setBounds(900,700,75,50); 
		quit.setFont(new Font("Trebuchet MS",Font.BOLD,20));
		quit.setOpaque(true); 
		quit.setBorder(BorderFactory.createBevelBorder(1)); 
		quit.setBackground(new Color(50,0,0)); 
		quit.setForeground(new Color(250,250,250)); 
		quit.setFocusable(false);
		quit.addActionListener(this); 
		quit.setText("Quit");

		goBack.setBounds(775,700,100,50); 
		goBack.setFont(new Font("Trebuchet MS",Font.BOLD,20));
		goBack.setOpaque(true); 
		goBack.setBorder(BorderFactory.createBevelBorder(1)); 
		goBack.setBackground(new Color(50,0,0)); 
		goBack.setForeground(new Color(250,250,250)); 
		goBack.setFocusable(false); 
		goBack.addActionListener(this); 
		goBack.setText("Go Back");

		usernameLabel.setBounds(25,300,500,100);
		usernameLabel.setBackground(new Color(24,41,88)); 
		usernameLabel.setForeground(new Color(24,41,88));  
		usernameLabel.setFont(new Font("Trebuchet MS",Font.PLAIN,45));

		passwordLabel.setBounds(25,400,500,100); 
		passwordLabel.setBackground(new Color(24,41,88));
		passwordLabel.setForeground(new Color(24,41,88)); 
		passwordLabel.setFont(new Font("Trebuchet MS",Font.PLAIN,45));
		passwordLabel.setText("Password:");

		usernameEntry.setBounds(520,300,400,100);
		usernameEntry.setBackground(new Color(211,211,211));
		usernameEntry.setForeground(new Color(24,41,88));
		usernameEntry.setFont(new Font("Trebuchet MS",Font.PLAIN,45));

		passwordEntry.setBounds(520,400,400,100);
		passwordEntry.setBackground(new Color(211,211,211));
		passwordEntry.setForeground(new Color(24,41,88));
		passwordEntry.setFont(new Font("Trebuchet MS",Font.PLAIN,45));

		warningMessage.setBounds(25,625,600,25); 
		warningMessage.setBackground(new Color(211,211,211)); 
		warningMessage.setForeground(new Color(24,41,88)); 
		warningMessage.setLineWrap(true);
		warningMessage.setEditable(false);
		warningMessage.setOpaque(true);
		warningMessage.setFont(new Font("Trebuchet MS",Font.PLAIN,20));

		mainHub(); // calls it to show main stuff
	}

	/**
	 * The new page has all its contents removed (for in case of go back) and all main page content shown
	 * @precondition none
	 * @postcondition the content is shown to user and they can select buttons to visit.
	 */
	private void mainHub () {
		frame.getContentPane().removeAll(); // this takes all out from frame
		frame.revalidate();
		frame.repaint(); 

		frame.add(optionStudent);
		frame.add(optionTeacher);
		frame.add(subtitle);
		frame.add(title);
		frame.add(quit);
		frame.setVisible(true);
	}

	/**
	 * This shows the login panel for the Student along with its contents
	 * @precondition the Student option button must have been selected
	 * @postcondition the student is allowed to enter their name and begin test
	 */
	private void studentReady () {
		frame.getContentPane().removeAll(); // this takes all out from frame FOR REAL
		frame.revalidate();
		frame.repaint();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // can leave program

		frame.add(title);
		title.setText("Student Entry Page");
		subtitle.setText("Test Sample A: If you start test you cannot go back");
		usernameLabel.setFont(new Font("Trebuchet MS",Font.PLAIN,35));
		usernameLabel.setText("Enter your first & last name: ");
		warningMessage.setText("Notice: After starting the test you cannot go back or quit the test");

		frame.add(subtitle);
		frame.add(usernameLabel);
		frame.add(usernameEntry);
		frame.add(warningMessage);
		frame.add(startTest);
		frame.add(goBack);
		frame.add(quit);
		frame.setVisible(true);      
	}

	/**
	 * This shows the login panel for the Teacher along with its contents
	 * @precondition the Teacher option button must have been selected
	 * @postcondition the Teacher can try to login by entering username and password.
	 */
	private void teacherReady() {
		frame.getContentPane().removeAll(); // this takes all out from frame
		frame.revalidate();
		frame.repaint(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(title);
		title.setText("Java MC Testing Program");
		frame.add(subtitle);
		subtitle.setText("Teacher Login Page");
		frame.add(goBack);
		frame.add(quit);

		usernameLabel.setText("Username:");
		usernameLabel.setFont(new Font("Trebuchet MS",Font.PLAIN,45));

		frame.add(usernameLabel);
		frame.add(passwordLabel);
		frame.add(usernameEntry);
		frame.add(passwordEntry);
		frame.add(teacherLogin);
		frame.setVisible(true);
	}

	/**
	 * This checks if teacher password is the same as the encrypted password
	 * @precondition the login button needs to be clicked and a username and password must be entered and not null
	 * @postcondition the user is allowed in as a teacher and the MainPage frame is disposed and a secure teacher window opens
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void tryToLogin () throws FileNotFoundException, IOException {
		try {
			p = new Password(); // password created to check password

		}catch(Exception abc) {
			abc.printStackTrace();
		}
		name = usernameEntry.getText(); // gets text from user entry in box
		pass = passwordEntry.getText(); 
		//if the username is right & the password is the encrypted password
		if (name.equals("banks") && pass.equals(p.getPass())) {
			frame.dispose(); // frame deleted
			Teacher s = new Teacher(); // teacher window opened
		}
		else {
			warningMessage.setText("Incorrect Password"); 
			frame.add(warningMessage);
			frame.revalidate();
			frame.repaint();
		}

	}

	/**
	 * If button is pressed, then the task is started based on the button
	 * @precondition a button must be clicked and have an actionlistener programmed to execute a task
	 * @postcondition the button executes its task.
	 * @param e is the 'action' that happens, in this case button pressed.
	 */
	public void actionPerformed(ActionEvent e) {
		// entry login screen for student button
		if(e.getSource()==optionStudent) {         
			studentReady(); 
		}
		// entry login screen for Teacher button
		if(e.getSource()==optionTeacher) {
			teacherReady(); 
		}
		// if student gets into the student portal and clicks login
		if(e.getSource()==startTest) {
			frame.dispose(); // delete frame
			name = usernameEntry.getText();
			try {
				Student s = new Student(name); // this sends username to Student and starts test in new window
			} catch (Exception abc) {
				return;
			}
		}
		// if teacher gets into teacher portal and clicks login
		if(e.getSource()==teacherLogin) {
			try {
				tryToLogin();     
			} catch (Exception abc) {
				abc.printStackTrace();
			}

		}
		if(e.getSource()==quit) {
			System.exit(0); // this will exit the code
		}
		if(e.getSource()==goBack) {
			title.setText("Java MC Testing Program");
			subtitle.setText("Please select Teacher/Student by clicking the button");
			mainHub(); // start page
		}
	}
}
