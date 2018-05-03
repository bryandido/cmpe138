import java.util.HashMap;
import java.util.Scanner;
import java.util.HashMap;
import java.sql.Connection;

public class Start {
	
	HashMap<Character, String> hmap = new HashMap<Character, String>(){
		{put('c',"civilian");}
		{put('m',"military");}
		{put('p',"politician");}
		{put('s',"senator");}
		{put('h',"head_of_state");}
	};
	private char person;
	private Authenticate auth;
	private Connection db;
	
	Start(Connection conn){
		db = conn;
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		
		do { // takes input from user
			System.out.println();
			System.out.println("WELCOME TO THE GOVERNMENT DATABASE!");
			System.out.println("Please enter the key that corresponds to you:");
			System.out.println("1. civilian - 'c'");
			System.out.println("2. military - 'm'");
			System.out.println("3. politician - 'p'");
			System.out.println("OR 'q' to exit the program");
				person = sc.nextLine().charAt(0);
			
			if (person == 'q') { // quit program
				System.out.println("Have nice day!");
				exit = true;
			}
			else if (person == 'c' || person == 'm' || person =='p') {
				exit = true;
				auth = new Authenticate(conn,hmap);
				if (auth.authenticate()==true) {
					System.out.println("You are logged in!");
					if (person == 'c') {
						Citizen citizen = new Citizen(db);
					} else if (person == 'm') {
						//Military military = new Military(db);
					} else {
						//Politician politician = new Politician(db);
					}
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
