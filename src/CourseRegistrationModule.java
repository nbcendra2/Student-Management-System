import java.util.*;
import java.io.*;

public class CourseRegistrationModule {
	
	static ArrayList<CourseRegistered> studentEnrolledInitial = new ArrayList<CourseRegistered>(); 
	static ArrayList<CourseRegistered> studentEnrolledFinal = new ArrayList<CourseRegistered>(); 
	public CourseRegistrationModule() {
		
	}
	public void displayMenu() {
		System.out.println();
		System.out.println("* * * * * Welcome to COURSE REGISTRATION SERVICE  * * * * * * * * * * * *");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("* * * * * Press 1 for query information about enrollment status.* * * * *");
		System.out.println("* * * * * Press 2 to add enrollment status information.  * * *  * * * * *");
		System.out.println("* * * * * Press 3 to delete enrollment status information. * *  * * * * *");
		System.out.println("* * * * * Press 4 to show all enrollment status information. *  * * * * *");
		System.out.println("* * * * * Press 5 to exit the service * * * * * * * * * * * * * * * * * *");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println();
	}
	public void initializeArray() {
		for(int i = 0; i<MainProgram.studentlist.size();i++) {
			for(int j = 0;j<MainProgram.courselist.size();j++) {
				if(MainProgram.studentEnrolled.isEmpty()) {
					CourseRegistered studentEnrollmentList = new CourseRegistered(MainProgram.studentlist.get(i).studentid, MainProgram.courselist.get(j).courseid);
					studentEnrolledInitial.add(studentEnrollmentList);
				}
				else {
					CourseRegistered studentEnrollmentList = new CourseRegistered(MainProgram.studentlist.get(i).studentid, MainProgram.courselist.get(j).courseid);
					studentEnrolledFinal.add(studentEnrollmentList);
				}
			}
		}
		if(MainProgram.studentEnrolled.isEmpty() == false) {
			for(int i = 0;i<studentEnrolledFinal.size();i++) {
				for(int z = 0; z<MainProgram.studentEnrolled.size();z++){
					if(studentEnrolledFinal.get(i).courseId.equals(MainProgram.studentEnrolled.get(z).courseId) && studentEnrolledFinal.get(i).studentId.equals(MainProgram.studentEnrolled.get(z).studentId)) {
						if(MainProgram.studentEnrolled.get(z).enrollmentStatus == "YES") {
							studentEnrolledFinal.get(i).enrollmentStatus = "YES";
							break;
						}
					}
					
				}
			}
		}
	}
	public void configureArray() { //to avoid duplicate in the main array
		MainProgram.studentEnrolled.clear();
		if(studentEnrolledFinal.isEmpty()) {
			for(CourseRegistered i : studentEnrolledInitial) {
				MainProgram.studentEnrolled.add(i);
			}
		}
		else {
			for(CourseRegistered j : studentEnrolledFinal) {
				MainProgram.studentEnrolled.add(j);
			}
			studentEnrolledFinal.clear();
		}
	}
	public static boolean checkTime(String student1, String course1) {
		ArrayList<String> listOfCourseEnrolled = new ArrayList<String>();
		ArrayList<String> listOfDays = new ArrayList<String>();
		ArrayList<String> listOfTime = new ArrayList<String>();
		ArrayList<Integer> listOfIndexSameDay = new ArrayList<Integer>();
		ArrayList<String> listOfTimeSameDay = new ArrayList<String>();
		String day1 = null;
		String time1 = null;
		boolean sameDay = false;
		boolean valid = false;
		for(int i = 0;i<MainProgram.studentEnrolled.size();i++) {
			if(MainProgram.studentEnrolled.get(i).studentId.equals(student1) && MainProgram.studentEnrolled.get(i).enrollmentStatus.equals("YES")) {
				listOfCourseEnrolled.add(MainProgram.studentEnrolled.get(i).courseId);
			}
		}
		if(listOfCourseEnrolled.isEmpty()) {
			valid = true;
		}
		else {
			for(int i = 0; i<MainProgram.courselist.size();i++) {
				if(MainProgram.courselist.get(i).courseid.equals(course1)) {
					day1 = MainProgram.courselist.get(i).day;
					time1 = MainProgram.courselist.get(i).time;
				}
				for(int j = 0;j<listOfCourseEnrolled.size();j++) {
					if(MainProgram.courselist.get(i).courseid.equals(listOfCourseEnrolled.get(j))) {
						listOfDays.add(MainProgram.courselist.get(i).day);
						listOfTime.add(MainProgram.courselist.get(i).time);
					}
				}
			}
			for(int k = 0;k<listOfDays.size();k++) {
				if(listOfDays.get(k).equals(day1)){
					sameDay = true;
					listOfIndexSameDay.add(k);
					listOfTimeSameDay.add(listOfTime.get(k));
				}
			}
		}
		if(sameDay == false) {
			valid = true;
		}
		else {
			String time2;
			valid = true;
			int hour1;
			int minute1;
			int hour2;
			int minute2;
			int hourcheck1 = Integer.parseInt(time1.substring(0,2));
			int minutecheck1 = Integer.parseInt(time1.substring(3,5));
			int hourcheck2 = Integer.parseInt(time1.substring(6,8));
			int minutecheck2 = Integer.parseInt(time1.substring(9,11));
			for(int i = 0; i<listOfIndexSameDay.size();i++) {
				if(listOfTime.get(listOfIndexSameDay.get(i)).equals(time1)){
					valid = false;
					break;
				}
				else {
					time2 = listOfTimeSameDay.get(i);
					hour1 = Integer.parseInt(time2.substring(0,2));
					minute1 = Integer.parseInt(time2.substring(3,5));
					hour2 = Integer.parseInt(time2.substring(6,8));
					minute2 = Integer.parseInt(time2.substring(9,11));
					
					if(hourcheck1 > hour1 && hourcheck1 < hour2) {
						valid = false;
						break;
					}
					if(hourcheck1 > hour1 && hourcheck1 == hour2) {
						if(minutecheck1 < minute2) {
							valid = false;
							break;
						}
					}
					if(hourcheck1 == hour1 && hourcheck1 < hour2) {
						if(minutecheck1 >= minute1) {
							valid = false;
							break;
						}
						if(minutecheck1 < minute1 && hourcheck2>hour1) {
							valid = false;
							break;
						}
						if(minutecheck1 < minute1 && hourcheck2 == hour1) {
							if(minutecheck2 > minute1) {
								valid = false;
								break;
							}
						}
					}
					if(hourcheck1 == hour1 && hourcheck1 == hour2) {
						if(minutecheck1 >= minute1 && minutecheck1 < minute2) {
							valid = false;
							break;
						}
						if(minutecheck1 < minute1 && minutecheck2 > minute1) {
							valid = false;
							break;
						}
					}
					if(hourcheck1 < hour1 && hourcheck2 > hour1) {
						valid = false;
						break;
					}
					if(hourcheck1 < hour1 && hourcheck2 == hour1) {
						if(minutecheck2 > minute1) {
							valid = false;
							break;
						}
						else {
							continue;
						}
					}
				}
			}
		}
		return valid;
	}
	
	public void queryStatus() {
		Scanner input = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.print("Please enter the student ID you wish to query: ");
		String studentInput = input.next();
		System.out.println();
		System.out.print("Please enter the course ID you wish to query: ");
		String courseInput = input.next();
		System.out.println();
		System.out.println("---------------------------------------");
		boolean dataExist = false;
		for(int i = 0; i<MainProgram.studentEnrolled.size(); i++) {
			if(MainProgram.studentEnrolled.get(i).studentId.equals(studentInput) && MainProgram.studentEnrolled.get(i).courseId.equals(courseInput) ) {
				System.out.println();
				System.out.println("Student ID Course ID Enrollment Status");
				System.out.println("    " + MainProgram.studentEnrolled.get(i).studentId + "       " + MainProgram.studentEnrolled.get(i).courseId + "       " + MainProgram.studentEnrolled.get(i).enrollmentStatus);
				dataExist = true;
				System.out.println();
				System.out.println("Query is complete...");
				System.out.println();
				break;
			}
		}
		if(dataExist == false) {
			System.out.println("The course you're looking for doesn't exist.");
			System.out.println("---------------------------------------");
		}
	}
	
	public void addEnrollment() {
		Scanner input = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.print("Please enter the student ID: ");
		String studentInput = input.next();
		System.out.print("Please enter the course ID: ");
		String courseInput = input.next();
		System.out.println();
		boolean dataExist = false;
		boolean enrollingStatus = false;
		int pointer = -1;
		for(int i = 0; i<MainProgram.studentEnrolled.size(); i++) {
			if(MainProgram.studentEnrolled.get(i).studentId.equals(studentInput) && MainProgram.studentEnrolled.get(i).courseId.equals(courseInput) ) {
				dataExist = true;
				pointer = i;
				if(MainProgram.studentEnrolled.get(i).enrollmentStatus.equals("YES")) {
					enrollingStatus = true;
				}
			}
		}
		if(dataExist == false) {
			System.out.println("The student's ID or course's ID doesn't exist");
			System.out.println("---------------------------------------");
		}
		if(dataExist == true && enrollingStatus == true) {
			System.out.println("The student is already enrolled in this course");
			System.out.println("---------------------------------------");
		}
		if(dataExist == true && enrollingStatus == false) {
			if(checkTime(studentInput, courseInput) == true) {
				MainProgram.studentEnrolled.get(pointer).enrollmentStatus = "YES";
				System.out.println("Successfully enrolled...");
				System.out.println("---------------------------------------");
				System.out.println();
			}
			else {
				System.out.println("The class you selected conflicts with another lesson you have");
				System.out.println("---------------------------------------");
				System.out.println();
			}
		}
	}
	
	public void deleteEnrollment() {
		Scanner input = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.print("Please enter the student ID corresponding to the enrollment status you want to delete: ");
		String studentInput = input.next();
		System.out.println();
		System.out.print("Please enter the course ID corresponding to the enrollment status you want to delete: ");
		String courseInput = input.next();
		System.out.println();
		boolean dataExist = false;
		boolean enrollingStatus = false;
		int pointer = -1;
		for(int i = 0; i<MainProgram.studentEnrolled.size(); i++) {
			if(MainProgram.studentEnrolled.get(i).studentId.equals(studentInput) && MainProgram.studentEnrolled.get(i).courseId.equals(courseInput) ) {
				dataExist = true;
				pointer = i;
				if(MainProgram.studentEnrolled.get(i).enrollmentStatus.equals("YES")) {
					enrollingStatus = true;
				}
			}
		}
		if(dataExist == false) {
			System.out.println("The student's ID or course's ID doesn't exist");
			System.out.println("---------------------------------------");
		}
		if(dataExist == true && enrollingStatus == true) {
			MainProgram.studentEnrolled.get(pointer).enrollmentStatus = "NO";
			System.out.println("successfully deleted");
			System.out.println("---------------------------------------");
		}
		if(dataExist == true && enrollingStatus == false) {
			System.out.println("The corresponding student is not enrolled in that course");
			System.out.println("---------------------------------------");
		}
	}
	
	public void displayStatus() {
		System.out.println("Student ID Course ID Enrollment Status");
		for(int i = 0; i<MainProgram.studentEnrolled.size();i++) {
			System.out.println("    " + MainProgram.studentEnrolled.get(i).studentId + "       " + MainProgram.studentEnrolled.get(i).courseId + "       " + MainProgram.studentEnrolled.get(i).enrollmentStatus);
		}
		
		try {
			File file = new File("courseenrollmentinfo.txt");
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			
			for (int i = 0; i < MainProgram.studentEnrolled.size(); i++) {
				pw.println(MainProgram.studentEnrolled.get(i).studentId + "/" + MainProgram.studentEnrolled.get(i).courseId + "/" + MainProgram.studentEnrolled.get(i).enrollmentStatus);
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

