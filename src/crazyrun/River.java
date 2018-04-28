package crazyrun;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class River {
    private int x;

   
    private int y;
    private int width ;
    private int height;
    private Color riverColor;
    private  ArrayList<Corcodile> corcodiles = new ArrayList<Corcodile>();
    private  ArrayList<Corcodile> corcodiles2 = new ArrayList<Corcodile>();

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
            int randY = rand.nextInt(170)+70;
            Corcodile corcodile = new Corcodile(100 , 20 , randX , randY , new Color(50, 80, 200, 255));
            corcodiles.add(corcodile);
        }
        
        for (int i = 0; i < 3; i++) {
            int randX = rand.nextInt(900);
            int randY = rand.nextInt(170)+70;
            Corcodile corcodile = new Corcodile(100 , 20 , randX , randY , new Color(50, 80, 200, 255));
            corcodiles2.add(corcodile);
        }
        
    }
    
    public void draw(Graphics g){
        g.setColor(getRiverColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
        
        for (int i = 0; i < corcodiles.size(); i++) {
            corcodiles.get(i).draw(g);
        }
        
        for (int j = 0; j < corcodiles2.size(); j++) {
            corcodiles2.get(j).draw(g);
        }
    }
    
    public void Move(){
        
        // moving right
        for (int i = 0; i < corcodiles.size(); i++) {
            if(corcodiles.get(i).getX() + corcodiles.get(i).getWidth() > Game.WIDTH ) {
                corcodiles.get(i).setX(rand.nextInt(1000)- (Game.WIDTH + 500));
                corcodiles.get(i).setxSpeed(0);
            }
            else{
                
                corcodiles.get(i).moveRight(width, height);
            }
            
        }
        
        // moving left
        for (int j = 0; j < corcodiles2.size(); j++) {
            if(corcodiles2.get(j).getX() + corcodiles2.get(j).getWidth() < Game.WIDTH - Game.WIDTH ) {
                corcodiles2.get(j).setX(Game.WIDTH + corcodiles2.get(j).getWidth());
                corcodiles2.get(j).setxSpeed(0);
            }
            else{
                
                corcodiles2.get(j).moveLeft(width, height);
            }
            
        }
    }
    
}
