package main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;

public class Player extends JFrame {

    private int anzahl;
    Player player;
    int score = 0;
    JFrame window;
    JButton set;
    JButton end;
    JLabel sets;
    JLabel zahl;
    Container unten;
    Container oben;
    int playerNumber;
    private Design design = null;
    

    public Player(final int i, final Design design) {
        this.playerNumber = i;
        this.design = design;
        player = this;
        // Frame erstellen
        window = new JFrame("Player " + playerNumber);
        window.setSize(200, 190);
        set = new JButton("SET");
        
        //set.addActionListener(new ButtonL());
        set.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                design.setPlayer(player);
            };
        });
        end = new JButton("End");
        end.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Game.endGame();
            };
        });
        set.setFont(new Font("Lucida Grande", Font.PLAIN, 48));
        set.setPreferredSize(new Dimension(201, 107));
        end.setPreferredSize(new Dimension(75, 29));

        // Label erstellen
        sets = new JLabel("SETs:  ");
        zahl = new JLabel("0");

        // Container erstellen fÃ¼r BorderLayout
        unten = new Container();
        oben = new Container();

        // BorderLayout setzen
        window.setLayout(new BorderLayout());
        unten.setLayout(new BorderLayout());
        oben.setLayout(new BorderLayout());

        // Buttons und Label zum Container hinzufÃ¼gen 
        oben.add(set, BorderLayout.CENTER);
        unten.add(sets, BorderLayout.WEST);
        unten.add(zahl, BorderLayout.CENTER);
        unten.add(end, BorderLayout.EAST);

        // Container zum Fenster hinzufÃ¼gen
        window.add(oben, BorderLayout.NORTH);
        window.add(unten, BorderLayout.SOUTH);

        // Frame ausgeben
        window.setVisible(true);
        if (i == 1) {
            window.setLocation(100, 100);
        } else if (i == 2) {
            window.setLocation(100, 500);
        } else if (i == 3) {
            window.setLocation(1000, 100);
        } else if (i == 4) {
            window.setLocation(1000, 500);
        }
        window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    

    public int getScore() {
        return score;
    }
    
    public void scoreIncrease(){
        score++;
        zahl.setText(String.valueOf(score));
    }
    public void scoreDecrease(){
        score--;
        zahl.setText(String.valueOf(score));
    }
    
    
    
    

//   private class ButtonL implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            
//           Design.setPlayer();
//            
//     
//        }
//
//}

}

