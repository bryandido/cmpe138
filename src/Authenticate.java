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
	}
	
	//SQL query
	public boolean authenticate() {
		Statement stmt = null;
		System.out.println("type is "+person+" value is "+hmap.get(Character.toString(person))+" login type is"+hmap.get(hmap.get(Character.toString(person))));
		String query = "SELECT * from "+hmap.get(Character.toString(person))+" WHERE "+hmap.get(hmap.get(Character.toString(person)))+"='"+username+"' AND password='"+password+"'";
		if(password.isEmpty()) {
			query = "SELECT * from "+hmap.get(Character.toString(person))+" WHERE "+hmap.get(hmap.get(Character.toString(person)))+"='"+username+"' AND password IS NULL";
		}
		
		try {
			stmt = db.createStatement(); // Create Query
	        ResultSet rs = stmt.executeQuery(query); //Executes Query
	        ResultSetMetaData rsmd = rs.getMetaData();
	        int columnsNumber = rsmd.getColumnCount();
	        if (rs.next()==false) {
	        	return false;
	        }
	        else {
	        do {
	            for(int i = 1; i < columnsNumber; i++)
	                System.out.print(rs.getString(i) + " ");
	            System.out.println();
	        } while (rs.next());
	        }
		}catch(SQLException e ) {
	        System.out.println(e);
	    }
		return true;
	}
}
