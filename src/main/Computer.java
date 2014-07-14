package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Computer extends Thread { // Class for the computer function, inherits Thread Class

    int min, max; // will be used in the random function
    static int score, difficulty; 
    Design design;

    Computer(String difficulty, Design obj) {
        design = obj;
        if (difficulty.equals("easy")) {
            min = 20000; // 20 seconds
            max = 40000; // 40 seconds
            this.difficulty = 1;
        } else if (difficulty.equals("normal")) {
            min = 10000; // 10 seconds
            max = 20000; // 20 seconds
            this.difficulty = 2;
        }
    }

    public void run() {
        while (true) {
            try {
                int random = new Random().nextInt(max - min) + min;
                sleep(random); // wait until a random time with min<= time <=max
                if(design.getPlayer() == null){
                    ArrayList<Card> found = Deck.findSet(); 
                    JOptionPane.showMessageDialog(null,"The Computer has found a Set!");
                    design.setComputer(); // tell the design class that a computer now needs access to the cards
                    design.setBorder(found); // show the set
                    design.setSETButtonVisible(false); // disable SET-Button of the player
                    score++; 
                    sleep(3000); //wait 3 seconds
                    Deck.replaceCards(found);
                    design.setSETButtonVisible(true); // enable the SET-Buton of the player
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

    public static void setScore(int score) { // used for the loadGame() function
        Computer.score = score;
    }
    
}
