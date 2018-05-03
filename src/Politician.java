import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Politician {

	Politician(DBconnect conn){
		int closePolitician = 1;
		int position = 0;
		int lawsOrBills = 0;
		int lawNo = 0; //convert to string later
		int billNo = 0; //convert to string later
		int input = 0;
		int id = 0; //convert to string later
		
		String lastName = null;
		String firstName = null;
		
		boolean lawNum = false, billNum = false;
		
		Connection con = null;
		Statement statement = null;
		
		Scanner scanner = new Scanner(System.in);
		do {
			
			String sql = null;
			System.out.println("Please select an option: ");
			System.out.println("1: Search for individuals");
			System.out.println("2: Add/Edit Citizens");
			System.out.println("3: Edit Laws or Bills");
			System.out.println("4: Create Bills");
			System.out.println("5: Vote on Bills");
			System.out.println("6: Exit");
			input = scanner.nextInt();
			
			if(input == 1)
			{	
				System.out.println("Please select their position within our country: ");
				System.out.println("1: Citizen");
				System.out.println("2: Immigrant");
				System.out.println("3: Politician");
				position = scanner.nextInt();
				
				System.out.println("Please enter their last name: ");
				lastName = scanner.next();
				
				System.out.println("Please enter their first name: ");
				firstName = scanner.next();
				
				//Write query here
				if(position == 1)
				{
					sql = "SELECT * FROM citizen WHERE last_name = " 
							+ "'" + lastName + "'" + 
							" AND first_name = "
							+ "'" + firstName + "'";
					
					//System.out.println(sql);
					System.out.println("For debugging - Line 62 - creating Citizen sql resultSet");
					
					con = conn.getConnection();
					try {
						statement = con.createStatement();
						ResultSet rs = statement.executeQuery(sql);
					
						while(rs.next())
						{
							if(rs.wasNull())
							{
								System.out.println("NULL");
							}
							else
							{
								String column1 = rs.getString("SSN");
								String column2 = rs.getString("first_name");
								String column3 = rs.getString("middle_initial");
								String column4 = rs.getString("last_name");
								String column5 = rs.getString("birth_date");
								String column6 = rs.getString("address");
								String column7 = rs.getString("password");
								String column8 = rs.getString("prisoner_id");
								String column9 = rs.getString("tax_id");
								String column10 = rs.getString("military_id");
								
								System.out.println("SSN: " + column1);
								System.out.println("First Name: " + column2);
								System.out.println("Middle Initial: " + column3);
								System.out.println("Last Name: " + column4);
								System.out.println("Birth Date: " + column5);
								System.out.println("Address: " + column6);
								System.out.println("Password: " + column7);
								System.out.println("Prisoner Id: " + column8);
								System.out.println("Tax Id: " + column9);
								System.out.println("Military Id: " + column10);
							}
						}
						rs.close();
						statement.close();
					
					}	
					catch (SQLException se)
					{
						//Handle errors for JDBC
				        se.printStackTrace();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					finally {
					//If con  & stmt not closed then try again and check for exceptions
				        try {
				            if (statement != null)
				                statement.close();
				        } catch (SQLException se2) {
				        }//cant do anything
				        /*try {
				            if (con != null)
				                con.close();
				        } catch (SQLException se) {
				            se.printStackTrace();
				        }*/
				    }
				}
				if(position == 2)
				{
					sql = "SELECT * FROM immigrant WHERE last_name = " 
							+ "'" + lastName + "'" + 
							" AND first_name = "
							+ "'" + firstName + "'";
					
					//System.out.println(sql);
					
					System.out.println("For debugging - Line 137 - creating Immigrant sql resultSet");
					
					con = conn.getConnection();
					try {
						statement = con.createStatement();
						ResultSet rs = statement.executeQuery(sql);
					
						while(rs.next())
						{
							if(rs.wasNull())
							{
								System.out.println("NULL");
							}
							else
							{
								String column1 = rs.getString("visa_number");
								String column2 = rs.getString("visa_type");
								String column3 = rs.getString("date_issues");
								String column4 = rs.getString("expiration_date");
								String column5 = rs.getString("first_name");
								String column6 = rs.getString("middle_initial");
								String column7 = rs.getString("last_name");
								
								System.out.println("visa_number: " + column1);
								System.out.println("visa_type: " + column2);
								System.out.println("date_issues: " + column3);
								System.out.println("expiration_date: " + column4);
								System.out.println("first_name: " + column5);
								System.out.println("middle_initial: " + column6);
								System.out.println("last_name: " + column7);
							}
						}
						rs.close();
						statement.close();
					
					}	
					catch (SQLException se)
					{
						//Handle errors for JDBC
				        se.printStackTrace();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					finally {
					//If con  & stmt not closed then try again and check for exceptions
				        try {
				            if (statement != null)
				                statement.close();
				        } catch (SQLException se2) {
				        }//cant do anything
				        /*try {
				            if (con != null)
				                con.close();
				        } catch (SQLException se) {
				            se.printStackTrace();
				        }*/
				    }
					
					
				}
				if(position == 3)
				{
					sql = "SELECT * FROM politician INNER JOIN citizen ON politician.ssn = citizen.ssn WHERE " 
							+ "last_name = "+ "'" + lastName + "'" + 
							" AND first_name = "
							+ "'" + firstName + "'";
					
					//System.out.println(sql);
					
					System.out.println("For debugging - Line 208 - creating Citizen sql resultSet");
					
					con = conn.getConnection();
					try {
						statement = con.createStatement();
						ResultSet rs = statement.executeQuery(sql);
					
						while(rs.next())
						{
							if(rs.wasNull())
							{
								System.out.println("NULL");
							}
							else
							{
								String column1 = rs.getString("SSN");
								String column2 = rs.getString("first_name");
								String column3 = rs.getString("middle_initial");
								String column4 = rs.getString("last_name");
								String column5 = rs.getString("birth_date");
								String column6 = rs.getString("address");
								String column7 = rs.getString("password");
								String column8 = rs.getString("prisoner_id");
								String column9 = rs.getString("tax_id");
								String column10 = rs.getString("military_id");
								String column11 = rs.getString("politician_id");
								
								System.out.println("SSN: " + column1);
								System.out.println("First Name: " + column2);
								System.out.println("Middle Initial: " + column3);
								System.out.println("Last Name: " + column4);
								System.out.println("Birth Date: " + column5);
								System.out.println("Address: " + column6);
								System.out.println("Password: " + column7);
								System.out.println("Prisoner Id: " + column8);
								System.out.println("Tax Id: " + column9);
								System.out.println("Military Id: " + column10);
								System.out.println("politician Id: " + column11);
							}
						}
						rs.close();
						statement.close();
					}	
					catch (SQLException se)
					{
						//Handle errors for JDBC
				        se.printStackTrace();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					finally {
					//If con  & stmt not closed then try again and check for exceptions
				        try {
				            if (statement != null)
				                statement.close();
				        } catch (SQLException se2) {
				        }//cant do anything
				        /*try {
				            if (con != null)
				                con.close();
				        } catch (SQLException se) {
				            se.printStackTrace();
				        }*/
				    }
				}
				
			}
			else if(input == 2)
			{
				System.out.println("Do you want to see laws or bills: ");
				System.out.println("1: Laws");
				System.out.println("2: Bills");
				lawsOrBills = scanner.nextInt();
				
				if(lawsOrBills == 1)
				{
					System.out.println("Do you have a specific law number?"
							+ " If you do not have a specific law number then all laws will be displayed.(y/n) ");
					String check = scanner.next();
					if(check == "y")
					{
						System.out.println("Enter the law number: ");
						lawNo = scanner.nextInt();
						lawNum = true;
					}
					else {
						//lawNum is kept false;
					}
					
				}
				if(lawsOrBills == 2)
				{
					System.out.println("Do you have a specific bill number?"
							+ " If you do not have a specific bill number then all laws will be displayed.(y/n) ");
					String check = scanner.next();
					if(check == "y")
					{
						System.out.println("Enter the bill number: ");
						billNo = scanner.nextInt();
						billNum = true;
					}
					else {
						//billNum is kept false;
					}
				}
				
				
				//Write query here
				
				if(lawNum == true)
				{
					sql = "SELECT law_id, description FROM law WHERE law_id = " + String.valueOf(lawNo);
				}
				else if(billNum == true)
				{
					sql = "SELECT bill_id, description FROM law WHERE bill_id = " + String.valueOf(billNo);
				}
				else if(lawNum == false)
				{
					sql = "SELECT law_id, description FROM law";
				}
				else if(billNum == false)
				{
					sql = "SELECT bill_id, description FROM law";
				}
				else
				{
					System.out.println("Error in creating search query, please contact an administrator at: 555-5555-5555");
				}
				
				//get result set here
				if((lawNum == true && billNum == false) || (lawNum == false && billNum == false))
				{
					System.out.println("For debugging - Line 300 - creating law sql resultSet");
					
					con = conn.getConnection();
					try {
						statement = con.createStatement();
						ResultSet rs = statement.executeQuery(sql);
					
						while(rs.next())
						{
							if(rs.wasNull())
							{
								System.out.println("NULL");
							}
							else
							{
								String column1 = rs.getString("last_name");
								String column2 = rs.getString("first_name");
								String column3 = rs.getString("address");
								
								System.out.println("Last Name: " + column1);
								System.out.println("First Name: " + column2);
								System.out.println("Address: " + column3);
							}
						}
						rs.close();
						statement.close();
					
					}	
					catch (SQLException se)
					{
						//Handle errors for JDBC
				        se.printStackTrace();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					finally {
					//If con  & stmt not closed then try again and check for exceptions
				        try {
				            if (statement != null)
				                statement.close();
				        } catch (SQLException se2) {
				        }//cant do anything
				        /*try {
				            if (con != null)
				                con.close();
				        } catch (SQLException se) {
				            se.printStackTrace();
				        }*/
				    }
				}
				else if((lawNum == false && billNum == true) || (lawNum == false && billNum == false))
				{
					System.out.println("For debugging - Line 354 - creating bill sql resultSet");
					
					con = conn.getConnection();
					try {
						statement = con.createStatement();
						ResultSet rs = statement.executeQuery(sql);
					
						while(rs.next())
						{
							if(rs.wasNull())
							{
								System.out.println("NULL");
							}
							else
							{
								String column1 = rs.getString("last_name");
								String column2 = rs.getString("first_name");
								String column3 = rs.getString("address");
								
								System.out.println("Last Name: " + column1);
								System.out.println("First Name: " + column2);
								System.out.println("Address: " + column3);
							}
						}
						rs.close();
						statement.close();
					
					}	
					catch (SQLException se)
					{
						//Handle errors for JDBC
				        se.printStackTrace();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					finally {
					//If con  & stmt not closed then try again and check for exceptions
				        try {
				            if (statement != null)
				                statement.close();
				        } catch (SQLException se2) {
				        }//cant do anything
				        /*try {
				            if (con != null)
				                con.close();
				        } catch (SQLException se) {
				            se.printStackTrace();
				        }*/
				    }
				}
				
			}
			else if(input == 3)
			{
				closePolitician = 0;
			}
			
			//Spacing for next query
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			
		}while (closePolitician != 0);
		
		//connection will be closed in start
		/*try {
            if (con != null)
                con.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }*/
		scanner.close();	
	}

}
