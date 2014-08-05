package draw;

import javax.swing.JApplet;

/* A note about comments...
 * If a comment begins with /**, it is a special comment that will be compiled into code documentation
 * Comments that begin with /* or // are merely programmer comments
 */

/**
 * YOUR TASK:
 * 1) Read and understand the code.  Your assignment will be similar to Math Game assignments, such as
 * reading existing code and adding/making changes
 * 2) Add a circle class (right click geometry, add new class)
 * Determine what is necessary to draw a circle and construct a class based on
 * the existing rectangle and line classes
 * 3) Add code that will allow the user to draw a circle.  You may do some research online for sample
 * code if necessary.  Be sure to add a radio button that will allow the user to search 
 * 4) As an extra challenge, you may try to figure out how to get the rectangle to be drawn moving the
 * mouse up and to the left, as you may notice that currently the rectangle vanishes when the mouse
 * is moved in that direction.  As a hint, you should only have to change about two lines of code
 * 
 * You should only need to work within the DrawArea, DrawPanel, OptionPanel classes (as well as the Circle class
 * after you create it)
 * 
 * GOOD LUCK
 * 
 * Main Class
 * Limitations
 * 		Circle  Drawing algorithm is crude (moving mouse left and up is inconvenient)
 * 		Can only draw one thing at a time (old drawings vanish)
 * Positives
 * 		Java swing (the GUI) automatically double buffers, which means no flickering!
 * 		Code is simpler and much more understandable than Math Games code
 * @author Roland
 * 
 */
public class Draw extends JApplet	{
	private static final long serialVersionUID = 7461506119652688812L;
	
	/*Variable Declarations*/
	DrawPanel dp;//Panel that user will draw images on
	OptionPanel op;
	
	/**
	 * Function that performs initialization
	 */
	public void init()	{
		setSize(400, 500);
		setLayout(null);
		
		//Create Drawing Panel
		dp = new DrawPanel();
		dp.getDa().setCurrentDrawing("line");//initial choice; can be changed through optionPanel
		
		//Create Choice Panel
		op = new OptionPanel(this);
		
		this.add(dp);
		this.add(op);
	}
}
