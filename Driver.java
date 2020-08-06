import javax.swing.JFrame;

public class Driver 
{
	static int myWidth = 400 + 26;
	static int myHeight = 700 + 71;
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Game");
		frame.setSize(myWidth, myHeight);
		frame.setLocation(0,0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Panel(frame));
		frame.setVisible(true);
	}
}
