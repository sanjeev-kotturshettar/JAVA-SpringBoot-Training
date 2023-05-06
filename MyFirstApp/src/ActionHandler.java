import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener{
	private TextField firstNumber;
	private TextField secondNumber;
	private Label reponse;
	
	public ActionHandler(TextField firstNumber, TextField secondNumber, Label lbl3) {
		// TODO Auto-generated constructor stub
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.reponse = lbl3;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Button b = (Button) e.getSource();
		int first = Integer.parseInt(this.firstNumber.getText());
		int second = Integer.parseInt(this.secondNumber.getText());
		Integer result = null;
		Maths maths = new Maths();
		
		if(e.getActionCommand().equalsIgnoreCase("Addition")) {
			result = maths.add(first, second);
		}else if (e.getActionCommand().equalsIgnoreCase("Substract")) {
			result = maths.subtract(first, second);
		}else if (e.getActionCommand().equalsIgnoreCase("Multiply")) {
			result = maths.multiply(first, second);
		}else if (e.getActionCommand().equalsIgnoreCase("Divide")) {
			result = maths.divide(first, second);
		}
		this.reponse.setText("Result = "+result);
		
	}
	

}
