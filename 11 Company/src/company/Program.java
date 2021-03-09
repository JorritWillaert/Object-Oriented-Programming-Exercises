package company;

public class Program {
	
	public static void main(String[] args) {
		printLocations(new Company());
	}
	
	public static void printLocations(Company company) {
		String[] locations = company.getLocations();
		for (int i = 0; i < 3; i++) {
			System.out.println(locations[i]);
		}
	}
}
