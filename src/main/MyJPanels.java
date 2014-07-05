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

        public MyJPanels(String name) {
            setBackground(Color.WHITE);
            setPreferredSize(new Dimension(100,50));
            this.name = name;
        }
        
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            super.paintComponent(g2);
              g2.setColor(Color.WHITE);
              g2.drawRoundRect(30, 30, 100, 50, 30, 30);
              g2.fillRoundRect(30, 30, 100, 50, 30, 30);
             
        }
        
        public String getName(){
            return this.name;
        }    

        public void setInto(JLabel label) {
            this.add(label, BorderLayout.CENTER);
            //this.setVisible(true);
        }
    }
    
