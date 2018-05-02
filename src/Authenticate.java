import java.util.Scanner;

public class Authenticate {
	
	private char person;
	private String username;
	private String password;
	
	Authenticate(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Username: ");
		username = sc.nextLine();
		
		System.out.println("Enter Password: ");
		password = sc.nextLine();	
	}
	
	//SQL query
	public boolean authenticate() {
		return true;
	}
}
