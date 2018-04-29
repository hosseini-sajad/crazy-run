package crazyrun;

import java.awt.Color;
import java.awt.Graphics;

public class Cars {
    private double x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private double xSpeed;

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
    
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect((int) getX(), getY(), getWidth(), getHeight());
    }
    
    public void moveRight(int gameWidth, int gameHeight) {
        xSpeed += 0.2;
        x += getxSpeed();
    }
    
    public void moveLeft(int gameWidth, int gameHeight) {
        xSpeed -= 0.2;
        x += getxSpeed();
    }
}
