package HivoltsActors;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

import java.awt.Color;

public class Mho extends Bug{
	
	  public Mho()
	    {
	   	 setColor(Color.WHITE);
	    }
	    
	
	public void act()
    {
		moveTo(getLocation().getAdjacentLocation(getDirection()));
	}

}
