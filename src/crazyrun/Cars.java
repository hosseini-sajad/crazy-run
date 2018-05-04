package crazyrun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Cars {
    private double x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private double xSpeed;
    private int xSpeedLeft = 8;
    private int xSpeedRight = 8;

    public Cars(int x, int y, int width, int height, Color color) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setColor(color);
        setxSpeed(0);
    }

    public double getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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

    public int getxSpeedLeft() {
        return xSpeedLeft;
    }

    public void setxSpeedLeft(int xSpeedLeft) {
        this.xSpeedLeft = xSpeedLeft;
    }

    public int getxSpeedRight() {
        return xSpeedRight;
    }

    public void setxSpeedRight(int xSpeedRight) {
        this.xSpeedRight = xSpeedRight;
    }
    
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect((int) getX(), getY(), getWidth(), getHeight());
    }
    
    public void moveRight(int gameWidth, int gameHeight) {
        x += getxSpeedRight();
    }
    
    public void moveLeft(int gameWidth, int gameHeight) {
        x -= getxSpeedLeft();
    }
    
    public Rectangle getBound() {
        return new Rectangle((int) getX(), getY(), getWidth(), getHeight());
    }
}
