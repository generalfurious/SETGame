
package main;

public class Card {
    String number, shade, symbol, color, icon;
    
    public Card(int number, int shade, String symbol, String color){
        this.number = whatNumber(number);
        this.symbol = symbol;
        this.shade = whatShade(shade);
        this.color = color;
        this.icon = "Card_Symbols\\" + this.color + "\\" + this.symbol +  "_" + this.color + "_" + this.shade + ".png";  
                    
    }
    
    public String whatNumber(int number){
        switch(number){
                case 1: return "1";
                case 2: return "2";
                case 3: return "3";
        }
        return "0";
    }
    
//    public String whatSymbol(int symbol){
//        switch(symbol){
//                case 1: return "hexagon";
//                case 2: return "rectangle";
//                case 3: return "wave";
//        }
//        return "0";
//    }
//    
    public String whatShade(int shade){
        switch(shade){
                case 1: return "full";
                case 2: return "half";
                case 3: return "empty";
        }
        return "0";
    }
    
//     public String whatColor(int color){
//        switch(color){
//                case 1: return "red";
//                case 2: return "blue";
//                case 3: return "purple";
//        }
//        return "none";
//    }

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
