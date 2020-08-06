import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements MouseListener	{
	Timer t;
	Symbol s;
	static String firstNumber = "0";
	static String secondNumber = "0";
	boolean first = true;
	boolean equals = false;

	public Panel(JFrame frame)	{   
		t = new Timer(20, new Listener());
		t.start();
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g)	{
		blank(g);
		drawUI(g);
		drawNumber(g);
	}

	public void blank(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0 , 400, 700);
	}

	public void drawNumber(Graphics g) {
		String s;
		Font font = new Font("Helvetica", Font.BOLD, 100);
		g.setColor(Color.black);
		g.setFont(font);
		if(first)
			s = firstNumber;
		else 
			s = secondNumber;

		g.drawString(s,0,200);
	}

	public void drawUI(Graphics g) {
		Font font = new Font("Helvetica", Font.BOLD, 100);
		g.setColor(Color.black);
		g.setFont(font);
		for(int i = 1; i <= 5; i++) {
			g.drawLine(0, getHeight() - (i*100), 700, getHeight() - (i*100));
		}	

		for(int i = 1; i <= 3; i++) {
			g.drawLine(i * 100, 200, i * 100, 700);
		}

		int count = 1;
		for(int y = 3; y > 0; y--) {
			for(int x = 0; x < 3; x++) {
				g.drawString("" + count, (x * 100), 300 + (y * 100));
				count++;
			}
		}
		
		g.drawString("0", 100, 700);
		g.setFont(new Font("Helvetica", Font.BOLD, 75));
		g.drawString("<-", 0, 700);
		g.drawString(".", 200, 700);
		g.drawString("=", 300, 700);
		g.drawString("+", 300, 600);
		g.drawString("-", 300, 500);
		g.drawString("X", 300, 400);
		g.drawString("/", 300, 300);
		g.drawString("AC", 0, 300);
		g.drawString("+/-", 100, 300);
		g.drawString("%", 200, 300);
	}
	
	public void one() {
		if(first) {
			if(firstNumber.equals("0"))
				firstNumber = "1";
			else
				firstNumber += 1;
		}
		else {
			if(secondNumber.equals("0"))
				secondNumber = "1";
			else
				secondNumber += 1;
		}
	}
	
	public void two() {
		if(first) {
			if(firstNumber.equals("0"))
				firstNumber = "2";
			else
				firstNumber += 2;
		}
		else {
			if(secondNumber.equals("0"))
				secondNumber = "2";
			else
				secondNumber += 2;
		}
	}
	
	public void three() {
		if(first) {
			if(firstNumber.equals("0"))
				firstNumber = "3";	
			else
				firstNumber += 3;
		}
		else {
			if(secondNumber.equals("0"))
				secondNumber = "3";
			else
				secondNumber += 3;
		}
	}
	
	public void four() {
		if(first) {
			if(firstNumber.equals("0"))
				firstNumber = "4";
			else
				firstNumber += 4;
		}
		else {
			if(secondNumber.equals("0"))
				secondNumber = "4";
			else
				secondNumber += 4; 
		}
	}
	
	public void five() {
		if(first) {
			if(firstNumber.equals("0"))
				firstNumber = "5";
			else
				firstNumber += 5;
		}
		else {
			if(secondNumber.equals("0"))
				secondNumber = "5";
			else
				secondNumber += 5;
		}
	}
	
	public void six() {
		if(first) {
			if(firstNumber.equals("0"))
				firstNumber = "6";
			else
				firstNumber += 6;
		}
		else {
			if(secondNumber.equals("0"))
				secondNumber = "6";
			else
				secondNumber += 6;
		}
	}
	
	public void seven() {
		if(first) {
			if(firstNumber.equals("0"))
				firstNumber = "7";
			else
				firstNumber += 7;
		}
		else {
			if(secondNumber.equals("0"))
				secondNumber = "7";
			else
				secondNumber += 7;
		}
	}
	
	public void eight() {
		if(first) {
			if(firstNumber.equals("0"))
				firstNumber = "8";
			else
				firstNumber += 8;
		}
		else {
			if(secondNumber.equals("0"))
				secondNumber = "8";
			else
				secondNumber += 8;
		}
	}
	
	public void nine() {
		if(first) {
			if(firstNumber.equals("0"))
				firstNumber = "9";
			else
				firstNumber += 9;
		}
		else {
			if(secondNumber.equals("0"))
				secondNumber = "9";
			else
				secondNumber += 9;
		}
	}
	
	public void zero() {
		if(first) {
			if(!firstNumber.equals("0"))
				firstNumber += 0;
		}
		else {
			if(!secondNumber.equals("0"))
				secondNumber += 0;
		}
	}

	public void addition() {
		s = Symbol.Add;
		first = false;
	}

	public void subtract() {
		s = Symbol.Subtract;
		first = false;
	}

	public void multiply() {
		s = Symbol.Multiply;
		first = false;
	}

	public void divide() {
		s = Symbol.Divide;
		first = false;
	}

	public void percent() {
		if(first) {
			double temp = Double.valueOf(firstNumber);
			temp /= 100;
			firstNumber = "" + temp;
		}
		else {
			double temp = Double.valueOf(firstNumber);
			temp /= 100;
			firstNumber = "" + temp;
		}
	}

	public void invert() {
		if(first) {
			double temp = Double.valueOf(firstNumber);
			temp *= -1;
			firstNumber = "" + temp;
		}
		else {
			double temp = Double.valueOf(firstNumber);
			temp *= -1;
			firstNumber = "" + temp;
		}
	}

	public void clear() {
		firstNumber = "0";
		secondNumber = "0";
	}

	public void equal() {
		double tempOne = Double.valueOf(firstNumber);
		double tempTwo = Double.valueOf(secondNumber);
		
		switch(s) {
		case Add:
			tempOne += tempTwo;
			break;
		case Subtract:
			tempOne -= tempTwo;
			break;
		case Multiply:
			tempOne *= tempTwo;
			break;
		default:
			tempOne /= tempTwo;
			break;
		}
		
		equals = true;
		firstNumber = "" + tempOne;
		secondNumber = "0";
		first = true;
	}

	public void dot() {
		if(first)
			firstNumber += ".";
		else 
			secondNumber += ".";
	}

	public void delete() {
		if(first) {
			if(!firstNumber.equals("0"))
				firstNumber = firstNumber.substring(0, firstNumber.length() - 1);
		}
		else 
			if(!secondNumber.equals("0"))
				secondNumber = secondNumber.substring(0, secondNumber.length() - 1);
	}

	private class Listener implements ActionListener	{
		public void actionPerformed(ActionEvent e)	{        
			repaint();
		}
	}
	
	public void mousePressed(MouseEvent e) 	{
	}

	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		int tempx = x/100;
		int tempy = y/100;

		if(equals) {
			clear();
			equals = false;
			firstNumber = "0";
			secondNumber = "0";
		}

		if(tempy == 2) {
			switch(tempx) {
			case(0):
				clear();
			break;
			case(1):
				invert();
			break;
			case(2):
				percent();
			break;
			case(3):
				divide();
			break;
			default:
				break;
			}
		}

		if(tempy == 3) {
			switch(tempx) {
			case(0):
				seven();
			break;
			case(1):
				eight();
			break;
			case(2):
				nine();
			break;
			case(3):
				multiply();
			break;
			default:
				break;
			}
		}

		if(tempy == 4) {
			switch(tempx) {
			case(0):
				four();
			break;
			case(1):
				five();
			break;
			case(2):
				six();
			break;
			case(3):
				subtract();
			break;
			default:
				break;
			}
		}

		if(tempy == 5) {
			switch(tempx) {
			case(0):
				one();
			break;
			case(1):
				two();
			break;
			case(2):
				three();
			break;
			case(3):
				addition();
			break;
			default:
				break;
			}
		}

		if(tempy == 6) {
			switch(tempx) {
			case(0):
				delete();
			break;
			case(1):
				zero();
			break;
			case(2):
				dot();
			break;
			case(3):
				equal();
			break;
			default:
				break;
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}
}
