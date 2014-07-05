/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
class MyJPanels extends JPanel {
        
        private String name;
        private int counter = 0;
                
        
        public MyJPanels(String name) {
           // setLayout(new BorderLayout());
            setBackground(Color.WHITE);
            setPreferredSize(new Dimension(100,50));
            this.name = name;
        }
        
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            super.paintComponent(g2);
              g2.setColor(Color.WHITE);
              g2.fillRoundRect(5, 10, 115, 230, 30, 30);
             
        }
        
        public String getName(){
            return this.name;
        }    

        //Überladene Methoden
        public void setInto(JLabel label) {
             
                this.setLayout(new BorderLayout());
                this.add(label,BorderLayout.CENTER);
                this.validate();
        }
        
        public void setInto(JLabel label, int number) {
            
            this.counter+=1;
            
            int pos_x_axis  = (int) Math.sqrt(Design.PANEL_WIDTH) /3;
            int pos_y_axis_upper_area    = Design.PANEL_HEIGHT / 4;
            int pos_y_axis_lower_area    = (Design.PANEL_HEIGHT / 2) + (pos_y_axis_upper_area/2);
            
            if (number == 2) {
                
                if (this.counter == 1) {
                    this.setLayout(null);
                    //this.setLayout(new BorderLayout());
                    //this.add(label,BorderLayout.NORTH);
                    
                    label.setSize((Card.average_width) ,(Card.max_height));
                    label.setLocation(pos_x_axis,pos_y_axis_upper_area);      //Die Wurzel von x ergibt den y-wert /2 damit der wert in der mitte liegen soll
                    this.add(label);
                    this.validate();                    
                   
                    System.out.println(this.getWidth()+" - "+ (int) Math.sqrt(this.getWidth())/2);
                    
                } else if (this.counter == 2) {
                    label.setSize((Card.average_width) ,(Card.max_height));                     
                    label.setLocation(pos_x_axis,pos_y_axis_lower_area);
                    this.add(label);
                    this.validate();
                }
            } else {
                //this.setLayout(new BorderLayout());
                this.add(label, BorderLayout.CENTER);
            }

            
            
        }
    }
    
