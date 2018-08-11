package robot.views;

import robot.CarrierRobot;
import robot.Robot;
import robot.RobotModel;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class Task1 implements TreeModel{
    private RobotModel _robotModel;
    protected TreeModelListener _treeModelListener;

    Task1(RobotModel robotModel){
        _robotModel=robotModel;
    }

    public Object getRoot() {
        return _robotModel.root();
    }

    public Object getChild(Object parent, int index) {
        if (parent instanceof CarrierRobot){

            try {
                return ((CarrierRobot) parent).robotAt(index);
            }
            catch (NullPointerException | IndexOutOfBoundsException e){
                return null;
            }

        } else {
            return null;
        }
    }

    public int getChildCount(Object parent) {
        if (parent instanceof CarrierRobot){
            return ((CarrierRobot) parent).robotCount();
        }
        return 0;
    }

    public boolean isLeaf(Object node) {
        return !(node instanceof CarrierRobot);
    }

    public void valueForPathChanged(TreePath path, Object newValue) {

    }

    public int getIndexOfChild(Object parent, Object child) {
        if (parent instanceof CarrierRobot){
            return ((CarrierRobot) parent).indexOf((Robot) child);
        }
        return -1;
    }

    public void addTreeModelListener(TreeModelListener l) {
        _treeModelListener=l;
    }

    public void removeTreeModelListener(TreeModelListener l) {
        if (_treeModelListener==l){
            _treeModelListener=null;
        }
    }
}
