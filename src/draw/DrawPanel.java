package draw;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

/**
 * The panel that holds the area the shapes are drawn
 * Responsible for detecting mouse movements
 * @author Roland
 *
 */
public class DrawPanel extends JPanel implements MouseMotionListener, MouseListener {
	
	private static final long serialVersionUID = -523498629473738225L;
	
	private int mx, my;//mouse coordinates
	private DrawArea da;
	
	public DrawPanel()	{
		setSize(400, 400);
		setLayout(null);
		addMouseMotionListener(this);
		addMouseListener(this);
		
		//create DrawArea
		da = new DrawArea();
		da.setBounds(0, 0, 400, 400);
		da.addMouseMotionListener(this);
		da.addMouseListener(this);
		add(da);
	}

	public int getMx() {
		return mx;
	}

	public void setMx(int mx) {
		this.mx = mx;
	}

	public int getMy() {
		return my;
	}

	public void setMy(int my) {
		this.my = my;
	}
	
	//EVENT HANDLING

	@Override
	public void mouseDragged(MouseEvent e) {
		//storing mouse coordinates
		mx = e.getX();
		my = e.getY();
		if(da.getCurrentDrawing().equals("line"))	{
			da.getLn().setSecondEndpoint(new Dimension(getMx(), getMy()));
		}
		else if(da.getCurrentDrawing().equals("rectangle"))	{
			da.getRect().setrWidth(mx - da.getRect().getOrigin().getWidth());
			da.getRect().setrHeight(my - da.getRect().getOrigin().getHeight());
			System.out.println("HEIGHT: "+da.getRect().getrHeight()+"WIDTH: "+da.getRect().getrWidth());
		}
		da.validate();
		da.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//storing mouse coordinates
		mx = e.getX();
		my = e.getY();
		System.out.println("MOUSE MOVED");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//IGNORE
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("MOUSE ENTERED");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("MOUSE EXITED");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//storing mouse coordinates
		mx = e.getX();
		my = e.getY();
		if(da.getCurrentDrawing().equals("line"))	{
			da.getLn().setFirstEndpoint(new Dimension(getMx(), getMy()));
			System.out.println("PRESSED: (" + da.getLn().getFirstEndpoint().getWidth() + ", " + da.getLn().getFirstEndpoint().getHeight() + ")");
		}
		else if(da.getCurrentDrawing().equals("rectangle"))	{
			da.getRect().setOrigin(new Dimension(mx, my));
			System.out.println("PRESSED: (" + da.getRect().getOrigin().getWidth() + ", " + da.getRect().getOrigin().getHeight() + ")");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//storing mouse coordinates
		mx = e.getX();
		my = e.getY();
		if(da.getCurrentDrawing().equals("line"))	{
			System.out.println("RELEASED: (" + da.getLn().getSecondEndpoint().getWidth() + ", " + da.getLn().getSecondEndpoint().getHeight() + ")");
			da.getLn().setSecondEndpoint(new Dimension(getMx(), getMy()));
		}
		else if(da.getCurrentDrawing().equals("rectangle"))	{
			da.getRect().setrWidth(mx - da.getRect().getOrigin().getWidth());
			da.getRect().setrHeight(my - da.getRect().getOrigin().getHeight());
			System.out.println("RELEASED: (" + da.getRect().getOrigin().getWidth() + ", " + da.getRect().getOrigin().getHeight() + ")");
		}
		da.validate();
		da.repaint();
	}

	public DrawArea getDa() {
		return da;
	}

	public void setDa(DrawArea da) {
		this.da = da;
	}
}