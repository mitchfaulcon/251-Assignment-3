package robot;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;


/**
 * A class that implements test cases aimed at identifying bugs in the
 * implementations of class FlyingRobot.
 *
 * @author Mitchell Faulconbridge
 *
 */
public class TestFlyingRobot {
    // Fixture object that is used by the tests.
    private MockPainter _painter;

    /**
     * This method is called automatically by the JUnit test-runner immediately
     * before each @Test method is executed. setUp() recreates the fixture so
     * that there no side effects from running individual tests.
     */
    @Before
    public void setUp() {
        _painter = new MockPainter();
    }

    /**
     * Test to ensure that the flying robot has been painted correctly
     */
    @Test
    public void testFlyingRobotPaintedCorrectly(){
        FlyingRobot robot = new FlyingRobot(40,25,3,6,25,20);
        robot.paint(_painter);
        assertEquals("(oval 40,25,25,20)",_painter.toString());
    }
}