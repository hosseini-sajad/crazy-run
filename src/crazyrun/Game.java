package crazyrun;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel implements ActionListener, KeyListener {

	public static final int WIDTH = 600;
	public static final int HEIGHT = 800;
        public static final int ROAD_HEIGHT = 220;
        public static final int RIVER_HEIGHT = 220; 
        private static int score = 0;
	
        // game font
        Font gameFont = new Font("Press Start 2P", Font.BOLD, 26);
        
	// game objects
	private Player player;
        private River river;
        public Road road;
        private Timer timer;
       
	public Game() {
		player = new Player(280, 760, 40, Color.WHITE);
                road = new Road(0, 450, WIDTH, ROAD_HEIGHT, Color.decode("#434343"));
                river = new River(0, 70 ,WIDTH,RIVER_HEIGHT, Color.decode("#008dc7"));
                timer = new Timer(30, this);
		timer.start();

                setFocusable(true);
		addKeyListener(this);
	}
        
        
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// ----------game design---------------------
		setBackground(Color.decode("#cda360"));

                road.draw(g);
                river.draw(g);
                player.draw(g);
		
		//collision detection
                
                for (int i = 0; i < river.getCorcodiles().size(); i++) {
                    if(player.getBound().intersects(river.getCorcodiles().get(i).getBound()))
                        score++;
                }
                
                for (int i = 0; i < river.getCorcodiles2().size(); i++) {
                    if(player.getBound().intersects(river.getCorcodiles2().get(i).getBound()))
                        score++;    
                }
                
                for (int i = 0; i < road.getCars().size(); i++) {
                if (player.getBound().intersects(road.getCars().get(i).getBound())) {
                    score++;
                }
            }
                
                for (int i = 0; i < road.getCars2().size(); i++) {
                if (player.getBound().intersects(road.getCars2().get(i).getBound())) {
                    score++;
                }
            }
		

		// ----------score design----------------------
		g.setColor(new Color(0, 0, 0, 0));
                g.fillRect(0, 0, WIDTH, 70);
                
                g.setColor(Color.BLACK);
                g.setFont(gameFont);
                g.drawString("Score: "+ score, 10, 48);

	}

    @Override
    public void actionPerformed(ActionEvent e) {
        road.move();
        river.Move();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }
    
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP)
            player.moveUp();
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            player.moveDown();
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            player.moveLeft();
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            player.moveRight();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}