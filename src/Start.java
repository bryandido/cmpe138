import java.util.Scanner;

public class Start {
	
	private DBconnect mysql;
	private char person;
	private Authenticate auth;
	private Citizen citizen;
	
	Start(DBconnect db){
		mysql = db;
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		
		do {
			
			System.out.println("Civilian - 'c'");
			System.out.println("Military - 'm'");
			System.out.println("Politician - 'p'");
			System.out.println("'q' to exit the program");
			System.out.print("Enter the letter that corresponds to you: ");
			person = sc.nextLine().charAt(0);
			
			if (person == 'q') {
				System.out.println("Have nice day!");
				exit = true;
			}
			else if (person == 'c' || person == 'm' || person =='p') {
				exit = true;
				auth = new Authenticate();
				if (auth.authenticate()==true) {
					System.out.println("You are logged in!");
					citizen = new Citizen(mysql);
				} else {
					System.out.println("Wrong login! Program exiting.");
				}
			} 
			else {
				System.out.println("Invalid choice. Try again.");
			}
		} while (exit == false);
	}
}
