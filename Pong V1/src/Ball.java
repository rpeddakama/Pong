import java.awt.Graphics;

public class Ball {
	
	public static int ballX = 400;
	public static int ballY = 300;
	
	public static int xVel = 0;
	public static int yVel = 0;
	
	public void draw(Graphics g) {
		g.fillOval(ballX, ballY, 20, 20);
		ballX+=xVel;
		ballY+=yVel;
	}
	
	public void Collision() {
		
		//boundary collision
		if(ballY < 0) {
			yVel = -yVel;
		}
		
		if(ballY > Main.HEIGHT-40) {
			yVel = -yVel;
		}
		
		//paddle collision
		if(ballX <= Shapes.x + 15 && ballX > 0) {
			if(Shapes.y <= ballY && Shapes.y + 100 >= ballY){
				System.out.println("OTHER HIT");
				xVel = -xVel;
			}
		}
	
		
		if(ballX >= Shapes.px - 17 && ballX < 810) {
			if(Shapes.py <= ballY && Shapes.py + 100 >= ballY){
			System.out.println("HIT");
			xVel = -xVel;
			
			}		
		}
	}
}
	
