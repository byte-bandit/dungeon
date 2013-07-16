package dungeon;

import org.newdawn.slick.*;
import dungeon.level.*;
import dungeon.rendering.GFXLibrary;


public class Dungeon extends BasicGame
{
 
	Level tst = new Level(32, 32);
	boolean down = false;
  public Dungeon()
  {
	  super("Hello World");
	  
	  dungeon.rendering.GraphicsManager.addChild(tst);
  }
 
  @Override
  public void init(GameContainer gc) throws SlickException
  {
	  Configuration.WINDOW_ASPECT_RATIO = gc.getAspectRatio();
	  Configuration.WINDOW_HEIGHT = gc.getHeight();
	  Configuration.WINDOW_WIDTH = gc.getWidth();
	  Configuration.WINDOW_SCREEN_HEIGHT = gc.getScreenHeight();
	  Configuration.WINDOW_SCREEN_WIDTH = gc.getScreenWidth();
	  
	  System.out.println(System.getProperty("user.dir"));
	  GFXLibrary.init();
  }
 
  @Override
  public void update(GameContainer gc, int delta) throws SlickException
  {
	  dungeon.update.UpdateManager.update();
	  dungeon.userInterface.InputManager.Update(gc);
	  
	  if(org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_P) && !down)
	  {
		  down=true;
		  dungeon.rendering.GraphicsManager.removeChild(tst);
		  tst = new Level(32,32);
		  dungeon.rendering.GraphicsManager.addChild(tst);
	  }
	  
	  if(!org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_P))
	  {
		  down=false;
	  }
  }
 
  @Override
  public void render(GameContainer gc, Graphics g) throws SlickException
  {
	  dungeon.rendering.GraphicsManager.draw(g);
  }
 
  public static void main(String[] args) throws SlickException
  {
     AppGameContainer app = new AppGameContainer(new Dungeon());
 
     app.setDisplayMode(800, 600, false);
     app.start();
  }
}