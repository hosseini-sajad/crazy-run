package crazyrun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {
    private int x;
    private int y;
    private int size;
    private Color color;
    private int xSpeed = 8;

    public Player(int x, int y, int size, Color color) {
        setX(x);
        setY(y);
        setSize(size);
        setColor(color);
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }
    
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getSize(), getSize());
    }
    
    public void moveLeft(){
        if(getX() > 0)
            x -= getxSpeed();
    }
    
    public void moveRight(){
        if(getX() + getSize() < Game.WIDTH)
            x += getxSpeed();
    }
    
    public Rectangle getBound() {
        return new Rectangle(x, y, size, size);
    }
}
