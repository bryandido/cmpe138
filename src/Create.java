import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Random;

public class Create {
	Scanner sc;
	private Connection con;
	private String SSN,password,firstName,middleInitial,lastName,birthDate,address;
	private int politicianID;
	private int militaryID;
	private String start,end,rank,hq;
	
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
		//Create Politician First
		politicianID = randIDGen();
		String query;
		//SQL Statement
		query = "INSERT INTO politician VALUES ("+politicianID+")";
		//Query
		DBquery(query);
		//Register Politican as a Citizen
		RegisterCivilian();
		query = "UPDATE citizen SET politician_id = "+politicianID+" WHERE ssn="+SSN+"";
		DBquery(query);
	}
	public void RegisterMilitaryPersonnel() {
		//Create Military First
		String query;
		System.out.println("When did you start service? (yyyy-mm-dd)");
		start = sc.next();
		System.out.println("When will it end? (yyyy-mm-dd)");
		end = sc.next();
		System.out.println("What is your rank?");
		rank = sc.next();
		sc.nextLine();
		System.out.println("Where are you stationed?");
		hq = sc.nextLine();
		
		query = "INSERT INTO military_branch VALUES ('"+hq+"', null)";
		DBquery(query);
		
		militaryID = randIDGen();
		//SQL Statement
		query = "INSERT INTO military_personnel VALUES ("+militaryID+",'"+start+"','"+end+"','"+rank+"','"+hq+"')";
		//Query
		DBquery(query);
		//Register Military as a Citizen
		RegisterCivilian();
		query = "UPDATE citizen SET military_id="+militaryID+" WHERE ssn="+SSN+"";
		DBquery(query);	
	}
	public void RegisterCivilian() {
		String query;
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
		//SQL Statement
		query = "INSERT INTO citizen "
				+ "VALUES ("+SSN+", '"+firstName+"', '"+middleInitial+"', '"+lastName+"', '"+birthDate+"', '"+address+"', '"+password+"', null, null, null, null)";
		//Query
		DBquery(query);
	}
	public void DBquery(String q) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(q); //Executes Query
			System.out.println("...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Create Query
	}
	public int randIDGen() {
		Random rand = new Random();
		int low = 100000000;
		int high = 999999999;
		return rand.nextInt(high-low)+low;
	}
}
