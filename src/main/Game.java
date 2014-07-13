package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class Game {

    static ArrayList<Player> playerList = new ArrayList<>();
    static ArrayList<Integer> savePlayer;
    static ArrayList<Integer> winnersList;
    
    static int score;
    static int scorepl1, scorepl2, scorepl3, scorepl4, player, i;
    static Design design;
    static Computer computer = null;

    public Game(ArrayList<String> symbol, ArrayList<String> color, String difficulty) throws RemoteException, InterruptedException {
        new Deck(symbol, color);
        design = new Design();
        computer = new Computer(difficulty, design);
        computer.start();
        playerList.add(new Player(1, design));
    }

    public Game(ArrayList<String> symbol, ArrayList<String> color, int players) throws InterruptedException, IOException, ClassNotFoundException {
        new Deck(symbol, color);
        design = new Design();
        for (int i = 1; i <= players; i++) {
            playerList.add(new Player(i, design));
        }
        design.setPlayerList(playerList);
        
    }

    public static void endGame() {
        
        winnersList = new ArrayList<>();

        for (i = 0; i < playerList.size(); i++) {

            if (i == 0) {
                scorepl1 = playerList.get(i).getScore();
                winnersList.add(scorepl1);
            } else if (i == 1) {
                scorepl2 = playerList.get(i).getScore();
                winnersList.add(scorepl2);
            } else if (i == 2) {
                scorepl3 = playerList.get(i).getScore();
                winnersList.add(scorepl3);
            } else {
                scorepl4 = playerList.get(i).getScore();
                winnersList.add(scorepl4);
            }
        }
        i--;
        Collections.sort(winnersList);

        if (winnersList.get(i).equals(scorepl1)) {
            Sound.applaus.play();
            JOptionPane.showMessageDialog(null, "Congratulation Player 1. You have the most SETs");
        }
        if (winnersList.get(i).equals(scorepl2)) {
            Sound.applaus.play();
            JOptionPane.showMessageDialog(null, "Congratulation Player 2. You have the most SETs");
        }
        if (winnersList.get(i).equals(scorepl3)) {
            Sound.applaus.play();
            JOptionPane.showMessageDialog(null, "Congratulation Player 3. You have the most SETs");
        }
        if (winnersList.get(i).equals(scorepl4)) {
            Sound.applaus.play();
            JOptionPane.showMessageDialog(null, "Congratulation Player 4. You have the most SETs");
        }

        System.exit(0);
    }

    public static void saveGame(String filePath) throws IOException {
        if(!filePath.endsWith(".set"))
            filePath = filePath.concat(".set");
        
        FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        ArrayList<ArrayList> list = new ArrayList<>();
        list.add(Deck.deck);
        list.add(Deck.displayed);
        savePlayer = new ArrayList<>();
        for (int i = 0; i < playerList.size(); i++) {
            savePlayer.add(playerList.get(i).getScore());
        }
        if (computer != null) {
            savePlayer.add(1000);
            savePlayer.add(Computer.getScore());
            savePlayer.add(Computer.getDifficulty());
        }
        list.add(savePlayer);
        oos.writeObject(list);
        oos.close();
        JOptionPane.showMessageDialog(null, "Game saved.");

    }

    public static void loadGame(String filePath) throws IOException, ClassNotFoundException, InterruptedException {

        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<ArrayList> list = (ArrayList<ArrayList>) ois.readObject();
        Deck.setDeck(list.get(0));
        Deck.setDisplayed(list.get(1));
        savePlayer = list.get(2);
        for (Player p : playerList) {
            p.closeWindows();
        }
        playerList.clear();
        design.setPlayer(null);
        for (int i = 0; i < savePlayer.size(); i++) {
            if (savePlayer.get(i) == 1000) { // If it is a computer
                if (savePlayer.get(i + 2) == 1) {
                    new Computer("easy", design).start();
                    Computer.setScore(savePlayer.get(i + 1));
                } else if (savePlayer.get(i + 2) == 2) {
                    new Computer("normal", design).start();
                    Computer.setScore(savePlayer.get(i + 1));
                }
                break;
            }
            playerList.add(new Player(i + 1, design));
            playerList.get(i).setScore(savePlayer.get(i));
        }

        design.showCards();

        JOptionPane.showMessageDialog(null, "Game loaded.");
    }

    public static void main(String args[]) throws InterruptedException, IOException, ClassNotFoundException {
        ArrayList<String> symbol = new ArrayList<>();
        symbol.add("oval");
        symbol.add("heart");
        symbol.add("rectangle");
        ArrayList<String> color = new ArrayList<>();
        color.add("green");
        int players = 4;
        new Game(symbol, color, players);
    }
}
