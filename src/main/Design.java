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
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Design extends JFrame implements Runnable {
///Klassen ID

    private static final long serialVersionUID = 1L;

///Klassenattribute
    public ArrayList<MyJPanels> JPanelList = new ArrayList<>();
    public ArrayList<Icon> IconList = new ArrayList<>();
    public ArrayList<Card> clicked = new ArrayList<>();
    public ArrayList<MyJPanels> cards = new ArrayList<>();      //Speichert die geklickten JPanels, siehe in Mouslistener
    public JFileChooser fileChooser;
    public static Player player;

    public static final int PANEL_WIDTH = 125;
    public static final int PANEL_HEIGHT = 230;

    private JScrollPane scrollPane = null;      //
    private JPanel container = null;

    private int zahler = 0;                      //#3
    public int x_Achse = 5;			//#4
    public int y_Achse = 5;			//#5
    private int number;
    private int von = 1;
    private int bis = 3;
    public int size;

    //Menubar reference variables declaration
    private JMenuBar menuBar = null;
    private JMenu menuFile = null;

    //Submenu reference variable declaration
    private JMenuItem menuItemFileLoad = null;
    private JMenuItem menuItemFileSave = null;
    private JMenuItem menuItemFileExit = null;


///Standardkonsruktor	
    public Design() throws InterruptedException {
        ///JFrame ... (1)
        //main frame
        super("Set");
        this.setLayout(null);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setSize(700, 725);									//setSize(Width,Height); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        this.container = new JPanel();

        ///MenÃ¼leiste
        menuBar = new JMenuBar();
        //HinzufÃ¼gen von MenÃ¼s
        menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F);

        menuBar.add(menuFile);

        //Add menu entries into in FileMenu
        menuItemFileSave = new JMenuItem("Save", KeyEvent.VK_S);
        menuItemFileLoad = new JMenuItem("Load", KeyEvent.VK_L);
        menuItemFileExit = new JMenuItem("Exit", KeyEvent.VK_E);

        //registry by FileListener
        menuItemFileSave.addActionListener(new MenuBarListener());
        menuItemFileLoad.addActionListener(new MenuBarListener());
        menuItemFileExit.addActionListener(new MenuBarListener());

        menuFile.add(menuItemFileSave);
        menuFile.add(menuItemFileLoad);
        menuFile.add(menuItemFileExit);

        ///JPanel ...
        //Hier werden JPanels erstellt und gleichzeit an MausListener registriert
        this.createJPanels();

        ///JFrame ... (2)    
        //JPanels is adding in the following Method
        this.showCards();
        this.setEnabled(false);
        //this.setTime();   //Zeigt die Uhrzeit an,
    }//Konstruktor wird geschlossen

///Klassen Methoden	
    public void createJPanels() {
        
        JPanelList.clear();
        for (int i = 0; i <= Deck.displayed.size(); i++) {

            JPanelList.add(new MyJPanels("panel " + i));
            JPanelList.get(i).addMouseListener(new MausListener());

        }
    }   

    public void showCards() throws InterruptedException {
        for(int i=0; i<JPanelList.size();i++){
            this.remove(JPanelList.get(i));
        }
        createJPanels();
        x_Achse = 5;
        y_Achse = 5;
        for (int i = 0; i < Deck.displayed.size(); i++) {
            //i < 4 1.Zeile
            size = Deck.displayed.size() / 3;
            if (i >= size && i < size * 2) {                                //2. Zeile
                if (i == size) {
                    this.setXAchseDefault();
                }
                this.y_Achse = 240;
            } else if (i >= size * 2 && i < Deck.displayed.size()) {         //3.Zeile
                if (i == size * 2) {
                    this.setXAchseDefault();
                }
                this.y_Achse = 475;
            }

            JPanelList.get(i).setBounds(x_Achse, y_Achse, this.PANEL_WIDTH, this.PANEL_HEIGHT);
            JPanelList.get(i).setBackground(Color.WHITE);
            JPanelList.get(i).setBorder(null);

            number = Integer.parseInt(Deck.displayed.get(i).getNumber());

            switch (number) {
                case 1:
                    JPanelList.get(i).setInto(new JLabel(new ImageIcon(Deck.displayed.get(i).getIcon())));
                    break;
                case 2:
                    JPanelList.get(i).setInto(new JLabel(new ImageIcon(Deck.displayed.get(i).getIcon())), number, Deck.displayed.get(i));
                    JPanelList.get(i).setInto(new JLabel(new ImageIcon(Deck.displayed.get(i).getIcon())), number, Deck.displayed.get(i));
                    break;
                case 3:
                    JPanelList.get(i).setInto(new JLabel(new ImageIcon(Deck.displayed.get(i).getIcon())), number, Deck.displayed.get(i));
                    JPanelList.get(i).setInto(new JLabel(new ImageIcon(Deck.displayed.get(i).getIcon())), number, Deck.displayed.get(i));
                    JPanelList.get(i).setInto(new JLabel(new ImageIcon(Deck.displayed.get(i).getIcon())), number, Deck.displayed.get(i));
                    break;
            }

            x_Achse += 130;														//#6

            //Add components into Frame    
            this.setJMenuBar(menuBar);
            this.add(JPanelList.get(i));
            

        }//for(int i;...;...) closing
        this.setSize(x_Achse + 15, this.getHeight());   //Hier wird der JFrame noch einmal je nach Bedarf gezeichnet
        this.validate();
        this.repaint();

    }//Method closing

    public void setXAchseDefault() {
        x_Achse = 5;
    }

    public void setPlayer(Player obj){
        player = obj;
        if(player != null) {
        	this.setEnabled(true);
        }
        
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                Date d = new Date();
                this.setTitle(d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds());
            } catch (Exception e) {
            }

        }
    }

///Innere Klassen, Listener	
    private class MausListener implements MouseListener {

        int count_Wins = 0;
        int count_Lose = 0;
        StringTokenizer st = null;

        @Override
        public void mouseClicked(MouseEvent e) {
            st = new StringTokenizer(e.getComponent().getName(), " ");

            //cards.add((MyJPanels) e.getComponent());

            while (st.hasMoreTokens()) {
                try {
                    int a = Integer.parseInt(st.nextToken());

                    if (JPanelList.get(a).getBorder() != null) {
                        JPanelList.get(a).setBorder(null);
                        clicked.remove(Deck.displayed.get(a));
                    } else {
                        JPanelList.get(a).setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
                        clicked.add(Deck.displayed.get(a));
                    }

                    if (clicked.size() == 3) {

                        if (Deck.isSet(clicked.get(0), clicked.get(1), clicked.get(2))) {
                            JOptionPane.showMessageDialog(null, "Congratulations! This is a Set");
                            Deck.replaceCards(clicked);
                            showCards();
                            player.scoreIncrease();
                        } else {
                            JOptionPane.showMessageDialog(null, "That isn't a Set!");
                            showCards();
                            player.scoreDecrease();
                        }
                        Design.this.setEnabled(false);
                        clicked.clear(); //Karten werden gelÃ¶scht
                        System.out.println(player.getScore());
                    }//if closing
                } catch (NumberFormatException | HeadlessException ex) {
                } catch (InterruptedException ex) {
                    Logger.getLogger(Design.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

    }

    public void setTime() {
        Thread t = new Thread(this);
        t.start();
    }

    public void removeCards(Card a) {

        for (int i = 0; i < Deck.displayed.size(); i++) {

            System.out.println("display: " + Deck.displayed.get(i).getIcon() + " Card: " + a.getIcon());

            if (Deck.displayed.get(i).getIcon() == a.getIcon()) {
                this.remove(JPanelList.get(i));
                this.repaint();
            }

        }
        //        this.remove();
        //        this.repaint();
    }

    public void setBorder(ArrayList<Card> cards) {

        for (int i = 0; i < Deck.displayed.size(); i++) {
            if (Deck.displayed.get(i).getIcon() == cards.get(i).getIcon()) {
                JPanelList.get(i).setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
            }
        }

    }

    private class MenuBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //Listens to Sub-Menu "Save"
            if (e.getSource() == menuItemFileSave) {
                fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
                    try {
                        Game.saveGame(String.valueOf(fileChooser.getSelectedFile()));
                        // save to file
                    } catch (IOException ex) {
                        Logger.getLogger(Design.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } //Listens to Sub-Menu "Load"
                else if (e.getSource() == menuItemFileLoad) {
                    System.out.println("load");
                    fileChooser = new JFileChooser();
                    if (fileChooser.showOpenDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
                        try {
                            Game.loadGame(String.valueOf(fileChooser.getSelectedFile()));
                            // save to file
                        } catch (IOException | ClassNotFoundException ex) {
                            Logger.getLogger(Design.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } //Listens to Sub-Menu "Exit"
                else if (e.getSource() == menuItemFileExit) {
                	System.out.println(e.getSource());
                    System.exit(0);
                } //Listens to Sub-Menu "Help-ShowManual"
            }
        }
    }
   
    public static void main(String[] args) throws InterruptedException {
    }
}
