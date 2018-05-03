import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Create {
	Scanner sc;
	private String SSN;
	private String password;
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String birthDate;
	private String address;
	private String politicianID;
	private String militaryID;
	private Connection con;
	
	Create(char c, Connection conn){
		con = conn;
		sc = new Scanner(System.in);
		if (c == 'p') { // if politician
			System.out.println("Registation for Politician");
			RegisterPolitician();
			System.out.println("Now to login...");
		} 
		else if (c == 'm') { // if military personnel
			System.out.println("Registation for Military Personnel");
			RegisterMilitaryPersonnel();
			System.out.println("Now to login...");
		} 
		else { // if civilian
			System.out.println("Registation for Civilian");
			RegisterCivilian();
			System.out.println("Now to login...");
		}
	}
	public void RegisterPolitician() {
		// create civilian first
		RegisterCivilian();
		//query
		
	}
	public void RegisterMilitaryPersonnel() {
		// create civilian first
		RegisterCivilian();
		
	}
	public void RegisterCivilian() {
		String query ="";
		System.out.println("Enter your SSN: ");
		SSN = sc.next();
		System.out.println("Enter your first name: ");
		firstName = sc.next();
		System.out.println("Enter your middle initial: ");
		middleInitial = sc.next();
		System.out.println("Enter your last name: ");
		lastName = sc.next();
		System.out.println("Enter your birthDate");
		birthDate = sc.next();
		sc.nextLine();
		System.out.println("Enter address: ");
		address = sc.nextLine();
		System.out.println("Enter your password: ");
		password = sc.next();
		
		query = "INSERT INTO citizen VALUES ("+SSN+", '"+firstName+"', '"+middleInitial+"', '"+lastName+"', '"+birthDate+"', '"+address+"', '"+password+"', null, null, null, null)";
		System.out.println(query);
		//Query
		DBquery(query);
	}
	public void DBquery(String q) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(q); //Executes Query
			System.out.println("Success!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Create Query
	}
}
