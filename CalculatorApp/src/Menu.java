import java.io.IOException;

public class Menu {
	public static int show() throws IOException {
		System.out.println("Please select option to perform mathematical operation");
		System.out.println("***************************");
		System.out.println("1  - Addition \n2 - Subtraction \n3 - Multiplication \n4 - Division \n5 - Square \n6 - Cube \n");
		int option = BasicInput.readInteger();
		return option;
		
	}
}
