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

/**
 * Sets up a game of hivolts. The board consists of a perimeter of fences, 12 randomly placed mhos, 20 randomly placed fences, and 1 randomly placed main player. Functionality is limited. See attached document.
 * @author alexlove
 *
 */
public class Hivolts extends World {
	private static final World<Actor> world = null;
	public static MainPlayer main = new MainPlayer();
	static Location mainLocation;
	static Random generator = new Random();
	static int turnCount = 0;
	static ArrayList<Mho> mhoList;

	/**
	 * Constructs a game of hivolts with a set up grid.
	 */
	public Hivolts(){
		final BoundedGrid gameGrid = new BoundedGrid(12,12);
		final World<Actor> world = new World(gameGrid);
		ArrayList<Fence> myFences = new ArrayList<Fence>();//array list for perimeter of fences.
		/**
		 * Adding border of fences
		 */
		for (int i = 0; i < 12 ; i++ )//handles cases to loop fences around perimeter
		{
			for (int k = 0; k< 12; k++)
			{
				if ((k<1 || k > 10) || (k>0 && k <12 && (i ==0 || i ==11) ))
				{
					myFences.add(new Fence());//add new fence to list
					world.add(new Location (k,i), myFences.iterator().next());//add fence to location among perimeter
				}
			}



		}
		mainLocation = world.getRandomEmptyLocation();//determines a random starting location for the main player
		main.putSelfInGrid(gameGrid, mainLocation); //puts the main player in gameGrid with the random location


		mhoList = new ArrayList<Mho>();//array list for random mhos

		/**
		 * adding random Mhos
		 */
		for (int i = 0; i <12; i++)//iterate through mhoList
		{
			mhoList.add(new Mho());
			Location mhoLocation = world.getRandomEmptyLocation();//random location for mho to be placed
			mhoList.get(i).putSelfInGrid(gameGrid, mhoLocation);//add mhos to random locations
		}

		ArrayList<Fence> randomFenceList = new ArrayList<Fence>();//array list for randomly placed fences
		/**
		 * Adding random fences
		 */
		for (int i = 0; i <20; i++)
		{
			randomFenceList.add(new Fence());;
			Location randomFenceLocation = world.getRandomEmptyLocation();//location for fences in unoccupied locations in the world
			world.add(randomFenceLocation, randomFenceList.iterator().next());//add fences to the world
		}

		java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new java.awt.KeyEventDispatcher() { 
			/**
			 * keystroke listener for main player
			 */
			public boolean  dispatchKeyEvent (java.awt.event.KeyEvent event) {

				String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString();
				try

				{

					if (key.equals("pressed Q"))//move up and left
					{
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
					if (key.equals("pressed A"))//move left
					{
						main.setKeyPressed('A');
						main.act();
					}
					if (key.equals("pressed S"))//stay for a turn
					{
						main.setKeyPressed('S');
						main.act();
					}
					if (key.equals("pressed Z"))//move down and left
					{
						main.setKeyPressed('Z');
						main.act();

					}
					if (key.equals("pressed X"))//move down 
					{
						main.setKeyPressed('X');
						main.act();

					} 
					if (key.equals("pressed C"))//move down and right
					{
						main.setKeyPressed('C');
						main.act();
					}
					if (key.equals("pressed J"))//move to random location					
					{
						turnCount++;
						main.moveTo(world.getRandomEmptyLocation());//does not function properly because no chance of landing on a mho

					}
					

				}
				//main dies if this happens
				catch (IllegalStateException ex)
				{
					main.die(world);
				}
				catch(NullPointerException e)
				{

				}



				mhoMove();//attempt to move mhos



				return true;


			}
		});

		
		world.show();//show world
		for(int i = 0; i < mhoList.size(); i++)
		{
			if(main.getLocation().compareTo(mhoList.get(i).getLocation()) == 0)
			{
			System.out.println("hello");//testing to see if works	
				main.die();
			}
		}

	}

	public void mhoMove()
	{
		for (int i = 0; i < mhoList.size();i++)//loop through mho's and act
		{
			mhoList.get(i).act(world, main);
		}
	}





	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Hivolts newGame = new Hivolts();//make a new game


	}//end main

}//end class