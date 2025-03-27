import java.util.*;

public class CourseRegistered {
	Scanner input = new Scanner(System.in);
	String studentId;
	String courseId;
	String enrollmentStatus;
	
	public CourseRegistered(String studentId, String courseId) {
		this.studentId = studentId;
		this.courseId = courseId;
		enrollmentStatus = "NO";
	}
}
