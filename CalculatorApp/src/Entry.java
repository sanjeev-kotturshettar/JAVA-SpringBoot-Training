import java.io.IOException;

public class Entry {
	public static void main(String[] args) throws IOException {
		
		//Starting point of the app
		System.out.println("Calculator App");
		
		//Logical call's Object initialisation
		Maths m = new Maths();
		
		boolean loop = true;		
		while(loop) {
			//Select menu
			int operation = Menu.show();
			
			switch (operation) {
			case 1:
				System.out.println("Select to perform Addition");
				System.out.println("Please Enter First Number");
				int add1 = BasicInput.readInteger();
				
				System.out.println("Please Enter Second Number");
				int add2 = BasicInput.readInteger();
				
				//call to methods
				m.add(add1, add2);		//Addition of two numbers
				break;
			
			case 2:
				System.out.println("Select to perform Substraction");
				System.out.println("Please Enter First Number");
				int sub1 = BasicInput.readInteger();
				
				System.out.println("Please Enter Second Number");
				int sub2 = BasicInput.readInteger();
				
				//call to methods
				m.subtract(sub1, sub2);		//Subtraction of two numbers
				break;
			
			case 3:
				System.out.println("Select to perform Substraction");
				System.out.println("Please Enter First Number");
				int mul1 = BasicInput.readInteger();
				
				System.out.println("Please Enter Second Number");
				int mul2 = BasicInput.readInteger();
				
				//call to methods
				m.multiply(mul1, mul2);		//Multiplication of two numbers
				break;

			case 4:
				System.out.println("Select to perform Substraction");
				System.out.println("Please Enter First Number");
				int div1 = BasicInput.readInteger();
				
				System.out.println("Please Enter Second Number");
				int div2 = BasicInput.readInteger();
				
				//call to methods
				m.divide(div1, div2);		//Division of two numbers
				break;
				
			case 5:
				System.out.println("Select to perform Square");
				System.out.println("Please Enter Number");
				int snumber = BasicInput.readInteger();
				
				//call to methods
				m.square(snumber);		//Square of number
				break;

			case 6:
				System.out.println("Select to perform Cube");
				System.out.println("Please Enter Number");
				int cnumber = BasicInput.readInteger();
				
				//call to methods
				m.cube(cnumber);		//Cube of number
				break;

			default:
				break;
			}
			
			//Check if user wants to repeat process
			System.out.println("Want to continue?");
			System.out.println("Select Y - Yes or N - No");
			String option = BasicInput.readString();
			if(option.toLowerCase().equals("n")) {
				//Exit from processing loop
				loop = false;
			}
		}	
		System.out.println("Thankyou for using!!!");
	}
}
