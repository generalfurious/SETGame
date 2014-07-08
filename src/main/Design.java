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
import com.sun.glass.ui.MenuBar;
import com.sun.java.accessibility.AccessBridge;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Design extends JFrame implements Runnable{
///Klassen ID

    private static final long serialVersionUID = 1L;

///Klassenattribute
    public ArrayList<MyJPanels> JPanelList = new ArrayList<>();
    public ArrayList<Icon> IconList = new ArrayList<>();
    public ArrayList<Card> clicked = new ArrayList<>();
    public ArrayList<MyJPanels> cards = new ArrayList<>();      //Speichert die geklickten JPanels, siehe in Mouslistener
    
    public static final int PANEL_WIDTH  = 125; 
    public static final int PANEL_HEIGHT = 230;

    private JScrollPane scrollPane = null;      //
    private JPanel container  = null;
    

    private int zahler = 0;                      //#3
    public int x_Achse = 5;			//#4
    public int y_Achse = 5;			//#5
    private int number;
    private int von = 1;
    private int bis = 3;
    int size;
    
    
  //Menubar reference variables declaration
    JMenuBar menuBar  = null;
    JMenu menuFile    = null;
    JMenu menuHelp    = null;
    JMenu menuFileNew = null;
    
    //Submenu reference variable declaration
    JMenuItem menuItemFileLoad   = null;
    JMenuItem menuItemFileSave   = null;
    JMenuItem menuItemFileExit   = null;
    
    JMenuItem menuItemHelpShowManual = null;
    
///Standardkonsruktor	
    public Design() throws InterruptedException {
    ///JFrame ... (1)
        //main frame
        super("Set");
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(700, 720);									//setSize(Width,Height); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        this.container = new JPanel();
      
    ///Menüleiste
      menuBar = new JMenuBar();
        //Hinzufügen von Menüs
        menuFile = new JMenu("File");
	menuHelp = new JMenu("Help");
	
      menuBar.add(menuFile);
      menuBar.add(menuHelp);
      
      
      //Add menu entries into in FileMenu
      menuItemFileSave       = new JMenuItem("Save");
      menuItemFileLoad       = new JMenuItem("Load");
      menuItemFileExit       = new JMenuItem("Exit");
      menuItemHelpShowManual = new JMenuItem("Show Manual");
      
      //registry by FileListener
      menuItemFileSave.addActionListener(new MenuBarListener());
      
      
      menuFile.add(menuItemFileLoad);
      menuFile.add(menuItemFileSave);
      menuFile.add(menuItemFileExit);
      menuHelp.add(menuItemHelpShowManual);
      
      
        
    ///JPanel ...
        //Hier werden JPanels erstellt und gleichzeit an MausListener registriert
        this.createJPanels();
    
    ///JFrame ... (2)    
        //JPanels is adding in the following Method
        this.showCards();

        //this.setTime();   //Zeigt die Uhrzeit an,
        
        
        
        
        
    }//Konstruktor wird geschlossen



///Klassen Methoden	
    public void createJPanels() {
        for (int i = 0; i <= Deck.displayed.size(); i++) {
            
            JPanelList.add(new MyJPanels("panel " +i));
            JPanelList.get(i).addMouseListener(new MausListener());
            
        }
    }

    public void showCards() throws InterruptedException {

        for (int i = 0; i < Deck.displayed.size(); i++) {
                                                                           //i < 4 1.Zeile
            size = Deck.displayed.size()/3;
            if (i >= size && i < size *2) {                                //2. Zeile
                if (i == size) {
                    this.setXAchseDefault();
                }
                this.y_Achse = 240;
            } else if (i >= size*2 && i < Deck.displayed.size()) {         //3.Zeile
                if (i == size*2) {
                    this.setXAchseDefault();
                }
                this.y_Achse = 475;
            }
            
            //JPanelList.get(i).set
            JPanelList.get(i).setBounds(x_Achse, y_Achse, this.PANEL_WIDTH, this.PANEL_HEIGHT);
            JPanelList.get(i).setBackground(Color.WHITE);
            JPanelList.get(i).setBorder(null);
            
            number = Integer.parseInt(Deck.displayed.get(i).getNumber());
            
            switch (number) {
                case 1:
                    JPanelList.get(i).setInto(new JLabel(new ImageIcon(Deck.displayed.get(i).getIcon())));
                    break;
                case 2:
                    JPanelList.get(i).setInto(new JLabel(new ImageIcon(Deck.displayed.get(i).getIcon())),number);
                    JPanelList.get(i).setInto(new JLabel(new ImageIcon(Deck.displayed.get(i).getIcon())),number);
                    break;
                case 3:
                    JPanelList.get(i).setInto(new JLabel(new ImageIcon(Deck.displayed.get(i).getIcon())),number);
                    JPanelList.get(i).setInto(new JLabel(new ImageIcon(Deck.displayed.get(i).getIcon())),number);
                    JPanelList.get(i).setInto(new JLabel(new ImageIcon(Deck.displayed.get(i).getIcon())),number);
                    break;
            }
            
            x_Achse += 130;														//#6
           
        //Add components into Frame    
            this.setJMenuBar(menuBar);
            this.add(JPanelList.get(i));
              

        }//for(int i;...;...) closing
       this.setSize(x_Achse + 15 , this.getHeight());   //Hier wird der JFrame noch einmal je nach Bedarf gezeichnet
       this.repaint();
       
    }//Method closing

    public void setXAchseDefault() {
        x_Achse = 5;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Date d = new Date();
                this.setTitle(d.getHours()+":"+d.getMinutes()+":"+d.getSeconds());
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
            zahler += e.getClickCount();
            st = new StringTokenizer(e.getComponent().getName(), " ");
            
            System.out.println(zahler);
            
            cards.add((MyJPanels) e.getComponent());
            
            while(st.hasMoreTokens()) {
                    try{
                        int a = Integer.parseInt(st.nextToken());

                if(JPanelList.get(a).getBorder() != null){
                    JPanelList.get(a).setBorder(null);
                    clicked.remove(Deck.displayed.get(a));
                }else{
                    JPanelList.get(a).setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.RED));
                    clicked.add(Deck.displayed.get(a));
                }
                
                        System.out.println("clicked.size(): " +clicked.size());
                 if(clicked.size() %3 == 0 
                         && clicked.get(0) != clicked.get(1) && clicked.get(0) != clicked.get(2)
                         && clicked.get(1) != clicked.get(2)){
                    
                     if(Deck.isSet(clicked.get(0), clicked.get(1), clicked.get(2))){
                        JOptionPane.showMessageDialog(null, "Congratulations! That is a Set");
                        if(Deck.displayed.size()>=12)
                            Deck.removeCards(clicked);
                        else
                            Deck.replaceCards(clicked);
                        //Bei Set werden karten vom Deck gelöscht
                        for(int i = 0; i<clicked.size();i++) {
                            removeCards(clicked.get(i));  
                        }
                        
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "That isn't a Set!");
    //                    clicked.removeAll(clicked);
                           //Karten werden gelöscht
                       
                        
                    }

                  for(int i = 0; i<cards.size();i++) {
                      System.out.println(cards.get(i));
                      cards.get(i).setBorder(null);
                  }
                  
                  clicked.clear();                                          //Diese Zeile löscht nach 3 Objekten die ArrayListe clicked, somit kann man mit der Zeile 177 immer wieder arbeiten
                  cards.clear();
                  zahler = 0;
                 }//if closing
                }catch(Exception ex){}
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
    
        for(int i = 0;i<Deck.displayed.size();i++) {
            
            System.out.println("display: " +Deck.displayed.get(i).getIcon() +" Card: " +a.getIcon());
            
            if(Deck.displayed.get(i).getIcon() == a.getIcon()) {
                 this.remove(JPanelList.get(i));
                 this.repaint();
            }
            
        }
    //        this.remove();
    //        this.repaint();
    }
    
    public  void setBorder(ArrayList<Card> cards) {
        
        for (int i = 0; i < Deck.displayed.size(); i++) {
            if(Deck.displayed.get(i).getIcon() == cards.get(i).getIcon()) {
                JPanelList.get(i).setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.RED));
            }
        }
        
    
    }
    
    private class MenuBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            //Listens to Sub-Menu "Save"
            if(e.getSource() == Design.this.menuItemFileSave) {}
            
            //Listens to Sub-Menu "Load"
            else if(e.getSource() == Design.this.menuItemFileLoad) {}
            
            //Listens to Sub-Menu "Exit"
            else if(e.getSource() == Design.this.menuItemFileExit) {}
            
            //Listens to Sub-Menu "Help-ShowManual"
            else if(e.getSource() == Design.this.menuItemHelpShowManual) {}
            
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
            new Deck();
    }
}
