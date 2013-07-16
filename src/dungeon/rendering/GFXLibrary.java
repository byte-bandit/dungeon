package dungeon.rendering;

import dungeon.level.TileType;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GFXLibrary
{
	
	public static Image tile_rock;
	public static Image tile_floor;

	/**
	 * Initiate the Library, load in all the sprites, etc...
	 * CALL THIS DURING STARTUP OF THE PROGRAM
	 */
	public static void init()
	{
		try
		{
			Image raw = new Image("gfx.png");
			
			tile_rock = raw.getSubImage(0, 0, 16, 16);
			tile_floor = raw.getSubImage(16, 0, 16, 16);
			
			
		} catch (SlickException ex)
		{
			Logger.getLogger(GFXLibrary.class.getName()).log(Level.SEVERE, "Graphics File not found!", ex);
		}
	}
	
	
	
	
	public static Image getTile(TileType type)
	{
		switch(type)
		{
			case FLOOR:
				return tile_floor;
				
			case ROCK:
				return tile_rock;
		}
		
		return null;
	}
}
