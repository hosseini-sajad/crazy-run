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
import java.util.ArrayList;

public class Game extends JPanel implements ActionListener, KeyListener {

	public static final int WIDTH = 600;
	public static final int HEIGHT = 800;
        public static final int ROAD_HEIGHT = 220;
        public static final int RIVER_HEIGHT = 220; 
        public static int score = 0;
	
        // game font
        Font gameFont = new Font("Press Start 2P", Font.BOLD, 18);
        
	// game objects
	private Player player;
        private River river;
        private Road road;   
        private ArrayList<Gift> gifts = new ArrayList<>();
        private Timer timer;
        
        private boolean play;
        private boolean hasCollision = false;
        
       
	public Game() {
		player = new Player(280, 760, 40, Color.WHITE);
                road = new Road(0, 450, WIDTH, ROAD_HEIGHT, Color.decode("#434343"));
                river = new River(0, 70 ,WIDTH,RIVER_HEIGHT, Color.decode("#008dc7"));
                for (int i = 0; i < 3; i++) {
                Gift gift = new Gift((i + 1) * 100, (i + 1) * 200, 30, 30);
                gifts.add(gift);
                play = true;
            }
                
                timer = new Timer(30, this);
		timer.start();

                setFocusable(true);
		addKeyListener(this);
	}
        
        public void restart() {
            player = new Player(280, 760, 40, Color.WHITE);
            road = new Road(0, 450, WIDTH, ROAD_HEIGHT, Color.decode("#434343"));
            river = new River(0, 70, WIDTH, RIVER_HEIGHT, Color.decode("#008dc7"));
            for (int i = 0; i < 3; i++) {
                Gift gift = new Gift((i + 1) * 100, (i + 1) * 200, 30, 30);
                gifts.add(gift);
                play = true;
                score = 0;
                hasCollision = false;
            }
        }
        
        
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// ----------game design---------------------
		setBackground(Color.decode("#cda360"));

                road.draw(g);
                river.draw(g);
                player.draw(g);
                for(Gift gift : gifts)
                gift.draw(g);
                
                //player loses
                if(hasCollision){
                    play = false;
                    g.setColor(Color.RED);
                    g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
                    g.drawString("Game Over!", 20, HEIGHT / 2);
                    g.drawString("Your Score is: " + score, 20, HEIGHT / 2 + 25);
                    g.drawString("Please press ENTER key to restart...", 20, HEIGHT / 2 + 50);
                }
                
                
                //player wins
                if(player.getY() + player.getSize() < river.getY()){
                    play = false;
                    g.setColor(Color.GREEN);
                    g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
                    g.drawString("Congradulations, You Won...", 20, HEIGHT / 2);
                    g.drawString("Your Score is: " + score, 20, HEIGHT / 2 + 25);
                    g.drawString("Please press ENTER key to restart...", 20, HEIGHT / 2 + 50);
                }
		

		// ----------score design----------------------
		g.setColor(new Color(0, 0, 0, 0));
                g.fillRect(0, 0, WIDTH, 70);
                
                g.setColor(Color.BLACK);
                g.setFont(gameFont);
                g.drawString("Score: " + score, 10, 48);
                
                g.dispose();

	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (play) {
            road.move();
            river.Move();

            //collision detection
            for (int i = 0; i < gifts.size(); i++) {
                if (player.getBound().intersects(gifts.get(i).getBound())) {
                    gifts.get(i).setPosition(0);
                    gifts.remove(i);
                }
            }

            collisionDetection();

            repaint();
        }
    }
    
    public void collisionDetection(){
        for (int i = 0; i < river.getCorcodiles().size(); i++) {
            if (player.getBound().intersects(river.getCorcodiles().get(i).getBound())) {
                hasCollision = true;
            }
        }

        for (int i = 0; i < river.getCorcodiles2().size(); i++) {
            if (player.getBound().intersects(river.getCorcodiles2().get(i).getBound())) {
                hasCollision = true;
            }
        }

        for (int i = 0; i < road.getCars().size(); i++) {
            if (player.getBound().intersects(road.getCars().get(i).getBound())) {
                hasCollision = true;
            }
        }

        for (int i = 0; i < road.getCars2().size(); i++) {
            if (player.getBound().intersects(road.getCars2().get(i).getBound())) {
                hasCollision = true;
            }
        }
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
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            restart();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}