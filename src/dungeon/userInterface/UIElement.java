/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.userInterface;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import dungeon.rendering.DrawableGameComponent;

/**
 *
 * @author Luke
 */
public class UIElement implements DrawableGameComponent {
    protected int posX = 0;
    protected int posY =0;
    protected int elementWidth = 0;
    protected int elementHeight = 0;
    private Color _backgroundColor = Color.white;
    private int _id = -1;
    
    
    public UIElement(int px, int py, int width, int height)
    {
        posX = px;
        posY = py;
        elementWidth = width;
        elementHeight = height;

    }
    
    public Color getBackgroundColor()
    {
        return _backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor)
    {
        _backgroundColor = backgroundColor;
    }
    
     public final boolean isMouseOver(int x, int y)
    {
        return x > posX && x < (posX + elementWidth) &&
               y > posY && y < (posY + elementHeight);
    }
     
    public void setX(int x)
    {
        posX = x;
    }

    public final int getY()
    {
        return posY;
    }
    
    public void setY(int y)
    {
        posY = y;
    }
    
    public int getWidth()
    {
        return elementWidth;
    }

    public void setWidth(int width)
    {
        elementWidth = width;
    }

    public int getHeight()
    {
        return elementHeight;
    }

    public void setHeight(int height)
    {
        elementHeight = height;
    }

    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
