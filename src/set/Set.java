import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

public class Set //extends JComponent 
{
    //Instance Fields
    private Color fillColor;
    private ArrayList<SetCardComponent> cardsInPlay;
    private ArrayList<SetCardComponent> cardsSelected;
    private Deck deck;
    private JPanel gameBoard;
    private JFrame frame;
    private JFrame endGameFrame;
    private JButton endGame;
    private boolean gameOver;
    
    
    //Constructor
    public Set ()
    {
        fillColor = Color.BLACK;
        
        cardsInPlay = new ArrayList<SetCardComponent>();
        deck = new Deck();
        deck.shuffle();
        
        cardsSelected = new ArrayList<SetCardComponent>();
        
        gameBoard = new JPanel();
        gameBoard.setLayout(new GridLayout(2, 6, 50, 50));
        
        endGame = new JButton("End Game");
        
        frame = new JFrame();
        frame.setSize(900, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(fillColor);
        
        endGameFrame = new JFrame();
        endGameFrame.setSize(50,50);
        endGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        endGameFrame.add(endGame);
        endGameFrame.setLocation(900,0);
        endGameFrame.setVisible(true);
        
        gameOver = false;
        
        for (int i = 0; i < 12; i++)
        {
            cardsInPlay.add(deck.removeTopSetCard());
        }
    }//end constructor
    
    
    public void setBoard ()
    {
        frame.remove(gameBoard);
        gameBoard.removeAll();
        for (SetCardComponent current : cardsInPlay)
        {
            gameBoard.add(current);
            current.addMouseListener(current);
        }
        
        frame.getContentPane().add(gameBoard);
        frame.setVisible(true); 
    }
    
    public void printGame()
    {
        System.out.println("You have collected " + (81 - (deck.getSize() + 12))/3 + " sets and there are " + (deck.getSize() + 12)/3 + " sets left.");
    }
    
    public void printGameOver()
    {
        System.out.println("Game Over! You collected " + (81 - (deck.getSize() + 12))/3 + " sets!");
    }
    
    
    public void play ()
    {  
        class ButtonListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getActionCommand().equals("End Game"))
                {
                    gameOver = true;
                }
            }//end actionPerformed method
            
        }//end ButtonListener class
        ActionListener listener = new ButtonListener();
        endGame.addActionListener(listener);
        
        this.printGame();
        this.setBoard();
        if(!this.possibleSet())
                    {
                        gameOver = true;
                        System.out.println("There are no more sets in play.");
                    }
        while(cardsInPlay.size() != 0 && !gameOver)
        {
            while(cardsSelected.size() != 3)
            {
                for(SetCardComponent currentCard : cardsInPlay)
                {
                    if(currentCard.getIsSelected())
                    {
                        if(!cardsSelected.contains(currentCard))
                        {
                            cardsSelected.add(currentCard);
                        }
                    }
                    else if (!currentCard.getIsSelected())
                    {
                        if(cardsSelected.contains(currentCard))
                            cardsSelected.remove(cardsSelected.indexOf(currentCard));
                    }
                }
            }
            
            if(cardsSelected.size() == 3)
            {
                if (!checkSet(cardsSelected.get(0), cardsSelected.get(1), cardsSelected.get(2)))
                {
                    for (int i = cardsSelected.size() - 1; i >= 0; i--)
                    {
                        cardsSelected.get(i).setIsSelected(false);
                        cardsSelected.remove(i);
                    }
                    System.out.println("That was not a Set. Try Again!");
                }
                
                else //if (checkSet(cardsSelected.get(0), cardsSelected.get(1), cardsSelected.get(2)))
                {
                    System.out.println("That was a Set!  Those 3 cards are now removed and replaced with new cards.");
                    for(int i = cardsInPlay.size() - 1; i >= 0; i--)
                    {
                        if(cardsSelected.contains(cardsInPlay.get(i)))
                        {
                            cardsInPlay.remove(i);
                        }
                    }
                    
                    for(SetCardComponent cardListener : cardsInPlay)
                        cardListener.removeMouseListener(cardListener);
                    cardsSelected.removeAll(cardsSelected);
                    
                    for (int i = 0; i < 3; i++)
                    {
                        cardsInPlay.add(deck.removeTopSetCard());
                    }
                    this.play();
                }
            }
        }
        
        this.printGameOver();
        
    }//end play method
    
    public boolean possibleSet()
    {
        for(SetCardComponent a : cardsInPlay)
        {
            for(SetCardComponent b : cardsInPlay)
            {
                for(SetCardComponent c : cardsInPlay)
                {
                    if(!a.equals(b) && !a.equals(c) && !b.equals(c) && this.checkSet(a,b,c))
                        return true;
                    
                }
            }
        }
        return false;
    }
    
    public boolean checkSet(SetCardComponent a, SetCardComponent b, SetCardComponent c)
    {
        if((a.getColor() == b.getColor() && a.getColor() == c.getColor()) || (a.getColor() != b.getColor() && a.getColor() != c.getColor() && b.getColor() != c.getColor()))
        {
            if((a.getShade() == b.getShade() && a.getShade() == c.getShade()) || (a.getShade() != b.getShade() && a.getShade() != c.getShade() && b.getShade() != c.getShade()))
            {
                if((a.getShape() == b.getShape() && a.getShape() == c.getShape()) || (a.getShape() != b.getShape() && a.getShape() != c.getShape() && b.getShape() != c.getShape()))
                {
                    if((a.getNumShapes() == b.getNumShapes() && a.getNumShapes() == c.getNumShapes()) || (a.getNumShapes() != b.getNumShapes() && a.getNumShapes() != c.getNumShapes() && b.getNumShapes() != c.getNumShapes()))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public JPanel getGameBoard()
    {
        return gameBoard;
    }
}