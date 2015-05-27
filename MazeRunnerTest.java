import sofia.micro.*;
import sofia.micro.jeroo.*;
import static sofia.micro.jeroo.CompassDirection.*;
import static sofia.micro.jeroo.RelativeDirection.*;

// -------------------------------------------------------------------------
/**
 *  This class is for the TestCase of the
 *  methods for the MazeRunner to execute. 
 *  This TestClase class will be checking and
 *  testing if the methods the MazeRunner
 *  is executing are correct and agrees with
 *  the result.
 *  
 *  
 *  @author Christopher Aska Toda (aska192)
 *  @version 2.2.1-14 (2013.09.24)
 */
public class MazeRunnerTest extends TestCase
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new MazeRunnerTest test object.
     */
    public MazeRunnerTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }

    //~ Methods ...............................................................

    // ----------------------------------------------------------

    /**
     * Test the myProgram() method and collects
     * all the net and flowers in the island resulting
     * with 0 net and flowers on the island. The MazeRunner
     * would end up at the south-east of the island
     * after collecting all the flowers and removing all 
     * the net on the island.
     * 
     */

    public void testMyProgram()
    {
        Island allIsland = new MazeIsland(45);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());

    }

    /**
     * Test the turnAtEndRoad() method that turns
     * in a different pathway when arrives at an end point.
     * 
     */

    public void testTurnAtEndRoad()
    {
        Island island = new MazeIsland(70); 
        MazeRunner runner = new MazeRunner();
        island.add(runner, 1, 1);
        runner.myProgram();

        // The jeroo should end at the south east corner of island
        assertEquals(9, runner.getGridX());
        assertEquals(5, runner.getGridY());

        assertTrue(runner.isFacing(NORTH));

        assertEquals(0, island.getObjects(Flower.class).size());
        assertEquals(0, island.getObjects(Net.class).size());
    }

    /**
     * Test the removeNet() method that removes
     * all the nets on the island while searching for them
     * by hopping within the island.
     */

    public void testRemoveNet()
    {
        Island island = new MazeIsland(70); 
        MazeRunner runner = new MazeRunner();
        island.add(runner, 1, 1);
        runner.myProgram();

        // The jeroo should end at the south east corner of island
        assertEquals(9, runner.getGridX());
        assertEquals(5, runner.getGridY());

        assertTrue(runner.isFacing(NORTH));

        assertEquals(0, island.getObjects(Flower.class).size());
        assertEquals(0, island.getObjects(Net.class).size());
    }    

    /**
     * Test the seeNoWater() method that keeps on
     * hopping or running when there is no obstacles ahead
     * including water. However, when it is faced with obstacles
     * such as a flower or net then the MazeRunner would 
     * react and collect the flowers or remove the net.
     */

    public void testSeeNoWater()
    {
        Island island = new MazeIsland(70); 
        MazeRunner runner = new MazeRunner();
        island.add(runner, 1, 1);
        runner.myProgram();

        // The jeroo should end at the south east corner of island
        assertEquals(9, runner.getGridX());
        assertEquals(5, runner.getGridY());

        assertTrue(runner.isFacing(NORTH));

        assertEquals(0, island.getObjects(Flower.class).size());
        assertEquals(0, island.getObjects(Net.class).size());

    }    

    /**
     * Test the changeRoute() method that changes
     * direction and going to different pathways so that
     * the MazeRunner can collect the leftover flowers or 
     * remove the nets in a different path or section of the island.
     */

    public void testChangeRoute()
    {
        Island island = new MazeIsland(70); 
        MazeRunner runner = new MazeRunner();
        island.add(runner, 1, 1);
        runner.myProgram();

        // The jeroo should end at the south east corner of island
        assertEquals(9, runner.getGridX());
        assertEquals(5, runner.getGridY());

        assertTrue(runner.isFacing(NORTH));

        assertEquals(0, island.getObjects(Flower.class).size());
        assertEquals(0, island.getObjects(Net.class).size());

    }    

    /**
     * Test the myProgram() method in world 40.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.
     * Such as when the MazeRunner is facing
     * water, and sees water on the left and right.
     */

    public void testWorld40()
    {
        Island allIsland = new MazeIsland(40);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }

    /**
     * Test the myProgram() method in world 21.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.

     */

    public void testWorld21()
    {
        Island allIsland = new MazeIsland(21);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }

    /**
     * Test the myProgram() method in
     * world 22.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.

     */

    public void testWorld22()
    {
        Island allIsland = new MazeIsland(22);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }

    /**
     * Test the myProgram() method in
     * world 24.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.
     */

    public void testWorld24()
    {
        Island allIsland = new MazeIsland(24);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }

    /**
     * Test the myProgram() method in
     * world 30.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.
     */

    public void testWorld30()
    {
        Island allIsland = new MazeIsland(30);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }

    /**
     * Test the myProgram() method in
     * world 31.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.
     */

    public void testWorld31()
    {
        Island allIsland = new MazeIsland(31);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }

    /**
     * Test the myProgram() method in
     * world 33.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.
     */

    public void testWorld33()
    {
        Island allIsland = new MazeIsland(33);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }

    /**
     * Test the myProgram() method in
     * world 34.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.
     */

    public void testWorld34()
    {
        Island allIsland = new MazeIsland(34);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }

    /**
     * Test the myProgram() method in
     * world 35.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.
     */

    public void testWorld35()
    {
        Island allIsland = new MazeIsland(35);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }

    /**
     * Test the myProgram() method in
     * world 36.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.
     */

    public void testWorld36()
    {
        Island allIsland = new MazeIsland(36);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }

    /**
     * Test the myProgram() method in
     * world 38.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.
     */

    public void testWorld38()
    {
        Island allIsland = new MazeIsland(38);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }

    /**
     * Test the myProgram() method in
     * world 39.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.
     */

    public void testWorld39()
    {
        Island allIsland = new MazeIsland(39);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }

    /**
     * Test the myProgram() method in
     * world 42.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.
     */

    public void testWorld42()
    {
        Island allIsland = new MazeIsland(42);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }

    /**
     * Test the myProgram() method in
     * world 47.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.
     */

    public void testWorld47()
    {
        Island allIsland = new MazeIsland(47);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }

    /**
     * Test the myProgram() method in
     * world 48.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.
     */

    public void testWorld48()
    {
        Island allIsland = new MazeIsland(48);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }

    /**
     * Test the myProgram() method in
     * world 50.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.
     */

    public void testWorld50()
    {
        Island allIsland = new MazeIsland(50);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }

    /**
     * Test the myProgram() method in
     * world 54.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.
     */

    public void testWorld54()
    {
        Island allIsland = new MazeIsland(54);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }

    /**
     * Test the myProgram() method in
     * world 55.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.
     */

    public void testWorld55()
    {
        Island allIsland = new MazeIsland(55);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }

    /**
     * Test the myProgram() method in
     * world 65.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.
     */

    public void testWorld65()
    {
        Island allIsland = new MazeIsland(65);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }

    /**
     * Test the myProgram() method in
     * world 95.
     * Testing some other methods that
     * could be used on this island and wasn't
     * capable to be used on other island.
     */

    public void testWorld95()
    {
        Island allIsland = new MazeIsland(95);
        MazeRunner allRunner = new MazeRunner(); 
        allIsland.add(allRunner, 1, 1);
        allRunner.myProgram();
        // The jeroo should end at the south east corner of island
        assertEquals(allIsland.getWidth() - 2, allRunner.getGridX());
        assertEquals(allIsland.getHeight() - 2, allRunner.getGridY());

        assertEquals(0, allIsland.getObjects(Flower.class).size());
        assertEquals(0, allIsland.getObjects(Net.class).size());
    }
    
    
    
    // ----------------------------------------------------------
}
