package robot;

/**
 * Class to represent a tracked robot which has 6 sides if it is large enough
 * and 4 sides if it is smaller.
 *
 * @author Mitchell Faulconbridge
 */
public class TrackedRobot extends Robot {
    /**
     * Default constructor that creates a TrackedRobot instance whose instance
     * variables are set to default values.
     */
    public TrackedRobot() {
        super();
    }

    /**
     * Creates a TrackedRobot instance with specified values for instance
     * variables.
     * @param x x position.
     * @param y y position.
     * @param deltaX speed and direction for horizontal axis.
     * @param deltaY speed and direction for vertical axis.
     */
    public TrackedRobot(int x, int y, int deltaX, int deltaY) {
        super(x,y,deltaX,deltaY);
    }

    /**
     * Creates a TrackedRobot instance with specified values for instance
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
    public TrackedRobot(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x,y,deltaX,deltaY,width,height);
    }

    /**
     * Creates a TrackedRobot instance with specified values for instance
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
    public TrackedRobot(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
        super(x,y,deltaX,deltaY,width,height,text);
    }

    /**
     * Paints this TrackedRobot object using the supplied Painter object.
     */
    public void paintOutline(Painter painter) {
        if (_width>40) {
            painter.drawLine(_x, (_y+_height/2), (_x+20), _y);
            painter.drawLine((_x+20), _y,(_x+_width-20),_y);
            painter.drawLine((_x+_width-20),_y,(_x+_width),(_y+_height/2));
            painter.drawLine((_x+_width),(_y+_height/2),(_x+_width-20),(_y+_height));
            painter.drawLine((_x+_width-20),(_y+_height),(_x+20),(_y+_height));
            painter.drawLine((_x+20),(_y+_height),_x, (_y+_height/2));
        } else {
            painter.drawLine(_x, (_y+_height/2), (_x+_width/2), _y);
            painter.drawLine((_x+_width/2), _y,(_x+_width),(_y+_height/2));
            painter.drawLine((_x+_width),(_y+_height/2),(_x+_width/2), (_y+_height));
            painter.drawLine((_x+_width/2), (_y+_height),_x, (_y+_height/2));

        }
    }
}