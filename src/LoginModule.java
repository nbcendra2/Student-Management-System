import java.io.*;
import java.util.*;

public class LoginModule {
	Scanner input = new Scanner(System.in);
	
	String username;
	String password;
	
	public LoginModule() {
		
	}
	
	public void UserInput() {
		
		System.out.println("---------------------------------------------------");
		System.out.print("Please enter your username: ");
		this.username = input.nextLine();
		System.out.println();
		System.out.print("Please enter your password: ");
		this.password = input.nextLine();
		System.out.println();
		
	}
	
	public static boolean CorrectorNot(String name, String name2, String pass, String pass2) {
		if (name.equals(name2) && pass.equals(pass2)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean CheckPerLine() {
		try {
			
			File file = new File("/Users/nigelcendra/eclipse-workspace/StudentManagementSystem/users.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String strLine;
			
			while ((strLine = br.readLine()) != null) {
				String[] splited = strLine.split(" ");
				String name = splited[0];
				String pass = splited[1];
				if (LoginModule.CorrectorNot(this.username, name, this.password, pass) == true) {
					return true;
				}
			}
			return false;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	
	
}
