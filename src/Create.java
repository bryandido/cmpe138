import java.util.Scanner;

public class Create {
	Scanner sc;
	private String SSN;
	private String password;
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String birthDate;
	private String address;
	private String politicianID;
	private String militaryID;
	
	Create(char c){
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
		// create civilian first
		RegisterCivilian();
		//query
		
	}
	public void RegisterMilitaryPersonnel() {
		// create civilian first
		RegisterCivilian();
		
	}
	public void RegisterCivilian() {
		System.out.println("Enter your SSN: ");
		SSN = sc.next();
		System.out.println("Enter your password: ");
		password = sc.next();
		System.out.println("Enter your first name: ");
		firstName = sc.next();
		System.out.println("Enter your middle initial: ");
		middleInitial = sc.next();
		System.out.println("Enter your last name: ");
		lastName = sc.next();
		System.out.println("Enter your birthDate");
		birthDate = sc.next();
		System.out.println("Enter address: ");
		address = sc.next();
		//query
	}
}
