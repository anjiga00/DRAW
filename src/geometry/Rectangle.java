package geometry;

import java.awt.Dimension;

public class Rectangle {
	private Dimension origin;
	private double rWidth;
	private double rHeight;
	
	public Rectangle()	{
		origin = new Dimension();
	}
	public Rectangle(Dimension origin, double rWidth, double rHeight)	{
		this.origin = origin;
		this.rWidth = rWidth;
		this.rHeight = rHeight;
	}
	public Dimension getOrigin() {
		return origin;
	}
	public void setOrigin(Dimension origin) {
		this.origin = origin;
	}
	public double getrWidth() {
		return rWidth;
	}
	public void setrWidth(double rWidth) {
		this.rWidth = rWidth;
	}
	public double getrHeight() {
		return rHeight;
	}
	public void setrHeight(double rHeight) {
		this.rHeight = rHeight;
	}
	
	
}
