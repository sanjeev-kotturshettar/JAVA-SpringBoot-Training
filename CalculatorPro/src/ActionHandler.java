import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.util.Maths;

public class ActionHandler implements ActionListener {
	
	CalculatorFrame cf;

	public ActionHandler(CalculatorFrame calculatorFrame) {
		cf = calculatorFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		e.getSource();
		int firstNumber = Integer.parseInt(cf.firstNumber.getText());
		int secondNumber = Integer.parseInt(cf.secondNumber.getText());
		int result = 0;
		Maths maths = new Maths();
		
		if(e.getActionCommand().equalsIgnoreCase("add")) {
			result = maths.add(firstNumber, secondNumber);
			
		}else if (e.getActionCommand().equalsIgnoreCase("substract")) {
			result = maths.subtract(firstNumber, secondNumber);
			
		}else if (e.getActionCommand().equalsIgnoreCase("multiply")) {
			result = maths.multiply(firstNumber, secondNumber);
			
		}else if (e.getActionCommand().equalsIgnoreCase("divide")) {
			result = maths.divide(firstNumber, secondNumber);
			
		}
		
		cf.lbl3.setText("Result = "+ result);
		
	}

}
