package crazyrun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;
import javax.swing.ImageIcon;

public class Player {

    private int x;
    private int y;
    private int playerWidth;
    private int playerHeight;
    private Color color;
    private int ySpeed = 10;
    private int xSpeed = 10;

    public Player(int x, int y, int width, int height, Color color) {
        setX(x);
        setY(y);
        setPlayerWidth(width);
        setPlayerHeight(height);
        setColor(color);
    }
    
     public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getPlayerWidth() {
        return playerWidth;
    }

    public void setPlayerWidth(int playerWidth) {
        this.playerWidth = playerWidth;
    }

    public int getPlayerHeight() {
        return playerHeight;
    }

    public void setPlayerHeight(int playerHeight) {
        this.playerHeight = playerHeight;
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

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void draw(Graphics g) {

        URL iconUrl;
        iconUrl = getClass().getClassLoader().getResource("player1.png");
        if (iconUrl != null) {
            ImageIcon icon = new ImageIcon(iconUrl);
            Image image = icon.getImage();
            g.drawImage(image, (int) x, y, 20, 65, null);
        } else {
            g.setColor(getColor());
            g.fillRect(getX(), getY(), getPlayerWidth(), getPlayerHeight());
        }

    }

    public Rectangle getBound() {
        return new Rectangle(getX(), getY() + 60, getPlayerWidth(), getPlayerHeight() - 60);
    }

    public void moveUp() {
        if (getY() > 0) {
            y -= ySpeed;
        }
    }

    public void moveDown() {
        if (getY() < Game.HEIGHT && getY() + getPlayerHeight() != Game.HEIGHT) {
            y += ySpeed;
        }
    }

    public void moveLeft() {
        if (getX() > 0) {
            x -= getxSpeed();
        }
    }

    public void moveRight() {
        if (getX() + getPlayerWidth() < Game.WIDTH) {
            x += getxSpeed();
        }
    }

}
