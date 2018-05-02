import java.sql.Connection;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

public class Citizen {
	
	Citizen(DBconnect conn){
		int x = 1;
		String position = null;
		String lastName = null;
		String firstName = null;
		String lawsOrBills = null;
		String lawNo = null;
		String billNo = null;
		boolean lawNum = false, billNum = false;
		String input = null;
		
		Scanner scanner = new Scanner(System.in);
		do {
			
			String sql;
			System.out.println("Please select an option: ");
			System.out.println("1: Search for individuals");
			System.out.println("2: View laws");
			System.out.println("3: Exit");
			input = scanner.nextLine();
			
			if(input == "1")
			{	
				System.out.println("Please select their position within our country: ");
				System.out.println("1: Citizen");
				System.out.println("2: Immigrant");
				System.out.println("3: Politician");
				position = scanner.nextLine();
				
				System.out.println("Please enter their last name: ");
				lastName = scanner.nextLine();
				
				System.out.println("Please enter their first name: ");
				firstName = scanner.nextLine();
				
				//Write query here
				if(position == "1")
				{
					sql = "SELECT last_name, first_name, address FROM citizen WHERE last_name = " 
							+ lastName + 
							" AND first_name = "
							+ firstName;
				}
				if(position == "2")
				{
					sql = "SELECT last_name, first_name FROM immigrant WHERE last_name = " 
							+ lastName + 
							" AND first_name = "
							+ firstName;
				}
				if(position == "3")
				{
					sql = "SELECT last_name, first_name, address FROM politician INNER JOIN citizen WHERE politician.ssn = citizen.snn AND " 
							+ "last_name = "+ lastName + 
							" AND first_name = "
							+ firstName;
				}
				
				//get resultSet here
			}
			if(input == "2")
			{
				System.out.println("Do you want to see laws or bills: ");
				System.out.println("1: Laws");
				System.out.println("2: Bills");
				lawsOrBills = scanner.nextLine();
				
				if(lawsOrBills == "1")
				{
					System.out.println("Do you have a specific law number?"
							+ " If you do not have a specific law number then all laws will be displayed.(y/n) ");
					String check = scanner.nextLine();
					if(check == "y")
					{
						System.out.println("Enter the law number: ");
						lawNo = scanner.nextLine();
						lawNum = true;
					}
					else {
						//lawNum is kept false;
					}
					
				}
				if(lawsOrBills == "2")
				{
					System.out.println("Do you have a specific bill number?"
							+ " If you do not have a specific bill number then all laws will be displayed.(y/n) ");
					String check = scanner.nextLine();
					if(check == "y")
					{
						System.out.println("Enter the bill number: ");
						billNo = scanner.nextLine();
						billNum = true;
					}
					else {
						//billNum is kept false;
					}
				}
				
				
				//Write query here
				
				if(lawNum == true)
				{
					sql = "SELECT law_id, description FROM law WHERE law_id = " + lawNo;
				}
				else if(billNum == true)
				{
					sql = "SELECT bill_id, description FROM law WHERE bill_id = " + billNo;
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
			}
			if(input == "3")
			{
				x = 0;
			}
			
		}while (x == 0);
		
		
		
		//close for now, move it down later
		scanner.close();
		
		
	}

}
