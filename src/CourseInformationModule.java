import java.util.*;
import java.io.*;

public class CourseInformationModule {
	
	public CourseInformationModule() {
		
	}
	
	public void displayMenu() {
		System.out.println("* * * * Welcome to COURSE INFORMATION MANAGEMENT SERVICE  * * * *");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("* * * * * Press 1 for course information inquiry. * * * * * * * *");
		System.out.println("* * * * * Press 2 to add new course information.  * * * * * * * *");
		System.out.println("* * * * * Press 3 to modify course information. * * * * * * * * *");
		System.out.println("* * * * * Press 4 to delete course information. * * * * * * * * *");
		System.out.println("* * * * * Press 5 to display all course information.  * * * * * *");
		System.out.println("* * * * * Press 6 to exit the service * * * * * * * * * * * * * *");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println();
	}
	
	public void addCourse() {
		Scanner input = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.print("Enter the course ID you wish to add: ");
		String userinput = input.next();
		System.out.println();
		boolean value = false;
		for (int i = 0; i < MainProgram.courselist.size(); i++) {
			if (MainProgram.courselist.get(i).courseid.equals(userinput)) {
				value = true;
				System.out.println("The course's ID you inputted has already existed.");
				System.out.println("---------------------------------------");
				break;
			}
		}
		if (value == false) {
			System.out.println("---------------------------------------");
			System.out.println("The course ID you inputted isn't in our database yet.");
			System.out.println("Please enter detailed information about this new course.");
			System.out.println("---------------------------------------");
			System.out.println();
			Course newcourse = new Course();
			MainProgram.courselist.add(newcourse);
			System.out.println("The new course has been succesfully added.");
			System.out.println("---------------------------------------");
		}
	}
	
	public void queryCourse() {
		Scanner input = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.print("Enter the course's ID you wish to query: ");
		String userinput = input.next();
		System.out.println();
		boolean value = false;
		for (int i = 0; i < MainProgram.courselist.size(); i++) {
			if (MainProgram.courselist.get(i).courseid.equals(userinput)) {
				value = true;
				System.out.println("Below is the information for this course.");
				System.out.println("Course ID: " + MainProgram.courselist.get(i).courseid);
				System.out.println("Name: " + MainProgram.courselist.get(i).name);
				System.out.println("Credits: " + MainProgram.courselist.get(i).credits);
				System.out.println("Day: " + MainProgram.courselist.get(i).day);
				System.out.println("Time: " + MainProgram.courselist.get(i).time);
				System.out.println("---------------------------------------");
				break;
			}
		}
		if (value == false) {
			System.out.println("The course you're looking for doesn't exist.");
			System.out.println("---------------------------------------");
		}
	}
	
	public void modifyCourse() {
		Scanner input = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.print("Enter the course's ID you wish to modify: ");
		String userinput = input.next();
		System.out.println();
		boolean value = false;
		for (int i = 0; i < MainProgram.courselist.size(); i++) {
			if (MainProgram.courselist.get(i).courseid.equals(userinput)) {
				value = true;
				System.out.print("What do you want to modify (Name/Credits/Day/Time)? ");
				String userinput2 = input.next();
				System.out.println();
				if (userinput2.equals("Name")) {
					System.out.print("Change the course's name into: ");
					MainProgram.courselist.get(i).name = input.next();
					System.out.println("---------------------------------------");
					break;
				}
				if (userinput2.equals("Credits")) {
					System.out.print("Change the course's credits into: ");
					MainProgram.courselist.get(i).credits = input.next();
					System.out.println("---------------------------------------");
					break;
				}
				if (userinput2.equals("Day")) {
					System.out.print("Change the course's day into: ");
					MainProgram.courselist.get(i).day = input.next();
					System.out.println("---------------------------------------");
					break;
				}
				if (userinput2.equals("Time")) {
					System.out.print("Change the course's time into: ");
					MainProgram.courselist.get(i).time = input.next();
					System.out.println("---------------------------------------");
					break;
				}
			}
		}
		if (value == false) {
			System.out.println("The course you're looking for doesn't exist.");
			System.out.println("---------------------------------------");
		}
	}
	
	public void deleteCourse() {
		Scanner input = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.print("Enter the course's ID you wish to delete: ");
		String idinput = input.nextLine();
		System.out.println();
		System.out.print("Enter the course's name you wish to delete: ");
		String nameinput = input.nextLine();
		System.out.println();
		System.out.print("Enter the course's credits you wish to delete: ");
		String creditsinput = input.nextLine();
		System.out.println();
		System.out.print("Enter the course's day you wish to delete: ");
		String dayinput = input.nextLine();
		System.out.println();
		System.out.print("Enter the course's time you wish to delete: ");
		String timeinput = input.nextLine();
		System.out.println();
		boolean value = false;
		for (int i = 0; i < MainProgram.courselist.size(); i++) {
			if (MainProgram.courselist.get(i).courseid.equals(idinput) && MainProgram.courselist.get(i).name.equals(nameinput) && MainProgram.courselist.get(i).day.equals(dayinput) && MainProgram.courselist.get(i).time.equals(timeinput) && MainProgram.courselist.get(i).credits.equals(creditsinput)) {
				value = true;
				System.out.println("The course with course ID: " + MainProgram.courselist.get(i).courseid + " is getting deleted.");
				MainProgram.courselist.remove(i);
				System.out.println("Course has been succesfully deleted.");
				System.out.println();
				System.out.println("---------------------------------------");
				break;
			}
		}
		if (value == false) {
			System.out.println("The course you're looking for doesn't exist.");
			System.out.println("---------------------------------------");
		}
	}
	
	public void displayCourse() {
		System.out.println("---------------------------------------");
		System.out.println("Below is all courses information inside our database.");
		System.out.println();
		for (int i = 0; i < MainProgram.courselist.size(); i++) {
			
			System.out.println("Course " + (i+1) + " information:");
			System.out.println("Course ID: " + MainProgram.courselist.get(i).courseid);
			System.out.println("Name: " + MainProgram.courselist.get(i).name);
			System.out.println("Credits: " + MainProgram.courselist.get(i).credits);
			System.out.println("Day: " + MainProgram.courselist.get(i).day);
			System.out.println("Time: " + MainProgram.courselist.get(i).time);
			System.out.println();
		}
		
		try {
			File file = new File("courseinfo.txt");
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			
			for (int i = 0; i < MainProgram.courselist.size(); i++) {
				pw.println(MainProgram.courselist.get(i).courseid + "/" + MainProgram.courselist.get(i).name + "/" + MainProgram.courselist.get(i).credits + "/" + MainProgram.courselist.get(i).day + "/" + MainProgram.courselist.get(i).time);
			}
				pw.close();		
			} catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
		
		System.out.println();
		System.out.println("- End -");
		System.out.println("---------------------------------------");
		
	}
	
}
