package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Computer extends Thread {

    int min, max;
    static int score, difficulty;
    Design design;

    Computer(String difficulty, Design obj) {
        design = obj;
        if (difficulty.equals("easy")) {
            min = 20000;
            max = 40000;
            this.difficulty = 1;
        } else if (difficulty.equals("normal")) {
            min = 10000;
            max = 20000;
            this.difficulty = 2;
        }
    }

    public void run() {
        while (true) {
            try {
                int random = new Random().nextInt(max - min) + min;
                sleep(random);
                if(design.getPlayer() == null){
                    ArrayList<Card> found = Deck.findSet();
                    JOptionPane.showMessageDialog(null,"The Computer has found a Set!");
                    design.setComputer();
                    design.setBorder(found);
                    score++;
                    sleep(3000);
                    Deck.replaceCards(found);
                    design.showCards();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Computer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static int getScore() {
        return score;
    }
    
    public static int getDifficulty(){
        return difficulty;
    }

    public static void setScore(int score) {
        Computer.score = score;
    }
    
    
    
}
