package company;

public class Program {
	
	public static void main(String[] args) {
		printLocations(new CompanyA());
	}
	
	//opgeloste methode van de oproep in main = opgeroepen methode in main
	/**
	 * @pre | company != null  
	 */
	public static void printLocations(Company company) {
		String[] locations = company.getLocations(); //Dynamically bounded
		for (int i = 0; i < 2; i++) { 
			System.out.println(locations[i]); //Statically bounded
		}
	}
}
