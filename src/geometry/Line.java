package geometry;

import java.awt.Dimension;

/*
 * NOTE! Dimension width = x, Dimension height = y
 */
/**
 * Class used to hold slope and endpoints of line
 * @author Roland
 *
 */
public class Line {
	
	private Dimension e1 = null;
	private Dimension e2 = null;
	private double slope; //caution, must be called using getSlope function
	
	public Line()	{
		e1 = new Dimension();
		e2 = new Dimension();
		getSlope();
	}
	
	//Overloaded constructor - Remember this, Juniors?? :)
	public Line(Dimension e1, Dimension e2)	{
		this.e1 = e1;
		this.e2 = e2;
		getSlope();
	}
	
	public void setFirstEndpoint(Dimension e1)	{
		this.e1 = e1;
		getSlope();
	}
	
	public void setSecondEndpoint(Dimension e2)	{
		this.e2 = e2;
		getSlope();
	}
	
	public Dimension getFirstEndpoint()	{
		return e1;
	}
	
	public Dimension getSecondEndpoint()	{
		return e2;
	}
	
	public double getSlope()	{
		slope = (e1.getHeight() - e2.getHeight()) / (e1.getWidth() - e2.getWidth());
		return slope;
	}
	
}
