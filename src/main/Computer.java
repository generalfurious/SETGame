package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Computer extends Thread {
    Design design;
    int min, max, score=0;
    ArrayList<Card> found;
    
    Computer(Design obj, String difficulty) {
        if (difficulty.equals("easy")) {
            min = 20000;
            max = 40000;
        } else if (difficulty.equals("normal")) {
            min = 10000;
            max = 20000;
        }
        design = obj;
        found = new ArrayList<>();
    }

    public void run() {
        while (true) {
            try {
                int random = new Random().nextInt(max - min) + min;
                sleep(random);
                found.clear();
                found = Deck.findSet();
                if(found.isEmpty())
                    Game.endGame();
                JOptionPane.showMessageDialog(null,"The Computer has found a Set!");
                design.setBorder(found);
                sleep(3000);
                Deck.replaceCards(found);
                score++;
                design.showCards();
            } catch (InterruptedException ex) {
                Logger.getLogger(Computer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
