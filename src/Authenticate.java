import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

import org.jasypt.util.password.BasicPasswordEncryptor;

public class Authenticate {
	
	private String username;
	private String password;
	private char person;
	private Connection db;
	HashMap<String, String> hmap;
	BasicPasswordEncryptor passwordEncryptor;
	
	Authenticate(Connection conn,HashMap h,char p,BasicPasswordEncryptor passEncrpt){
		db=conn;
		hmap=h;
		person=p;
		Scanner sc = new Scanner(System.in);
		passwordEncryptor = passEncrpt;
		
		System.out.print("Enter SSN/ID: ");
		username = sc.nextLine();
		
		System.out.print("Enter Password: ");
		password = sc.nextLine();
	}
	
	//SQL query
	public boolean authenticate() {
		Statement stmt = null;
		String query;
		
		//Debugging Purposes
		System.out.println("Char '"+person+"' is "+hmap.get(Character.toString(person))+" with type "+hmap.get(hmap.get(Character.toString(person))));
		
		if (person == 'm') {
			query = "SELECT password "
					+ "FROM military_personnel "
					+ "INNER JOIN citizen ON citizen.military_id = military_personnel.military_id "
					+ "WHERE military_personnel.military_id='"+username+"'";
			if(password.isEmpty()) {
				password = null;
			}
		} else if (person == 'p') {
			query = "SELECT password "
					+ "FROM politician "
					+ "INNER JOIN citizen ON citizen.politician_id = politician.politician_id "
					+ "WHERE politician.politician_id='"+username+"'";
			if(password.isEmpty()) {
				password = null;
			}
		}
		else {
			query = "SELECT password "
					+ "FROM citizen "
					+ "WHERE ssn='"+username+"'";
			if(password.isEmpty()) {
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
	        	//System.out.println("user: "+username+" pwd: "+password+" db pwd is "+rs.getObject(1));
		        if (password==null) {
		        	if (password!=rs.getObject(1)) {
			        	return false;
			        } 
		        } else {
		        	if (passwordEncryptor.checkPassword(password, rs.getObject(1).toString())) {
			        	return false;
			        } 
		        }
	        	
	        }
		}catch(SQLException e ) {
	        System.out.println(e);
	    }
		return true;
	}
}
