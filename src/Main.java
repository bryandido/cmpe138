public class Main {

	public static void main(String[] args) {
		
		//Connects to government database
		DBconnect mysql = new DBconnect();
		mysql.connect();
		if (mysql.check()) {
			Start app = new Start(mysql.getConnection());
		}
	}

}
