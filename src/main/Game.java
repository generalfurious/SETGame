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

public class Game { //Game is responsible for the initialization of all functions

    static ArrayList<Player> playerList = new ArrayList<>();
    static ArrayList<Integer> savePlayer;
    static ArrayList<Integer> winnersList;
    static ArrayList<String> winners;

    static int score;
    static int scorepl1, scorepl2, scorepl3, scorepl4, player, i;
    static Design design;
    static Computer computer = null;

    //this constructor is called if the player decides to play against the computer
    public Game(ArrayList<String> symbol, ArrayList<String> color, String difficulty) throws RemoteException, InterruptedException {
        new Deck(symbol, color); // creates a deck with the chosen symbols and colors
        design = new Design(); // creates a new JFrame with the cards in it
        computer = new Computer(difficulty, design); // creates a Computer object
        computer.start();   // starts the thread
        playerList.add(new Player(1, design)); // creates a new Player and starts a new JFrame 
        design.setPlayerList(playerList); // tell the design class about the players
    }

    //this constructor is called if the player decides to play against other players
    public Game(ArrayList<String> symbol, ArrayList<String> color, int players) throws InterruptedException, IOException, ClassNotFoundException {
        new Deck(symbol, color); // creates a deck with the chosen symbols and colors
        design = new Design(); // creates a new JFrame with the cards in it
        for (int i = 1; i <= players; i++) {
            playerList.add(new Player(i, design)); //add as many players as chosen
        }
        design.setPlayerList(playerList); // tell the design class about the players
    }

    public static void endGame() {

        winnersList = new ArrayList<>();
        winners = new ArrayList<>();

        for (i = 0; i < playerList.size(); i++) {
            if (i == 0) {
                scorepl1 = playerList.get(i).getScore();
                winnersList.add(scorepl1);
                scorepl2 = -100;
                scorepl3 = -100;
                scorepl4 = -100;
            } else if (i == 1) {
                scorepl2 = playerList.get(i).getScore();
                winnersList.add(scorepl2);
                scorepl3 = -100;
                scorepl4 = -100;
            } else if (i == 2) {
                scorepl3 = playerList.get(i).getScore();
                winnersList.add(scorepl3);
                scorepl4 = -100;
            } else {
                scorepl4 = playerList.get(i).getScore();
                winnersList.add(scorepl4);
            }
        }
        i--;
        if (computer != null) {
            winnersList.add(Computer.getScore());
        }
        int max = Collections.max(winnersList);

        if (max == scorepl1) {
            winners.add("1");
        }
        if (max == scorepl2) {
            winners.add("2");
        }
        if (max == scorepl3) {
            winners.add("3");
        }
        if (max == scorepl4) {
            winners.add("4");
        }
        if (computer != null && max == Computer.getScore()) {
            winners.add("computer");
        }

        if (winners.size() == 1) {
            if (winners.get(0).equals("computer")) {
                JOptionPane.showMessageDialog(null, "The computer has won with " + Computer.getScore() + " SETs.");
            } else {
                JOptionPane.showMessageDialog(null, "Congratulation Player " + winners.get(0) + ", you have the most SETs!");
            }
        } else if (winners.size() == 2) {
            if (winners.get(1).equals("computer")) {
                JOptionPane.showMessageDialog(null, "Draw!");
            } else {
                JOptionPane.showMessageDialog(null, "Congratulation! Player " + winners.get(0) + " and Player " + winners.get(1) + " have the most SETs");
            }
        } else if (winners.size() == 3) {
            JOptionPane.showMessageDialog(null, "Congratulation! Player " + winners.get(0) + ", Player " + winners.get(1) + " and Player " + winners.get(2) + " have the most SETs");
        } else if (winners.size() == 4) {
            JOptionPane.showMessageDialog(null, "Congratulation! Player " + winners.get(0) + ", Player " + winners.get(1) + ", Player " + winners.get(2) + " and Player " + winners.get(3) + " have the most SETs");
        }
        Sound.applaus.play();
        System.exit(0);
    }

    public static void saveGame(String filePath) throws IOException { // saves the Game to a file the player has chosen
        if (!filePath.endsWith(".set")) // if the case chooses an old savefile
        {
            filePath = filePath.concat(".set"); // add .set to the end
        }
        FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        ArrayList<ArrayList> list = new ArrayList<>();
        list.add(Deck.deck);    // save the deck
        list.add(Deck.displayed); // save the cards that were currently used
        savePlayer = new ArrayList<>();
        for (int i = 0; i < playerList.size(); i++) {
            savePlayer.add(playerList.get(i).getScore()); // save the score of every player and by that we know how many players there are
        }
        if (computer != null) { // add the computer
            savePlayer.add(1000); // 1000 is used a id for the computer
            savePlayer.add(Computer.getScore()); // save the score of computer
            savePlayer.add(Computer.getDifficulty()); // save the difficulty
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
                if (savePlayer.get(i + 2) == 1) { // if difficulty is 1(easy)
                    new Computer("easy", design).start();
                } else if (savePlayer.get(i + 2) == 2) { // if difficulty is 2(normal)
                    new Computer("normal", design).start();
                }
                Computer.setScore(savePlayer.get(i + 1));
                break;  // no more players
            }
            playerList.add(new Player(i + 1, design));
            playerList.get(i).setScore(savePlayer.get(i));
        }

        design.showCards(); // show Cards

        JOptionPane.showMessageDialog(null, "Game loaded.");
    }
}
