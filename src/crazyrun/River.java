package crazyrun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class River {
    private int x;
    private int y;
    private int width ;
    private int height;
    private Color riverColor;
    private final ArrayList<Corcodile> corcodiles = new ArrayList<Corcodile>();
    private final ArrayList<Corcodile> corcodiles2 = new ArrayList<Corcodile>();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getRiverColor() {
        return riverColor;
    }

    public void setRiverColor(Color riverColor) {
        this.riverColor = riverColor;
    }

    public ArrayList<Corcodile> getCorcodiles() {
        return corcodiles;
    }
    
    public ArrayList<Corcodile> getCorcodiles2() {
        return corcodiles2;
    }

    // getting random number for corcodile place 
    Random rand = new Random();
    
    public River(int x , int y , int width , int height , Color color){
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setRiverColor(color);
        
        for (int i = 0; i < 3; i++) {
            int randX = rand.nextInt(900);
            int randY = rand.nextInt(120) +  225;
            
            Corcodile corcodile = new Corcodile(100 , 32 , randX , randY , Color.green);
            corcodiles.add(corcodile);
        }
        
        for (int i = 0; i < 3; i++) {
            int randX = rand.nextInt(900);
            int randY = rand.nextInt(120) +  225;
            Corcodile corcodile = new Corcodile(100 , 32 , randX , randY , Color.green);
            corcodiles2.add(corcodile);
        }
        
    }
    
    public void draw(Graphics g){
        URL riverURL;
        riverURL = getClass().getClassLoader().getResource("river3.png");
        ImageIcon riverIcon = new ImageIcon(riverURL);
        Image river = riverIcon.getImage();
        g.drawImage(river, 0, 70, getWidth(), getHeight(), null);
        
        for (int i = 0; i < corcodiles.size(); i++) {
            corcodiles.get(i).setIsRight(true);
            corcodiles.get(i).draw(g);
        }
        
        for (int j = 0; j < corcodiles2.size(); j++) {
            corcodiles2.get(j).setIsRight(false);
            corcodiles2.get(j).draw(g);
        }
    }
    
    public void Move(){
        // moving right
        for (int i = 0; i < corcodiles.size(); i++) {
            
            // change if condition beacause corcodile removed when x + corcodile(width) = gameWidth and its not true.
            // set random Y for corcodile 
            if(corcodiles.get(i).getX() > Game.WIDTH ) {

                corcodiles.get(i).setX(rand.nextInt(1000)- (Game.WIDTH + 500));
                
                // set random Y but it has problem where random number is upper than 200.
                corcodiles.get(i).setY(rand.nextInt(120) +  225);
            }
            else{
                corcodiles.get(i).moveRight(width, height);
            }
            
        }
        
        // moving left
        for (int j = 0; j < corcodiles2.size(); j++) {
            if(corcodiles2.get(j).getX() + corcodiles2.get(j).getWidth() < 0 ) {
                
                corcodiles2.get(j).setX(Game.WIDTH + corcodiles2.get(j).getWidth());
               
                // set random Y but it has problem where random number is upper than 200.
                corcodiles2.get(j).setY(rand.nextInt(120) +  225);
            }
            else{
                 
                corcodiles2.get(j).moveLeft(width, height);
            }
            
        }
    }
    
    public River getBound(){
        return new River (x, y, width, height, riverColor);
    }
    
}
