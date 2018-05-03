import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;

public class Military {
	
	Military(Connection conn){
		int closeMilitary=1;
		int position=0;
		int lawsOrBills=0;
		int input=0;
		
		String lastName = null;
		String firstName = null;
		String lawNo = null;
		String billNo = null;
		
		boolean lawNum = false, billNum = false;
		
		Connection con = null;
		Statement statement = null;
		
		Scanner scanner = new Scanner(System.in);
		do {
			
			String sql = null;
			System.out.println("Please select an option: ");
			System.out.println("1: Search for individuals");
			System.out.println("2: View laws");
			System.out.println("3: Exit");
			input = scanner.nextInt();
			
			if(input == 1)
			{	
				System.out.println("Please select their position within our country: ");
				System.out.println("1: Citizen");
				System.out.println("2: Immigrant");
				System.out.println("3: Politician");
				System.out.println("4: Military");
				position = scanner.nextInt();
				
				System.out.println("Please enter their last name: ");
				lastName = scanner.next();
				
				System.out.println("Please enter their first name: ");
				firstName = scanner.next();
				
				//Write query here
				if(position == 1)
				{
					sql = "SELECT last_name, first_name, address FROM citizen WHERE last_name = " 
							+ "'" + lastName + "'" + 
							" AND first_name = "
							+ "'" + firstName + "'";
					
					//System.out.println(sql);
					System.out.println("For debugging - Line 58 - creating Citizen sql resultSet");
					
					con = conn;
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
				if(position == 2)
				{
					sql = "SELECT last_name, first_name FROM immigrant WHERE last_name = " 
							+ "'" + lastName + "'" + 
							" AND first_name = "
							+ "'" + firstName + "'";
					
					//System.out.println(sql);
					
					System.out.println("For debugging - Line 119 - creating Immigrant sql resultSet");
					
					con = conn;
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
								
								System.out.println("Last Name: " + column1);
								System.out.println("First Name: " + column2);
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
					sql = "SELECT last_name, first_name, address FROM politician INNER JOIN citizen ON politician.politician_id = citizen.politician_id WHERE " 
							+ "last_name = "+ "'" + lastName + "'" + 
							" AND first_name = "
							+ "'" + firstName + "'";
					
					//System.out.println(sql);
					
					System.out.println("For debugging - Line 180 - creating Politican sql resultSet");
					
					con = conn;
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
				if(position==4)
				{
					sql = "SELECT last_name, first_name, rank,start_date,end_date FROM MILITARY_PERSONNEL INNER JOIN citizen ON MILITARY_PERSONNEL.military_id = citizen.military_id WHERE " 
							+ "last_name = "+ "'" + lastName + "'" + 
							" AND first_name = "
							+ "'" + firstName + "'";
					
					//System.out.println(sql);
					
					System.out.println("For debugging - Line 180 - creating Military sql resultSet");
					
					con = conn;
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
								String column3 = rs.getString("rank");
								String column4 = rs.getString("start_date");
								String column5 = rs.getString("end_date");
								
								System.out.println("Last Name: " + column1);
								System.out.println("First Name: " + column2);
								System.out.println("rank: " + column3);
								System.out.println("Start Date: " + column4);
								System.out.println("End Date: " + column5);

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
					if(check.equals("y"))
					{
						System.out.println("Enter the law number: ");
						lawNo = scanner.next();
						lawNum = true;
					}
					else {
						lawNum = false;
					}
					
				}
				if(lawsOrBills == 2)
				{
					System.out.println("Do you have a specific bill number?(y/n)"
							+ " If you do not have a specific bill number then all laws will be displayed.");
					String check = scanner.next();
					if(check.equals("y"))
					{
						System.out.println("Enter the bill number: ");
						billNo = scanner.next();
						billNum = true;
					}
					else {
						billNum = false;
					}
				}
				
				
				//Write query here
				
				if(lawNum == true && billNum == false)
				{
					sql = "SELECT law_id, description FROM law WHERE law_id = " + "'" + lawNo + "'";
				}
				else if(billNum == true && lawNum == false)
				{
					sql = "SELECT bill_id, description FROM bill WHERE bill_id = " + "'" + billNo + "'";
				}
				else if(lawNum == false && lawsOrBills == 1)
				{
					sql = "SELECT law_id, description FROM law";
				}
				else if(billNum == false && lawsOrBills == 2)
				{
					sql = "SELECT bill_id, description FROM bill";
				}
				else
				{
					System.out.println("Error in creating search query, please contact an administrator at: 555-5555-5555");
				}
				
				//get result set here
				if((lawNum == true && billNum == false) || (lawNum == false && lawsOrBills == 1))
				{
					System.out.println("For debugging - Line 300 - creating law sql resultSet");
					
					con = conn;
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
								String column1 = rs.getString("law_id");
								String column2 = rs.getString("description");
								
								System.out.println("Law Id: " + column1);
								System.out.println("description: " + column2);
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
				else if((lawNum == false && billNum == true) || (lawsOrBills == 2 && billNum == false))
				{
					System.out.println("For debugging - Line 354 - creating bill sql resultSet");
					
					con = conn;
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
								String column1 = rs.getString("bill_id");
								String column2 = rs.getString("description");
								
								System.out.println("Bill Id: " + column1);
								System.out.println("description: " + column2);
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
				closeMilitary = 0;
			}
			
			//Spacing for next query
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			
		}while (closeMilitary != 0);
		
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