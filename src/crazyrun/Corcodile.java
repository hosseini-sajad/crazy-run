package crazyrun;

import java.awt.Color;
import java.awt.Graphics;

public class Corcodile {
    
    private int width;
    private int height;
    private Color color;
    private int x;
    private int y;
    private int xSpeed;

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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

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

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public Corcodile(int width , int height , int x , int y , Color color){
        setWidth(width);
        setHeight(height);
        setColor(color);
        setxSpeed(0);
        setX(x);
        setY(y);
    }
    
    public void draw(Graphics g){
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
    
    public void moveRight(int riverWidth , int riverHeight){
           xSpeed += 1;
           x += xSpeed;
    }
    
    public void moveLeft(int riverWidth , int riverHeight){
           xSpeed -= 1;
           x += xSpeed;
    }
    
}



