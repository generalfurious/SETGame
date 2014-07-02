package main;

import java.util.ArrayList;
import java.util.Random;


public class Game {
    public Game(ArrayList<String> symbol, ArrayList<String> color, String difficulty){
        new Deck(symbol, color, difficulty);
    }

    public Game(ArrayList<String> symbol, ArrayList<String> color, int players){
        new Deck(symbol, color);
    }

    
    public static void main(String[] args){
        new Deck();
       
    }
}
