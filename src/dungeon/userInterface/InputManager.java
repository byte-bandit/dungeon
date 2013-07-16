/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.userInterface;

import org.newdawn.slick.GameContainer;

/**
 *
 * @author Luke
 */
public class InputManager
{
    public static void Update(GameContainer gc)
	{
		if(org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_ESCAPE))
		{
			gc.exit();
		}
	}
}
