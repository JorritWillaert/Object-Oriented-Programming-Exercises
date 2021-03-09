package company;

public class Company {
	
	/**
	 * @post | result != null
	 * @post | result.length == 3
	 */
	public String[] getLocations() { //Program has now more than one possible executions
		return new String[] {System.getenv("LOC1"), System.getenv("LOC2"), System.getenv("LOC3")};
	}
}
