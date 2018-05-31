package crazyrun;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Game extends JPanel implements ActionListener, KeyListener {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 800;
    public static final int ROAD_HEIGHT = 220;
    public static final int RIVER_HEIGHT = 400;
    public static int score = 0;

    // game font
    Font gameFont = new Font("Press Start 2P", Font.BOLD, 18);

    // game objects
    private Player player;
    private River river;
    private Road road;
    private ArrayList<Gift> gifts = new ArrayList<>();
    private Timer timer;
    public static GameState state = GameState.MENU;
    private boolean play;
    private boolean hasCollision = false;
    private Menu menu;
    private boolean isPaused = false;

    public Game() {
        
        menu = new Menu();
        
        player = new Player(280, 760, 20, 65, Color.WHITE);
        road = new Road(0, 450, WIDTH, ROAD_HEIGHT, Color.decode("#434343"));
        river = new River(0, 70, WIDTH, RIVER_HEIGHT, Color.decode("#008dc7"));
        
        for (int i = 0; i < 3; i++) {
            Gift gift = new Gift((i + 1) * 100, (i + 1) * 200, 30, 30);
            gifts.add(gift);
            play = true;
        }

        timer = new Timer(30, this);
        timer.start();

        setFocusable(true);
        addKeyListener(this);
        addMouseListener(new MouseInput());
    }
    

    public void restart() {
        player = new Player(280, 760, 20, 65, Color.WHITE);
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

        if (state == GameState.GAME) {
            // ----------game design---------------------
            setBackground(Color.WHITE);

            road.draw(g);
            river.draw(g);
            //player.draw(g);
            for (Gift gift : gifts) {
                gift.draw(g);
            }

            // ----------score design----------------------
            g.setColor(Color.decode("#40ECFF"));
            g.fillRect(0, 0, WIDTH, 70);

            g.setColor(Color.BLACK);
            g.setFont(gameFont);
            g.drawString("Score: " + score, 10, 48);
            
            //grass
            g.setColor(Color.yellow);
            g.fillRect(0, HEIGHT - 150, WIDTH, 120);
            URL grass = getClass().getClassLoader().getResource("grass.png");
            ImageIcon grassIcon = new ImageIcon(grass);
            Image grassImage = grassIcon.getImage();
            g.drawImage(grassImage, 0, HEIGHT - 150 , WIDTH, 120, null);

            // start place image
            URL startSign = getClass().getClassLoader().getResource("natureWithBridge2.png");
            ImageIcon startIcon = new ImageIcon(startSign);
            Image startImage = startIcon.getImage();
            g.drawImage(startImage, 0, HEIGHT - 100, 600, 100, null);
            // after collision start place should be darker
            
            if (!play) {
                g.setColor(new Color(0, 0, 0, 110));
                g.fillRect(0, HEIGHT - 100, WIDTH, 100);
            }
            player.draw(g);
            //player loses
            if (hasCollision) {
                play = false;

                g.setColor(new Color(0, 0, 0, 170));
                g.fillRect(0, 0, WIDTH, HEIGHT);

                g.setColor(Color.RED);
                g.setFont(new Font("Oswald", Font.BOLD, 62));
                g.drawString("Game Over!", 165, HEIGHT / 2 - 35);

                g.setColor(Color.WHITE);
                g.setFont(new Font("tahoma", Font.BOLD, 22));
                g.drawString("Your Score : " + score, 225, HEIGHT / 2);

                g.setFont(new Font("tahoma", Font.BOLD, 20));
                g.drawString("Please press ENTER key to restart...", 145, HEIGHT / 2 + 29);
            }

            //player wins
            if (player.getY() + player.getPlayerHeight() < 210) {
                play = false;
                g.setColor(new Color(0, 0, 0, 110));
                g.fillRect(0, 0, WIDTH, HEIGHT);

                g.setColor(Color.decode("#00ff00"));
                g.setFont(new Font("Oswald", Font.BOLD, 64));
                g.drawString("You Won!", 185, HEIGHT / 2 - 35);

                g.setColor(Color.WHITE);
                g.setFont(new Font("tahoma", Font.BOLD, 22));
                g.drawString("Your Score : " + score, 225, HEIGHT / 2);

                g.setFont(new Font("tahoma", Font.BOLD, 20));
                g.drawString("Please press ENTER key to restart...", 145, HEIGHT / 2 + 29);

            }
            
            // paused
            if (isPaused) {
                g.setColor(new Color(0, 0, 0, 170));
                g.fillRect(0, 0, WIDTH, HEIGHT);

                g.setColor(Color.WHITE);
                g.setFont(new Font("Oswald", Font.BOLD, 62));
                g.drawString("Paused!", 205, HEIGHT / 2 - 35);
            }
            
            
        }
        
        else if(state == GameState.MENU){
            setBackground(Color.GRAY);
            menu.render(g);
        }

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

    public void collisionDetection() {
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
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.moveUp();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.moveDown();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.moveRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER && !play) {
            restart();
        }
        if(e.getKeyCode() == KeyEvent.VK_M){
            Game.state = GameState.MENU;
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE && !isPaused && play){

            isPaused = true;
            
            for (int i = 0; i < road.getCars().size(); i++) {
                road.getCars().get(i).setxSpeedRight(0);
            }
            for (int j = 0; j < road.getCars2().size(); j++) {
                road.getCars2().get(j).setxSpeedLeft(0);
            }
            for (int i = 0; i < river.getCorcodiles().size(); i++) {
                river.getCorcodiles().get(i).setxSpeed(0);
            }
            for (int j = 0; j < river.getCorcodiles2().size(); j++) {
                river.getCorcodiles2().get(j).setxSpeed(0);
            }
            
            player.setxSpeed(0);
            player.setySpeed(0);
            
        }
        if(e.getKeyCode() == KeyEvent.VK_P && isPaused){
            
            isPaused = false;
            
            for (int i = 0; i < road.getCars().size(); i++) {
                road.getCars().get(i).setxSpeedRight(10);
            }
            for (int j = 0; j < road.getCars2().size(); j++) {
                road.getCars2().get(j).setxSpeedLeft(10);
            }
            for (int i = 0; i < river.getCorcodiles().size(); i++) {
                river.getCorcodiles().get(i).setxSpeed(5);
            }
            for (int j = 0; j < river.getCorcodiles2().size(); j++) {
                river.getCorcodiles2().get(j).setxSpeed(5);
            }
            
            player.setxSpeed(10);
            player.setySpeed(10);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
