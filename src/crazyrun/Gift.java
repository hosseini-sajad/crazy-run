package crazyrun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.swing.ImageIcon;

public class Gift {
    private int x;
    private int y;
    private int width;
    private int height;
    private int position = 1;

    public Gift(int x, int y, int width, int height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setPosition(position);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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

    public void draw(Graphics g) {
           URL giftUrl;
           giftUrl = getClass().getClassLoader().getResource("gift1.png");
           ImageIcon giftIcon = new ImageIcon(giftUrl);
           Image giftImage = giftIcon.getImage();
           if(position == 1)
               g.drawImage(giftImage, getX(), getY(), getWidth(), getHeight(), null);
    }
    
    public Rectangle getBound(){
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
}
