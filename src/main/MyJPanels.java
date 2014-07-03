/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
class MyJPanels extends JPanel {
        
        private String name;

        
        public MyJPanels(String name) {
            this.name = name;
        }
        
//        public void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            g.setColor(new Color(100,100,155));
//            g.fillRect(1,1,100,100);
//        }
        
        public String getName(){
            return this.name;
        }    

        public void setInto(JLabel label) {
            this.add(label);
        }
    }
    
