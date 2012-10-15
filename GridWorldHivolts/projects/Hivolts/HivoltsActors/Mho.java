package HivoltsActors;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

import java.awt.Color;
/**
 * A Mho in the game hivolts that can move and die
 * @author alexlove
 *
 */
public class Mho extends Bug{
	
	
	
	  public Mho()
	    {
	   	 setColor(Color.BLACK);
	   	
	    }
	
	
	  
	/**
	 * 
	 * @param world the world in which the mho in contained
	 * @param main the main player of the game
	 */
	public void act(World<Actor> world, MainPlayer main)
    {
		
		if(canMove())
		{
			//some reason all mhos move 3 spaces each time
			
			Location testUp = new Location(getLocation().getRow()-1 ,(getLocation().getCol()));	
			 if(getGrid().getEmptyAdjacentLocations(getLocation()).contains(testUp))//see if can move up
			 {
				 moveTo( testUp); 
			 }
			 testUp = new Location(getLocation().getRow()-1 ,(getLocation().getCol() +1));
			 if(getGrid().getEmptyAdjacentLocations(getLocation()).contains(testUp))//see if can move up right
			 {
				 moveTo( testUp); 
			 }
			 testUp = new Location(getLocation().getRow()-1 ,(getLocation().getCol()-1));
			 if(getGrid().getEmptyAdjacentLocations(getLocation()).contains(testUp))//see if can move up left
			 {
				 moveTo( testUp); 
			 }
			 testUp = new Location(getLocation().getRow() ,(getLocation().getCol()+1));
			 if(getGrid().getEmptyAdjacentLocations(getLocation()).contains(testUp))//see if can move right
			 {
				 moveTo( testUp); 
			 }
			 testUp = new Location(getLocation().getRow()-1 ,(getLocation().getCol()));
			 if(getGrid().getEmptyAdjacentLocations(getLocation()).contains(testUp))//see if can move left
			 {
				 moveTo( testUp); 
			 }
			 testUp = new Location(getLocation().getRow()+1 ,(getLocation().getCol()));
			 if(getGrid().getEmptyAdjacentLocations(getLocation()).contains(testUp))//see if can move down
			 {
				 moveTo( testUp); 
			 }
			 testUp = new Location(getLocation().getRow()+1 ,(getLocation().getCol()-1));
			 if(getGrid().getEmptyAdjacentLocations(getLocation()).contains(testUp))//see if can move down left
			 {
				 moveTo( testUp); 
			 }
			 testUp = new Location(getLocation().getRow()+1 ,(getLocation().getCol()+1));
			 if(getGrid().getEmptyAdjacentLocations(getLocation()).contains(testUp))//see if can move down right
			 {
				 moveTo( testUp); 
			 }
			 
			
			 
		}
		
	}

}
