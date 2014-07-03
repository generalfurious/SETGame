package main;

import java.util.ArrayList;

public class Game {
    public Game(ArrayList<String> symbol, ArrayList<String> color, String difficulty){
        System.out.println(symbol +" " + color + " ");
        new Deck(symbol, color, difficulty);
    }

    public Game(ArrayList<String> symbol, ArrayList<String> color, int players) throws InterruptedException{
        System.out.println(symbol +" " + color + " ");
        new Deck(symbol, color);
        new Design();
    }

    
    public static void main(String[] args){
    }
}
