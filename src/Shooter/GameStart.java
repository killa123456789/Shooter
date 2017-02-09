package Shooter;

import javax.swing.*;

/**
 * Created by Ilya on 31.01.2017.
 */
public class GameStart {
    public static void main(String[] args) {
        GamePanel panel = new GamePanel();
        JFrame StartFrame = new JFrame("BubbleShooter");
        StartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StartFrame.setContentPane(panel);
        StartFrame.pack();
        StartFrame.setLocationRelativeTo(null);//позиция по центру
        StartFrame.setVisible(true);// фрейм включен
        panel.start();


    }
}
