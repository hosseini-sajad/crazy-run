package crazyrun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

    
    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
           int mx = me.getX();
           int my = me.getY();
           
           if(mx > Game.WIDTH/2 - 95 && mx <= Game.WIDTH + 105){
               if(my >= 250 && my <= 300){
                   Game.state = GameState.GAME;
               }
           }
           
           if(mx > Game.WIDTH/2 - 95 && mx <= Game.WIDTH + 105){
               if(my >= 325 && my <= 375 ){
                 System.exit(0);
               }
           }
           
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
