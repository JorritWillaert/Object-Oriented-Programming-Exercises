package company;

public class CompanyA extends Company{
	
	//Opgeroepen methode
	/**
	 * @post | result != null
	 * @post | result.length == 2
	 */
	public String[] getLocations() { //Specification of CompanyA is stricter than Company
		return new String[] {	System.getenv("LOC2"), 
								System.getenv("LOC1")};
	}
}
 