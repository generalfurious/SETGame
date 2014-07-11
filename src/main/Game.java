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

    static ArrayList<Player> playerList = new ArrayList<>();
    static ArrayList<Integer> savePlayer;
    static ArrayList<Integer> winnersList;
    static int score, player;
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
    }

    public static void endGame() {
        score = playerList.get(0).getScore();
        winnersList = new ArrayList<>();

        for (int i = 0; i < playerList.size(); i++) {
            if (score <= playerList.get(i).getScore()) {
                score = playerList.get(i).getScore();
            }
            player = playerList.get(i).getPlayerNumber();
        }
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getScore() == score) {
                winnersList.add(i);
            }
            switch (winnersList.size()) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Congratulation Player " + winnersList.get(0) + ". You have the most SETs");
                case 2:
                    JOptionPane.showMessageDialog(null, "Congratulation Player " + winnersList.get(0) + " and Player " + winnersList.get(1) + ". You have the most SETs");
                case 3:
                    JOptionPane.showMessageDialog(null, "Congratulation Player " + winnersList.get(0) + ", Player " + winnersList.get(1) + " and Player " + winnersList.get(2) + ". You have the most SETs");
                case 4:
                    JOptionPane.showMessageDialog(null, "Congratulation Player " + winnersList.get(0) + ", Player " + winnersList.get(1) + ", Player " + winnersList.get(2) + " and Player " + winnersList.get(3) + ". You have the most SETs");
            }
        }
        System.exit(0);
    }

    public static void saveGame(String filePath) throws IOException {

        FileOutputStream fos = new FileOutputStream(filePath.concat(".set"));
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
