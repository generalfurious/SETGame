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
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Design extends JFrame {
///Klassen ID
    private static final long serialVersionUID = 1L;

///Klassenattribute
    private ArrayList<MyJPanels> JPanelList = new ArrayList<>();			
    private ArrayList<Card> clickedList     = new ArrayList<>();
    private ArrayList<Player> playerList    = new ArrayList<>();
    
    private Player player 		   		   = null;

    //JPanel metrics
    public static final int PANEL_WIDTH  = 125;
    public static final int PANEL_HEIGHT = 230;
    
    private int x_Achse = 0;						
    private int y_Achse = 0;		
    private int size    = 0;
    private int number  = 0;
   
    //JMenubar reference variables declaration
    private JMenuBar menuBar = null;
    private JMenu menuFile   = null;

    //Submenu (of JMenuBar) reference variable declaration
    private JMenuItem menuItemFileLoad = null;
    private JMenuItem menuItemFileSave = null;
    private JMenuItem menuItemFileExit = null;
    
    private JFileChooser fileChooser    = null;

    private boolean computer            = false;
    
///Standardkonsruktor	
    public Design() throws InterruptedException {
    	
  ///JFrame ... (1)
        //main frame
    	super("Set");
        this.setJFrame();
    	
   ///MenüLeiste
        this.setJMenuBar();

  ///JFrame ... (2)    
        this.showCards();
        
    }//Constructor

///Klassen Methoden	
    
    //Create a JMenuBar 
    public void setJMenuBar() {
 	   menuBar = new JMenuBar();
        //Hinzufügen von Menüs
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
 }//addJMenuBar
    
    //Create severeal JPanels and registriy them to the MouseListener
    public void createJPanels() {
    	
    	//For the first invokation irrelevant
    	if(JPanelList.size() != 0) {
    		JPanelList.clear();
    	}
    	
        for (int i = 0; i <= Deck.displayed.size(); i++) {
            JPanelList.add(new MyJPanels("panel " + i));
            JPanelList.get(i).addMouseListener(new MausListener());
        }
    } //createPanels 

    //Remove cards from the JFrame (which are visible for the user)
    public void removeCards(Card a) {
    	
    	//Deck.displayed:= ArrayList<Card> contents the cards which are shown
    	//respective card removing from the JPanelList
        for (int i = 0; i < Deck.displayed.size(); i++) {

            if (Deck.displayed.get(i).getIcon() == a.getIcon()) {
                this.remove(JPanelList.get(i));
                this.repaint();
            }
        }
    }//removeCards

    //Sets a Red Border to the respective JPanel which are choosen by the user
    //The respective (choosen) JPanel will become a Red frame
    public void setBorder(ArrayList<Card> cards) {

    //The respective JPanel will be identify with the card object "cards" which is delivered as a parameter
        for (int i = 0; i < Deck.displayed.size(); i++) {
            if (Deck.displayed.get(i).getIcon() == cards.get(i).getIcon()) {
                JPanelList.get(i).setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
            }
        }
    }//setBorder
    
    //Cards will be display on the jframe
    public void showCards() throws InterruptedException {
       
    	//this for loop removes all JPanels	from the JPanelList (so lang as JPanelList isn't empty)
    	if(JPanelList.size() != 0) {
    		for(int i=0; i<JPanelList.size();i++){
                this.remove(JPanelList.get(i));
    		}
    	}
    	
    	//Creates JPanels 
    	this.createJPanels();
        
        //Values of JPanel axis
        this.x_Achse = 15;
        this.y_Achse = 5;
        
        for (int i = 0; i < Deck.displayed.size(); i++) {
        																	//i < 4 1.Zeile
            size = Deck.displayed.size() / 3;
            if (i >= size && i < size * 2) {                                //second line
                if (i == size) {
                    this.setXAchseDefault();								//first position from the respective line therefore we have to set the value of the x-axis to default
                }
                this.y_Achse = 240;
            } else if (i >= size * 2 && i < Deck.displayed.size()) {         //third line
                if (i == size * 2) {
                    this.setXAchseDefault();								//same like line 181
                }
                this.y_Achse = 475;
            }

            //JPanel properties
            JPanelList.get(i).setBounds(x_Achse, y_Achse, Design.PANEL_WIDTH, Design.PANEL_HEIGHT);
            JPanelList.get(i).setBackground(Color.WHITE);
            JPanelList.get(i).setBorder(null);
            
            //number == amount of "symbols" of a respective card in the ArrayList "displayed"
            number = Integer.parseInt(Deck.displayed.get(i).getNumber());
            
            //To each JPanel which are in the ArrayList "JPanelList" will add of the amount of "number" Card Symbols 
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
            //Position of JPanels on the X-Axis
            x_Achse += 130;

            //Add components into Frame    
            this.setJMenuBar(menuBar);
            //Add JPanel into JFrame
            this.add(JPanelList.get(i));
            
        }//for(int i;...;...) closing
        
        //Here the JFrame is drawn once more as needed
        this.setSize(x_Achse + 15, this.getHeight());  
        this.validate();
        this.repaint();

        //prophibits any activity within the frame
        this.setEnabled(false);
    }//showCards
    
    //This method will be invoke, if an user/player click the "SET" button
    public void setPlayer(Player obj){
    	//obj refer to User which press the "SET" button
        player = obj;
        
        if(player != null) {
        	//if a user/player press the "SET" button, afterward he is permitted to operate the frame
        	this.setEnabled(true);
        }
       //sets the visibilty of the  "SET" button from the other players to enable
       this.setSETButtonVisible(obj, false);
        
    }//setPlayer
    
    //sets the computer
    //adjust the enability of the frame
    public void setComputer() {
        computer = true;
        if (computer != false) {
            this.setEnabled(true);
        }
    }//setComputer
    
    
    //getter
    public Player getPlayer() {
        return player;
    }//getPlayer
    
    //JFrame properties
    public void setJFrame() {
        this.setLayout(null);
        this.setFocusable(true);											
        this.getContentPane().setBackground(new Color(0,130,0));			//new Color == Green current background color
        this.setUndecorated(true);											//frame from the Jframe is not more visible
        this.setVisible(true);
        this.setSize(700, 725);									
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);				
        this.setLocationRelativeTo(null);
    }//setJFrame
    
    //Important for the JPanel position
    public void setXAchseDefault() {
        x_Achse = 15;
    }//setXAchseDefault

    //for ALL(has the amount which are the amount of current players) "SET" buttons
    public void setSETButtonVisible(boolean status) {
    	for(int i = 0; i<playerList.size();i++) {
        	playerList.get(i).set.setEnabled(status);
        }
    }//setSetButtonVisible 
    
    //Overloading Method
    public void setSETButtonVisible(Player player, boolean status) {
    	//all player buttons except the button of the parameter player
    	for(int i = 0; i<playerList.size();i++) {
        	if(playerList.get(i) != player) {
        		playerList.get(i).set.setEnabled(status);
        	}
        }
    }//setSetButtonVisible 

    //Important for the "SET" button/s
    public void setPlayerList(ArrayList<Player> playerList) {
    	//the number of playerList.size() shows the number of current amount of player/s
    	this.playerList = playerList;
    }//setPlayerList
   

///Innere Klassen, Listener	
    private class MausListener implements MouseListener {

        int count_Wins = 0;
        int count_Lose = 0;
        StringTokenizer st = null;

        @Override
        public void mouseClicked(MouseEvent e) {
        	//JPanels name is from the typ String panel + an int incrementing from 0 up to n
        	//thereby to get the number, we have to seperate the string
            st = new StringTokenizer(e.getComponent().getName(), " ");

            while (st.hasMoreTokens()) {
                try {
                    int a = Integer.parseInt(st.nextToken());

                    if (JPanelList.get(a).getBorder() != null) {
                        JPanelList.get(a).setBorder(null);
                        clickedList.remove(Deck.displayed.get(a));
                    } else {
                        JPanelList.get(a).setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
                        clickedList.add(Deck.displayed.get(a));
                    }

                    if (clickedList.size() == 3) {

                    	//if the cards which is selected by the player is a SET, then execute the if instruction
                        if (Deck.isSet(clickedList.get(0), clickedList.get(1), clickedList.get(2))) {
                            JOptionPane.showMessageDialog(null, "Congratulations! This is a Set");
                            Deck.replaceCards(clickedList);
                            showCards();
                            player.scoreIncrease();
                        //if the cards (...) is not a SET, then execute the else instruction    
                        } else {
                            JOptionPane.showMessageDialog(null, "That isn't a Set!");
                            showCards();
                            player.scoreDecrease();
                        }
                        setSETButtonVisible(true);
                        Design.this.setEnabled(false);					
                        clickedList.clear(); 
                        System.out.println(player.getScore());
                    }//if closing
                } catch (NumberFormatException | HeadlessException ex) {} 
                  catch (InterruptedException ex) {}
            }//while
        }

        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}

    }//MausListener

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
                    } catch (IOException ex) {}
                } 
                
                //Listens to Sub-Menu "Load"
                else if (e.getSource() == menuItemFileLoad) {
                    fileChooser = new JFileChooser();
                    if (fileChooser.showOpenDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
                        try {
                            Game.loadGame(String.valueOf(fileChooser.getSelectedFile()));
                        } catch (IOException | ClassNotFoundException ex) {} 
                          catch (InterruptedException e1) {
							
							e1.printStackTrace();
						}
                    }
                }
                
                //Listens to Sub-Menu "Exit"
                else if (e.getSource() == menuItemFileExit) {
                	System.out.println(e.getSource());
                    System.exit(0);
                } 
            }
        }
    }//MenuBarListener
}//Design
