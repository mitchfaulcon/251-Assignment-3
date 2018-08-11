package robot;

import java.awt.*;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Craig Sutherland
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;
	private FontMetrics _f;

	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
	}

	/**
	 * //@see robot.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
	}

	/**
	 * //@see robot.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * //@see bounce.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}

	public void fillRect(int x, int y, int width, int height) { _g.fillRect(x, y, width, height); }

	public Color getColour() { return _g.getColor(); }

	public void setColour(Color colour) { _g.setColor(colour); }

	public void translate(int x, int y){
		_g.translate(x,y);
	}

	public void drawCenteredText(String text, int x, int y, int width, int height) {
		int stringWidth = _g.getFontMetrics().stringWidth(text);

		int stringAscent = _g.getFontMetrics().getAscent();
		int stringDescent = _g.getFontMetrics().getDescent();
		int heightAdjust = (stringAscent - stringDescent)/2;

		_g.drawString(text, x + width/2 - stringWidth/2, y + height/2 + heightAdjust);
	}

	public void drawImage(Image img, int x, int y, int width, int height) {
		_g.drawImage(img,x,y,width,height,null);
	}
}
