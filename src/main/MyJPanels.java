package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MyJPanels extends JPanel {

///Class ID	
	private static final long serialVersionUID = 1L;

///Class- Attributes	
	private String name = null;
	private int counter = 0;
	
/// Constructor               
	public MyJPanels(String name) {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(100,50));
        this.name = name;
    }
    
	//getter
    public String getName(){
        return this.name;
    }    

    //Overloaded method
    //Add one label into JPanel label includes one symbol
    public void setInto(JLabel label) {
        this.setLayout(new BorderLayout());
        this.add(label,BorderLayout.CENTER);
        this.validate();
    }
    
    //Overloaded Method
    public void setInto(JLabel label, int number, Card card) {
        
    	int pos_x_axis = (int) Math.sqrt(Design.PANEL_WIDTH) /3;				//X-Achsen Koordiante
    	int pos_y_axis =  Design.PANEL_HEIGHT / 4;								//Y-Achsen Koordinate
    	
    	//counter == amount of labels or line number of respective symbol
    	this.counter+=1;			
    	
    	if(card.getSymbol().equals("Hexagon")) {
    		Card.height = 68;
    		
    		if(number == 2) {							//2 Zeilen bzw. 2 Labels sollen angezeigt werden
    			if(this.counter == 1) {
    				this.setLayout(null);
    			}
    			else if(this.counter == 2) {
    				pos_y_axis+=Card.height;
    			}
    		}
    		else{
    		}															
    	}//H E X A G O N
    	
    	else if(card.getSymbol().equals("Oval")) {
    		Card.height = 42;
    		pos_x_axis +=10;
    		
    		if(number == 2) {
    			if(this.counter == 1) {
    				this.setLayout(null);
    				pos_y_axis+=25;
    			}
    			else if(this.counter == 2) {
    				pos_y_axis+=65;
    			}
    		}
    		else {
    			if(this.counter == 1) {
    				this.setLayout(null);
    				pos_y_axis+=5;
    			}
    			else if(this.counter == 2) {
    				pos_y_axis+=Card.height+5;
    			}
    			else {
    				pos_y_axis +=Card.height+45;
    			}
    		}
        }//O V A L

    	else if(card.getSymbol().equals("Rectangle")) {
    		Card.height = 35;
    		pos_x_axis +=10;
    		if(number == 2) {
    			if(this.counter == 1) {
    				this.setLayout(null);
    				pos_y_axis+=25;
    			}
    			else if(this.counter == 2) {
    				pos_y_axis+=(Card.height+30);
    			}
    		}
    		else {
    			if(this.counter == 1) {
    				this.setLayout(null);
    				pos_y_axis+=5;
    			}
    			else if(this.counter == 2) {
    				pos_y_axis+=(Card.height+8);
    			}
    			else if(this.counter == 3) {
    				pos_y_axis+=(Card.height*2+11);
    			}
    		}
    	}//RECTANGLE
    	
    	else if(card.getSymbol().equals("Wave")) {
    		pos_x_axis+=8;
    		Card.height = 58;
    		if(number == 2) {
    			if(this.counter == 1) {
    				this.setLayout(null);
    				pos_y_axis+=10;
    			}
    			else if(this.counter == 2) {
    				pos_y_axis+=65;
    			}
    		}
    		else {
    			if(this.counter == 1) {
    				this.setLayout(null);
    				pos_y_axis=20;
    			}
    			else if(this.counter == 2) {
    				pos_y_axis+=20;
    			}
    			else {
    				pos_y_axis +=Card.height+22;
    			}
    		}
    	}//W A V E
    	
    	else if(card.getSymbol().equals("Heart")) {
    		Card.height = 60;
    		pos_x_axis+=8;
    		//2 labels
    		if(number == 2) {
    			if(this.counter == 1) {
    				this.setLayout(null);
    				pos_y_axis+=5;
    			}
    			else if(this.counter == 2) {
    				pos_y_axis+=Card.height+15;
    			}
    		}
    		//3 labels
    		else {
    			if(this.counter == 1) {
    				this.setLayout(null);
    				pos_y_axis = 18;
    			}
    			else if(this.counter == 2) {
    				pos_y_axis += 30;
    			}
    			else {
    				pos_y_axis += Card.height+35;
    			}
    		}
    	}//H E A R T
    	
    	else if(card.getSymbol().equals("Star")){
    		Card.height = 75;
    		pos_x_axis+=8;
    		if(number == 2) {
    			if(this.counter == 1) {
    				this.setLayout(null);
    				pos_y_axis-=10;
    			}
    			else if(this.counter == 2) {
    				pos_y_axis+= Card.height-10;
    			}
    		}
    		else if(number == 3) {
   			 	this.add(label, BorderLayout.CENTER);
    		}
    	}//S T A R
    	
    		label.setSize((Card.average_width) ,(Card.height));
	        label.setLocation(pos_x_axis, pos_y_axis);     
	        this.add(label);
	        this.validate(); 
    }
}

