import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Politician {

	Politician(Connection conn){
		int closePolitician = 1;
		int position = 0;
		int lawsOrBills = 0;
		//int lawNo = 0; //convert to string later
		String billNo = null; //convert to string later
		int input = 0;
		
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
			System.out.println("2: Add/Edit Citizens/Immigrants");
			System.out.println("3: Edit Bills");
			System.out.println("4: Create/Delete/View Bills");
			System.out.println("5: Exit");
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
					sql = "SELECT * FROM politician INNER JOIN citizen ON politician.politician_id = citizen.politician_id WHERE " 
							+ "last_name = "+ "'" + lastName + "'" + 
							" AND first_name = "
							+ "'" + firstName + "'";
					
					//System.out.println(sql);
					
					System.out.println("For debugging - Line 208 - creating Citizen sql resultSet");
					
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
				System.out.println("Do you want to add/edit an immigrant or citizen?");
				System.out.println("1: Add citizen/immigrant");
				System.out.println("2: Edit citizen/immigrant");
				position = scanner.nextInt();
				
				if(position == 1)
				{
					System.out.println("Do you want to add a citizen or an immigrant?");
					System.out.println("1: Add citizen");
					System.out.println("2: Add immigrant");
					int citOrImm = scanner.nextInt();
					
					if(citOrImm == 1)
					{
						System.out.println("Please enter the following fields as they appear: ");
						
						System.out.println("SSN: ");
						String ssn = scanner.next();
						
						System.out.println("First Name: ");
						String first_name = scanner.next();
						
						System.out.println("Middle Initial: ");
						String middle_initial = scanner.next();
						
						System.out.println("Last Name: ");
						String last_name = scanner.next();
						
						System.out.println("Birth Date: ");
						String birth_date = scanner.next();
						
						System.out.println("Address: ");
						String address = scanner.next();
						//System.out.println("Password: "); Set to null
						//System.out.println("Prisoner Id: "); Set to null
						/*System.out.println("Tax Id: ");
						String tax_id = scanner.next();*/
						//System.out.println("Military Id: "); Set to null
						//System.out.println("politician Id: "); Set to null
						
						/*sql = "UPDATE citizen SET SSN = " + "'" + ssn + "'," + " first_name =" + "'" + first_name + "',"
								+ " middle_initial = " + "'" + middle_initial + "'," + " last_name = " + "'" + last_name + "',"
								+ " birth_day = " + "'" + birth_date + "'," + " address = " + "'" + address + "', "
								+ " tax_id = " + "'" + tax_id + "'";*/
						sql = "INSERT INTO citizen (ssn, first_name, middle_initial, last_name, birth_date, address, password, prisoner_id, tax_id, military_id, politician_id)"
								+ "VALUES(" + "'" + ssn + "', " + "'" + first_name + "', " + "'" + middle_initial + "', " + "'" + last_name + "', " + "'" + birth_date + "', " + "'" + address + "', " + "null , " + "null, "  + "null, " + "null, " + "null" + ")";
						
						System.out.println("For debugging - Line 326 - creating Citizen sql resultSet");
						
						con = conn;
						try {
							statement = con.createStatement();
							boolean insertCheck = statement.execute(sql);
						
							/*if(insertCheck == true)
							{
								System.out.println("Successfully inserted");
							}
							else
							{
								System.out.println("Error when creating a citizen object, please ask for administrator assistance");
							}*/
							
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
					else if(citOrImm == 2)
					{
						System.out.println("Please enter the following fields as they appear: ");
						
						System.out.println("Visa Number: ");
						String visa_number = scanner.next();
						
						System.out.println("Visa Type: ");
						String visa_type = scanner.next();
						
						System.out.println("Date Issued: ");
						String date_issued = scanner.next();
						
						System.out.println("Expiration Date: ");
						String expiration_date = scanner.next();
						
						System.out.println("First Name: ");
						String first_name = scanner.next();
						
						System.out.println("Middle Initial: ");
						String middle_initial = scanner.next();
						
						System.out.println("Last Name: ");
						String last_name = scanner.next();

						
						/*sql = "UPDATE citizen SET SSN = " + "'" + ssn + "'," + " first_name =" + "'" + first_name + "',"
								+ " middle_initial = " + "'" + middle_initial + "'," + " last_name = " + "'" + last_name + "',"
								+ " birth_day = " + "'" + birth_date + "'," + " address = " + "'" + address + "', "
								+ " tax_id = " + "'" + tax_id + "'";*/
						sql = "INSERT INTO immigrant (visa_number, visa_type, date_issued, expiration_date, first_name, middle_initial, last_name)"
								+ "VALUES(" + "'" + visa_number + "', " +  "'" + visa_type + "', " + "'" + date_issued + "', " + "'" + expiration_date + "', " + "'" + first_name + "', " + "'" + middle_initial + "', " + "'" + last_name + "'" + ")";
						
						System.out.println("For debugging - Line 403 - creating immigrant sql resultSet");
						
						con = conn;
						try {
							statement = con.createStatement();
							boolean insertCheck = statement.execute(sql);
						
							/*if(insertCheck == true)
							{
								System.out.println("Successfully inserted");
							}
							else
							{
								System.out.println("Error when creating a immigrant object, please ask for administrator assistance");
							}*/
							
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
				if(position == 2)
				{
					System.out.println("Do you want to edit a citizen or an immigrant: ");
					System.out.println("1: Citizen");
					System.out.println("2: Immigrant");
					int citOrImm = scanner.nextInt();
					
					if(citOrImm == 1)
					{
						
						String SSN = null;
						
						System.out.println("Please enter the citizen's SSN");
						SSN = scanner.next();
						sql = "UPDATE citizen SET ";
						//System.out.println("DEBUGGING SQL -- CITIZEN EDIT");
						//System.out.println("sql");
						
						int quit = 0; 
						String first_name = null, middle_initial = null, last_name = null, birth_date = null, address = null,/* password = null, */prisoner_id = null, tax_id = null, military_id = null, politician_id = null, exit = null; 
						boolean /*ssn = false,*/ fn = false, mi = false, ln = false, bd = false, addr = false, /*pass = false,*/  pr_id = false, t_id = false, m_id = false, p_id = false;
						do {
							System.out.println("Please choose what values you want to edit: ");
							//System.out.println("1: SSN ");
							System.out.println("1: First Name ");
							System.out.println("2: Middle Initial ");
							System.out.println("3: Last Name ");
							System.out.println("4: Birth Date");
							System.out.println("5: Address");
							//System.out.println("7: Password");
							System.out.println("6: Prisoner Id");
							System.out.println("7: Tax Id");
							System.out.println("8: Military Id");
							System.out.println("9: Politician Id");
							System.out.println("10: Exit");
							quit = scanner.nextInt();
							/*if(quit == 1)
							{
								System.out.println("Please enter a new SSN: ");
								SSN = scanner.next();
								ssn = true;
							}*/
							if(quit == 1)
							{
								System.out.println("Please enter a new First Name: ");
								first_name = scanner.next();
								fn = true;
							}
							else if(quit == 2)
							{
								System.out.println("Please enter a new Middle Initial: ");
								middle_initial = scanner.next();
								mi = true;
							}
							else if(quit == 3)
							{
								System.out.println("Please enter a new Last Name: ");
								last_name = scanner.next();
								ln = true;
							}
							else if(quit == 4)
							{
								System.out.println("Please enter a new Birth Date: ");
								birth_date = scanner.next();
								bd = true;
							}
							else if(quit == 5)
							{
								System.out.println("Please enter a new Address: ");
								address = scanner.next();
								addr = true;
							}
							/*else if(quit == 7)
							{
								System.out.println("Please enter a new Password: ");
								password = scanner.next();
								pass = true;
							}*/
							else if(quit == 6)
							{
								System.out.println("Please enter a new Prisoner Id: ");
								prisoner_id = scanner.next();
								pr_id = true;
							}
							else if(quit == 7)
							{
								System.out.println("Please enter a new Tax Id: ");
								tax_id = scanner.next();
								t_id = true;
							}
							else if(quit == 8)
							{
								System.out.println("Please enter a new Military Id: ");
								military_id = scanner.next();
								m_id = true;
							}
							else if(quit == 9)
							{
								System.out.println("Please enter a new Politician Id: ");
								politician_id = scanner.next();
								p_id = true;
							}
							else if(quit == 10)
							{
								System.out.println("Are you sure you want to make these changes?(y/n)");
								exit = scanner.next();
								if(exit.equals("y"))
								{
									quit = 11;
								}
								else {
									//do nothing
								}
							}
						}while (quit != 11);
						
						if(fn == true)
						{
							sql = sql + " first_name = " + "'" + first_name + "'";
						}
						if(mi == true)
						{
							sql = sql + " middle_initial = " + "'" + middle_initial + "'";
						}
						if(ln == true)
						{
							sql = sql + " last_name = " + "'" + last_name + "'";
						}
						if(bd == true)
						{
							sql = sql + " birth_date = " + "'" + birth_date + "'";
						}
						if(addr == true)
						{
							sql = sql + " address = " + "'" + address + "'";
						}
						if(pr_id == true)
						{
							sql = sql + " prisoner_id = " + "'" + prisoner_id + "'";
						}
						if(t_id == true)
						{
							sql = sql + " tax_id = " + "'" + tax_id + "'";
						}
						if(m_id == true)
						{
							sql = sql + " military_id = " + "'" + military_id + "'";
						}
						if(p_id == true)
						{
							sql = sql + " politician_id = " + "'" + politician_id + "'";
						}
						
						sql = sql + " WHERE ssn = " + "'" + SSN + "'";
						
						System.out.println("DEBUGGING SQL -- CITIZEN EDIT -- after adding SQL");
						System.out.println("sql");
						
						System.out.println("For debugging - Line 603 - editing citizen sql resultSet");
						
						con = conn;
						try {
							statement = con.createStatement();
							boolean insertCheck = statement.execute(sql);
						
							/*if(insertCheck == true)
							{
								System.out.println("Successfully updated");
							}
							else
							{
								System.out.println("Error when editing a citizen object, please ask for administrator assistance");
							}*/
							
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
					else if(citOrImm == 2)
					{
						String VISA_NUMBER = null;
						
						System.out.println("Please enter the immigrant's visa number");
						VISA_NUMBER = scanner.next();
						sql = "UPDATE immigrant SET ";
						//System.out.println("DEBUGGING SQL -- IMMIGRANT EDIT");
						//System.out.println("sql");
						
						int quit = 0; 
						String visa_type = null, date_issued = null, expiration_date = null, first_name = null, middle_initial = null, last_name = null, exit; 
						boolean vt = false, di = false, ed = false, fn = false, mi = false, ln = false;
						do {
							System.out.println("Please choose what values you want to edit: ");
							System.out.println("1: Visa Type");
							System.out.println("2: Date Issued");
							System.out.println("3: Expiration Date");
							System.out.println("4: First Name ");
							System.out.println("5: Middle Initial ");
							System.out.println("6: Last Name ");
							System.out.println("7: Exit");
							quit = scanner.nextInt();
							
							if(quit == 1)
							{
								System.out.println("Please enter a new Visa Type: ");
								visa_type = scanner.next();
								vt = true;
							}
							else if(quit == 2)
							{
								System.out.println("Please enter a new Date Issued: ");
								date_issued = scanner.next();
								di = true;
							}
							else if(quit == 3)
							{
								System.out.println("Please enter a new Expiration Date: ");
								expiration_date = scanner.next();
								ed = true;
							}
							else if(quit == 4)
							{
								System.out.println("Please enter a new First Name: ");
								first_name = scanner.next();
								fn = true;
							}
							else if(quit == 5)
							{
								System.out.println("Please enter a new Middle Initial: ");
								middle_initial = scanner.next();
								mi = true;
							}
							else if(quit == 6)
							{
								System.out.println("Please enter a new Last Name: ");
								last_name = scanner.next();
								ln = true;
							}
							else if(quit == 7)
							{
								System.out.println("Are you sure you want to make these changes?(y/n)");
								exit = scanner.next();
								if(exit.equals("y"))
								{
									quit = 10;
								}
								else {
									//do nothing
								}
							}
						}while (quit != 10);
						
						if(vt == true)
						{
							sql = sql + " visa_type = " + "'" + visa_type + "'";
						}
						if(di == true)
						{
							sql = sql + " date_issued = " + "'" + date_issued + "'";
						}
						if(ed == true)
						{
							sql = sql + " expiration_date = " + "'" + expiration_date + "'";
						}
						if(fn == true)
						{
							sql = sql + " first_name = " + "'" + first_name + "'";
						}
						if(mi == true)
						{
							sql = sql + " middle_initial = " + "'" + middle_initial + "'";
						}
						if(ln == true)
						{
							sql = sql + " last_name = " + "'" + last_name + "'";
						}
			
						
						sql = sql + " WHERE visa_number = " + "'" + VISA_NUMBER + "'";
						
						System.out.println("DEBUGGING SQL -- IMMIGRANT EDIT -- after adding SQL");
						System.out.println("sql");
						
						System.out.println("For debugging - Line 752 - creating immigrant sql resultSet");
						
						con = conn;
						try {
							statement = con.createStatement();
							boolean insertCheck = statement.execute(sql);
						
							/*if(insertCheck == true)
							{
								System.out.println("Successfully updated");
							}
							else
							{
								System.out.println("Error when creating a immigrant object, please ask for administrator assistance");
							}*/
							
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
			}
			else if(input == 3)
			{
				System.out.println("Please enter the Bill Id to edit: ");
				billNo = scanner.next();
				
				System.out.println("Please enter the Bill Id's new description: ");
				String description = scanner.next();
				
				sql = "UPDATE bill SET description = " + "'" + description + "'" + "WHERE bill_id = " + "'" + billNo + "'";
				
				System.out.println("For debugging - Line 809 - editting bill sql resultSet");
					
				con = conn;
					try {
						statement = con.createStatement();
						boolean insertCheck = statement.execute(sql);
					
						/*if(insertCheck == true)
						{
							System.out.println("Successfully updated");
						}
						else
						{
							System.out.println("Error when editing a citizen object, please ask for administrator assistance");
						}*/
						
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
				//}
				
			}
			else if(input == 4)
			{
				System.out.println("Please select an option: ");
				System.out.println("1: Create bill");
				System.out.println("2: Delete bill");
				System.out.println("3: View all bills");
				int billCrOrDel = scanner.nextInt();
				
				if(billCrOrDel == 1)
				{
					System.out.println("Please enter a bill id: ");
					String id = scanner.next();
					System.out.println("Please enter a bill description");
					String description = scanner.next();
					
					sql = "INSERT INTO bill (bill_id, description) VALUES(" + "'" + id + "', " + "'" + description + "'" + ")";
					
					System.out.println("For debugging - Line 868 - creating bill sql resultSet");
					
					con = conn;
					try {
						statement = con.createStatement();
						boolean insertCheck = statement.execute(sql);
						
						/*if(insertCheck == true)
						{
							System.out.println("Successfully inserted");
						}
						else
						{
							System.out.println("Error when creating a bill object, please ask for administrator assistance");
						}*/
						
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
				else if(billCrOrDel == 2)
				{
					System.out.println("Please enter a bill id to delete: ");
					String id = scanner.next();
					
					sql = "DELETE FROM bill WHERE bill_id" + "'" + id + "'";
					
					System.out.println("For debugging - Line 919 - deleting bill sql resultSet");
					
					con = conn;
					try {
						statement = con.createStatement();
						boolean insertCheck = statement.execute(sql);
					
						/*if(insertCheck == true)
						{
							System.out.println("Successfully inserted");
						}
						else
						{
							System.out.println("Error when deleting a bill object, please ask for administrator assistance");
						}*/
						
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
				else if(billCrOrDel == 3)
				{
					sql = "SELECT bill_id, description FROM bill";
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
								
								System.out.println("Law Id: " + column1);
								System.out.println("description: " + column2);
							}
						}
						rs.close();
						statement.close();
						
					
						/*if(insertCheck == true)
						{
							System.out.println("Successfully inserted");
						}
						else
						{
							System.out.println("Error when deleting a bill object, please ask for administrator assistance");
						}*/
						
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
			else if(input == 5)
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
