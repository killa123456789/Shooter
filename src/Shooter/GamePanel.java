package Shooter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Ilya on 31.01.2017.
 */
public class GamePanel extends JPanel implements Runnable {

    //FIELD
    public static int WIDTH = 400;
    public static int HEIGHT = 400;

    private Thread thread = new Thread(this);
    private BufferedImage image;
    private Graphics2D g;


    public static GameBack background;
    public static Player player;

    public static ArrayList<Bullet> bullets;
    public static ArrayList<Enemy> enemies;


    //CONSTRUCTOR
    public GamePanel() {
        super();

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);//Ловит фокус
        requestFocus();//Активирует фокус
        addKeyListener(new Listensers());
    }
    //FUNCTIONS

    public void start() {
        thread = new Thread(this);
        thread.start();//Запускает поток

    }

    @Override
    public void run() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//Сглаживание между соседними пикселями


        background = new GameBack();
        player = new Player();
        bullets = new ArrayList<Bullet>();
        enemies = new ArrayList<Enemy>();
        //TODO remove
        enemies.add(new Enemy(1, 1));
        enemies.add(new Enemy(1, 1));

        while (true) { //TODO States


            GameUpdate();// С каждым кругом обновляет данные
            GameRender();
            gameDraw();

            try {
                thread.sleep(33);//TODO FPS
            } catch (InterruptedException e) {
                e.printStackTrace();// Если не засыпает то выдаст исключение
            }

        }
    }


    public void GameUpdate() {//Обновляются данные
        background.update();

        //Player update
        player.update();

        //Bullets Update
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).update();
            boolean remove = bullets.get(i).remove();
            if (remove) {
                bullets.remove(i);
                i--;
            }
        }
        //ENEMIES UPDATE
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).update();
        }
        //BULLETS-ENEMIES COLLIDE
        for (int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i);
            double ex = e.getX();
            double ey = e.getY();

            for (int j = 0; j < bullets.size(); j++) {


                Bullet b = bullets.get(j);
                double bx = b.getX();
                double by = b.getY();
                double dx = ex - bx;
                double dy = ey - by;
                double dist = Math.sqrt(dx * dx + dy * dy);
                if ((int) dist < e.getR() + b.getR()) {
                    e.hit();
                    bullets.remove(j);
                    break;
                }
            }

            boolean remove = e.remove();
            if (remove) {
                enemies.remove(i);
                i--;
            }
        }
    }

    public void GameRender() {
        //Background draw
        background.draw(g);

        //Player draw
        player.draw(g);

        //Bullets draw
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).draw(g);
        }

        //DRAW ENEMY
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).draw(g);
        }

    }

    private void gameDraw() {
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();//Отчистка кэша
    }


}
