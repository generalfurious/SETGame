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
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    
    public static final int PANEL_WIDTH  = 115; 
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
///Standardkonsruktor	
    public Design() throws InterruptedException {
    ///JFrame ...
        //main frame
        super("Set");
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(700, 725);									//setSize(Width,Height); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        this.container = new JPanel();
      
        JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        

   ///JPanel ...
        //Hier werden JPanels erstellt und gleichzeit an MausListener registriert
        this.createJPanels();
        //JPanels zum Frame hinzufügen
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
            if (i >= size && i < size *2) {              //2. Zeile
                if (i == size) {
                    this.setXAchseDefault();
                }
                this.y_Achse = 240;
            } else if (i >= size*2 && i < Deck.displayed.size()) {      //3.Zeile
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
            
            x_Achse += 120;														//#6
           
            this.container.add(JPanelList.get(i));
            this.scrollPane = new JScrollPane(this.container);
            
            this.add(scrollPane);
            this.add(JPanelList.get(i));
           
                    
            
        }//for(int i;...;...) closing
       this.setSize(x_Achse + 15 , this.getHeight());                       //Hier wird der JFrame noch einmal je nach Bedarf gezeichnet
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
            
            
            System.out.println("Geklickt an Positon, X: " +e.getX() +" Y:" +e.getYOnScreen());
            
            
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
            
             if(clicked.size() == 3){
                if(Deck.isSet(clicked.get(0), clicked.get(1), clicked.get(2))){
                    JOptionPane.showMessageDialog(null, "Congratulations! That is a Set"); 
                    
                    if(Deck.displayed.size()>=12)
                        Deck.removeCards(clicked);
                    else
                        Deck.replaceCards(clicked);
                }else{
                    JOptionPane.showMessageDialog(null, "That isn't a Set!");
//                    clicked.removeAll(clicked);
                }
                
              for(int i = 0; i<cards.size();i++) {
                  System.out.println(cards.get(i));
                  cards.get(i).setBorder(null);
              }
              
              clicked.clear();                                          //Diese Zeile löscht nach 3 Objekten die ArrayListe clicked, somit kann man mit der Zeile 177 immer wieder arbeiten
            }
            }catch(Exception ex){}
            }
            
           
            
        }
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

    public void setTime() {
        Thread t = new Thread(this);
        t.start();
    }
    
    
    public static void main(String[] args) throws InterruptedException {
            new Deck();
    }
}
