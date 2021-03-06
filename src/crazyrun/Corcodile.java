package crazyrun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;
import javax.swing.ImageIcon;

public class Corcodile {

    private int width;
    private int height;
    private Color color;
    private int x;
    private int y;
    private int xSpeed = 5;
    private boolean isRight;

    public boolean isIsRight() {
        return isRight;
    }

    public void setIsRight(boolean isRight) {
        this.isRight = isRight;
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

    public Corcodile(int width, int height, int x, int y, Color color) {
        setWidth(width);
        setHeight(height);
        setColor(color);
        setX(x);
        setY(y);
    }

    public void draw(Graphics g) {
        URL iconUrl;
        
        if (isRight) {
            iconUrl = getClass().getClassLoader().getResource("corcodile.png");
        } else {
            iconUrl = getClass().getClassLoader().getResource("corcodile2.png");
        }

        if (iconUrl != null) {
            ImageIcon icon = new ImageIcon(iconUrl);
            Image image = icon.getImage();
            g.drawImage(image, (int) x, y, 100, 32, null);
        } else {
            g.setColor(getColor());
            g.fillRect((int) getX(), getY(), getWidth(), getHeight());
        }

    }

    public void moveRight(int riverWidth, int riverHeight) {
        x += xSpeed;
    }

    public void moveLeft(int riverWidth, int riverHeight) {
        x -= xSpeed;
    }

    public Rectangle getBound() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
}
