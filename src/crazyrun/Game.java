package crazyrun;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel {

	public static final int WIDTH = 100;
	public static final int HEIGHT = 800;
	public static final int SCORE_HEIGHT = 120;
	
	// game objects
	private Player player;

	
	public Game() {
		player = new Player(WIDTH / 2 - 20, HEIGHT - 40, 40, Color.BLACK);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// ----------game design---------------------
		setBackground(Color.WHITE);
		player.draw(g);
		
		
		//collision detection
		
		
		// ----------score design----------------------
		
		
	}

}
