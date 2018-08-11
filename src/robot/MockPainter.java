package robot;

import java.awt.*;

/**
 * Implementation of the Painter interface that does not actually do any
 * painting. A MockPainter implementation responds to Painter requests by
 * logging simply logging them. The contents of a MockPainter object's
 * log can be retrieved by a call to toString() on the MockPainter.
 * 
 * @author Craig Sutherland
 * 
 */
public class MockPainter implements Painter {
	private Color _colour=new Color(0, 0, 0);
	// Internal log.
	private StringBuffer _log = new StringBuffer();

	/**
	 * Returns the contents of this MockPainter's log.
	 */
	public String toString() {
		return _log.toString();
	}

	/**
	 * Logs the drawRect call.
	 */
	public void drawRect(int x, int y, int width, int height) {
		_log.append("(rectangle " + x + "," + y + "," + width + "," + height + ")");
	}
	
	/**
	 * Logs the drawOval call.
	 */
	public void drawOval(int x, int y, int width, int height) {
		_log.append("(oval " + x + "," + y + "," + width + "," + height + ")");
	}

	/**
	 * Logs the drawLine call.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_log.append("(line " + x1 + "," + y1 + "," + x2 + "," + y2 + ")");
	}

	public void fillRect(int x, int y, int width, int height) {
		_log.append("(fill " + x + "," + y + "," + width + "," + height + ")");
	}

	public Color getColour() {
		_log.append("getColour " + _colour + ")");
		return _colour;
	}

	public void setColour(Color colour) {
		_colour=colour;
		_log.append("setColour " + _colour + ")");
	}

	public void translate(int x, int y){

	}

	public void drawCenteredText(String text, int x, int y, int width, int height) {

	}

	public void drawImage(Image img, int x, int y, int width, int height) {

	}
}