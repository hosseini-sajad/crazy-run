package crazyrun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;
import javax.swing.ImageIcon;

public class Cars {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private double xSpeed;
    private int xSpeedLeft = 8;
    private int xSpeedRight = 8;
    private boolean isRight = true;

    public boolean isIsRight() {
        return isRight;
    }

    public void setIsRight(boolean isRight) {
        this.isRight = isRight;
    }

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
        URL iconUrl;
        if (isRight) {
            iconUrl = getClass().getClassLoader().getResource("sport-carR.png");
        }else{
            iconUrl = getClass().getClassLoader().getResource("sport-carL.png");
        }
            if (iconUrl != null) {
                ImageIcon icon = new ImageIcon(iconUrl);
                Image image = icon.getImage();
                g.drawImage(image, x, y, 100, 50, null);
            } else {
                g.setColor(getColor());
                g.fillRect(getX(), getY(), getWidth(), getHeight());
            }
    }
    
    public void moveRight(int gameWidth, int gameHeight) {
        xSpeed += 0.1;
        x += getxSpeedRight();
    }
    
    public void moveLeft(int gameWidth, int gameHeight) {
        xSpeed += 0.1;
        x -= getxSpeedLeft();
    }
    
    public Rectangle getBound() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
}
