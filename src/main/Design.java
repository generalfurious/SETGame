package main;

/*
 * Author: Ramazan Cinardere
 */
/**
 * K O M M E N T A R E (#...)
 *
 * #1: #2:
 *
 *
 */
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Design extends JFrame {
///Klassen ID

    private static final long serialVersionUID = 1L;

///Klassenattribute
    private ArrayList<JPanel> JPanelList = new ArrayList<>();
    private ArrayList<Icon> IconList = new ArrayList<Icon>();
    private ArrayList<String> pathesList;
    private ArrayList<Card> JPClickedList = new ArrayList<Card>();
    
    private final int X = 50;			//#1
    private final int Y = 50;			//#2

    JFrame frame_player1 = null;
    JFrame frame_player2 = null;

    JLabel label1 = null;
    JLabel label2 = null;
    JLabel label3 = null;

    int zahler = 0;                             //#3
    private int x_Achse = 5;			//#4
    private int y_Achse = 5;			//#5
    int number;

///Standardkonsruktor	
    public Design() throws InterruptedException {
        ///JFrame ...
        //main frame
        super("Set");
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(700, 725);									//setSize(Width,Height); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);
        this.setFocusable(true);

        //frame_player1
        this.frame_player1 = new JFrame();
        this.frame_player1.setSize(50, 50);
        this.frame_player1.setLocation(10, 10);
        this.frame_player1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.frame_player1.setVisible(true);

        ///JPanel ...
        //Hier werden JPanels erstellt und gleichzeit an MausListener registriert
        this.createJPanels();
        //JPanels zum Frame hinzufügen

        this.showCards();

    }//Konstruktor wird geschlossen


///Klassen Methoden	
    public void createJPanels() {
        for (int i = 0; i <= 12; i++) {
            JPanelList.add(i, new JPanel());
            JPanelList.get(i).setName("panel " + i);
            JPanelList.get(i).addMouseListener(new MausListener());
        }
    }

    public void showCards() throws InterruptedException {

        Random r;
        int von = 0, bis = 90;
        int zahl, tmp;

        for (int i = 0; i < 12; i++) {

            if (i >= 4 && i < 8) {
                if (i == 4) {
                    this.setXAchseDefault();
                }
                this.y_Achse = 230;
            } else if (i >= 8 && i < 12) {
                if (i == 8) {
                    this.setXAchseDefault();
                }
                this.y_Achse = 455;
            }

            JPanelList.get(i).setBounds(x_Achse, y_Achse, 100, 220);
            JPanelList.get(i).setBackground(Color.WHITE);
            
            new Deck();
            
           
            
            number = (int) Math.random()*3+1;//Integer.parseInt(Deck.displayed.get(i).getNumber());
            System.out.println(number);
            
            switch (number) {
                case 1:
                    System.out.println("1");
                    JPanelList.get(i).add(new JLabel(new ImageIcon(Deck.displayed.get(i).getIcon())));
                    break;
                case 2:
                    System.out.println("2");
                    JPanelList.get(i).add(new JLabel(new ImageIcon(Deck.displayed.get(i).getIcon())));
                    JPanelList.get(i).add(new JLabel(new ImageIcon(Deck.displayed.get(i).getIcon())));
                    break;
                case 3:
                    System.out.println("3");
                    JPanelList.get(i).add(new JLabel(new ImageIcon(Deck.displayed.get(i).getIcon())));
                    JPanelList.get(i).add(new JLabel(new ImageIcon(Deck.displayed.get(i).getIcon())));
                    JPanelList.get(i).add(new JLabel(new ImageIcon(Deck.displayed.get(i).getIcon())));
                    break;
            }
            
            x_Achse += 105;														//#6

            this.add(JPanelList.get(i));
            this.repaint();
            this.setSize(this.getWidth() +1 , this.getHeight() + 1);
            
        }//for(int i;...;...) closing
    }//Method closing

    public void setXAchseDefault() {
        x_Achse = 5;
    }
    
 

///Innere Klassen, Listener	
    private class MausListener implements MouseListener {
        
        @Override
        public void mouseClicked(MouseEvent e) {
            zahler += e.getClickCount();
            System.out.println(zahler);
                
            System.out.println("Sie haben geklickt: " +e.getComponent().getName());
            System.out.println(JPanelList.get(0));
            //JPClickedList.add( e.getSource());
            
            if (zahler == 4) {
                JDialog d = new JDialog(Design.this);
                d.add(new JLabel("Zu Viele Klicks"));
                d.setLocationRelativeTo(Design.this);
                d.setSize(100, 100);
                d.setVisible(true);
                zahler = 0;
                for(int i = 0; i<JPClickedList.size();i++) {
            //    System.out.println("JPClickedList Index-No: " + i +" Content: " +JPClickedList.get(i).getName());
            }
            }

        Deck.isSet(JPClickedList.get(0), JPClickedList.get(1), JPClickedList.get(2));
        
            
        }//mouseClicked;

        @Override
        public void mouseEntered(MouseEvent arg0) {
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
        }

        @Override
        public void mousePressed(MouseEvent arg0) {
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
        }

    }

    public static void main(String[] args) {

        try {
            new Design();
        } catch (InterruptedException e) {
        }
    }
}
