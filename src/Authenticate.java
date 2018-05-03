import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

public class Authenticate {
	
	private String username;
	private String password;
	private char person;
	private Connection db;
	HashMap<String, String> hmap;
	
	Authenticate(Connection conn,HashMap h,char p){
		db=conn;
		hmap=h;
		person=p;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter SSN/ID: ");
		username = sc.nextLine();
		
		System.out.println("Enter Password: ");
		password = sc.nextLine();	
		sc.close();
	}
	
	//SQL query
	public boolean authenticate() {
		Statement stmt = null;
		String query;
		
		//Debugging Purposes
		System.out.println("Char '"+person+"' is "+hmap.get(Character.toString(person))+" with type "+hmap.get(hmap.get(Character.toString(person))));
		
		if (person == 'm') {
			query = "SELECT password FROM military_personnel INNER JOIN citizen ON citizen.military_id = military_id WHERE military_personnel.military_id='"+username+"'";
		} else if (person == 'p') {
			query = "SELECT password FROM politician INNER JOIN citizen ON citizen.politician_id = politician_id WHERE politician.politician_id='"+username+"'";
		}
		else {
			query = "SELECT password FROM citizen WHERE ssn='"+username+"'";
			if(password.isEmpty()) {
				query = "SELECT password FROM citizen WHERE ssn='"+username+"' AND password IS NULL";
				password = null;
			}
		}
		try {
			stmt = db.createStatement(); // Create Query
	        ResultSet rs = stmt.executeQuery(query); //Executes Query
	        ResultSetMetaData rsmd = rs.getMetaData();
	        if (rs.next()==false) {
	        	return false;
	        }
	        else {
		        if (password!=rs.getObject(1)) {
		        	return false;
		        }
	        }
		}catch(SQLException e ) {
	        System.out.println(e);
	    }
		return true;
	}
}
