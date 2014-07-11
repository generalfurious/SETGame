package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Computer extends Thread {

    int min, max;

    Computer(String difficulty) {
        if (difficulty.equals("easy")) {
            min = 20000;
            max = 40000;
        } else if (difficulty.equals("normal")) {
            min = 10000;
            max = 20000;
        }
    }

    public void run() {
        while (true) {
            try {
                int random = new Random().nextInt(max - min) + min;
                sleep(random);
                ArrayList<Card> found = Deck.findSet();
                JOptionPane.showMessageDialog(null,"The Computer has found a Set!");
//                Design.setBorder(found);
                sleep(3000);
                Deck.replaceCards(found);
            } catch (InterruptedException ex) {
                Logger.getLogger(Computer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
