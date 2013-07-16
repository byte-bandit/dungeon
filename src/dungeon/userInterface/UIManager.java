/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.userInterface;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import dungeon.Configuration;

/**
 *
 * @author Luke
 */
public class UIManager extends UIElement {
    private Image _backgroundImage = null;
    
    public UIManager()
    {
        super(0, 0, Configuration.WINDOW_SCREEN_WIDTH, Configuration.WINDOW_SCREEN_HEIGHT);
    }
    
    
    @Override
    public void draw(Graphics g){
        g.drawRect(this.posX, this.posY, this.elementHeight/10, this.elementWidth/10);
    }
}
