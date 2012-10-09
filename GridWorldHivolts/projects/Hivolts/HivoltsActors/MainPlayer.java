package HivoltsActors;

import info.gridworld.actor.Actor;

import java.awt.Color;

public class MainPlayer extends Actor {
	
	  public MainPlayer()
	    {
	   	 setColor(Color.white);
	    }
	    
	
	public void act()
    {
	   	 
	   	 char charPressed ='0';
	   
	   	 switch(charPressed)
	   	 {
	   	 case 'Q': 	 //move up and left
	   		 break;   	 
	   	 case 'W':   	 // move up
	   		 break;   	 
	   	 case 'E':   	 // move up and right
	   		 break;   	 
	   	 case 'A':   	 // move left
	   		 break;
	   	 case 'S':   	 // don't move
	   		 break;
	   	 case 'D':   	 // move right
	   		 break;
	   	 case 'Z':   	 // move down and left
	   		 break;
	   	 case 'X':   	 // move down
	   		 break;
	   	 case 'C':   	 // move down and right
	   		 break;
	   	 case 'J':   	 // jump
	   		 break;
	   	 
	   	 }
	   	 
	   	 
	}
	
    public void die() {
        removeSelfFromGrid();
        System.exit(1);
}

}
