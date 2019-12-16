import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Shapes extends JPanel implements KeyListener, ActionListener {
	
	public static int x = 10;
	public static int y = 150;
	
	public static int px = 760;
	public static int py = 150;
	
	public static int PyVel = 0;
	public static int yVel = 0;
	
	public static int p1Score = 0;
	public static int p2Score = 0;
	public static int winnerScore;
	
	public static int currentState = 0;
	public static int MENU_STATE = 0;
	public static int GAME_STATE = 1;
	public static int END_STATE = 2;

	
	Font mainFont = new Font("TimesRoman", Font.PLAIN, 48);
	Timer timer = new Timer(1000/60,this);
	Ball ball = new Ball();
	
	public Shapes() {
		timer.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		drawGameState(g);
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		}

		if (currentState == GAME_STATE) {
			drawGameState(g);
		}

		if (currentState == END_STATE) {
			drawEndState(g);
		}
		}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ball.Collision();
		y+=yVel;
		py+=PyVel;
		repaint();
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if(c == KeyEvent.VK_W) {
			yVel = -20;
			if(y < 5)
				y = 5;
			}
		
	
		if (c == KeyEvent.VK_S) {
			yVel = 20;
			if(y > 460)
				y = 460;
		}
		
		if(c == KeyEvent.VK_O) {
			PyVel = -20;
			System.out.println(py);
			if(py < 5)
				py = 5;
			}
		
		if (c == KeyEvent.VK_L) {
			PyVel = 20;
			System.out.println(py);
			if(py > 460)
				py = 460;
		}
		
		if(c == KeyEvent.VK_SPACE) {
			Ball.xVel = 2;
			Ball.yVel = 5;
		}
	
		
		//restart
		if(c == KeyEvent.VK_SPACE) {
			if(Ball.ballX != 400 && Ball.ballY != 300) {
				calculateScore();
			}
		}
		
		//switch game states
	if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		currentState++;
		
		if (currentState > END_STATE) {

			currentState = MENU_STATE;
	
	}
	}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		yVel = 0;
		PyVel = 0;
	}
	
	public void calculateScore() {
		if(Ball.ballX < -1)
			p2Score+=1;
		else if(Ball.ballX > 801)
			p1Score+=1;
		resetBallPosition();
	}
	
	public void resetBallPosition() {
		Ball.ballX = 400;
		Ball.ballY = 300;
		Ball.xVel = 0;
		Ball.yVel = 0;
	}
	
//	public void setWinnerScore () {
//		if(p1Score > p2Score)
//			p1Score = winnerScore;
//		if(p2Score > p1Score)
//			p2Score = winnerScore;
//	}
//	
//	public int getWinnerScore() {
//		return winnerScore;
//	}
	
	public void drawGameState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
		g.setColor(Color.blue);
		g.fillRect(x, y, 15, 100);
		g.fillRect(px, py, 15, 100);
		g.setColor(Color.orange);
		ball.draw(g);
		p1Score = 0;
		p2Score = 0;
		g.drawString("Player 1 Score: " + p1Score, 30, 50);
		g.drawString("Player 2 Score: " + p2Score, 660, 50);
		
	}
	
	public void drawMenuState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
		g.setColor(Color.blue);
		g.setFont(mainFont);
		g.drawString("Pong by MEG", 175, 260);
		g.drawString("Press ENTER To Play", 175, 350);
		resetBallPosition();

	}
	
	public void drawEndState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
		g.setColor(Color.orange);
		g.setFont(mainFont);
		g.drawString("WINNER: ", 175, 260);
		g.drawString("LOSER: ", 175, 350);
		g.drawString("Press ENTER To Play Again", 175, 440);

	}


}
