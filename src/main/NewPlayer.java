/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Asus
 */
public class NewPlayer extends JFrame {
    
    private String name;
    private static int zaehler = 0;

    public NewPlayer() {
        super("Player " + (zaehler++));
        
    }

    
    
    public NewPlayer(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
}

class Button extends JButton {
    
    private String frame_Name;
    private static int zaehler = 0;

    public Button(JFrame obj) {
        super();
        setName("SET");
        this.frame_Name = obj.getName();
    }
    
    public String getFrameName() {
        return this.frame_Name;
    }
    
    public String getButtonName() {
        return this.getName();
    }
    

    
}