package main;

import java.util.ArrayList;
import java.util.Random;

public class Deck { // Responsible for the deck of cards and the cards which are displayed

    static ArrayList<Card> deck; // All 81 Cards
    static ArrayList<Card> displayed; // The Cards that currently used
    static ArrayList<String> symbol, color;
    static int random;

    public Deck(ArrayList<String> symbol, ArrayList<String> color) {
        deck = new ArrayList<>();
        displayed = new ArrayList<>();

        Deck.symbol = symbol;
        Deck.color = color;

        createDeck();
        fillDeck();
    }

    public static void createDeck() {    // Create the 81 Cards with each number, shade, symbol and color
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                for (String symbolx : Deck.symbol) {
                    if (color.size() != 1) { // player choses three colors
                        for (String colorx : Deck.color) {
                            deck.add(new Card(i, j, symbolx, colorx));
                        }
                    }//end of l (color) 
                    else { // if the player only choses one color
                        deck.add(new Card(i, j, symbolx, Deck.color.get(0)));
                    }
                }//end of k (symbol) 
            }//end of j (shade) 
        }//end of i (number) 

    }

    public static boolean isSetAvailable() { // Checks if there is a Set
        for (Card a : displayed) {
            for (Card b : displayed) {
                for (Card c : displayed) {
                    if (a.equals(b) || a.equals(c) || b.equals(c)) { // if a card is used by two loops then continue
                        continue;
                    }
                    if (isSet(a, b, c)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean isSet(Card a, Card b, Card c) { // Checks wether these three Cards are a Set
        if (a.getNumber().equals(b.getNumber()) && a.getNumber().equals(c.getNumber()) || !a.getNumber().equals(b.getNumber()) && !a.getNumber().equals(c.getNumber()) && !b.getNumber().equals(c.getNumber())) {
            if (a.getShade().equals(b.getShade()) && a.getShade().equals(c.getShade()) || !a.getShade().equals(b.getShade()) && !a.getShade().equals(c.getShade()) && !b.getShade().equals(c.getShade())) {
                if (a.getSymbol().equals(b.getSymbol()) && a.getSymbol().equals(c.getSymbol()) || !a.getSymbol().equals(b.getSymbol()) && !a.getSymbol().equals(c.getSymbol()) && !b.getSymbol().equals(c.getSymbol())) {
                    if (a.getColor().equals(b.getColor()) && a.getColor().equals(c.getColor()) || !a.getColor().equals(b.getColor()) && !a.getColor().equals(c.getColor()) && !b.getColor().equals(c.getColor())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static ArrayList<Card> findSet() { // Returns a Set
        ArrayList<Card> found = new ArrayList<>();
        for (Card a : displayed) {
            for (Card b : displayed) {
                for (Card c : displayed) {
                    if (a.equals(b) || a.equals(c) || b.equals(c)) {
                        continue;
                    }
                    if (isSet(a, b, c)) {
                        found.add(a);
                        found.add(b);
                        found.add(c);
                        return found;
                    }
                }
            }
        }
        return found;
    }

    public static void addCards(int number) { // Add Cards to the displayed deck
        if (!deck.isEmpty()) { // if there are still Cards in the deck
            for (int i = 0; i < number; i++) { 
                random = new Random().nextInt(deck.size()); // Create a random number with 0<number<deck.size()
                displayed.add(deck.get(random));
                deck.remove(random); // Take this card from the original deck
            }
        }
    }

    public static void replaceCards(ArrayList<Card> remove) { //replaces three cards in displayed with three new cards from deck
        if (!deck.isEmpty()) { 
            if (displayed.size() == 12) {
                for (int i = 0; i < displayed.size(); i++) {
                    for (Card oldCard : remove) {
                        if (displayed.get(i) == oldCard) {
                            random = new Random().nextInt(deck.size()); // Create a random number(0, size+1)
                            displayed.set(i, deck.get(random));
                            deck.remove(random);
                        }
                    }
                }
            } else {    // no more cards in deck
                removeCards(remove); 
            }
            fillDeck(); // for the case that no set is available
        }
        if(displayed.isEmpty())
            Game.endGame(); 
    }

    public static void removeCards(ArrayList<Card> remove) { // remove cards from displayed
        for (Card old : remove) {
            displayed.remove(old);
        }
    }

    public static void fillDeck() { // Fills the deck if there is no Set or if there are less than 12 Cards
        while (!isSetAvailable() || displayed.size() < 12 && deck.size() >= 3) {
            addCards(3);
        }
    }

    public static void setDeck(ArrayList<Card> deck) { // used for the loadGame() function
        Deck.deck = deck;
    }

    public static void setDisplayed(ArrayList<Card> displayed) { // used for the loadGame() function
        Deck.displayed = displayed;
    }

}
