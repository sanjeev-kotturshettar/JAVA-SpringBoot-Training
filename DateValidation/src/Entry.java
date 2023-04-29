import com.common.Date;

public class Entry {
	public static void main(String[] args) {
		System.out.println("Date Validation");
		Date dt = new Date(-1, 2, 2024);
		dt.setDay(30);
		System.out.println(dt);
	}
}
