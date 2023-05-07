import java.awt.Button;
import java.awt.Frame;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Icon;
import javax.swing.JOptionPane;

public class JugglerFrame extends Frame{
	public TextField tfOne;
	public TextField tfTwo;
	public TextField tfThree;

	public JugglerFrame(String title, int x, int y, int width, int height, boolean visibility) {
		//Set Frame properties
		setTitle(title);
		setBounds(x, y, width, height);
		setVisible(visibility);
		setLayout(null);
		
		//create text fields
		tfOne = new TextField("1");
		tfOne.setBounds(50, 100, 130, 30);
		add(tfOne);
		
		tfTwo = new TextField("2");
		tfTwo.setBounds(250, 100, 130, 30);
		add(tfTwo);
		
		tfThree = new TextField("3");
		tfThree.setBounds(165, 150, 130, 30);
		add(tfThree);
		
		//Add Button
		Button clockWise = new Button("Clock-Wise");
		clockWise.setBounds(50, 250, 150, 30);
		add(clockWise);
		
		Button antiClockWise = new Button("Anti-Clock-Wise");
		antiClockWise.setBounds(220, 250, 150, 30);
		add(antiClockWise);
		
		//Add Event Listeners
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JugglerFrame jf = (JugglerFrame)e.getSource();
				int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","EXIT",JOptionPane.YES_NO_OPTION);
				if(confirm == JOptionPane.YES_OPTION) {
					jf.dispose();
				}
			}
		});
		
		clockWise.addActionListener(new ActionHandler(this));
		antiClockWise.addActionListener(new ActionHandler(this));
		
	}

}
