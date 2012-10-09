import java.util.ArrayList;



import HivoltsActors.Fence;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;
import HivoltsActors.Mho;
import HivoltsActors.MainPlayer;


public class Hivolts extends World {
	public static MainPlayer main = new MainPlayer();
	
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
   	 World world = new World(new BoundedGrid(12,12));
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
   	world.add(new Location(5,5), main);
   	world.add(new Location(5,6), new Mho());
   	/**
   	java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new java.awt.KeyEventdispatcher() { 
   	public boolean dispatchKeyEvent (java.awt.event.KeyEvent event) {
   	String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString();
   	if (key.equals('q'))
   		main.setDirection(90);
   	 return true;
   	}
   	});
   	*/
   	
   	 
   	
   	
   	world.show();
   	 
    }

}