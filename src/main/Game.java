package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Game {
    public Game(ArrayList<String> symbol, ArrayList<String> color, String difficulty) throws RemoteException, InterruptedException{
        new Deck(symbol, color);
        new Design();
        new Computer(difficulty).start();
    }

    public Game(ArrayList<String> symbol, ArrayList<String> color, int players) throws InterruptedException, IOException, ClassNotFoundException{
        new Deck(symbol, color);
        new Design();

        //saveGame("savefile.set");
        //loadGame("savefile.set");
    }

    
    public static void main(String[] args){
    }
    
    public static void  saveGame(String filePath) throws IOException{
        
        FileOutputStream fos = new FileOutputStream(filePath.concat(".set"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);   
        ArrayList<ArrayList> list = new ArrayList<>();
        list.add(Deck.deck);
        list.add(Deck.displayed);
        oos.writeObject(list); // write MenuArray to ObjectOutputStream
        oos.close();
        JOptionPane.showMessageDialog(null, "Game saved.");
        
    }
    
    public static void loadGame(String filePath) throws IOException, ClassNotFoundException{

        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<ArrayList> list = (ArrayList<ArrayList>) ois.readObject();
        ArrayList<Card> cards = list.get(0);
        System.out.println(cards.get(0).getIcon());
        
        JOptionPane.showMessageDialog(null, "Game loaded.");
    }
}
