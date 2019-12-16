import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel{
	
public static final int WIDTH = 800;
public static final int HEIGHT = 600;
	
	public static void main (String[] args) {
		Main m = new Main();
		m.setup();
		
	}
	
	public void setup() {
		JFrame frame = new JFrame();
		Shapes s = new Shapes();
		frame.setTitle("2 PLAYER PONG");
		frame.setSize(WIDTH,HEIGHT);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(s);
	}
	
}