
package main;

import java.io.Serializable;

public class Card implements Serializable{ // Class for the card-objects, Serializable for the saveGame() function
    String number, shade, symbol, color, icon;
    
    public static final int average_width = 105; // y-Position of the labels
    public static int height; // x-Position of the labels
    
    public Card(int number, int shade, String symbol, String color){
        this.number = String.valueOf(number);
        this.symbol = symbol;
        this.shade = whatShade(shade); 
        this.color = color;
        this.icon = "Card_Symbols\\" + this.color + "\\" + this.symbol +  "_" + this.color + "_" + this.shade + ".png";  
        //Creation of the icon path with the help of the attributes
                    
    }

    public String whatShade(int shade){ // What shade does the number imply?
        switch(shade){
                case 1: return "full";
                case 2: return "half";
                case 3: return "empty";
        }
        return "0";
    }
    

    public String getNumber() {
        return number;
    }

    public String getShade() {
        return shade;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getColor() {
        return color;
    }

    public String getIcon() {
        return icon;
    }
}    
