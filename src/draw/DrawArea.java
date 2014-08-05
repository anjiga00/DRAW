package draw;

import geometry.Line;
import geometry.Rectangle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 * The actual area in which shapes are drawn
 * Responsible for executing the code to draw the shape
 * @author Roland
 *
 */
public class DrawArea extends JLabel{

	private static final long serialVersionUID = 6347078696840106209L;
	
	private String currentDrawing = null;//stores string denoting what drawing is selected
	private Line ln;
	private Rectangle rect;
	
	public DrawArea()	{
		setLayout(null);
		ln = new Line();
		rect = new Rectangle();
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	public void setCurrentDrawing(String currentDrawing)	{
		this.currentDrawing = currentDrawing;
	}
	
	public String getCurrentDrawing()	{
		return currentDrawing;
	}

	public Line getLn() {
		return ln;
	}

	public void setLn(Line ln) {
		this.ln = ln;
	}
	
	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(Color.BLACK);
		if(currentDrawing.equals("line"))	{
			g2.draw(new Line2D.Double(
					ln.getFirstEndpoint().getWidth(), 
					ln.getFirstEndpoint().getHeight(),
					ln.getSecondEndpoint().getWidth(),
					ln.getSecondEndpoint().getHeight()));
		}
		else if(currentDrawing.equals("rectangle"))	{
			double orgW = rect.getOrigin().getWidth();
			double orgH = rect.getOrigin().getHeight();
			if(rect.getrWidth() < 0)
				orgW += rect.getrWidth();
			if(rect.getrHeight() < 0)
				orgH += rect.getrHeight();
			g2.draw(new Rectangle2D.Double(
					orgW,
					orgH,
                    rect.getrWidth(),
                    rect.getrHeight()));
		}
		System.out.println("DRAWING");
	}
}
