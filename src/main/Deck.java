/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.util.ArrayList;

public class Deck { // Responsible for the deck of cards and the cards which are displayed
    static ArrayList<Card> deck; // All 81 Cards
    static ArrayList<Card> displayed; // The Cards that are shown
    static int random,size;
    
    public Deck(){
        deck = new ArrayList<>();
        displayed = new ArrayList<>();
        size = 81;
        
        createDeck();
        addCards(12); //Create the deck that is going to be displayed
        fillDeck();
        
        System.out.println(displayed.get(0).getIcon());
        
    }
   
    public void createDeck(){    // Create the 81 Cards with each number, shade, symbol and color
        for (int i = 1; i <= 3; i++){
            for (int j = 1; j <= 3; j++){
                for (int k = 1; k <= 3; k++){
                    for (int l = 1; l <= 3; l++){
                        deck.add(new Card (i, j, k, l));
                    }//end of l (color)
                }//end of k (symbol) 
            }//end of j (shade) 
        }//end of i (number) 
        
    }
    

    public static boolean isSetAvailable(){ // Checks if there is a Set
        for(Card a : displayed ){
            for(Card b : displayed) {
                for(Card c : displayed){
                    if(a.equals(b) || a.equals(c) || b.equals(c))
                        continue;
                    if(isSet(a,b,c))
                        return true;
                }
            }
        }
        
        return false;
    }
    
    public static boolean isSet(Card a, Card b, Card c){ // Checks wether these three Cards are a Set
       if(a.getNumber().equals(b.getNumber()) && a.getNumber().equals(c.getNumber())  || !a.getNumber().equals(b.getNumber()) && !a.getNumber().equals(c.getNumber()) && !b.getNumber().equals(c.getNumber()) ){
        if(a.getShade().equals(b.getShade()) && a.getShade().equals(c.getShade())  || !a.getShade().equals(b.getShade()) && !a.getShade().equals(c.getShade()) && !b.getShade().equals(c.getShade()) ){
         if(a.getSymbol().equals(b.getSymbol()) && a.getSymbol().equals(c.getSymbol())  || !a.getSymbol().equals(b.getSymbol()) && !a.getSymbol().equals(c.getSymbol()) && !b.getSymbol().equals(c.getSymbol()) ){
          if(a.getColor().equals(b.getColor()) && a.getColor().equals(c.getColor())  || !a.getColor().equals(b.getColor()) && !a.getColor().equals(c.getColor()) && !b.getColor().equals(c.getColor()) ){
           return true;
          }
         }
        }
       }
       return false;
    }
    
    public static void addCards(int number){ // Add Cards to the displayed deck
        if(size != 0){
            for(int i=0;i<number;i++){ // At the beginning we add 12 Random Cards to this deck
                random = (int) Math.random() * (size+1) ; // Create a random number(0, size+1)
                displayed.add(deck.get(random)); 
                deck.remove(random); // Take this card from the original deck
                size--; // Decrement the size of the original deck
            }
        }
    }
    
    public static void removeCard(Card card){ //Removes a Card
        displayed.remove(card);
    }
    
    public static void fillDeck(){ // Fills the deck if there is no Set or if there are less than 12 Cards
        while(!isSetAvailable() || displayed.size() < 12 && deck.size() >= 3){
            addCards(3);
        }
    }

}
    
    
