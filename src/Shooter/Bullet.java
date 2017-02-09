package Shooter;

import java.awt.*;

/**
 * Created by Ilya on 01.02.2017.
 */
public class Bullet {

    //FIELDS
    private double x;
    private double y;
    private  int r;

    private Color color;

    private int speed;

    //CONSTRUCTOR
    public Bullet(){

        x = GamePanel.player.getX();
        y =  GamePanel.player.getY();
        r = 2;
        color = Color.WHITE;
        speed = 10;


    }


    //FUNCTIONS
public double getX(){return x;}
    public double getY(){return  y;}
    public int getR(){return r;}


    public boolean remove(){
        if(y < 0){
            return true;
        }
        return false;

    }
    public void update(){

        y -= speed;

    }
    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval((int) x,(int) y, r, 2 * r);



    }

}
