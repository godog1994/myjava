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
	static Location mainLocation;
	static Random generator = new Random();
	static int turnCount = 0;

	
    
	public int getTurnCount()
	{
		return turnCount;
	}
	
	
	/**
     * @param args
     */
    public static void main(String[] args) {
    
    final BoundedGrid gameGrid = new BoundedGrid(12,12);
   	 World<Actor> world = new World(gameGrid);
   	 ArrayList<Fence> myFences = new ArrayList<Fence>();
   	 /**
   	  * Adding border of fences
   	  */
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
   	 mainLocation = world.getRandomEmptyLocation();
   	 main.putSelfInGrid(gameGrid, mainLocation);
   	 
   	 
   	ArrayList<Mho> mhoList = new ArrayList<Mho>();
   		
   		/**
   		 * adding random Mhos
   		 */
   		for (int i = 0; i <12; i++)
   		{
   			int x = generator.nextInt(10)+1;
   			int y = generator.nextInt(10)+1;
   			mhoList.add(new Mho());
   			Location mhoLocation = world.getRandomEmptyLocation();
   			
   				
   				world.add(mhoLocation,mhoList.iterator().next());
   			
   			
   		}
   		
   		ArrayList<Fence> randomFenceList = new ArrayList<Fence>();
   		/**
   		 * Adding random fences
   		 */
   		for (int i = 0; i <20; i++)
   		{
   			int x = generator.nextInt(10)+1;
   			int y = generator.nextInt(10)+1;
   			randomFenceList.add(new Fence());;
   			Location randomFenceLocation = world.getRandomEmptyLocation();
   			
   				
   				
      			world.add(randomFenceLocation, randomFenceList.iterator().next());
      			
   			
   			
   		}
   		//for (int i = 0; i < mhoList.size();i++)
    	{
    		//mhoList.iterator().next().act();
    	}
    
    
   
   		
   	java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new java.awt.KeyEventDispatcher() { 
   	public boolean dispatchKeyEvent (java.awt.event.KeyEvent event) {
   	String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString();
	if (turnCount %2 == 0 )
   	{
   	
   	if (key.equals("pressed Q"))//move up and left
   	{
   		
   		turnCount++;
   		main.setKeyPressed('Q');
   		System.out.println(turnCount);
   		main.act();
   		
   	}
   	if (key.equals("pressed E"))//move up and right
   	{
   		turnCount++;
   		main.setKeyPressed('E');
   		System.out.println(turnCount);
   		main.act();
   		
   	}
   	if (key.equals("pressed W"))//move up
   	{
   		turnCount++;
   		main.setKeyPressed('W');
   		System.out.println(turnCount);
   		main.act();
   		
   	}
   	if (key.equals("pressed D"))//move right
   	{
   		turnCount++;
   		main.setKeyPressed('D');
   		System.out.println(turnCount);
   		main.act();
   		
   	}
	if (key.equals("pressed A"))//move down
   	{
		turnCount++;
		main.setKeyPressed('A');
		System.out.println(turnCount);
   		main.act();
   		
   	}
   	if (key.equals("pressed S"))//move down
   	{
   		turnCount++;
   		main.setKeyPressed('S');
   		System.out.println(turnCount);
   		main.act();
   		
   	}
	if (key.equals("pressed Z"))//move down
   	{
		turnCount++;
		main.setKeyPressed('Z');
   		System.out.println(turnCount);
   		main.act();
   		
   	}
	if (key.equals("pressed X"))//move down
   	{
		turnCount++;
		main.setKeyPressed('X');
   		System.out.println(turnCount);
   		main.act();
   		
   	} 
	if (key.equals("pressed C"))//move down
   	{
		turnCount++;
		main.setKeyPressed('C');
   		System.out.println(turnCount);
   		main.act();
   		
   	} 
	if (key.equals("pressed J"))//move down
   	{
		turnCount++;
		main.setKeyPressed('J');
   		System.out.println(turnCount);
   		main.act();
   		
   	}
	
   	}
	return true;
   	
   	}
   	});
   	
   	
	while (turnCount %2 ==1){
		
	    	System.out.println("in the loop");
	    	
	   		for (int i = 0; i < mhoList.size();i++)
	    	{
	    		mhoList.iterator().next().act();
	    	}
	    	turnCount++;
	    
	}
   	
   	
   	 if( main.isDead())
   	 {
   		 world.setMessage("You have died. You lose.");
   	 }
   	 
   	 for (int i=0; i <=turnCount;i++)
   	 {
   		System.out.println(turnCount);
   	 }
   	
   	
   	world.show();
   	 
    }

}