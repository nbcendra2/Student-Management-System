import java.util.*;
import java.io.*;


public class MainProgram {
	static ArrayList<Student> studentlist = new ArrayList<Student>();
	static ArrayList<Course> courselist = new ArrayList<Course>();
	static ArrayList<CourseRegistered> studentEnrolled = new ArrayList<CourseRegistered>();
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice1;
		int choice2;
		String answer;
		
		LoginModule studentlogin = new LoginModule();
		
		boolean value = false;
		for (int i = 3; i >= 1; i--) {
			studentlogin.UserInput();
			studentlogin.CheckPerLine();
			if (studentlogin.CheckPerLine() == true) {
				System.out.println("Redirecting...");
				System.out.println("---------------------------------------------------");
				value = true;
				break;
			}
			else {
				if (i == 2 || i == 3) {
					System.out.println("Your account doesn't exist or you input the wrong password!");
					System.out.println("You have " + (i-1) + " opportunities left.");
					continue;
				}
				if (i == 1) {
					System.out.println("Your account doesn't exist or you input the wrong password!");
					System.out.println("You don't have any opportunities left.");
					System.exit(0);
				}
			}
		}
		while (true) {
			if (value == true) {
				MainMenu menu = new MainMenu();
				menu.DisplayMenu();
			}
			else {
				System.exit(0);
			}
			System.out.print("Enter which service do you want to access: ");
			choice1 = input.nextInt();
			System.out.println();
			
			if (choice1 == 4) {
				System.out.println("Thank you for using our services!");
				System.exit(0);
			}
			
			System.out.println("Accessing...");
		
			if (choice1 == 1) {
				StudentInformationModule studentinfo = new StudentInformationModule();
				while (true) {
					studentinfo.displayMenu();
			
					System.out.print("Enter which service do you want to access: ");
					choice2 = input.nextInt();
					System.out.println();
					System.out.println("Accessing...");
					System.out.println();
			
					if (choice2 == 1) {
						while (true) {
							studentinfo.queryStudent();
							System.out.print("Do you want to continue inquiry? (Yes/No) ");
							answer = input.next();
							System.out.println();
							if (answer.equals("Yes")) {
								continue;
							}
							if (answer.equals("No")) {
								break;
							}
						}
					}
					if (choice2 == 2) {
						while (true) {
							studentinfo.addStudent();
							System.out.print("Do you want to continue adding? (Yes/No) ");
							answer = input.next();
							System.out.println();
							if (answer.equals("Yes")) {
								continue;
							}
							if (answer.equals("No")) {
								break;
							}
						}
					}
					if (choice2 == 3) {
						while (true) {
							studentinfo.modifyStudent();
							System.out.print("Do you want to continue modification? (Yes/No) ");
							answer = input.next();
							System.out.println();
							if (answer.equals("Yes")) {
								continue;
							}
							if (answer.equals("No")) {
								break;
							}
						}
					}
					if (choice2 == 4) {
						while (true) {
							studentinfo.deleteStudent();
							System.out.print("Do you want to continue deletion? (Yes/No) ");
							answer = input.next();
							System.out.println();
							if (answer.equals("Yes")) {
								continue;
							}
							if (answer.equals("No")) {
								break;
							}
						}
					}	
					if (choice2 == 5) {
						while (true) {
							studentinfo.displayStudent();
							System.out.print("Do you want to display again? (Yes/No) ");
							answer = input.next();
							System.out.println();
							if (answer.equals("Yes")) {
								continue;
							}
							if (answer.equals("No")) {
								break;
							}
						}
					}
					if (choice2 == 6) {
						break;
					}
				}
			}
			if (choice1 == 2) {
				CourseInformationModule courseinfo = new CourseInformationModule();
				while (true) {
					courseinfo.displayMenu();
			
					System.out.print("Enter which service do you want to access: ");
					choice2 = input.nextInt();
					System.out.println();
					System.out.println("Accessing...");
					System.out.println();
			
					if (choice2 == 1) {
						while (true) {
							courseinfo.queryCourse();
							System.out.print("Do you want to continue inquiry? (Yes/No) ");
							answer = input.next();
							System.out.println();
							if (answer.equals("Yes")) {
								continue;
							}
							if (answer.equals("No")) {
								break;
							}
						}
					}
					if (choice2 == 2) {
						while (true) {
							courseinfo.addCourse();
							System.out.print("Do you want to continue adding? (Yes/No) ");
							answer = input.next();
							System.out.println();
							if (answer.equals("Yes")) {
								continue;
							}
							if (answer.equals("No")) {
								break;
							}
						}
					}
					if (choice2 == 3) {
						while (true) {
							courseinfo.modifyCourse();
							System.out.print("Do you want to continue modification? (Yes/No) ");
							answer = input.next();
							System.out.println();
							if (answer.equals("Yes")) {
								continue;
							}
							if (answer.equals("No")) {
								break;
							}
						}
					}
					if (choice2 == 4) {
						while (true) {
							courseinfo.deleteCourse();
							System.out.print("Do you want to continue deletion? (Yes/No) ");
							answer = input.next();
							System.out.println();
							if (answer.equals("Yes")) {
								continue;
							}
							if (answer.equals("No")) {
//								courseinfo.txtConverter();
								break;
							}
						}
					}	
					if (choice2 == 5) {
						while (true) {
							courseinfo.displayCourse();
							System.out.print("Do you want to display again? (Yes/No) ");
							answer = input.next();
							System.out.println();
							if (answer.equals("Yes")) {
								continue;
							}
							if (answer.equals("No")) {
								break;
							}
						}
					}
					if (choice2 == 6) {
						break;
					}
				}
			}
			if(choice1 == 3) {
				CourseRegistrationModule courseEnrolled = new CourseRegistrationModule();
				courseEnrolled.initializeArray();
				courseEnrolled.configureArray();
				while(true){
					courseEnrolled.displayMenu();
					System.out.print("Enter which service do you want to access: ");
					choice2 = input.nextInt();
					System.out.println();
					System.out.println("Accessing...");
					System.out.println();
					if (choice2 == 1) {
						while(true) {
							courseEnrolled.queryStatus();
							System.out.print("Do you want to continue inquiry? (Yes/No) ");
							answer = input.next();
							System.out.println();
							if (answer.equals("Yes")) {
								continue;
							}
							if (answer.equals("No")) {
								break;
							}
						}
					}
					if(choice2 == 2) {
						while(true) {
							courseEnrolled.addEnrollment();
							System.out.print("Do you want to continue adding? (Yes/No) ");
							answer = input.next();
							System.out.println();
							if (answer.equals("Yes")) {
								continue;
							}
							if (answer.equals("No")) {
								break;
							}
						}
					}
					if(choice2 == 3) {
						while(true) {
							courseEnrolled.deleteEnrollment();
							System.out.print("Do you want to continue deletion? (Yes/No) ");
							answer = input.next();
							System.out.println();
							if (answer.equals("Yes")) {
								continue;
							}
							if (answer.equals("No")) {
								break;
							}
						}
					}
					if(choice2 == 4) {
						while(true) {
							courseEnrolled.displayStatus();
							System.out.print("Do you want to display again? (Yes/No) ");
							answer = input.next();
							System.out.println();
							if (answer.equals("Yes")) {
								continue;
							}
							if (answer.equals("No")) {
								break;
							}
						}
					}
					if(choice2 == 5) {
						break;
					}
				}
			}
		}
	}
}