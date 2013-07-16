package dungeon.update;

import java.util.LinkedList;
import org.newdawn.slick.Graphics;

public class UpdateManager
{
	
	private static LinkedList<UpdatetableGameComponent> children = new LinkedList<UpdatetableGameComponent> ();
	
	public static void addChild(UpdatetableGameComponent c)
	{
		children.add(c);
	}



	public static boolean removeChild(UpdatetableGameComponent c)
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



	public static void update()
	{
		for(UpdatetableGameComponent c : children)
		{
			c.update();
		}
	}

}
