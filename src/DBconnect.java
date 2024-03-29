import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnect {
	Connection connection;
	public void connect(){
		
		String PUBLIC_DNS = "cmpe138-db.c4uxpsipwhcm.us-west-1.rds.amazonaws.com";
		String PORT = "3306";
		String DATABASE = "government";
		String REMOTE_DATABASE_USERNAME = "team";
		String DATABASE_USER_PASSWORD = "team123";
		
		System.out.println("----MySQL JDBC Connection Testing -------");
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        System.out.println("Where is your MySQL JDBC Driver?");
	        e.printStackTrace();
	        return;
	    }

	    System.out.println("MySQL JDBC Driver Registered!");
	    connection = null;

	    try {
	        connection = DriverManager.
	                getConnection("jdbc:mysql://" + PUBLIC_DNS + ":" + PORT + "/" + DATABASE, REMOTE_DATABASE_USERNAME, DATABASE_USER_PASSWORD);
	    } catch (SQLException e) {
	        System.out.println("Connection Failed!:\n" + e.getMessage());
	    }

	    if (connection != null) {
	        System.out.println("SUCCESS!!!! You made it, take control of your database now!");
	    } else {
	        System.out.println("FAILURE! Failed to make connection!");
	    }
	}
	
	public boolean check() {
		if (connection != null) {
			return true;
		} else {
			return false;
		}
	}
	public Connection getConnection() {
		if (connection != null) {
			return connection;
		}
		else {
			return null;
		}
	}
}
