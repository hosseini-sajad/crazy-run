package crazyrun;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener{

	public static final int WIDTH = 600;
	public static final int HEIGHT = 800;
	public static final int SCORE_HEIGHT = 120;
        public static final int ROAD_HEIGHT = 220;
        
	
	// game objects
	private Player player;
        public Road road;
        private Timer timer;
        
        
	public Game() {
		player = new Player(WIDTH / 2 - 20, HEIGHT - 40, 40, Color.BLACK);
                road = new Road(0, HEIGHT - 350, WIDTH, ROAD_HEIGHT, Color.decode("#434343"));
                timer = new Timer(30, this);
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// ----------game design---------------------
		setBackground(Color.decode("#cda360"));
		player.draw(g);
                road.draw(g);
                
		
		//collision detection
		
		
		// ----------score design----------------------
		
		
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        road.move();
        repaint();
    }
    
}
