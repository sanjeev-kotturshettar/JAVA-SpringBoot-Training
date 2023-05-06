import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalculatorFrame extends Frame{
	public Label lbl3;
	public TextField firstNumber;
	public TextField secondNumber;
	
	//Class Constructor
	public CalculatorFrame(String title, int x, int y, int width, int height, boolean visibility) {
		//Default settings
		setBounds(x, y, width, height);
		setVisible(visibility);
		setTitle(title);
		setLayout(null);
		
		//Create Labels and TextBoxes
		Label lbl1 = new Label("First Number");
		lbl1.setBounds(50, 100, 130, 30);
		add(lbl1);
		
		firstNumber = new TextField();
		firstNumber.setBounds(200, 100, 130, 30);
		add(firstNumber);
		
		Label lbl2 = new Label("Second Number");
		lbl2.setBounds(350, 100, 130, 30);
		add(lbl2);
		
		secondNumber = new TextField();
		secondNumber.setBounds(500, 100, 130, 30);
		add(secondNumber);
		
		//Show result block
		lbl3 = new Label();
		lbl3.setBounds(300, 200, 130, 30);
		add(lbl3);
		
		//Create Buttons
		Button addButton = new Button("Add");
		addButton.setBounds(50, 300, 130, 30);
		add(addButton);
		
		Button subButton = new Button("Substract");
		subButton.setBounds(200, 300, 120, 30);
		add(subButton);
		
		Button multiplyButton = new Button("Multiply");
		multiplyButton.setBounds(350, 300, 150, 30);
		add(multiplyButton);
		
		Button divideButton = new Button("Divide");
		divideButton.setBounds(500, 300, 120, 30);
		add(divideButton);
		
		//Add Event Listeners
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				CalculatorFrame mf = (CalculatorFrame)e.getSource();
				mf.dispose();
				
			}
		});
		
		addButton.addActionListener(new ActionHandler(this));
		subButton.addActionListener(new ActionHandler(this));
		multiplyButton.addActionListener(new ActionHandler(this));
		divideButton.addActionListener(new ActionHandler(this));		
	}

}
