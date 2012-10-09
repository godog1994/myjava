package HivoltsActors;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class MainPlayer extends Actor {
	
private char keyPressed;	
	
	  public MainPlayer()
	    {
	   	 setColor(Color.WHITE);
	   	 
	    }
	  
	    public void move()
	    {
	        Grid<Actor> gr = getGrid();
	        if (gr == null)
	            return;
	        Location loc = getLocation();
	        Location next = loc.getAdjacentLocation(getDirection());
	        if (gr.isValid(next))
	            moveTo(next);
	    }
	   
	    
	    public void  setKeyPressed(char c)
	    {
	    	keyPressed = c;
	    }
	    
	    
	    
	    public char getKeyPressed()
	    {
	    	return keyPressed;
	    }
	    
	
	public void act()
    {
	  
		
		
		
		
	   	 
	    
	   	 switch(keyPressed)
	   	 {
	   	 case 'Q': 	//System.out.println(getLocation().getCol() );
	   	 	
	   	 			moveTo(new Location((getLocation().getRow()) -1,(getLocation().getCol())-1));										//move up and left
	   		 break;   	 
	   	 case 'W':  moveTo(new Location((getLocation().getRow()) -1,(getLocation().getCol()))); 	 // move up
	   		 break;   	 
	   	 case 'E':   moveTo(new Location((getLocation().getRow()) -1,(getLocation().getCol())+1));	 // move up and right
	   		 break;   	 
	   	 case 'A':   moveTo(new Location((getLocation().getRow()) ,(getLocation().getCol())-1));	 // move left
	   		 break;
	   	 case 'S':   moveTo(new Location((getLocation().getRow()) ,(getLocation().getCol())));	 // don't move
	   		 break;
	   	 case 'D':   moveTo(new Location((getLocation().getRow()),(getLocation().getCol())+1)); 	 // move right
	   		 break;
	   	 case 'Z':   moveTo(new Location((getLocation().getRow()) +1,(getLocation().getCol())-1));	 // move down and left
	   		 break;
	   	 case 'X':   moveTo(new Location((getLocation().getRow()) +1,(getLocation().getCol())));	 // move down
	   		 break;
	   	 case 'C':   moveTo(new Location((getLocation().getRow()) +1,(getLocation().getCol())+1));	 // move down and right
	   		 break;
	   	 case 'J':   //moveTo(new Location((getLocation().getRow()) -1,(getLocation().getCol())-1));	 // jump
	   		 break;
	   		} 
	   		 
		
	   	 
	   	 
	   	 
	   	 
	}
	
  


	public void die() {
        removeSelfFromGrid();
        System.exit(1);
}

}
