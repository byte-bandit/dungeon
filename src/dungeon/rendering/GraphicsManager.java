package dungeon.rendering;

import java.util.LinkedList;
import org.newdawn.slick.Graphics;

public class GraphicsManager
{
	private static LinkedList<DrawableGameComponent> children = new LinkedList<DrawableGameComponent> ();
	
	public static void addChild(DrawableGameComponent c)
	{
		children.add(c);
	}
	
	public static boolean removeChild(DrawableGameComponent c)
	{
		try
		{
			children.remove(c);
			return true;
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	public static void draw(Graphics g)
	{
		for(DrawableGameComponent c : children)
		{
			c.draw(g);
		}
	}
}
