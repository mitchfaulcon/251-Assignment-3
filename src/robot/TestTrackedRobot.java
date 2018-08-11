package robot;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;


/**
 * A class that implements test cases aimed at identifying bugs in the
 * implementations of class TrackedRobot.
 *
 * @author Mitchell Faulconbridge
 *
 */
public class TestTrackedRobot {
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
     * Test to ensure that the small tracked robot has been painted correctly
     */
    @Test
    public void testSmallTrackedRobotPaintedCorrectly(){
        TrackedRobot robot = new TrackedRobot(40,25,3,6,30,30);
        robot.paint(_painter);
        assertEquals("(line 40,40,55,25)(line 55,25,70,40)(line 70,40,55,55)(line 55,55,40,40)",_painter.toString());
    }

    /**
     * Test to ensure that the large tracked robot has been painted correctly
     */
    @Test
    public void testLargeTrackedRobotPaintedCorrectly(){
        TrackedRobot robot = new TrackedRobot(40,25,3,6,50,50);
        robot.paint(_painter);
        assertEquals("(line 40,50,60,25)(line 60,25,70,25)(line 70,25,90,50)(line 90,50,70,75)(line 70,75,60,75)(line 60,75,40,50)",_painter.toString());
    }
}