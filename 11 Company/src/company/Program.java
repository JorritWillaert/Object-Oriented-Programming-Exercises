package company;

public class Program {
	
	public static void main(String[] args) {
		printLocations(new Company());
	}
	
	/**
	 * @pre | company != null
	 */
	public static void printLocations(Company company) {
		String[] locations = company.getLocations();
		for (int i = 0; i < 3; i++) { //Due to the post-condition is this statement correct
			System.out.println(locations[i]);
		}
	}
}
