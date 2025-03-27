import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class StudentInformationModule {
	
	public StudentInformationModule() {
		
	}
	
	public void displayMenu() {
		System.out.println("* * * * Welcome to STUDENT INFORMATION MANAGEMENT SERVICE * * * *");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("* * * * * Press 1 for student information inquiry.  * * * * * * *");
		System.out.println("* * * * * Press 2 to add new student information. * * * * * * * *");
		System.out.println("* * * * * Press 3 to modify student information.  * * * * * * * *");
		System.out.println("* * * * * Press 4 to delete student information.  * * * * * * * *");
		System.out.println("* * * * * Press 5 to display all student information. * * * * * *");
		System.out.println("* * * * * Press 6 to exit the service * * * * * * * * * * * * * *");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println();
	}
	
	public void addStudent() {
		Scanner input = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.print("Enter the student's ID you wish to add: ");
		String userinput = input.next();
		boolean value = false;
		for (int i = 0; i < MainProgram.studentlist.size(); i++) {
			if (MainProgram.studentlist.get(i).studentid.equals(userinput)) {
				System.out.println("The student ID you entered has already existed.");
				System.out.println("---------------------------------------");
				System.out.println();
				value = true;
				break;
			}
		}
		if (value == false) {
			System.out.println("The student ID isn't in our record yet, please enter the detailed information.");
			System.out.println("---------------------------------------");
			System.out.println();
			Student newstudent = new Student();
			MainProgram.studentlist.add(newstudent);
			System.out.println("Student has been successfully added.");
			System.out.println("---------------------------------------");
		}
	}
	
	public void queryStudent() {
		Scanner input = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.print("Enter the student's ID you wish to know more about: ");
		String userinput = input.next();
		boolean value = false;
		for (int i = 0; i < MainProgram.studentlist.size(); i++) {
			if (MainProgram.studentlist.get(i).studentid.equals(userinput)) {
				value = true;
				System.out.println();
				System.out.println("Student ID: " + MainProgram.studentlist.get(i).studentid);
				System.out.println("Name: " + MainProgram.studentlist.get(i).name);
				System.out.println("Gender: " + MainProgram.studentlist.get(i).gender);
				System.out.println("---------------------------------------");
				System.out.println();
				break;
			}
		}
		if (value == false) {
			System.out.println("The student's ID you input isn't in our record yet.");
			System.out.println("---------------------------------------");
		}
	}
	
	public void modifyStudent() {
		Scanner input = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.print("Enter the student's ID you wish to modify: ");
		String userinput = input.next();
		boolean value = false;
		for (int i = 0; i < MainProgram.studentlist.size(); i++) {
			if (MainProgram.studentlist.get(i).studentid.equals(userinput)) {
				value = true;
				System.out.println();
				System.out.print("What do you want to modify (Name/Gender)? ");
				String userinput2 = input.next();
				System.out.println();
				if (userinput2.equals("Name")) {
					System.out.print("Change the student's name into: ");
					MainProgram.studentlist.get(i).name = input.next();
					System.out.println();
					System.out.println("Student's name has been changed to: " + MainProgram.studentlist.get(i).name);
					System.out.println("---------------------------------------");
					break;
				}
				if (userinput2.equals("Gender")) {
					System.out.print("Change the student's gender into: ");
					MainProgram.studentlist.get(i).gender = input.next();
					System.out.println();
					System.out.println("Student's gender has been changed to: " + MainProgram.studentlist.get(i).gender);
					System.out.println("---------------------------------------");
					break;
				}
			}
		}
		if (value == false) {
			System.out.println("The student's ID you input isn't in our record yet.");
			System.out.println("---------------------------------------");
		}
	}
	
	public void deleteStudent() {
		Scanner input = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.print("Enter the student's ID you wish to delete: ");
		String idinput = input.nextLine();
		System.out.println();
		System.out.print("Enter the student's name you wish to delete: ");
		String nameinput = input.nextLine();
		System.out.println();
		System.out.print("Enter the student's gender you wish to delete: ");
		String genderinput = input.nextLine();
		System.out.println();
		boolean value = false;
		for (int i = 0; i < MainProgram.studentlist.size(); i++) {
			if (MainProgram.studentlist.get(i).studentid.equals(idinput) && MainProgram.studentlist.get(i).name.equals(nameinput) && MainProgram.studentlist.get(i).gender.equals(genderinput)) {
				value = true;
				System.out.println("Student with ID: " + MainProgram.studentlist.get(i).studentid + " is being removed.");
				MainProgram.studentlist.remove(i);
				System.out.println("Student has been removed.");
				System.out.println("---------------------------------------");
				break;
			}
		}
		if (value == false) {
			System.out.println("The student's ID you input isn't in our record yet.");
			System.out.println("---------------------------------------");
		}
	}
	
	public void displayStudent() {
		System.out.println("---------------------------------------");
		System.out.println("Below is printed all student's information!");
		System.out.println();
		for (int i = 0; i < MainProgram.studentlist.size(); i++) {
			
			System.out.println();
			System.out.println("Student " + (i+1) + " information:");
			System.out.println("Student ID: " + MainProgram.studentlist.get(i).studentid);
			System.out.println("Name: " + MainProgram.studentlist.get(i).name);
			System.out.println("Gender: " + MainProgram.studentlist.get(i).gender);
			
		}
		
		try {
			File file = new File("studentinfo.txt");
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			
			for (int i = 0; i < MainProgram.studentlist.size(); i++) {
				pw.println(MainProgram.studentlist.get(i).studentid + "/" + MainProgram.studentlist.get(i).name + "/" + MainProgram.studentlist.get(i).gender);
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
