import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Quiz implements ActionListener{
	String questions [] = {
			"Number of primitive data types in Java are?",
			"What is the size of float and double in java?",
			"Automatic type conversion is possible in which of the possible cases?",
			"Select the valid statement."
	};
	String[][] options = {
			{"6","7","8","9"},
			{"32 and 64","32 and 32","64 and 64","64 and 32"},
			{"Byte to int","Int to long","Long to int","Short to int"},
			{"char[] ch = new char(5)","char[] ch = new char[5]","char[] ch = new char()","char[] ch = new char[]"}
	};
    char[] answers = {
    		'A',
    		'B',
    		'C',
    		'D'
    };
    char guess;
    char answer;
    int index;
    int currect_guesses=0;
    int tot_quest = questions.length;
    double result;
    int seconds=10;
    
    JFrame jframe = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea jtextarea = new JTextArea();
    JButton abutton = new JButton();
    JButton bbutton = new JButton();
    JButton cbutton = new JButton();
    JButton dbutton = new JButton();
    
    JLabel ans_lableA = new JLabel();
    JLabel ans_labelB = new JLabel();
    JLabel ans_labelC = new JLabel();
    JLabel ans_labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel second_left = new JLabel();
    
    JTextField numer_right = new JTextField();
    JTextField percentage = new JTextField();
	Quiz(){
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(650, 650);
		jframe.setLayout(null);
		jframe.getContentPane().setBackground(new Color(50,50,50));
		jframe.setResizable(false);
		
		
		textfield.setBounds(0, 0, 650, 50);
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);

		jtextarea.setBounds(0, 50, 650, 50);
		jtextarea.setLineWrap(true);
		jtextarea.setWrapStyleWord(true);
		jtextarea.setBackground(new Color(25,25,25));
		jtextarea.setForeground(new Color(25,255,0));
		jtextarea.setEditable(false);
		
		abutton.setBounds(0, 100, 100, 100);
		abutton.setFocusable(false);
		abutton.addActionListener(this);
		abutton.setText("A");
		
		bbutton.setBounds(0, 200, 100, 100);
		bbutton.setFocusable(false);
		bbutton.addActionListener(this);
		bbutton.setText("B");
		
		cbutton.setBounds(0, 300, 100, 100);
		cbutton.setFocusable(false);
		cbutton.addActionListener(this);
		cbutton.setText("C");
		
		dbutton.setBounds(0, 400, 100, 100);
		dbutton.setFocusable(false);
		dbutton.addActionListener(this);
		dbutton.setText("D");
		
		ans_lableA.setBounds(125, 100, 500, 100);
		ans_lableA.setBackground(new Color(25,25,25));
		ans_lableA.setForeground(new Color(25,255,0));
		
		ans_labelB.setBounds(125, 200, 500, 100);
		ans_labelB.setBackground(new Color(25,25,25));
		ans_labelB.setForeground(new Color(25,255,0));
		
		
		ans_labelC.setBounds(125, 300, 500, 100);
		ans_labelC.setBackground(new Color(25,25,25));
		ans_labelC.setForeground(new Color(25,255,0));
		
		ans_labelD.setBounds(125, 400, 500, 100);
		ans_labelD.setBackground(new Color(25,25,25));
		ans_labelD.setForeground(new Color(25,255,0));
		
		second_left.setBounds(535, 510, 100, 100);
		second_left.setBackground(new Color(25,25,25));
		second_left.setForeground(new Color(255,0,0));
		second_left.setOpaque(true);
		second_left.setHorizontalAlignment(JTextField.CENTER);
		second_left.setText(String.valueOf(seconds));
		
		time_label.setBounds(535, 475, 100, 25);
		time_label.setBackground(new Color(50,50,50));
		time_label.setForeground(new Color(255,0,0));
		time_label.setHorizontalAlignment(JTextField.CENTER);
		time_label.setText("timer >:D");
		
		numer_right.setBounds(255, 225, 200, 100);
		numer_right.setBackground(new Color(25,25,25));
		numer_right.setForeground(new Color(255,0,0));
		numer_right.setHorizontalAlignment(JTextField.CENTER);
		numer_right.setEditable(false);
		
		percentage.setBounds(255, 325, 200, 100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(255,0,0));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		
		jframe.add(time_label);
		jframe.add(second_left);
		jframe.add(ans_lableA);
		jframe.add(ans_labelB);
		jframe.add(ans_labelC);
		jframe.add(ans_labelD);
		
		jframe.add(abutton);
		jframe.add(bbutton);
		jframe.add(cbutton);
		jframe.add(dbutton);
		
		jframe.add(jtextarea);
		jframe.add(textfield);
		jframe.setVisible(true);
		nextQuestion();
	}
    public void nextQuestion() {
    	if(index>=tot_quest) {
			result();
		}else {
			textfield.setText("Question"+(index+1));
			jtextarea.setText(questions[index]);
			ans_lableA.setText(options[index][0]);
			ans_labelB.setText(options[index][1]);
			ans_labelC.setText(options[index][2]);
			ans_labelD.setText(options[index][3]);
		}
    }
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		abutton.setEnabled(false);
		bbutton.setEnabled(false);
		cbutton.setEnabled(false);
		dbutton.setEnabled(false);
		if(e.getSource()==abutton) {
			answer = 'A';
			if(answer == answers[index]) {
				currect_guesses++;
			}
		}
		if(e.getSource()==bbutton) {
			answer = 'B';
			if(answer == answers[index]) {
				currect_guesses++;
			}
		}
		if(e.getSource()==cbutton) {
			answer = 'C';
			if(answer == answers[index]) {
				currect_guesses++;
			}
		}
		if(e.getSource()==dbutton) {
			answer = 'D';
			if(answer == answers[index]) {
				currect_guesses++;
			}
		}
		displayAnswer();
	}
	public void displayAnswer() {
		abutton.setEnabled(false);
		bbutton.setEnabled(false);
		cbutton.setEnabled(false);
		dbutton.setEnabled(false);
		if(answers[index]!='A') 
			ans_lableA.setForeground(new Color(255,0,0));
		if(answers[index]!='B') 
			ans_labelB.setForeground(new Color(255,0,0));
		if(answers[index]!='C') 
			ans_labelC.setForeground(new Color(255,0,0));
		if(answers[index]!='D') 
			ans_labelD.setForeground(new Color(255,0,0));
		
		Timer pause = new Timer(2000,new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	ans_lableA.setForeground(new Color(25,255,0));
			    	ans_labelB.setForeground(new Color(25,255,0));
			    	ans_labelC.setForeground(new Color(25,255,0));
			    	ans_labelD.setForeground(new Color(25,255,0));
			    	ans_lableA.setForeground(new Color(25,255,0));
			    	answer = ' ';
			    	seconds=10;
			    	second_left.setText(String.valueOf(seconds));
			    	abutton.setEnabled(true);
			    	bbutton.setEnabled(true);
					cbutton.setEnabled(true);
					dbutton.setEnabled(true);
					index++;
					nextQuestion();
				}
			   
		});
		pause.setRepeats(false);
		pause.start();
	}
   public void result() {
	   abutton.setEnabled(false);
	   bbutton.setEnabled(false);
	   cbutton.setEnabled(false);
	   dbutton.setEnabled(false);
	   result = (int)((currect_guesses/(double)tot_quest)*100);
	   textfield.setText("Result");
	   jtextarea.setText("");
	   ans_lableA.setText("");
	   ans_labelB.setText("");
	   ans_labelC.setText("");
	   ans_labelD.setText("");
	   numer_right.setText("("+currect_guesses+"/"+tot_quest+")");
	   percentage.setText(result+"%");
	   
	   jframe.add(numer_right);
	   jframe.add(percentage);
   }
}
