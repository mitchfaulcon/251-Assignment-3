package robot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;


/**
 * Simple GUI program to show an animation of robots. Class AnimationViewer is
 * a special kind of GUI component (JPanel), and as such an instance of 
 * AnimationViewer can be added to a JFrame object. A JFrame object is a 
 * window that can be closed, minimized, and maximized. The state of an
 * AnimationViewer object comprises a list of Robots and a Timer object. An
 * AnimationViewer instance subscribes to events that are published by a Timer.
 * In response to receiving an event from the Timer, the AnimationViewer iterates 
 * through a list of Robots requesting that each Robot paints and moves itself.
 * 
 * @author Craig Sutherland
 * 
 */
@SuppressWarnings("serial")
public class AnimationViewer extends JPanel implements ActionListener {
	// Frequency in milliseconds for the Timer to generate events.
	private static final int DELAY = 20;

	// Collection of Robots to animate.
	private List<Robot> _robots;

	private Timer _timer = new Timer(DELAY, this);

	/**
	 * Creates an AnimationViewer instance with a list of Robot objects and 
	 * starts the animation.
	 */
	public AnimationViewer() {
		_robots = new ArrayList<Robot>();
	
		// Populate the list of Robots.
		_robots.add(new WheeledRobot(0, 0, 2, 3));
		_robots.add(new WheeledRobot(10, 10, 5, 7));
		_robots.add(new FlyingRobot(5,5,2,4));
		_robots.add(new TrackedRobot(60,20,4,3,100,100));
		_robots.get(_robots.size()-1).addText("Tracked Robot");
		_robots.add(new TrackedRobot(400,300,4,3,30,30));
		_robots.add(new DynamicWheeledRobot(75,200,5,8));
		_robots.add(new DynamicWheeledRobot(150,150,8,4, new Color(255,0,0)));
		_robots.add(new DynamicWheeledRobot(150,150,-5,-5,30,30, new Color(82, 208, 83)));
		_robots.add(new ChangingEdgeRobot(80,300,3,3,40,40));

		CarrierRobot _topLevelNest = new CarrierRobot(0, 0, 2, 2, 100, 100);
		CarrierRobot _midLevelNest = new CarrierRobot(30, 50, 2, 2, 50, 50);
		CarrierRobot _bottomLevelNest = new CarrierRobot(5, 5, 2, 2, 10, 10);
		Robot _simpleRobot = new FlyingRobot(1, 1, 1, 1, 5, 5);

		_midLevelNest.add(_bottomLevelNest);
		_midLevelNest.add(_simpleRobot);
		_topLevelNest.add(_midLevelNest);
		_topLevelNest.addText("Top Robot");

		_robots.add(_topLevelNest);
		
		// Start the animation.
		_timer.start();
	}

	/**
	 * Called by the Swing framework whenever this AnimationViewer object
	 * should be repainted. This can happen, for example, after an explicit 
	 * repaint() call or after the window that contains this AnimationViewer 
	 * object has been opened, exposed or moved.
	 * 
	 */
	public void paintComponent(Graphics g) {
		// Call inherited implementation to handle background painting.
		super.paintComponent(g);
		
		// Calculate bounds of animation screen area.
		int width = getSize().width;
		int height = getSize().height;
		
		// Create a GraphicsPainter that Robot objects will use for drawing.
		// The GraphicsPainter delegates painting to a basic Graphics object.
		Painter painter = new GraphicsPainter(g);
		
		// Progress the animation.
		for(Robot robot : _robots) {
			robot.paint(painter);
			robot.move(width, height);
		}
	}

	/**
	 * Notifies this AnimationViewer object of an ActionEvent. ActionEvents are
	 * received by the Timer.
	 */
	public void actionPerformed(ActionEvent e) {
		// Request that the AnimationViewer repaints itself. The call to 
		// repaint() will cause the AnimationViewer's paintComponent() method 
		// to be called.
		repaint();
	}
	
	
	/**
	 * Main program method to create an AnimationViewer object and display this
	 * within a JFrame window.
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Animation viewer");
				frame.add(new AnimationViewer());
		
				// Set window properties.
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			}
		});
	}
}
