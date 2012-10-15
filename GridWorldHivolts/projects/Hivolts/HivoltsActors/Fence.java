package HivoltsActors;
import info.gridworld.actor.Actor;

import java.awt.Color;


/**
 * A permanently placed fence that cannot move
 * @author alexlove
 *
 */
public class Fence extends Actor {
    
	public boolean isFence;
    public Fence()
    {
   	 setColor(Color.black);
   	 isFence = true;
    }
    
    
     /**
 	* Overrides the <code>act</code> method in the <code>Actor</code> class
 	* to do nothing.
 	*/
    public void act()
    {
	}
    
    
    
    

}
