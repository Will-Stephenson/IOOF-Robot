import com.stephenson_william.robot_movement.CardinalDirection;
import com.stephenson_william.robot_movement.Direction;
import com.stephenson_william.robot_movement.Robot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class RobotUnitTest {

    private Robot testRobot;

    @BeforeEach
    private void createTestRobot(){
        testRobot = new Robot(1,2, CardinalDirection.NORTH);
    }

    @Test
    void setPosition() {
        testRobot.setPosition(4,3);
        Assertions.assertEquals(4,testRobot.getxPos());
        Assertions.assertEquals(3,testRobot.getyPos());
    }

    @Test
    void rotateLeft() {
        testRobot.rotate(Direction.LEFT);
        Assertions.assertEquals(CardinalDirection.WEST, testRobot.getDirection());
    }

    @Test
    void rotateRight() {
        testRobot.rotate(Direction.RIGHT);
        Assertions.assertEquals(CardinalDirection.EAST, testRobot.getDirection());
    }

    @Test
    void move() {
        testRobot.move();
        Assertions.assertEquals(testRobot.getxPos(),1);
        Assertions.assertEquals(testRobot.getyPos(),3);
    }
}