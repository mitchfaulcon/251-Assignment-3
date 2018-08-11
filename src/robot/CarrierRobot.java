package robot;

import java.util.ArrayList;
import java.util.List;

public class CarrierRobot extends Robot{

    List<Robot> _children = new ArrayList<>();

    /**
     * Creates a CarrierRobot object with default values for state.
     */
    public CarrierRobot() {
        super();
    }

    /**
     * Creates a CarrierRobot object with specified location values,
     * default values for other state items.
     */
    public CarrierRobot(int x, int y) {
        super(x,y);
    }

    /**
     * Creates a CarrierRobot with specified values for location, velocity
     * and direction. Non-specified state items take on default values.
     */
    public CarrierRobot(int x, int y, int deltaX, int deltaY) {
        super(x,y,deltaX,deltaY);
    }

    /**
     * Creates a CarrierRobot with specified values for location, velocity,
     * direction, width and height.
     */
    public CarrierRobot(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x,y,deltaX,deltaY,width,height);
    }

    /**
     * Creates a CarrierRobot with specified values for location, velocity,
     * direction, width and height.
     */
    public CarrierRobot(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
        super(x,y,deltaX,deltaY,width,height,text);
    }

    /**
     * Moves a CarrierRobot object (including its children) within the bounds
     * specified by arguments width and height.
     */
    public void move(int width, int height){
        super.move(width,height);
        for (Robot child:_children){
            child.move(_width,_height);
        }
    }

    /**
     * Paints a CarrierRobot object by drawing a rectangle around the edge of
     * its bounding box. The CarrierRobot object's children are then painted.
     */
    public void paintOutline(Painter painter){
        painter.drawRect(_x,_y,_width,_height);
        painter.translate(_x,_y);
        for (Robot child:_children){
            child.paint(painter);
        }
        painter.translate(-_x,-_y);
    }

    /**
     * Attempts to add a robot to a CarrierRobot object. If successful, a
     * two-way link is established between the CarrierRobot and the newly
     * added Robot.
     * @param robot the robot to be added.
     * @throws IllegalArgumentException if an attempt is made to add a Robot
     * to a CarrierRobot instance where the Robot argument is already a child
     * within a CarrierRobot instance. An IllegalArgumentException is also
     * thrown when an attempt is made to add a Robot that will not fit within
     * the bounds of the proposed CarrierRobot object.
     */
    void add(Robot robot) throws IllegalArgumentException{
        // Check if child will fit within parent bounding box
        if (robot._parent!=null || robot._x+robot._width>_width || robot._y+robot._height>_height){
            throw new IllegalArgumentException();
        } else {
            // Establish link between parent and child
            _children.add(robot);
            robot._parent=this;
        }
    }

    /**
     * Removes a particular Robot from a CarrierRobot instance. Once removed,
     * the two-way link between the CarrierRobot and its former child is
     * destroyed. This method has no effect if the Robot specified to remove
     * is not a child of the CarrierRobot.
     * @param robot the robot to be removed.
     */
    void remove(Robot robot){
        if (_children.contains(robot)) {
            _children.remove(robot);
            robot._parent=null;
        }
    }

    /**
     * Returns the Robot at a specified position within a CarrierRobot. If
     * the position specified is less than zero or greater than the number of
     * children stored in the CarrierRobot less one this method throws an
     * IndexOutOfBoundsException.
     * @param index the specified index position.
     */
    public Robot robotAt(int index) throws IndexOutOfBoundsException{
        if (index<0 || index>_children.size()-1){
            throw new IndexOutOfBoundsException();
        } else {
            return _children.get(index);
        }
    }

    /**
     * Returns the number of children contained within a CarrierRobot object.
     */
    public int robotCount(){
        return _children.size();
    }

    /**
     * Returns the index of a specified child within a CarrierRobot object.
     * If the Robot specified is not actually a child of the CarrierRobot
     * this method returns -1; otherwise the value returned is in the range
     * 0 .. robotCount() - 1.
     * @param robot the robot whose index position within the CarrierRobot is
     * requested.
     */
    public int indexOf(Robot robot){
        if (_children.contains(robot)){
            return _children.indexOf(robot);
        } else {
            return -1;
        }
    }

    /**
     * Returns true if the Robot argument is a child of the CarrierRobot
     * object on which this method is called, false otherwise.
     */
    public boolean contains(Robot robot){
        return _children.contains(robot);
    }
}