package draw;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Panel that holds radio buttons to allow user to choose what shape to draw
 * @author Roland
 *
 */
public class OptionPanel extends JPanel	implements ActionListener	{

	private static final long serialVersionUID = 7740828768261643758L;
	
	public static Draw dr;
	private JRadioButton line;
	private JRadioButton rectangle;
	
	public OptionPanel(Draw dr)	{
		OptionPanel.dr = dr;
		setBounds(0, 400, 100, 100);
		setLayout(new FlowLayout());
		line = new JRadioButton("Line");
		line.setSelected(true);
		rectangle = new JRadioButton("Rectangle");
		
		line.addActionListener(this);
		rectangle.addActionListener(this);
		
		this.add(line);
		this.add(rectangle);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == line)	{
			dr.dp.getDa().setCurrentDrawing("line");
			line.setSelected(true);
			rectangle.setSelected(false);
		}
		
		else if(e.getSource() == rectangle)	{
			dr.dp.getDa().setCurrentDrawing("rectangle");
			line.setSelected(false);
			rectangle.setSelected(true);
		}
		
	}
}
