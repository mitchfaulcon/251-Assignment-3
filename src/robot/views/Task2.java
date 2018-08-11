package robot.views;

import robot.Robot;
import robot.RobotModel;
import robot.RobotModelEvent;
import robot.RobotModelListener;

import javax.swing.event.TreeModelEvent;
import java.util.List;

public class Task2 extends Task1 implements RobotModelListener{

    public Task2(RobotModel robotModel){
        super(robotModel);
    }

    public void update(RobotModelEvent event) {
        TreeModelEvent treeEvent;
        RobotModel source = event.source();
        Robot[] path = {event.operand()};
        int[] childIndices = {event.index()};
        Robot[] children = {event.operand()};

        if (event.parent() !=null){
            List<Robot> pathList = event.parent().path();
            path = new Robot[pathList.size()];
            path = pathList.toArray(path);
        }

        treeEvent = new TreeModelEvent(source, path, childIndices, children);


        if (event.eventType().equals(RobotModelEvent.EventType.RobotAdded)) {
            _treeModelListener.treeNodesInserted(treeEvent);
        } else if (event.eventType().equals(RobotModelEvent.EventType.RobotRemoved)) {
            _treeModelListener.treeNodesRemoved(treeEvent);
        }
    }
}
