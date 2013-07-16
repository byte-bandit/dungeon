package dungeon.level;

import dungeon.rendering.DrawableGameComponent;
import java.util.LinkedList;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;

/**
 *
 * @author Kna
 */
public class Level implements DrawableGameComponent
{
	
	private int width;
	private int height;
	
	private int[][] matrice;
	private LinkedList<Room> rooms = new LinkedList<Room>();
	
	private Point db;
	
	/**
	 *
	 * @param w - width of the level (in tiles)
	 * @param h - height of the level (in tiles)
	 */
	public Level(int w, int h)
	{
		this.width = w;
		this.height = h;
		this.matrice = new int[w][h];
		
		//Fill the whole map with solid earth
		//this.fillWithDirt();
		
		//Dig out a single room in the centre of the map
		diggRoom((int)w/2, (int)h/2, 7, 7);
		
		//Pick a wall of any room
		int rmc = (int)(Math.random()*this.rooms.size());
		Room wrk = this.rooms.get(rmc);
		
		db = wrk.getWallPieceLocation();
		db.setX(db.getX()+wrk.getPos().getX());
		db.setY(db.getY()+wrk.getPos().getY());
		
		//Decide upon a new feature to build
		//this just be a 7x5 room
		
		//See if there is room to add the new feature through the chosen wall
		
		//If yes, continue. If no, go back to step 3
		//Add the feature through the chosen wall
		//Go back to step 3, until the dungeon is complete
		//Add the up and down staircases at random points in map
		//Finally, sprinkle some monsters and items liberally over dungeon
		
		
		
	}

	@Override
	public void draw(Graphics g)
	{
		for(Room r : this.rooms)
		{
			r.draw(g);
		}
		
		g.setColor(Color.red);
		for(int x=0; x<this.width; x++)
		{
			for(int y=0; y<this.height; y++)
			{
				if(matrice[x][y] == 1)
				{
					g.drawRect(x*16, y*16, 16, 16);
				}
			}
		}
		
		g.setDrawMode(org.newdawn.slick.Graphics.MODE_NORMAL);
		g.setColor(Color.yellow);
		g.fillRect(db.getX()*16, db.getY()*16, 16, 16);
		g.drawString((int)db.getX()-16+", "+((int)db.getY()-16), db.getX()*16+24, db.getY()*16);
	}
	
	
	
	
	private void diggRoom(int x, int y, int w, int h)
	{
		this.rooms.add(new Room(x, y, w, h));
		for(int n=x; n<x+w; n++)
		{
			for(int i=y; i<y+h; i++)
			{
				this.matrice[n][i] = 1;
			}
		}
	}
	
	
	
	/**
	 * Will digg out a square room at the given coords using the coords for the middle of the room.
	 * @param x - X Coord of the middle of the room
	 * @param y - Y Coord of the middle of the room
	 * @param size - Size of the room
	 * @return True if successfull, false if blocked
	 */
	/*private boolean diggSquareRoom(int x, int y, int size)
	{
		int oc=0;
		//Check for size count
		if(size % 2 == 1)
		{
			oc=1;
		}
		
		
		
		for(int i = x-(size/2); i <= x+(size/2)+oc; i++)
		{
			for(int n = y-(size/2); n <= y+(size/2)+oc; n++)
			{
				this.tiles[i-1][n-1] = TileType.FLOOR;
			}
		}
		
		//If we end up here, something went wrong
		return false;
	}*/
	
	
	/**
	 * Will fill the whole level (every tile) with dirt.
	 * @return void
	 */
	/*private void fillWithDirt()
	{
		for(int i=0; i < this.width; i++)
		{
			for(int n=0; n < this.height; n++)
			{
				this.tiles[i][n] = TileType.ROCK;
			}
		}
	}*/
	
	
	
	/*public void DebugDraw(Graphics g)
	{
		for(int i=0; i < this.width; i++)
		{
			for(int n=0; n < this.height; n++)
			{
				switch(tiles[i][n])
				{
					case FLOOR:
						g.setColor(Color.black);
						g.fillRect(i*16, n*16, 16, 16);
						break;
						
					case ROCK:
						g.setColor(Color.darkGray);
						g.fillRect(i*16, n*16, 16, 16);
						break;
				}
			}
		}
	}*/
	
	

}
