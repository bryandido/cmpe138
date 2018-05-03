public class Create {
	
	Create(char c){
		
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
	}
}
