import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

/**
 * This Component illustrates keyboard and mouse interactions.
 *
 * @author Mr. Dietzler
 */

public class SetCardComponent extends JComponent implements KeyListener,
    MouseListener
{
    //Instance Fields
    private boolean isSelected;
    private int numShapes;
    private int shape;
    private int shade;
    private Color color;
    private final int SHAPE_HEIGHT;
    private final int SHAPE_WIDTH;
    
    //Constructor
    public SetCardComponent (int n, int p, int s, int c)
    {
        this.setSize (100, 250);
        
        isSelected = false;
        
        numShapes = n;
        shape = p;
        shade = s;
        
        if (c == 1)
            color = Color.RED;
        else if (c == 2)
            color = Color.GREEN;
        else if (c == 3)
            color = Color.BLUE;
        
        SHAPE_HEIGHT = 50;
        SHAPE_WIDTH = 80;
        
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.setBackground(Color.BLACK);
    }//end constructor
    
    
    public void paintComponent (Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        if (isSelected)
            this.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        else if(!isSelected)
             this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        
        if(this.getNumShapes() == 1)
        {
            if(this.getShape() == 1)
            {
                if(this.getShade() == 1)
                {
                    g2.setColor(this.getColor());
                    g2.draw(new Ellipse2D.Double(10, 100, SHAPE_WIDTH, SHAPE_HEIGHT)); 
                    new Hexagon2D.Double();
                    new Ellipse2D.Double();
                    new Heart2D;
                }
                else if(this.getShade() == 2)
                {
                    GradientPaint gradient = new GradientPaint(0,0,this.getColor(),100, 0,color.WHITE);
                    g2.setPaint(gradient);
                    g2.fill (new Ellipse2D.Double(10, 100, SHAPE_WIDTH, SHAPE_HEIGHT));
                }
                else if(this.getShade() == 3)
                {
                    g2.setColor(this.getColor());
                    g2.fill(new Ellipse2D.Double(10, 100, SHAPE_WIDTH, SHAPE_HEIGHT));
                }
            }
            else if(this.getShape() == 2)
            {
                if(this.getShade() == 1)
                {
                    g2.setColor(this.getColor());
                    g2.draw(new Rectangle2D.Double(10, 100, SHAPE_WIDTH, SHAPE_HEIGHT)); 
                }
                else if(this.getShade() == 2)
                {
                    GradientPaint gradient = new GradientPaint(0,0,this.getColor(),100, 0,color.WHITE);
                    g2.setPaint(gradient);
                    g2.fill (new Rectangle2D.Double(10, 100, SHAPE_WIDTH, SHAPE_HEIGHT));
                }
                else if(this.getShade() == 3)
                {
                    g2.setColor(this.getColor());
                    g2.fill(new Rectangle2D.Double(10, 100, SHAPE_WIDTH, SHAPE_HEIGHT));
                }
            }
            if(this.getShape() == 3)
            {
                if(this.getShade() == 1)
                {
                    g2.setColor(this.getColor());
                    int[] xs = {10, 50, 90};
                    int[] ys = {150, 100, 150};
                    g2.drawPolygon(xs, ys, 3);
                }
                if(this.getShade() == 2)
                {
                    GradientPaint gradient = new GradientPaint(0,0,this.getColor(),100, 0,color.WHITE);
                    g2.setPaint(gradient);
                    int[] xs = {10, 50, 90};
                    int[] ys = {150, 100, 150};
                    g2.fillPolygon(xs, ys, 3);
                }
                if(this.getShade() == 3)
                {
                    g2.setColor(this.getColor());
                    int[] xs = {10, 50, 90};
                    int[] ys = {150, 100, 150};
                    g2.fillPolygon(xs, ys, 3);
                }
            }
        }
        
        else if(this.getNumShapes() == 2)
        {
            if(this.getShape() == 1)
            {
                if(this.getShade() == 1)
                {
                    g2.setColor(this.getColor());
                    g2.draw(new Ellipse2D.Double(10, 50, SHAPE_WIDTH, SHAPE_HEIGHT));
                    g2.draw(new Ellipse2D.Double(10, 150, SHAPE_WIDTH, SHAPE_HEIGHT));
                }
                else if(this.getShade() == 2)
                {
                    GradientPaint gradient = new GradientPaint(0,0,this.getColor(),100, 0,color.WHITE);
                    g2.setPaint(gradient);
                    g2.fill (new Ellipse2D.Double(10, 50, SHAPE_WIDTH, SHAPE_HEIGHT));
                    g2.fill (new Ellipse2D.Double(10, 150, SHAPE_WIDTH, SHAPE_HEIGHT));
                }
                else if(this.getShade() == 3)
                {
                    g2.setColor(this.getColor());
                    g2.fill(new Ellipse2D.Double(10, 50, SHAPE_WIDTH, SHAPE_HEIGHT));
                    g2.fill(new Ellipse2D.Double(10, 150, SHAPE_WIDTH, SHAPE_HEIGHT));
                }
            }
            else if(this.getShape() == 2)
            {
                if(this.getShade() == 1)
                {
                    g2.setColor(this.getColor());
                    g2.draw(new Rectangle2D.Double(10, 50, SHAPE_WIDTH, SHAPE_HEIGHT));
                    g2.draw(new Rectangle2D.Double(10, 150, SHAPE_WIDTH, SHAPE_HEIGHT));
                }
                else if(this.getShade() == 2)
                {
                    GradientPaint gradient = new GradientPaint(0,0,this.getColor(),100, 0,color.WHITE);
                    g2.setPaint(gradient);
                    g2.fill (new Rectangle2D.Double(10, 50, SHAPE_WIDTH, SHAPE_HEIGHT));
                    g2.fill (new Rectangle2D.Double(10, 150, SHAPE_WIDTH, SHAPE_HEIGHT));
                }
                else if(this.getShade() == 3)
                {
                    g2.setColor(this.getColor());
                    g2.fill(new Rectangle2D.Double(10, 50, SHAPE_WIDTH, SHAPE_HEIGHT));
                    g2.fill(new Rectangle2D.Double(10, 150, SHAPE_WIDTH, SHAPE_HEIGHT));
                }
            }
            if(this.getShape() == 3)
            {
                if(this.getShade() == 1)
                {
                    g2.setColor(this.getColor());
                    int[] x1s = {10, 50, 90};
                    int[] y1s = {100, 50, 100};
                    g2.drawPolygon(x1s, y1s, 3);
                    int[] x2s = {10, 50, 90};
                    int[] y2s = {200, 150, 200};
                    g2.drawPolygon(x2s, y2s, 3);
                }
                if(this.getShade() == 2)
                {
                    GradientPaint gradient = new GradientPaint(0,0,this.getColor(),100, 0,color.WHITE);
                    g2.setPaint(gradient);
                    int[] x1s = {10, 50, 90};
                    int[] y1s = {100, 50, 100};
                    g2.fillPolygon(x1s, y1s, 3);
                    int[] x2s = {10, 50, 90};
                    int[] y2s = {200, 150, 200};
                    g2.fillPolygon(x2s, y2s, 3);
                }
                if(this.getShade() == 3)
                {
                    g2.setColor(this.getColor());
                    int[] x1s = {10, 50, 90};
                    int[] y1s = {100, 50, 100};
                    g2.fillPolygon(x1s, y1s, 3);
                    int[] x2s = {10, 50, 90};
                    int[] y2s = {200, 150, 200};
                    g2.fillPolygon(x2s, y2s, 3);
                }
            }
        }
        
        else if(this.getNumShapes() == 3)
        {
            if(this.getShape() == 1)
            {
                if(this.getShade() == 1)
                {
                    g2.setColor(this.getColor());
                    g2.draw(new Ellipse2D.Double(10, 25, SHAPE_WIDTH, SHAPE_HEIGHT));
                    g2.draw(new Ellipse2D.Double(10, 100, SHAPE_WIDTH, SHAPE_HEIGHT));
                    g2.draw(new Ellipse2D.Double(10, 175, SHAPE_WIDTH, SHAPE_HEIGHT));
                }
                else if(this.getShade() == 2)
                {
                    GradientPaint gradient = new GradientPaint(0,0,this.getColor(),100, 0,color.WHITE);
                    g2.setPaint(gradient);
                    g2.fill (new Ellipse2D.Double(10, 25, SHAPE_WIDTH, SHAPE_HEIGHT));
                    g2.fill (new Ellipse2D.Double(10, 100, SHAPE_WIDTH, SHAPE_HEIGHT));
                    g2.fill (new Ellipse2D.Double(10, 175, SHAPE_WIDTH, SHAPE_HEIGHT));
                }
                else if(this.getShade() == 3)
                {
                    g2.setColor(this.getColor());
                    g2.fill(new Ellipse2D.Double(10, 25, SHAPE_WIDTH, SHAPE_HEIGHT));
                    g2.fill(new Ellipse2D.Double(10, 100, SHAPE_WIDTH, SHAPE_HEIGHT));
                    g2.fill(new Ellipse2D.Double(10, 175, SHAPE_WIDTH, SHAPE_HEIGHT));
                }
            }
            else if(this.getShape() == 2)
            {
                if(this.getShade() == 1)
                {
                    g2.setColor(this.getColor());
                    g2.draw(new Rectangle2D.Double(10, 25, SHAPE_WIDTH, SHAPE_HEIGHT));
                    g2.draw(new Rectangle2D.Double(10, 100, SHAPE_WIDTH, SHAPE_HEIGHT));
                    g2.draw(new Rectangle2D.Double(10, 175, SHAPE_WIDTH, SHAPE_HEIGHT));
                }
                else if(this.getShade() == 2)
                {
                    GradientPaint gradient = new GradientPaint(0,0,this.getColor(),100, 0,color.WHITE);
                    g2.setPaint(gradient);
                    g2.fill (new Rectangle2D.Double(10, 25, SHAPE_WIDTH, SHAPE_HEIGHT));
                    g2.fill (new Rectangle2D.Double(10, 100, SHAPE_WIDTH, SHAPE_HEIGHT));
                    g2.fill (new Rectangle2D.Double(10, 175, SHAPE_WIDTH, SHAPE_HEIGHT));
                }
                else if(this.getShade() == 3)
                {
                    g2.setColor(this.getColor());
                    g2.fill(new Rectangle2D.Double(10, 25, SHAPE_WIDTH, SHAPE_HEIGHT));
                    g2.fill(new Rectangle2D.Double(10, 100, SHAPE_WIDTH, SHAPE_HEIGHT));
                    g2.fill(new Rectangle2D.Double(10, 175, SHAPE_WIDTH, SHAPE_HEIGHT));
                }
            }
            if(this.getShape() == 3)
            {
                if(this.getShade() == 1)
                {
                    g2.setColor(this.getColor());
                    int[] x1s = {10, 50, 90};
                    int[] y1s = {75, 25, 75};
                    g2.drawPolygon(x1s, y1s, 3);
                    int[] x2s = {10, 50, 90};
                    int[] y2s = {150, 100, 150};
                    g2.drawPolygon(x2s, y2s, 3);
                    int[] x3s = {10, 50, 90};
                    int[] y3s = {225, 175, 225};
                    g2.drawPolygon(x3s, y3s, 3);
                }
                if(this.getShade() == 2)
                {
                    GradientPaint gradient = new GradientPaint(0,0,this.getColor(),100, 0,color.WHITE);
                    g2.setPaint(gradient);
                    int[] x1s = {10, 50, 90};
                    int[] y1s = {75, 25, 75};
                    g2.fillPolygon(x1s, y1s, 3);
                    int[] x2s = {10, 50, 90};
                    int[] y2s = {150, 100, 150};
                    g2.fillPolygon(x2s, y2s, 3);
                    int[] x3s = {10, 50, 90};
                    int[] y3s = {225, 175, 225};
                    g2.fillPolygon(x3s, y3s, 3);
                }
                if(this.getShade() == 3)
                {
                    g2.setColor(this.getColor());
                    int[] x1s = {10, 50, 90};
                    int[] y1s = {75, 25, 75};
                    g2.fillPolygon(x1s, y1s, 3);
                    int[] x2s = {10, 50, 90};
                    int[] y2s = {150, 100, 150};
                    g2.fillPolygon(x2s, y2s, 3);
                    int[] x3s = {10, 50, 90};
                    int[] y3s = {225, 175, 225};
                    g2.fillPolygon(x3s, y3s, 3);
                }
            }
        }
    }//end paintComponent method
    
    public int getNumShapes()
    {
        return numShapes;
    }
    
    public int getShape()
    {
        return shape;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public int getShade()
    {
        return shade;
    }
    
    public boolean getIsSelected()
    {
        return isSelected;
    }
    
    public void setIsSelected (boolean newIsSelected)
    {
        isSelected = newIsSelected;
    }
    
    public void setNumShapes(int newNumShapes)
    {
        numShapes = newNumShapes;
    }
    
    public void setShape(int newShape)
    {
        shape = newShape;
    }
    
    public void setColor(Color newColor)
    {
        color = newColor;
    }
    
    public void setShade(int newShade)
    {
        shade = newShade;
    }
    
    public void keyReleased (KeyEvent key)
    {}
    
    public void keyPressed (KeyEvent key)
    {}
    
    public void keyTyped (KeyEvent key)
    {}
    
    public void mouseClicked (MouseEvent mouse)
    {}
    
    public void mousePressed (MouseEvent mouse)
    {
        if(isSelected)
            isSelected = false;
        else
            isSelected = true;
        repaint();
    }
    
    public void mouseReleased (MouseEvent mouse)
    {}
    
    public void mouseExited (MouseEvent mouse)
    {}
    
    public void mouseEntered (MouseEvent mouse)
    {}
    
    public boolean equals (SetCardComponent other)
    {
         SetCardComponent otherCard = other;
         if (otherCard.getColor() == color && otherCard.getShade() == shade && otherCard.getShape() == shape && otherCard.getNumShapes() == numShapes)
              return true;
         else 
              return false;
    }//end equals
    
}//end SetCardComponent class
