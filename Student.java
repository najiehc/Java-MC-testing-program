import java.awt.event.*; // needed for buttons
import java.awt.*; // needed for buttons
import javax.swing.*; // needed for JComponents
import java.io.*; // needed for exceptions for file take in
import java.lang.Thread; // needed for pause

//action listener needed for buttons
public class Student implements ActionListener{

	private String selection; // answer choice of student
	private int current; // current question
	private int numberCorrect = 0; 
	private int testLength; // How many questions on test
	private int result; // % score of student
	private String name; // student name, useful for printing to student log
	private JFrame frame = new JFrame(); // frame
	private JTextField title = new JTextField(); // top bar
	private JTextField subtitle = new JTextField(); // below top bar
	private JButton optionA = new JButton(); // button for choosing A
	private JButton optionB = new JButton(); // button for choosing B
	private JButton optionC = new JButton(); // button for choosing C
	private JButton optionD = new JButton(); // button for choosing D
	private JLabel optionLabelA = new JLabel(); // text for answer choice A
	private JLabel optionLabelB = new JLabel(); // text for answer choice B
	private JLabel optionLabelC = new JLabel(); // text for answer choice C
	private JLabel optionLabelD = new JLabel(); // text for answer choice D
	private JButton quitTest = new JButton(); // ending test button
	private JButton finalQuit = new JButton(); // quits program at end
	private JButton confirmButton = new JButton(); // confirms the selected answer and submits it to be checked
	private JTextField endCard1 = new JTextField(); // last screen component
	private JTextField endCard2 = new JTextField(); // last screen component
	private JTextField endCard3 = new JTextField(); // last screen component
	private JTextArea notice = new JTextArea(); // used to tell if scores have been submitted
	private TestFormatter t; // used to get test information


	/**
	 * Instantiates a new student and creates JFrame. Sets up JComponents
	 * @precondition on login page the student had to enter user name.
	 * @postcondition JFrame created and void method starts test
	 * @param n which is the name of student 
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Student(String n) throws FileNotFoundException, IOException {
		name = n;
		// try to get test information. try statement needed due to taking
		// in file, if error occurs, the error message is displayed
		try {
			createTest();
		} catch (Exception abc) {
			abc.printStackTrace();
		}
		testLength = t.getNumQuestions();

		frame.setTitle("JAVA MC TESTING PROGRAM (QUIZ)");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
		// useful so student needs to use quit button to leave program
		// this makes it that they need to then submit scores.
		frame.setSize(1000,800);
		frame.getContentPane().setBackground(new Color(255,254,251)); 
		frame.setLayout(null);
		frame.setResizable(false);

		title.setBounds(0,0,1000,75);
		title.setBackground(new Color(50,0,0));
		title.setForeground(new Color(250,250,250));
		title.setFont(new Font("Arial",Font.BOLD,45));
		title.setBorder(BorderFactory.createBevelBorder(1));
		title.setHorizontalAlignment(JTextField.CENTER);
		title.setEditable(false);

		subtitle.setBounds(0,75,1000,75); 
		subtitle.setBackground(new Color(50,0,0));
		subtitle.setForeground(new Color(250,250,250));
		subtitle.setFont(new Font("ARIAL",Font.BOLD,35));
		subtitle.setHorizontalAlignment(JTextField.CENTER);
		subtitle.setBorder(BorderFactory.createBevelBorder(1));
		subtitle.setEditable(false);

		optionA.setBounds(25,162,140,140);
		optionA.setFont(new Font("Trebuchet MS",Font.BOLD,35));
		optionA.setForeground(new Color(250,250,250));
		optionA.setBackground(new Color(24,41,88));
		optionA.setBorder(BorderFactory.createBevelBorder(1));
		optionA.setFocusable(false);
		optionA.setOpaque(true);
		optionA.addActionListener(this);
		optionA.setText("A");

		optionB.setBounds(25,312,140,140);
		optionB.setFont(new Font("Trebuchet MS",Font.BOLD,35));
		optionB.setOpaque(true);
		optionB.setForeground(new Color(250,250,250));
		optionB.setBackground(new Color(24,41,88));
		optionB.setBorder(BorderFactory.createBevelBorder(1)); 
		optionB.setFocusable(false);
		optionB.addActionListener(this);
		optionB.setText("B");

		optionC.setBounds(25,462,140,140); 
		optionC.setFont(new Font("Trebuchet MS",Font.BOLD,35));
		optionC.setOpaque(true);
		optionC.setForeground(new Color(250,250,250));
		optionC.setBackground(new Color(24,41,88));
		optionC.setBorder(BorderFactory.createBevelBorder(1));
		optionC.setFocusable(false);
		optionC.addActionListener(this);
		optionC.setText("C");

		optionD.setBounds(25,612,140,140);
		optionD.setFont(new Font("Trebuchet MS",Font.BOLD,35));
		optionD.setOpaque(true);
		optionD.setForeground(new Color(250,250,250));
		optionD.setBackground(new Color(24,41,88));
		optionD.setBorder(BorderFactory.createBevelBorder(1));
		optionD.setFocusable(false);
		optionD.addActionListener(this);
		optionD.setText("D");

		optionLabelA.setBounds(185,162,750,150); 
		optionLabelA.setBackground(new Color(24,41,88)); 
		optionLabelA.setForeground(new Color(24,41,88));
		optionLabelA.setFont(new Font("Trebuchet MS",Font.PLAIN,50));

		optionLabelB.setBounds(185,312,750,150);
		optionLabelB.setBackground(new Color(24,41,88));
		optionLabelB.setForeground(new Color(24,41,88));
		optionLabelB.setFont(new Font("Trebuchet MS",Font.PLAIN,50));

		optionLabelC.setBounds(185,462,750,150);
		optionLabelC.setBackground(new Color(24,41,88));
		optionLabelC.setForeground(new Color(24,41,88));
		optionLabelC.setFont(new Font("Trebuchet MS",Font.PLAIN,50));

		optionLabelD.setBounds(185,612,750,150);
		optionLabelD.setBackground(new Color(24,41,88));
		optionLabelD.setForeground(new Color(24,41,88));
		optionLabelD.setFont(new Font("Trebuchet MS",Font.PLAIN,50));

		quitTest.setBounds(900,700,75,50); 
		quitTest.setFont(new Font("Trebuchet MS",Font.BOLD,20));
		quitTest.setOpaque(true); 
		quitTest.setBorder(BorderFactory.createBevelBorder(1)); 
		quitTest.setBackground(new Color(50,0,0)); 
		quitTest.setForeground(new Color(250,250,250)); 
		quitTest.setFocusable(false); 
		quitTest.addActionListener(this); // makes the button responsive to user
		quitTest.setText("Quit");

		// quitTest button leaves test, finalQuit leaves program

		finalQuit.setBounds(900,700,75,50); 
		finalQuit.setFont(new Font("Trebuchet MS",Font.BOLD,20));
		finalQuit.setOpaque(true); 
		finalQuit.setBorder(BorderFactory.createBevelBorder(1)); 
		finalQuit.setBackground(new Color(50,0,0)); 
		finalQuit.setForeground(new Color(250,250,250)); 
		finalQuit.setFocusable(false); 
		finalQuit.addActionListener(this); // makes the button responsive to user
		finalQuit.setText("Quit"); 

		confirmButton.setBounds(750,550,250,50); 
		confirmButton.setFont(new Font("Trebuchet MS",Font.BOLD,20));
		confirmButton.setOpaque(true);
		confirmButton.setForeground(new Color(250,250,250));
		confirmButton.setBackground(new Color(13,55,13));
		confirmButton.setBorder(BorderFactory.createBevelBorder(1)); 
		confirmButton.setFocusable(false);
		confirmButton.addActionListener(this);
		confirmButton.setText("Confirm this selection");

		endCard1.setBounds(0,200,1000,200); 
		endCard1.setForeground(new Color(250,250,250));
		endCard1.setBackground(new Color(0,20,13));
		endCard1.setBackground(new Color(24,41,88));
		endCard1.setFont(new Font("Arial",Font.BOLD,75));
		endCard1.setBorder(BorderFactory.createBevelBorder(1));
		endCard1.setHorizontalAlignment(JTextField.CENTER);
		endCard1.setEditable(false);

		endCard2.setBounds(0,400,1000,200);
		endCard2.setForeground(new Color(250,250,250));
		endCard2.setBackground(new Color(24,41,88));
		endCard2.setFont(new Font("Arial",Font.BOLD,50));
		endCard2.setBorder(BorderFactory.createBevelBorder(1));
		endCard2.setHorizontalAlignment(JTextField.CENTER);
		endCard2.setEditable(false);

		endCard3.setBounds(0,0,1000,75); 
		endCard3.setBackground(new Color(50,0,0));
		endCard3.setForeground(new Color(250,250,250));
		endCard3.setFont(new Font("Arial",Font.BOLD,45));
		endCard3.setBorder(BorderFactory.createBevelBorder(1));
		endCard3.setText("Your Results to the test are below");
		endCard3.setHorizontalAlignment(JTextField.CENTER);
		endCard3.setEditable(false);

		notice.setBounds(25,625,750,25); 
		notice.setBackground(new Color(211,211,211)); 
		notice.setForeground(new Color(24,41,88));  
		notice.setLineWrap(true);
		notice.setOpaque(true); 
		notice.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
		notice.setEditable(false);

		frame.add(optionLabelA);
		frame.add(optionLabelB);
		frame.add(optionLabelC);
		frame.add(optionLabelD);
		frame.add(optionA);
		frame.add(optionB);
		frame.add(optionC);
		frame.add(optionD);
		frame.add(quitTest);
		frame.add(subtitle);
		frame.add(title);
		frame.setVisible(true);
		frame.add(confirmButton);
		confirmButton.setVisible(false);
		questionAsker(); // start test
	}

	/**
	 * Creates the test by taking in file from TestFormatter & decrypting it
	 * @precondition file "EncryptedTest.txt" must exist and not be empty. Must also be formatted as user desired
	 * @postcondition test created, questions and answers will now show up on screen
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void createTest() throws FileNotFoundException, IOException {
		try {
			t = new TestFormatter("EncryptedTest.txt", false); // false because do not want to print to a file

		} catch (Exception abc) {
			abc.printStackTrace();
		}
	}

	/**
	 * Pauses the program for 1-2 seconds in between questions for fluid animation
	 * @precondition a # must be passed and cannot be null
	 * @postcondition the program is paused for the long seconds
	 * @param seconds specifies time that pause lasts
	 */
	public static void pause (long seconds) {
		try {
			Thread.sleep(seconds*1000); // from java.lang, static method which sleeps for milliseconds 
			//  so multiplied seconds by 1000.
		} catch (Exception abc) {
			return; // if error created, leave method & ask next question
		}

	}

	/**
	 * Asks questions to user by formatting the buttons to work and changing text of subtitle and labels for answers
	 * @precondition file must be able to get read, test length less than 1000 questions
	 * @postcondition questions displayed to screen, buttons now work for selection
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void questionAsker() throws FileNotFoundException, IOException {		
		if(current >= testLength) {
			endTest();
		}
		else {
			optionA.setEnabled(true);
			optionB.setEnabled(true); // button pressing now works.
			optionC.setEnabled(true);
			optionD.setEnabled(true);
			confirmButton.setEnabled(true);
			title.setText("Question " + (current+1) + " of " + testLength); // updates for current question
			subtitle.setText(t.getQuestion(current));
			optionLabelA.setText(t.getChoice1(current));
			optionLabelB.setText(t.getChoice2(current));
			optionLabelC.setText(t.getChoice3(current));
			optionLabelD.setText(t.getChoice4(current));
		}
	}

	/**
	 * This method overrides the current method IF a button is pressed, and does its required task such as submitting answer
	 * @precondition a button must be clicked and have an actionlistener programmed to execute a task
	 * @postcondition the button executes its task.
	 * @param e is the 'action' that happens, in this case button pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// button for the first option. if selected this changes color of button to green
		// to highlight it is selected. also repaints and revalidates the frame so seen
		// on screen. Confirm button now seen so answer can be submitted
		if(e.getSource()==optionA) {
			selection= "A";
			optionA.setBackground(new Color(13,55,13));
			optionB.setBackground(new Color(24,41,88));
			optionC.setBackground(new Color(24,41,88));
			optionD.setBackground(new Color(24,41,88));
			confirmButton.setVisible(true);
			frame.revalidate();
			frame.repaint();
		}
		// button for the second option. if selected this changes color of button to green
		// to highlight it is selected. also repaints and revalidates the frame so seen
		// on screen. Confirm button now seen so answer can be submitted
		if(e.getSource()==optionB) {
			selection= "B";
			optionB.setBackground(new Color(13,55,13));
			optionA.setBackground(new Color(24,41,88));
			optionC.setBackground(new Color(24,41,88));
			optionD.setBackground(new Color(24,41,88));
			confirmButton.setVisible(true);
			frame.revalidate();
			frame.repaint();
		}
		// button for the third option. if selected this changes color of button to green
		// to highlight it is selected. also repaints and revalidates the frame so seen
		// on screen. Confirm button now seen so answer can be submitted
		if(e.getSource()==optionC) {
			selection= "C";
			optionC.setBackground(new Color(13,55,13));
			optionB.setBackground(new Color(24,41,88));
			optionA.setBackground(new Color(24,41,88));
			optionD.setBackground(new Color(24,41,88));
			confirmButton.setVisible(true);
			frame.revalidate();
			frame.repaint();
		}
		// button for the fourth option. if selected this changes color of button to green
		// to highlight it is selected. also repaints and revalidates the frame so seen
		// on screen. Confirm button now seen so answer can be submitted
		if(e.getSource()==optionD) {
			selection= "D";
			optionD.setBackground(new Color(13,55,13));
			optionB.setBackground(new Color(24,41,88));
			optionC.setBackground(new Color(24,41,88));
			optionA.setBackground(new Color(24,41,88));
			confirmButton.setVisible(true);
			frame.revalidate();
			frame.repaint();
		}
		if (e.getSource() == confirmButton) {
			if(selection.equalsIgnoreCase(t.getAnswer(current))) {
				// this sees if the selection is equal to the current questions' answer.
				numberCorrect++;
			}
			pause((long)(1.1)); // stops the program for 1.1 second pause.
			optionA.setBackground(new Color(24,41,88));
			optionB.setBackground(new Color(24,41,88)); // all buttons back to original color
			optionC.setBackground(new Color(24,41,88));
			optionD.setBackground(new Color(24,41,88));
			confirmButton.setVisible(false);
			current++; // increments so next question shown.
			try {
				questionAsker(); 
			} catch (Exception abc) {
				return;
			}
		}

		if(e.getSource() == quitTest) {
			try {
				endTest(); // tries to end test if possible
			} catch(Exception abc) {
				abc.printStackTrace();
			}
		}
		if(e.getSource()== finalQuit) {
			System.exit(0); // this will exit the program. only available at the end.
		}
	}

	/**
	 * Ends the test and displays the student scores to user and uploads the scores to the encrypted student log
	 * @precondition all questions must be answered or quit button pressed
	 * @postcondition final screen shown to user with score, they have option to exit now
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void endTest() throws FileNotFoundException, IOException{
		frame.getContentPane().removeAll(); // this takes all out from frame      
		frame.revalidate();
		frame.repaint();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // now "X" button leaves the program

		boolean a = false;
		result = t.getResults(numberCorrect); // gets % score of student
		try {
			StudentLog s = new StudentLog(name + ": " + result); // sends the score to be encrypted + uploaded to student log
			a = s.didResultsSend(); // returns if the log was updated
		}   catch (Exception abc) {
			abc.printStackTrace();
		} 
		
		//if log updated
		if (a == true) {
			notice.setText("Your results have been sent to Student Log, you may close the program");
		}
		
		// if log NOT updated
		else {
			notice.setText("Your results could not be sent to Student Log, contact your teacher!");
		}
		// showing scores on final screen
		endCard1.setText("You scored a " + result + "%");
		endCard2.setText("You selected the right answer " + numberCorrect + "/" + testLength + " times");

		frame.add(notice);
		frame.add(endCard1);
		frame.add(endCard2); // adds all to frame to see
		frame.add(endCard3);
		frame.add(finalQuit);

	}
}