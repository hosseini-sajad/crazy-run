package crazyrun;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Road {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color; 

    
    private ArrayList<Cars> cars = new ArrayList<>();
    private ArrayList<Cars> cars2 = new ArrayList<>();

    public Road(int x, int y, int width, int height, Color color) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setColor(color);
        
        
            for (int i = 0; i < 3; i++) {
                Cars car = new Cars(new Random().nextInt(590)
                        , new Random().nextInt((Game.HEIGHT - 280) - 470) + 470
                        , new Random().nextInt(80 - 30) + 30
                        , 20
                        , Color.orange);
                
                cars.add(car);
            }
                for (int j = 0; j < 3; j++) {
                    Cars car2 = new Cars(new Random().nextInt(590)
                            , new Random().nextInt((Game.HEIGHT - 180) - (Game.HEIGHT - 230)) + 570
                            , new Random().nextInt(80 - 30) + 30
                            , 20
                            , Color.orange);
                    
                    cars2.add(car2);
                }
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

    public ArrayList<Cars> getCars() {
        return cars;
    }

    public ArrayList<Cars> getCars2() {
        return cars2;
    }
    
    public void draw(Graphics g) {
        // draw road
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
        
        //draw two line side of road
        g.setColor(Color.white);
        g.fillRect(getX(), Game.HEIGHT - 340, Game.WIDTH, 10);
        g.fillRect(getX(), Game.HEIGHT - 150, Game.WIDTH, 10);
        
        //draw the middle line of road
            g.fillRect(getX(), Game.HEIGHT - 250, Game.WIDTH, 10);
        
        //draw cars
        int i = 0;
        for (Cars car : cars) {
            car.draw(g);
            i++;
        }
        
        int j = 0;
        for (Cars car : cars2) {
            car.draw(g);
            j++;
        }
    }
    
    public void move() {
        //check if cars went out of page remove it and back with new (x)
        int i = 0;
        for (Cars car : cars) {
            if(car.getX() + car.getWidth() > Game.WIDTH) {
                cars.remove(this);
                car.setX(-100);
                car.setxSpeed(0);
            }
            car.moveRight(Game.WIDTH, Game.HEIGHT);
            i++;
        }

        //check if cars went out of page remove it and back with new (x)
        int j = 0;
        for (Cars car : cars2) {
            if (car.getX() + car.getWidth() < 0) {
                cars2.remove(this);
                car.setX(700);
                car.setxSpeed(0);
            }
            car.moveLeft(Game.WIDTH, Game.HEIGHT);
            j++;
        }
    }
}
