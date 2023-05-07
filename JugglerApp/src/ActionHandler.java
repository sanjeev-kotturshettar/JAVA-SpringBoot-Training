import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
	JugglerFrame jf;
	public ActionHandler(JugglerFrame jugglerFrame) {
		jf = jugglerFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		e.getSource();
		int tfOne = Integer.parseInt(jf.tfOne.getText());
		int tfTwo = Integer.parseInt(jf.tfTwo.getText());
		int tfThree = Integer.parseInt(jf.tfThree.getText());
		
		
		if(e.getActionCommand().equalsIgnoreCase("clock-wise")) {
			//Swap number between the boxes
			int temp = tfThree;
			tfThree = ++tfTwo;
			tfTwo = ++tfOne;
			tfOne = ++temp;
		}else if (e.getActionCommand().equalsIgnoreCase("anti-clock-wise")) {
			//Swap number between the boxes
			int temp = tfOne;
			tfOne = --tfTwo;
			tfTwo = --tfThree;
			tfThree = --temp;
		}
		jf.tfOne.setText(String.valueOf(tfOne));
		jf.tfTwo.setText(String.valueOf(tfTwo));
		jf.tfThree.setText(String.valueOf(tfThree));
		
	}
}
