package dungeon.level;

import dungeon.rendering.DrawableGameComponent;
import java.util.LinkedList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;

public class Room implements DrawableGameComponent
{
	
	private int size_x;
	private int size_y;
	
	private Point pos;
	
	private Tile[][] tiles;
	
	
	/**
	 * Creates a new room
	 * @param w - Width
	 * @param h  - Height
	 */
	public Room(int x, int y, int w, int h)
	{
		this.size_x = w;
		this.size_y = h;
		this.pos = new Point(x, y);
		
		tiles = new Tile[w][h];
		buildTiles();
	}
	
	
	
	/**
	 * Used to get the position of a wallpiece
	 * @return The global position of a wallpiece
	 */
	public Point getWallPieceLocation()
	{
		if(Math.random() > .5)
		{
			//Take side piece
			int yval = (int)(Math.random()*(size_y-2))+1;
			int xval = (int)Math.round(Math.random()) * (this.size_x-1);
			System.out.println("side "+xval+", "+yval);
			return new Point(xval, yval); 
		}
		else
		{
			//Take top/bottom piece
			int xval = (int)(Math.random()*(this.size_x-2))+1;
			int yval = (int)Math.round(Math.random()) * (this.size_y-1);
			System.out.println("top/bot "+xval+", "+yval);
			return new Point(xval, yval); 
		}
	}
	
	
	
	/**
	 * Sets the tiles
	 */
	private void buildTiles()
	{
		//Create Floor
		for(int x = 1; x < this.size_x-1; x++)
		{
			for(int y = 1; y < this.size_y-1; y++)
			{
				tiles[x][y] = new Tile(this, TileType.FLOOR, x, y);
			}
		}
		
		
		//Create Walls
		for(int x=0; x < this.size_x; x++)
		{
			tiles[x][0] = new Tile(this, TileType.ROCK, x, 0);
			tiles[x][size_y-1] = new Tile(this, TileType.ROCK, x, size_y-1);
		}
		
		for(int y=0; y < this.size_y; y++)
		{
			tiles[0][y] = new Tile(this, TileType.ROCK, 0, y);
			tiles[size_x-1][y] = new Tile(this, TileType.ROCK, size_x-1, y);
		}
	}

	@Override
	public void draw(Graphics g)
	{
		for(int x = 0; x < this.size_x; x++)
		{
			for(int y = 0; y < this.size_y; y++)
			{
				tiles[x][y].draw(g);
			}
		}
	}

	/**
	 * @return the pos
	 */
	public Point getPos()
	{
		return pos;
	}
	
	
	
	
	

}
