package company;

public class CompanyB extends Company {

	/**
	 * @post | result != null
	 * @post| result.length == 1
	 */
	public String[] getLocations() {
		return new String[] {System.getenv("LOC4")};
	}

}
