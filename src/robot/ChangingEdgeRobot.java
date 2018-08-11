package robot;

import java.lang.Math;

/**
 * Class to represent a robot which appears as an n-sided regular polygon, with n changing
 * from 3 up to 10 then back down to 3 and so on, changing by 1 after bouncing off any side.
 *
 * @author Mitchell Faulconbridge
 *
 */
public class ChangingEdgeRobot extends Robot {
    protected int _bounces=3;
    protected int _bounceCountDirection=1;

    /**
     * Default constructor that creates a ChangingEdgeRobot instance whose instance
     * variables are set to default values.
     */
    public ChangingEdgeRobot() {
        super(DEFAULT_X_POS,DEFAULT_Y_POS,DEFAULT_DELTA_X,DEFAULT_DELTA_Y,DEFAULT_WIDTH,DEFAULT_WIDTH);
    }

    /**
     * Creates a ChangingEdgeRobot instance with specified values for instance
     * variables.
     * @param x x position.
     * @param y y position.
     * @param deltaX speed and direction for horizontal axis.
     * @param deltaY speed and direction for vertical axis.
     */
    public ChangingEdgeRobot(int x, int y, int deltaX, int deltaY) {
        super(x,y,deltaX,deltaY,DEFAULT_WIDTH,DEFAULT_WIDTH);
    }

    /**
     * Creates a ChangingEdgeRobot instance with specified values for instance
     * variables.
     * @param x x position.
     * @param y y position.
     * @param deltaX speed (pixels per move call) and direction for horizontal
     *        axis.
     * @param deltaY speed (pixels per move call) and direction for vertical
     *        axis.
     * @param width width in pixels.
     */
    public ChangingEdgeRobot(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x,y,deltaX,deltaY,width,height);
    }

    /**
     * Creates a ChangingEdgeRobot instance with specified values for instance
     * variables.
     * @param x x position.
     * @param y y position.
     * @param deltaX speed (pixels per move call) and direction for horizontal
     *        axis.
     * @param deltaY speed (pixels per move call) and direction for vertical
     *        axis.
     * @param width width in pixels.
     * @param text text to be added
     */
    public ChangingEdgeRobot(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
        super(x,y,deltaX,deltaY,width,height,text);
    }

    /**
     * Counts the number of bounces that the robot has done, ranging from 3 to 10.
     * @param width width of two-dimensional world.
     * @param height height of two-dimensional world.
     */
    public void move(int width, int height){
        int nextX = _x + _deltaX;
        int nextY = _y + _deltaY;

		if (_bounces>9){
			_bounceCountDirection=-1;
		} else if (_bounces<4){
			_bounceCountDirection=1;
		}

        if (nextY <= 0) {
            _bounces+=_bounceCountDirection;
        } else if (nextY + _height >= height) {
            _bounces+=_bounceCountDirection;
        }

        if (nextX <= 0) {
            _bounces+=_bounceCountDirection;
        } else if (nextX + _width >= width) {
            _bounces+=_bounceCountDirection;
        }

        super.move(width,height);
    }

    /**
     * Paints this ChangingEdgeRobot object using the supplied Painter object.
     */
    public void paintOutline(Painter painter) {
        for(int i=0;i<_bounces;i++){
            painter.drawLine((int)Math.round(_width/2*Math.cos((2*Math.PI*i)/_bounces)+(_x+_width/2)),
                             (int)Math.round(_width/2*Math.sin((2*Math.PI*i)/_bounces)+(_y+_width/2)),
                             (int)Math.round(_width/2*Math.cos((2*Math.PI*(i+1))/_bounces)+(_x+_width/2)),
                             (int)Math.round(_width/2*Math.sin((2*Math.PI*(i+1))/_bounces)+(_y+_width/2)));
        }
    }
}
