package crazyrun;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener {

	public static final int WIDTH = 300;
	public static final int HEIGHT = 600;
	public static final int SCORE_HEIGHT = 120;
	
	// game objects
	private Ball ball;
	private Board board;
	private Timer timer;
	
	public Game() {
		ball = new Ball(WIDTH / 2, 0, 40, Color.BLUE);
		board = new Board(WIDTH / 2 - 100, HEIGHT - SCORE_HEIGHT - 70, Color.BLACK, 200, 20);
		timer = new Timer(30, this);
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// ----------game design---------------------
		setBackground(Color.WHITE);
		ball.draw(g);
		board.draw(g);
		
		//collision detection
		if(ball.getBound().intersects(board.getBound()))
			ball.moveUp();
		
		// ----------score design----------------------
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, HEIGHT - SCORE_HEIGHT, WIDTH, SCORE_HEIGHT);
		
		g.setColor(Color.YELLOW);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		
		g.drawString("Your Name: Ali", 10, HEIGHT - SCORE_HEIGHT + 30);
		g.drawString("Your Score: 0", 10, HEIGHT - SCORE_HEIGHT + 50);
		
		g.setColor(Color.CYAN);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
		g.drawString("Powered By: M.Yasrebi", WIDTH - 150, HEIGHT - 20);	
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ball.move(WIDTH,HEIGHT - SCORE_HEIGHT);
		repaint();
	}
}
