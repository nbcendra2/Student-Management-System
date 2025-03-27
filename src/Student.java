import java.util.*;

public class Student {
	
	Scanner input = new Scanner(System.in);
	String studentid;
	String name;
	String gender;
	
	public Student() {
		System.out.print("Enter the student's ID number: ");
		studentid = input.next();
		System.out.println();
		System.out.print("Enter the student's name: ");
		input.skip("\\R?");
		name = input.next();
		System.out.println();
		System.out.print("Enter the student's gender (M/F): ");
		input.skip("\\R?");
		gender = input.nextLine();
		System.out.println();
	}
}
