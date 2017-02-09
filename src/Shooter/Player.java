package Shooter;

import java.awt.*;

/**
 * Created by Ilya on 01.02.2017.
 */
public class Player {

    //FIELDS
    private double x;
    private double y;
    private int r;
    private int speed;
    private double dx;//Коэффициент смещения
    private double dy;

    private Color color1;
    private Color color2;

    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;

    public static  boolean isFiring;

    //CONSTRUCTOR
    public Player(){
        x =GamePanel.WIDTH / 2;
        y=GamePanel.HEIGHT / 2;

         r = 5;

        speed = 5;
        dx = 0;
        dy = 0;

        color1 = Color.WHITE;

        up = false;
        down = false;
        left = false;
        right = false;
        isFiring = false;
    }


    //FUNCTIONS
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }



    public void update(){

        if(up && y > r){
            dy = -speed;
        }
        if(down && y < GamePanel.HEIGHT - r){
            dy = speed;
        }
        if(left && x >r){
            dx = -speed;
        }
        if(right && x  < GamePanel.WIDTH - r){
            dx = speed;
        }

        if(up && left || up && right || down && left|| down && right ){

            double angle = Math.toRadians(45);
            dy = dy * Math.sin(angle);
            dx = dx * Math.cos(angle);
        }

        y += dy;
        x += dx;

        dy = 0;
        dx = 0;

        if(isFiring){
            GamePanel.bullets.add(new Bullet());
        }

    }

    public void draw(Graphics2D g){
        g.setColor(color1);
        g.fillOval((int)(x - r),(int)(y - r), 2 * r, 2 * r);
        g.setStroke(new BasicStroke(3));//Увеличиваем толщину линии
        g.setColor(color1.darker());
        g.drawOval((int)(x - r),(int)(y - r), 2 * r, 2 * r);
        g.setStroke(new BasicStroke(1));
    }


}
