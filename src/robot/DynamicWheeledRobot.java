package robot;

import java.awt.*;

/**
 * Class to represent a dynamic wheeled robot, which appears as a coloured wheeled robot
 * after bouncing off the left or right and as a standard wheeled robot after bouncing
 * off the top or bottom.
 *
 * @author Mitchell Faulconbridge
 *
 */
public class DynamicWheeledRobot extends Robot {
    Color _colour=new Color(0,0,0);
    boolean _bounceOfSide=true;
    /**
     * Default constructor that creates a DynamicWheeledRobot instance whose instance
     * variables are set to default values.
     */
    public DynamicWheeledRobot() {
        super();
    }

    /**
     * Creates a DynamicWheeledRobot instance with specified values for instance
     * variables.
     * @param x x position.
     * @param y y position.
     * @param deltaX speed and direction for horizontal axis.
     * @param deltaY speed and direction for vertical axis.
     */
    public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY) {
        super(x,y,deltaX,deltaY);
    }

    /**
     * Creates a DynamicWheeledRobot instance with specified values for instance
     * variables.
     * @param x x position.
     * @param y y position.
     * @param deltaX speed and direction for horizontal axis.
     * @param deltaY speed and direction for vertical axis.
     * @param colour colour to paint robot with
     */
    public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY, Color colour) {
        super(x,y,deltaX,deltaY);
        _colour=colour;
    }

    /**
     * Creates a DynamicWheeledRobot instance with specified values for instance
     * variables.
     * @param x x position.
     * @param y y position.
     * @param deltaX speed (pixels per move call) and direction for horizontal
     *        axis.
     * @param deltaY speed (pixels per move call) and direction for vertical
     *        axis.
     * @param width width in pixels.
     * @param height height in pixels.
     */
    public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x,y,deltaX,deltaY,width,height);
    }

    /**
     * Creates a DynamicWheeledRobot instance with specified values for instance
     * variables.
     * @param x x position.
     * @param y y position.
     * @param deltaX speed and direction for horizontal axis.
     * @param deltaY speed and direction for vertical axis.
     * @param width width in pixels.
     * @param height height in pixels.
     * @param colour colour to paint robot with
     */
    public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY, int width, int height, Color colour) {
        super(x,y,deltaX,deltaY,width,height);
        _colour=colour;
    }

    /**
     * Creates a DynamicWheeledRobot instance with specified values for instance
     * variables.
     * @param x x position.
     * @param y y position.
     * @param deltaX speed and direction for horizontal axis.
     * @param deltaY speed and direction for vertical axis.
     * @param width width in pixels.
     * @param height height in pixels.
     * @param text text to be displayed
     * @param colour colour to paint robot with
     */
    public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY, int width, int height, String text, Color colour) {
        super(x,y,deltaX,deltaY,width,height,text);
        _colour=colour;
    }

    /**
     * Checks if robot has bounced of side or top/bottom.
     * @param width width of two-dimensional world.
     * @param height height of two-dimensional world.
     */
    public void move(int width, int height){
        int nextX = _x + _deltaX;
        int nextY = _y + _deltaY;

        if (nextY <= 0) {
            _bounceOfSide=false;
        } else if (nextY + _height >= height) {
            _bounceOfSide=false;
        }

        if (nextX <= 0) {
            _bounceOfSide=true;
        } else if (nextX + _width >= width) {
            _bounceOfSide=true;
        }

        super.move(width,height);
    }

    /**
     * Paints this DynamicWheeledRobot object using the supplied Painter object.
     */
    public void paintOutline(Painter painter) {
        painter.setColour(_colour);
        if(_bounceOfSide){
            painter.fillRect(_x,_y,_width,_height);
        } else {
            painter.drawRect(_x,_y,_width,_height);
        }
        // Reset colour for other robots
        painter.setColour(new Color(0,0,0));
    }
}
