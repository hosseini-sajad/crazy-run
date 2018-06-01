package crazyrun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class Road {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color; 

    
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Car> cars2 = new ArrayList<>();

    public Road(int x, int y, int width, int height, Color color) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setColor(color);
        
            // cars that moving right
            for (int i = 0; i < 3; i++) {
                float r = new Random().nextFloat();
                float g = new Random().nextFloat();
                float b = new Random().nextFloat();
                Car car = new Car(new Random().nextInt(590)
                        , new Random().nextInt(30) + 470
                        , 100
                        , 50
                        , new Color(r, g, b));
                
                cars.add(car);
            }
            // moving left
                for (int j = 0; j < 3; j++) {
                    float r = new Random().nextFloat();
                    float g = new Random().nextFloat();
                    float b = new Random().nextFloat();
                    Car car2 = new Car(new Random().nextInt(590)
                            , new Random().nextInt(30) + 570
                            , 100
                            , 50
                            , new Color(r, g, b));
                    
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

    public ArrayList<Car> getCars() {
        return cars;
    }

    public ArrayList<Car> getCars2() {
        return cars2;
    }
    
    public void draw(Graphics g) {
        URL iconUrl;
        iconUrl = getClass().getClassLoader().getResource("road3.png");
        ImageIcon icon = new ImageIcon(iconUrl);
        Image image = icon.getImage();
        g.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
        
        //draw cars
        for (Car car : cars) {
            car.setIsRight(true);
            car.draw(g);
        }
        
        for (Car car : cars2) {
            car.setIsRight(false);
            car.draw(g);
        }
    }
    
    public void move() {
        //move right
        //check if cars went out of page remove it and back with new (x)
        for (Car car : cars) {
            if(car.getX() > Game.WIDTH) {
                cars.remove(this);
                car.setX(new Random().nextInt(1000) - (Game.WIDTH + 500));
                float r = new Random().nextFloat();
                float g = new Random().nextFloat();
                float b = new Random().nextFloat();
            }
            car.moveRight(Game.WIDTH, Game.HEIGHT);
        }

        //move left
        //check if cars went out of page remove it and back with new (x)
        for (Car car : cars2) {
            if (car.getX() + car.getWidth() < (Game.WIDTH - Game.WIDTH)) {
                cars2.remove(this);
                car.setX(new Random().nextInt(200) + (Game.WIDTH));
                float r = new Random().nextFloat();
                float g = new Random().nextFloat();
                float b = new Random().nextFloat();
            }
            car.moveLeft(Game.WIDTH, Game.HEIGHT);
        }
    }
}