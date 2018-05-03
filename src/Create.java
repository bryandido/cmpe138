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
			System.out.println("Now login...");
		} 
		else if (c == 'm') { // if military personnel
			System.out.println("Registation for Military Personnel");
			RegisterMilitaryPersonnel();
			System.out.println("Now login...");
		} 
		else { // if civilian
			System.out.println("Registation for Civilian");
			RegisterCivilian();
			System.out.println("Now login...");
		}
	}
	public void RegisterPolitician() {
		RegisterCivilian();
		
	}
	public void RegisterMilitaryPersonnel() {
		RegisterCivilian();
		
	}
	public void RegisterCivilian() {
		System.out.println("Enter your SSN: ");
	}
}
