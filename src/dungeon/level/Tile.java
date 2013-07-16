package dungeon.level;

import dungeon.Configuration;
import org.newdawn.slick.Image;
import dungeon.rendering.DrawableGameComponent;
import dungeon.rendering.GFXLibrary;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;

public class Tile implements DrawableGameComponent
{
	
	private TileType type;
	private Point position;
	private Image gfx;
	private Room parent;
	
	/**
	 * 
	 * @param type - The type of Tile to create
	 */
	public Tile(Room parent, TileType type)
	{
		this.type = type;
		this.parent = parent;
	}
	
	/**
	 * 
	 * @param type - The type of Tile to create
	 * @param x - (optional) X Coord
	 * @param y - (optional) Y Coord
	 */
	public Tile(Room parent, TileType type, int x, int y)
	{
		this.type = type;
		this.position = new Point(x, y);
		this.parent = parent;
	}
	
	/**
	 * 
	 * @param type - The type of Tile to create
	 * @param pos  - (optional) Position of the tile
	 */
	public Tile(Room parent, TileType type, Point pos)
	{
		this.type = type;
		this.position = pos;
		this.parent = parent;
	}
	
	
	
	@Override
	public void draw(Graphics g)
	{
		g.drawImage(GFXLibrary.getTile(this.type), ((int)this.parent.getPos().getX()+(int)this.position.getX()) * Configuration.TILE_SIZE, ((int)this.parent.getPos().getY() + (int)this.position.getY()) * Configuration.TILE_SIZE);
		
		
	}
	
}
