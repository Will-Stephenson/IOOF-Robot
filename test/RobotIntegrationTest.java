import com.stephenson_william.robot_movement.CardinalDirection;
import com.stephenson_william.robot_movement.Direction;
import com.stephenson_william.robot_movement.Robot;
import com.stephenson_william.robot_movement.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class RobotIntegrationTest {

    private Robot testRobot;

    @BeforeEach
    private void createTestRobot(){

    }

    @Test
    void moveRobot() {
        testRobot = new Robot(1,2, CardinalDirection.EAST);

        testRobot.move();
        testRobot.move();
        testRobot.move();

        Assertions.assertEquals(4,testRobot.getxPos());
        Assertions.assertEquals(2,testRobot.getyPos());
    }

    @Test
    void moveAndRotateRobot() {
        testRobot = new Robot(2,1, CardinalDirection.NORTH);

        testRobot.move();
        testRobot.rotate(Direction.RIGHT);
        testRobot.move();
        testRobot.rotate(Direction.LEFT);
        testRobot.move();

        Assertions.assertEquals(3,testRobot.getxPos());
        Assertions.assertEquals(3,testRobot.getyPos());
        Assertions.assertEquals(CardinalDirection.NORTH,testRobot.getDirection());
    }

    @Test
    void moveRobotOverEdge() {
        testRobot = new Robot(1,1, CardinalDirection.NORTH);

        testRobot.move();
        testRobot.move();
        testRobot.move();
        testRobot.move();
        testRobot.move();
        testRobot.move();

        Assertions.assertEquals(1,testRobot.getxPos());
        Assertions.assertEquals(5,testRobot.getyPos());
    }

    @Test
    void placeRobot(){
        testRobot = new Robot();
        Main.parseInput(testRobot, "PLACE 1,3,NORTH");
        Assertions.assertEquals(1,testRobot.getxPos());
        Assertions.assertEquals(3,testRobot.getyPos());
        Assertions.assertEquals(CardinalDirection.NORTH,testRobot.getDirection());
    }

    @Test
    void placeAndMoveRobot(){
        testRobot = new Robot();
        Main.parseInput(testRobot, "PLACE 4,2,SOUTH");
        Main.parseInput(testRobot, "MOVE");
        Assertions.assertEquals(4,testRobot.getxPos());
        Assertions.assertEquals(1,testRobot.getyPos());
        Assertions.assertEquals(CardinalDirection.SOUTH,testRobot.getDirection());
    }

    @Test
    void placeAndRotateRobot(){
        testRobot = new Robot();
        Main.parseInput(testRobot, "PLACE 4,2,EAST");
        Main.parseInput(testRobot, "RIGHT");
        Assertions.assertEquals(4,testRobot.getxPos());
        Assertions.assertEquals(2,testRobot.getyPos());
        Assertions.assertEquals(CardinalDirection.SOUTH,testRobot.getDirection());
    }

}
