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
    static ArrayList<Player> playerList;
    static ArrayList<Integer> winnersList;
    static int score, player;
    public Game(ArrayList<String> symbol, ArrayList<String> color, String difficulty) throws RemoteException, InterruptedException{
        new Deck(symbol, color);
        new Design();
        new Computer(difficulty).start();
    }

    public Game(ArrayList<String> symbol, ArrayList<String> color, int players) throws InterruptedException, IOException, ClassNotFoundException{
        new Deck(symbol, color);
        new Design();
        playerList = new ArrayList<>();
        for(int i=1;i<=players;i++){
            playerList.add(new Player(i));
        }

        //saveGame("savefile.set");
        //loadGame("savefile.set");
    }

    
    public static void main(String[] args){
    }
    public static void endGame(){
        score = playerList.get(0).getScore();
        winnersList = new ArrayList<>();

        for(int i=0;i<playerList.size();i++){
            if(score <= playerList.get(i).getScore())
                score = playerList.get(i).getScore();
                player = playerList.get(i).getPlayerNumber();
        }
        for(int i=0;i<playerList.size();i++){
            if(playerList.get(i).getScore() == score)
                winnersList.add(i);
            switch(winnersList.size()){
                case 1:
                    JOptionPane.showMessageDialog(null, "Congratulation Player "+winnersList.get(0)+". You have the most SETs");
                case 2:
                    JOptionPane.showMessageDialog(null, "Congratulation Player "+winnersList.get(0)+" and Player "+winnersList.get(1)+". You have the most SETs");
                case 3:
                    JOptionPane.showMessageDialog(null, "Congratulation Player "+winnersList.get(0)+", Player "+winnersList.get(1)+" and Player "+winnersList.get(2)+". You have the most SETs");
                case 4:
                    JOptionPane.showMessageDialog(null, "Congratulation Player "+winnersList.get(0)+", Player "+winnersList.get(1)+", Player "+winnersList.get(2)+" and Player "+winnersList.get(3)+". You have the most SETs");
            }
        }
        System.exit(0);
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
