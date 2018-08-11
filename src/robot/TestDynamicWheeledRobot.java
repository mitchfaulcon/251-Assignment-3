package robot;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;


/**
 * A class that implements test cases aimed at identifying bugs in the
 * implementations of class DynamicWheeledRobot.
 *
 * @author Mitchell Faulconbridge
 *
 */
public class TestDynamicWheeledRobot {
    // Fixture object that is used by the tests.
    private MockPainter _painter;

    /**+
     * This method is called automatically by the JUnit test-runner immediately
     * before each @Test method is executed. setUp() recreates the fixture so
     * that there no side effects from running individual tests.
     */
    @Before
    public void setUp() {
        _painter = new MockPainter();
    }

    /**
     * Test to check that colour of the dynamic wheeled robot has been set correctly
     */
    @Test
    public void testDynamicColour(){
        _painter.setColour(new Color(135,100,50));
        _painter.getColour();
        assertEquals("setColour java.awt.Color[r=135,g=100,b=50])getColour java.awt.Color[r=135,g=100,b=50])",_painter.toString());
    }

    /**
     * Check that colour of the dynamic wheeled robot is correct after bouncing
     * off the top wall
     */
    @Test
    public void testDynamicRobotBounceOffTop() {
        DynamicWheeledRobot robot = new DynamicWheeledRobot(10, 10, 0, -10);
        robot.paint(_painter);
        robot.move(125, 135);
        robot.paint(_painter);
        robot.move(125, 135);
        robot.paint(_painter);
        assertEquals("setColour java.awt.Color[r=0,g=0,b=0])(fill 10,10,25,35)setColour java.awt.Color[r=0,g=0,b=0])" +
                "setColour java.awt.Color[r=0,g=0,b=0])(rectangle 10,0,25,35)setColour java.awt.Color[r=0,g=0,b=0])" +
                "setColour java.awt.Color[r=0,g=0,b=0])(rectangle 10,10,25,35)setColour java.awt.Color[r=0,g=0,b=0])", _painter.toString());
    }

    /**
     * Check that colour of the dynamic wheeled robot is correct after bouncing
     * off the bottom wall
     */
    @Test
    public void testDynamicRobotBounceOffBottom() {
        DynamicWheeledRobot robot = new DynamicWheeledRobot(50, 90, 0, 10,10,10);
        robot.paint(_painter);
        robot.move(100, 100);
        robot.paint(_painter);
        robot.move(100, 100);
        robot.paint(_painter);
        assertEquals("setColour java.awt.Color[r=0,g=0,b=0])(fill 50,90,10,10)setColour java.awt.Color[r=0,g=0,b=0])" +
                "setColour java.awt.Color[r=0,g=0,b=0])(rectangle 50,90,10,10)setColour java.awt.Color[r=0,g=0,b=0])" +
                "setColour java.awt.Color[r=0,g=0,b=0])(rectangle 50,80,10,10)setColour java.awt.Color[r=0,g=0,b=0])", _painter.toString());
    }

    /**
     * Check that colour of the dynamic wheeled robot is correct after bouncing
     * off the left wall
     */
    @Test
    public void testDynamicRobotBounceOffLeft() {
        DynamicWheeledRobot robot = new DynamicWheeledRobot(10, 10, -10, 0);
        robot.paint(_painter);
        robot.move(100, 100);
        robot.paint(_painter);
        robot.move(100, 100);
        robot.paint(_painter);
        assertEquals("setColour java.awt.Color[r=0,g=0,b=0])(fill 10,10,25,35)setColour java.awt.Color[r=0,g=0,b=0])" +
                "setColour java.awt.Color[r=0,g=0,b=0])(fill 0,10,25,35)setColour java.awt.Color[r=0,g=0,b=0])" +
                "setColour java.awt.Color[r=0,g=0,b=0])(fill 10,10,25,35)setColour java.awt.Color[r=0,g=0,b=0])", _painter.toString());
    }

    /**
     * Check that colour of the dynamic wheeled robot is correct after bouncing
     * off the right wall
     */
    @Test
    public void testDynamicRobotBounceOffRight() {
        DynamicWheeledRobot robot = new DynamicWheeledRobot(90, 50, 10, 0,10,10);
        robot.paint(_painter);
        robot.move(100, 100);
        robot.paint(_painter);
        robot.move(100, 100);
        robot.paint(_painter);
        assertEquals("setColour java.awt.Color[r=0,g=0,b=0])(fill 90,50,10,10)setColour java.awt.Color[r=0,g=0,b=0])" +
                "setColour java.awt.Color[r=0,g=0,b=0])(fill 90,50,10,10)setColour java.awt.Color[r=0,g=0,b=0])" +
                "setColour java.awt.Color[r=0,g=0,b=0])(fill 80,50,10,10)setColour java.awt.Color[r=0,g=0,b=0])", _painter.toString());
    }

    /**
     * Check that colour of the dynamic wheeled robot is correct after bouncing
     * off the top left corner
     */
    @Test
    public void testDynamicRobotBounceOffTopLeft() {
        DynamicWheeledRobot robot = new DynamicWheeledRobot(10, 10, -10, -10);
        robot.paint(_painter);
        robot.move(125, 135);
        robot.paint(_painter);
        robot.move(125, 135);
        robot.paint(_painter);
        assertEquals("setColour java.awt.Color[r=0,g=0,b=0])(fill 10,10,25,35)setColour java.awt.Color[r=0,g=0,b=0])" +
                "setColour java.awt.Color[r=0,g=0,b=0])(fill 0,0,25,35)setColour java.awt.Color[r=0,g=0,b=0])" +
                "setColour java.awt.Color[r=0,g=0,b=0])(fill 10,10,25,35)setColour java.awt.Color[r=0,g=0,b=0])", _painter.toString());
    }

    /**
     * Check that colour of the dynamic wheeled robot is correct after bouncing
     * off the top right corner
     */
    @Test
    public void testDynamicRobotBounceOffTopRight() {
        DynamicWheeledRobot robot = new DynamicWheeledRobot(90, 10, -12, -12);
        robot.paint(_painter);
        robot.move(125, 135);
        robot.paint(_painter);
        robot.move(125, 135);
        robot.paint(_painter);
        assertEquals("setColour java.awt.Color[r=0,g=0,b=0])(fill 90,10,25,35)setColour java.awt.Color[r=0,g=0,b=0])" +
                "setColour java.awt.Color[r=0,g=0,b=0])(rectangle 78,0,25,35)setColour java.awt.Color[r=0,g=0,b=0])setColour " +
                "java.awt.Color[r=0,g=0,b=0])(rectangle 66,12,25,35)setColour java.awt.Color[r=0,g=0,b=0])", _painter.toString());
    }

    /**
     * Check that colour of the dynamic wheeled robot is correct after bouncing
     * off the bottom left corner
     */
    @Test
    public void testDynamicRobotBounceOffBottomLeft() {
        DynamicWheeledRobot robot = new DynamicWheeledRobot(10, 90, -12,-15);
        robot.paint(_painter);
        robot.move(125, 135);
        robot.paint(_painter);
        robot.move(125, 135);
        robot.paint(_painter);
        assertEquals("setColour java.awt.Color[r=0,g=0,b=0])(fill 10,90,25,35)setColour java.awt.Color[r=0,g=0,b=0])" +
                "setColour java.awt.Color[r=0,g=0,b=0])(fill 0,75,25,35)setColour java.awt.Color[r=0,g=0,b=0])" +
                "setColour java.awt.Color[r=0,g=0,b=0])(fill 12,60,25,35)setColour java.awt.Color[r=0,g=0,b=0])", _painter.toString());
    }

    /**
     * Check that colour of the dynamic wheeled robot is correct after bouncing
     * off the bottom right corner
     */
    @Test
    public void testDynamicRobotBounceOffBottomRight() {
        DynamicWheeledRobot robot = new DynamicWheeledRobot(90, 90, 12, 15);
        robot.paint(_painter);
        robot.move(125, 135);
        robot.paint(_painter);
        robot.move(125, 135);
        robot.paint(_painter);
        assertEquals("setColour java.awt.Color[r=0,g=0,b=0])(fill 90,90,25,35)setColour java.awt.Color[r=0,g=0,b=0])" +
                "setColour java.awt.Color[r=0,g=0,b=0])(fill 100,100,25,35)setColour java.awt.Color[r=0,g=0,b=0])" +
                "setColour java.awt.Color[r=0,g=0,b=0])(fill 88,85,25,35)setColour java.awt.Color[r=0,g=0,b=0])", _painter.toString());
    }
}