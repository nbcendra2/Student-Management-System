import java.util.*;

public class Course {
	
	Scanner input = new Scanner(System.in);
	String courseid;
	String name;
	String credits;
	String day;
	String time;
	
	public Course() {
		System.out.print("Enter the course ID: ");
		courseid = input.nextLine();
		System.out.println();
		System.out.print("Enter the course name: ");
		name = input.nextLine();
		System.out.println();
		System.out.print("Enter the amount of credits: ");
		credits = input.nextLine();
		System.out.println();
		System.out.print("Enter the day this course occur: ");
		day = input.nextLine();
		System.out.println();
		System.out.print("Enter the time this course occur (HH:MM-HH:MM): ");
		time = input.nextLine();
		System.out.println();
	}
	
}
