import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowListener;

public class MyFrame extends Frame {
	
	public MyFrame (String string, int x, int y, int width, int height, boolean b) {
		this.setTitle(string);
		this.setBounds(x, y, width, height);
		this.setVisible(b);
		//this.addWindowListener(new WindowHandler());
		//this.addMouseListener(new MouseHandler());
		//this.addMouseMotionListener(new MouseMotionHandler());
		Label lbl1 = new Label("First Number");
		lbl1.setBounds(40, 100, 100, 30);
		add(lbl1);
		
		TextField firstNumber = new TextField();
		firstNumber.setBounds(170, 100, 150, 30);
		add(firstNumber);
		
		Label lbl2 = new Label("Second Number");
		lbl2.setBounds(350, 100, 100, 30);
		add(lbl2);
		
		TextField secondNumber = new TextField();
		secondNumber.setBounds(470, 100, 150, 30);
		add(secondNumber);
		
		Label lbl3 = new Label();
		lbl3.setBounds(150, 200, 100, 30);
		add(lbl3);
		
		Button addButton = new Button("Addition");
		addButton.setBounds(40, 400, 130, 30);
		
		Button subButton = new Button("Substract");
		subButton.setBounds(220, 400, 130, 30);
		
		Button multiplyButton = new Button("Multiply");
		multiplyButton.setBounds(400, 400, 130, 30);
		
		Button divideButton = new Button("Divide");
		divideButton.setBounds(580, 400, 130, 30);
		
		this.setLayout(null);
		this.add(addButton);
		this.add(subButton);
		this.add(multiplyButton);
		this.add(divideButton);
		
		addButton.addActionListener(new ActionHandler(firstNumber, secondNumber, lbl3));
		subButton.addActionListener(new ActionHandler(firstNumber, secondNumber, lbl3));
		multiplyButton.addActionListener(new ActionHandler(firstNumber, secondNumber, lbl3));
		divideButton.addActionListener(new ActionHandler(firstNumber, secondNumber, lbl3));
		
		this.addWindowListener(new MasterHandler());
		this.addMouseListener(new MasterHandler());
		this.addMouseMotionListener(new MasterHandler());
		
	}

}
