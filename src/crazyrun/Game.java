package crazyrun;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

<<<<<<< HEAD
public class Game extends JPanel implements ActionListener{

	public static final int WIDTH = 600;
	public static final int HEIGHT = 800;
        public static final int ROAD_HEIGHT = 220;
        
=======
public class Game extends JPanel implements ActionListener {

	public static final int WIDTH = 600;
	public static final int HEIGHT = 800;
        public static final int RIVER_HEIGHT = 220; 
>>>>>>> Amir
	
        // game font
        Font gameFont = new Font("Press Start 2P", Font.BOLD, 26);
        
	// game objects
	private Player player;
<<<<<<< HEAD
        public Road road;
        private Timer timer;
        
        
	public Game() {
		player = new Player(280, 760, 40, Color.WHITE);
                road = new Road(0, HEIGHT - 350, WIDTH, ROAD_HEIGHT, Color.decode("#434343"));
                timer = new Timer(30, this);
		timer.start();
=======
        private River river;
        private Timer timer;

	
	public Game() {
		player = new Player( 280, 760, 40, Color.WHITE);
		river = new River(0, 70 ,WIDTH,RIVER_HEIGHT, Color.decode("#008dc7"));
                timer = new Timer(30, this);
                timer.start();
>>>>>>> Amir
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// ----------game design---------------------
		setBackground(Color.decode("#cda360"));
		player.draw(g);
<<<<<<< HEAD
                road.draw(g);
=======
                river.draw(g);
               
                /*draw game river*/
>>>>>>> Amir
                
		
		//collision detection
		
		
		// ----------score design----------------------
		g.setColor(new Color(0, 0, 0, 30));
                g.fillRect(0, 0, WIDTH, 70);
                
                g.setColor(Color.BLACK);
                g.setFont(gameFont);
                String score = Integer.toString(0);
                g.drawString("Score: "+ score, 10, 48);
		
	}

    @Override
<<<<<<< HEAD
    public void actionPerformed(ActionEvent e) {
        road.move();
        repaint();
    }
    
=======
    public void actionPerformed(ActionEvent ae) {
        river.Move();
        repaint();
    }
     
>>>>>>> Amir
}
