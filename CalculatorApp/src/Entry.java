
public class Entry {
	public static void main(String[] args) {
		//variable declaration
		int a = 3;
		int b = 2;
		
		//Object initialisation
		Maths m = new Maths();
		
		//call to methods
		m.add(a, b);		//Addition of two numbers
		m.subtract(a, b);	//Subtraction of two numbers
		m.multiply(a, b);	//Multiplication of two numbers
		m.divide(a, b);		//Division of two numbers
		m.square(a);		//Square of integer a
		m.cube(a);			//Cube of integer b
	}

}
