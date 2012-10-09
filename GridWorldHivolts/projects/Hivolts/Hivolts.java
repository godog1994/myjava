import java.util.ArrayList;


import HivoltsActors.Fence;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;
import HivoltsActors.Mho;
import HivoltsActors.MainPlayer;


public class Hivolts {

    /**
     * @param args
     */
    public static void main(String[] args) {
   	 World world = new World(new BoundedGrid(12,12));
   	 //Fence[] testFence = new Fence();
   	 //List<Fence> fences = new ArrayList<Fence>();
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
   	 world.add(new Location(5,5), new MainPlayer());
   	world.add(new Location(5,6), new Mho());
   	 world.show();

    }

}