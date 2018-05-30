package crazyrun;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
    
    public Rectangle playButton = new Rectangle(Game.WIDTH/2 - 95, 250, 200, 50);
    public Rectangle exitButton = new Rectangle(Game.WIDTH/2 - 95, 325, 200, 50);
    
    
    public void render(Graphics g){
        
        Graphics2D g2d = (Graphics2D) g;
        
        Font font = new Font("oswald",Font.BOLD,80);
        g.setColor(Color.white);
        g.setFont(font);
        g.drawString("Crazy Run", Game.WIDTH /2 - 165, 150 );
        
        Font font1 = new Font("tahoma", Font.BOLD, 25);
        g.setFont(font1);
        
        g.drawString("Play", playButton.x + 75, playButton.y + 35);
        g.drawString("Exit", playButton.x + 75, exitButton.y + 35);
        
        g2d.draw(playButton);
        g2d.draw(exitButton);
    }
    
}
