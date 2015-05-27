import sofia.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  The class here is the subclass of Jeroo
 *  known as MazeRunner. In this class, the MazeRunner
 *  will execute certain instructions to collect all
 *  flowers and remove all nets in any given
 *  random island varying from different width,
 *  height, number of flowers, and number of nets.
 *  
 *
 *  @author Christopher Aska Toda (aska192)
 *  @version 2.2.1-14 (2013.09.24)
 */
public class MazeRunner extends Jeroo
{
    //~ Fields ................................................................
    private int retrievePointX;
    private int retrievePointY;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------

    /**
     * Creates a new MazeRunner object.
     */

    public MazeRunner()
    {
        super(1, 1, 10);
    }

    /**
     * The code below is myProgram that
     * contains grouped methods and behaviors
     * for the subclass Jeroo, MazeRunner, 
     * to execute in the island. The goal for the
     * MazeRunner to be collecting all the flowers
     * and removing all the net in the island and
     * ending at the south-east of the island.
     * The first two codes is assigning variables
     * to the coordinates at the south-east of the island
     * so that the MazeRunner can stop there
     * when the following conditions are met.
     */

    public void myProgram()
    {
        retrievePointX = this.getEndX();
        retrievePointY = this.getEndY();

        this.runAlongPath();

    }

    //~ Methods ...............................................................

    /**
     * The following methods below is telling
     * MazeRunner to walk or run on the narrow
     * pathways of the island and picking flowers,
     * and also removing nets on the way. 
     * It is also followed with additional
     * methods such as if it sees water ahead,
     * turn a different direction and change routes
     * to collect flowers and remove nets in 
     * different path ways.
     */

    public void runAlongPath()
    {
        while (!stop())
        {

            if (this.seesFlower(HERE))
            {
                this.pick();
            }
            else if (this.seesFlower(AHEAD))
            {
                this.hop();
                this.pick();
            }
            else if (this.seesFlower(LEFT))
            {
                this.turn(LEFT);
                this.hop();
                this.pick();
                this.runAlongPath();
                
            }

            this.seeNoWater();
            this.turnAtEndRoad();
            this.removeNet();
            this.changeRoute();
        }
    }

    /**
     * The following method below evaluates the boolean
     * of stop and checks each method in myProgram and
     * say if they are true or false to either execute
     * the methods and instructions.
     * 
     * @return true / false has ended.
     */

    public boolean stop()
    {
        return (this.getWorld().getObjects(Flower.class).size() == 0 
            && this.getWorld().getObjects(Net.class).size() == 0) 
            && (this.getGridX() == retrievePointX 
            && this.getGridY() == retrievePointY);
    }

    /**
     * The following method below will make the MazeRunner
     * change directions and walk in a different pathway 
     * when it sees water ahead and on either left or right, or 
     * both. 
     */

    public void turnAtEndRoad()
    {
        if (this.seesWater(AHEAD))
        {
            if (this.seesWater(LEFT) && !this.seesWater(RIGHT))
            {
                this.turn(RIGHT);
            }
            else if (this.seesWater(RIGHT) && !this.seesWater(LEFT))
            {
                this.turn(LEFT);
            }
            else if (this.seesWater(LEFT) && this.seesWater(RIGHT) 
                && this.seesWater(AHEAD))
            {
                this.turn(LEFT);
                this.turn(LEFT);
            }
            else
            {
                this.turn(LEFT);
            }
            this.runAlongPath();
            
        }

    }

    /**
     * The following method below holds a statement
     * that if the MazeRunner sees a net ahead of 
     * itself while hopping along the pathway,
     * it will remove the nets and keep on 
     * walking along the pathway.
     */

    public void removeNet()
    {
        if (this.seesNet(AHEAD) && this.hasFlower())
        {
            this.toss();
            this.runAlongPath();
        }
    }

    /**
     * The following method below is telling
     * the MazeRunner to keep walking or hopping
     * along the pathway as long as it is clear
     * ahead and also collect any flowers it sees 
     * ahead while walking.
     * There is a statement declared when all the
     * flowers are picked, all nets removed, and 
     * then when the MazeRunner ends up at the 
     * south-east of the island, it will stop there.
     */

    public void seeNoWater()
    {
        while (!stop() && this.isClear(AHEAD))
        {
            this.hop();
            this.changeRoute();
        }

        if (this.seesFlower(AHEAD))
        {
            this.hop();
            this.pick();
            this.runAlongPath();
            
        }

    }

    /**
     * The following methods below is giving
     * instructions to the MazeRunner when it is stuck
     * and so that it can change directions at different
     * situations for example like when it is clear left,
     * clear right, NOT clear ahead, NOT facing east, and
     * NOT facing north will make the MazeRunner turn right.
     * After changing the directions under certain conditions,
     * the Jeroo will keep on executing the program and 
     * walk along the path till there are no flowers and nets
     * on the island.
     */

    public void changeRoute()
    {
        if (!stop()) 
        {
            if (!this.isFacing(SOUTH) && this.seesWater(LEFT) 
                && this.isClear(RIGHT) || this.seesFlower(RIGHT) 
                || this.seesNet(RIGHT))
            {
                this.turn(RIGHT);
            }
            else if (!this.isFacing(WEST) && !this.isFacing(SOUTH) 
                && !this.isFacing(EAST) && this.seesWater(RIGHT) 
                && this.isClear(LEFT) || this.seesFlower(LEFT) 
                || this.seesNet(LEFT))
            {
                this.turn(LEFT);
            }
            else if (this.isClear(LEFT) && this.isClear(RIGHT) 
                && !this.isClear(AHEAD) && !this.isFacing(EAST) 
                && !this.isFacing(NORTH))
            {
                this.turn(RIGHT);
            }
            else if (this.isClear(LEFT) && this.isClear(AHEAD) 
                && this.isFacing(EAST) && !this.isClear(RIGHT))
            {
                this.hop();
            }
            else if (this.isClear(LEFT) && this.isClear(AHEAD) 
                && this.isFacing(SOUTH) && this.seesWater(RIGHT))
            {
                this.hop();
            }      
            else if (this.isClear(LEFT) && this.isClear(AHEAD) 
                && this.isFacing(NORTH) && this.seesWater(RIGHT))
            {
                this.hop();
            }  
            else if (this.isClear(LEFT) && this.isClear(RIGHT) 
                && !this.isClear(AHEAD) && this.isFacing(EAST))
            {
                this.turn(LEFT);
            }       
            else if (this.isClear(LEFT) && this.isClear(RIGHT) 
                && !this.isClear(AHEAD) && !this.isFacing(EAST) 
                && this.isFacing(NORTH))
            {
                this.turn(RIGHT);
            }
            else if (this.isClear(LEFT) && !this.isClear(RIGHT) 
                && this.isClear(AHEAD) && !this.isFacing(EAST) 
                && this.isFacing(WEST))
            {
                this.hop();
            }
            else if (this.isClear(LEFT) && this.isClear(AHEAD) 
                && this.isFacing(EAST) && this.isClear(RIGHT))
            {
                this.turn(RIGHT);
            }
            else if (this.isClear(LEFT) && this.isClear(AHEAD) 
                && this.isFacing(NORTH) && this.isClear(RIGHT))
            {
                this.turn(RIGHT);
            }
            else if (this.isClear(LEFT) && this.isClear(AHEAD) 
                && this.isFacing(WEST) && this.isClear(RIGHT))
            {
                this.turn(RIGHT);
            }
            else if (this.isClear(LEFT) && this.isClear(AHEAD) 
                && this.isFacing(SOUTH) && this.isClear(RIGHT))
            {
                this.turn(RIGHT);
            }

            this.runAlongPath();
            

        }
    }

    /**
     * The code below is declaring an integer boolean
     * and getting the points at the south-east of the
     * island so that it can be assigned to the MazeRunner
     * to stop there. The code getEndX() is implemented 
     * on the x-axis or the width and minus 2 to find that
     * coordination at the south-east of the island.
     * 
     * @return true / false has ended.
     */

    public int getEndX()
    {
        int width = this.getWorld().getWidth();
        return width - 2;

    }

    /**
     * The code below is declaring an integer boolean
     * and getting the points at the south-east of the
     * island so that it can be assigned to the MazeRunner
     * to stop there. The code getEndY() is implemented 
     * on the y-axis or the height and minus 2 to find that
     * coordinatAion at the south-east of the island.
     * 
     * @return true / false has ended.
     */

    public int getEndY()
    {
        int height = this.getWorld().getHeight();
        return height - 2;

    }
}