package main;



/*
 * Author: Ramazan Cinardere
 */

/** K O M M E N T A R E (#...)
 * 
 * #1: 
 * #2:
 * 
 * */

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Design extends JFrame{
///Klassen ID
	private static final long serialVersionUID = 1L;
	
///Klassenattribute
	private ArrayList<JPanel> JPanelList =  new ArrayList<>();
	private ArrayList<Icon> IconList = new ArrayList<Icon>();
	private ArrayList<String> pathesList;
	
	private final int X = 50;			//#1
	private final int Y = 50;			//#2
	
	JFrame frame_player1 = null;
	JFrame frame_player2 = null;
	
	JLabel label1 = null;
	JLabel label2 = null;
	JLabel label3 = null;
	
	int zahler = 0;						//#3
	private int x_Achse = 5;			//#4
	private int y_Achse = 5;			//#5
	
	private final String PATH_BLUE   = "C:\\Users\\Asus\\Dropbox\\Lerngruppe (1)\\Java\\SET\\Card_Symbols\\Blue";
	private final String PATH_GREEN  = "C:\\Users\\Asus\\Dropbox\\Lerngruppe (1)\\Java\\SET\\Card_Symbols\\Green";
	private final String PATH_PURPLE = "C:\\Users\\Asus\\Dropbox\\Lerngruppe (1)\\Java\\SET\\Card_Symbols\\Purple";
	private final String PATH_RED    = "C:\\Users\\Asus\\Dropbox\\Lerngruppe (1)\\Java\\SET\\Card_Symbols\\Red";
	private final String PATH_YELLOW = "C:\\Users\\Asus\\Dropbox\\Lerngruppe (1)\\Java\\SET\\Card_Symbols\\Yellow";
	
	
///Standardkonsruktor	
	public Design() throws InterruptedException {
	
	///JFrame ...
		//main frame
		super("Set");
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(700,725);									//setSize(Width,Height); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLocationRelativeTo(null);
		this.setFocusable(true);
		
		//frame_player1
		this.frame_player1 = new JFrame();
		this.frame_player1.setSize(50,50);
		this.frame_player1.setLocation(10, 10);
		this.frame_player1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.frame_player1.setVisible(true);
		
		//frame_player2
		
		
		
	///JLabel ...
		Icon icon = new ImageIcon("C:\\Users\\Asus\\Dropbox\\Lerngruppe (1)\\Java\\SET\\Card_Symbols\\Blue\\heart_blue_empty.png");
		this.label1 = new JLabel(icon);
		this.label2 = new JLabel("JLabel2");
		this.label3 = new JLabel("JLabel3");					
		
		label1.setBounds(225,5,50,50);									//setBounds(x-Achse,y-Achse,Breite,Höhe);
		label1.setForeground(Color.GREEN);	
		
	///JPanel ...
		//Hier werden JPanels erstellt und gleichzeit an MausListener registriert
		this.createJPanels();
		//JPanels zum Frame hinzufügen
		
		this.setIconsOfDirectory();
		this.setJPanelIntoFrame();	
		
		
	}//Konstruktor wird geschlossen

	
///Klassen Methoden	
	public void createJPanels() {
		for(int i = 0; i<=12;i++) {
			JPanelList.add(i,new JPanel());
			JPanelList.get(i).setName("panel " +i);
			JPanelList.get(i).addMouseListener(new MausListener());
		}
	
	}
	
	public void setJPanelIntoFrame() throws InterruptedException {
		
		Random r;
		int von = 0, bis = 90;
		int zahl, tmp;
		
		for(int i = 0; i<12;i++) {
			
			if(i>=4 && i<8) {
				if(i == 4) {this.setXAchseDefault();}
				this.y_Achse = 200;
			}
			else if(i>=8 && i<12) {
				if(i == 8) {this.setXAchseDefault();}
				this.y_Achse = 395;
			}
			
			JPanelList.get(i).setBounds(x_Achse,y_Achse,100,190);
			System.out.println("Breite: "+this.getWidth());
			JPanelList.get(i).setBackground(Color.WHITE);
				
			this.add(JPanelList.get(i));
			this.repaint();
			this.setSize(this.getWidth()+1,this.getHeight()+1);					//JFrame ändert sich je nach Bedarf
			this.validate();
				
			Thread.sleep(500);
			System.out.println(JPanelList.get(i).getName() +" " + JPanelList.get(i).getX());
			
			JPanelList.get(i).add(new JLabel(IconList.get(6)));
//			JPanelList.get(i).add(new JLabel(IconList.get(13)));
//			JPanelList.get(i).add(new JLabel(IconList.get(14)));
			x_Achse+=105;														//#6
			

		}//for(int i;...;...) closing
	}//Method closing
	
	public void setXAchseDefault() {
		x_Achse = 5;
	}
	
	public void setYAchseDefault() {
		y_Achse = 5;
	}
	
	public void setIconsOfDirectory() {
		pathesList = new ArrayList<String>();
		
		File file = null;
		String[] dir = null;
		
	// B L U E	
		file = new File(PATH_BLUE);
		dir = file.list();
		
			for (int i = 0; i < dir.length; i++) {
				IconList.add(new ImageIcon(PATH_BLUE+"\\"+dir[i]));
				pathesList.add(dir[i]);
			}
		
		file = null;
		dir = null;
		
	// G R E E N	
		file = new File(PATH_GREEN);
		dir = file.list();
		
			for (int i = 0; i < dir.length; i++) {
				IconList.add(new ImageIcon(PATH_GREEN+"\\"+dir[i]));
				pathesList.add(dir[i]);
			}
		
		file = null;
		dir = null;
		
	// P U R P L E
		file = new File(PATH_PURPLE);
		dir = file.list();
		
			for (int i = 0; i < dir.length; i++) {
				IconList.add(new ImageIcon(PATH_PURPLE+"\\"+dir[i]));
				pathesList.add(dir[i]);
			}
		
		file = null;
		dir = null;
		
	// R E D
		file = new File(PATH_RED);
		dir = file.list();
		
			for (int i = 0; i < dir.length; i++) {
				IconList.add(new ImageIcon(PATH_RED+"\\"+dir[i]));
				pathesList.add(dir[i]);
			}
		
		file = null;
		dir = null;
		
	// Y E L L O W
		file = new File(PATH_YELLOW);
		dir = file.list();
		
			for (int i = 0; i < dir.length; i++) {
				IconList.add(new ImageIcon(PATH_YELLOW+"\\"+dir[i]));
				pathesList.add(dir[i]);
			}
		
	}
	
	
	
///Innere Klassen, Listener	
	
	private class MausListener implements MouseListener {

		String eins = null;
		String zwei = null;
		String drei = null;
		
		
		@Override
		public void mouseClicked(MouseEvent e) {
			zahler+=e.getClickCount();
			System.out.println(zahler);
			
			if(zahler ==4) {
				JDialog d = new JDialog(Design.this);
				d.add(new JLabel("Zu Viele Klicks"));
				d.setLocationRelativeTo(Design.this);
				d.setSize(100,100);
				d.setVisible(true);
				zahler = 0;
			}
			
		eins = e.getComponent().getName();		
		if(e.getComponent().getName() != eins) {zwei = e.getComponent().getName();}
		if(e.getComponent().getName() != zwei && e.getComponent().getName() != eins) {drei = e.getComponent().getName();}
		
		if(eins != null && zwei != null && drei != null) {System.out.println(eins + " " + zwei + " " +drei);}
		System.out.println(eins);
		System.out.println(zwei);
		System.out.println(drei);
		
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

		try { new Design();
		}catch (InterruptedException e){}
	}
}

