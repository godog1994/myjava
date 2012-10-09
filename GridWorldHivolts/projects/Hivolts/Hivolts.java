import java.awt.List;
import java.util.ArrayList;
import java.util.Random;



import HivoltsActors.Fence;
import info.gridworld.actor.Actor;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;
import HivoltsActors.Mho;
import HivoltsActors.MainPlayer;


public class Hivolts extends World {
	public static MainPlayer main = new MainPlayer();
	static Location mainLocation = new Location(4,5);
	static Random generator = new Random();
	
	public boolean keyPressed(String description, Location loc)
	{
		System.out.println(description);
	    if (description.equals("Q"))  
	    {
	         step();
	    	return true;
	    }
	    /**
	    else
	    if (description.equals("H") || description.equals("shift H")) //when user presses h or H
	    {
	        
	    } 
	    else 
	    {
	        return false;
	    }
*/
	    return true;
	}
	
    /**
     * @param args
     */
    public static void main(String[] args) {
    final BoundedGrid gameGrid = new BoundedGrid(12,12);
   	 World<Actor> world = new World(gameGrid);
   	 ArrayList<Fence> myFences = new ArrayList<Fence>();
   	 for (int i = 0; i < 12 ; i++ )
   	 {
   		 for (int k = 0; k< 12; k++)
   		 {
   			 if ((k<1 || k > 10) || (k>0 && k <12 && (i ==0 || i ==11) ))
   			 {
   			 myFences.add(new Fence());
   			 world.add(new Location (k,i), myFences.iterator().next());
   			 }
   		 }
   		 
   		 
   		 
   	 }
   	main.putSelfInGrid(gameGrid, mainLocation);
   	ArrayList<Mho> mhoList = new ArrayList<Mho>();
   		for (int i = 0; i <12; i++)
   		{
   			int x = generator.nextInt(10)+1;
   			int y = generator.nextInt(10)+1;
   			mhoList.add(new Mho());
   			Location mhoLocation = new Location(x,y);
   			if (mhoLocation.equals(mhoLocation)|| mhoLocation.equals(mainLocation))//trying to make it so they dont take the same place as another object
   			{
   			
   				
   			}
   			else
   				world.add(mhoLocation,mhoList.iterator().next());
   			//mhoList.iterator().next().putSelfInGrid(gameGrid, new Location(x,y)); //why is the actor already in the grid
   		}
    
   
   	
   	java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new java.awt.KeyEventDispatcher() { 
   	public boolean dispatchKeyEvent (java.awt.event.KeyEvent event) {
   	String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString();
   	if (key.equals("pressed Q"))//move up and left
   	{
   		System.out.println("pressed Q");
   		main.setKeyPressed('Q');
   		main.act();
   	}
   	if (key.equals("pressed E"))//move up and right
   	{
   		main.setKeyPressed('E');
   		main.act();
   	}
   	if (key.equals("pressed W"))//move up
   	{
   		main.setKeyPressed('W');
   		main.act();
   	}
   	if (key.equals("pressed D"))//move right
   	{
   		main.setKeyPressed('D');
   		main.act();
   	}
	if (key.equals("pressed A"))//move down
   	{
   		main.setKeyPressed('A');
   		main.act();
   	}
   	if (key.equals("pressed S"))//move down
   	{
   		main.setKeyPressed('S');
   		main.act();
   	}
	if (key.equals("pressed Z"))//move down
   	{
   		main.setKeyPressed('Z');
   		main.act();
   	}
	if (key.equals("pressed X"))//move down
   	{
   		main.setKeyPressed('X');
   		main.act();
   	} 
	if (key.equals("pressed C"))//move down
   	{
   		main.setKeyPressed('C');
   		main.act();
   	} 
	if (key.equals("pressed J"))//move down
   	{
   		main.setKeyPressed('J');
   		main.act();
   	} 
	return true;
   	}
   	});
   	
   	
   	 if( main.isDead())
   	 {
   		 world.setMessage("You have died. You lose.");
   	 }
   	
   	
   	world.show();
   	 
    }

}