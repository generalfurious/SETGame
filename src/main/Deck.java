/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.util.ArrayList;

public class Deck {
    ArrayList<Card> deck;
    ArrayList<Card> displayed;
    
    public Deck(){
        deck = new ArrayList<>();
        displayed = new ArrayList<>();
        
        deck.add(new Card(1,2,3,1));
        System.out.println(deck.get(0).getIcon());
        
    
    }
    
    
}
