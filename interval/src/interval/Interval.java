package interval;

// Hier spreekt men niet over de private klasse-invarianten, maar over de setters en getters (dit is public)
/**
 * Elke instantie van deze klasse stelt eent interval van gehele getallen voor.
 * 
 * @invar De breedte is niet negatief
 * 		| 0 <= getWidth()
 * @invar De bovengrens is gelijk aan de ondergrens plus de breedte
 * 		| getBovengrens() == getOndergrens() + getWidth()
 */
public class Interval {
	
	// Private klasse-invarianten = reprentatie-invarianten
	/**
	 * @invar De bovengrens is niet kleiner dan de ondergrens
	 * 		| ondergrens <= bovengrens
	 */
	private int bovengrens;
	private int ondergrens;
	
	/**
	 * @pre  | initiëleOndergrens <= initiëleBovengrens
	 * @post | getBovengrens() == initiëleBovengrens
	 * @post | getOndergrens() == initiëleOndergrens
	 */
	public Interval(int initiëleBovengrens, int initiëleOndergrens){
		this.bovengrens = initiëleBovengrens;
		this.ondergrens = initiëleOndergrens;
	}
	
	public int getWidth() { //Als je 'static' verwijderd, wordt het een instantiemethode. Verwijziging naar instantie van klasse impliciet met 'this'
		return this.bovengrens - this.ondergrens;
	}
	
	public int getOndergrens() {
		return ondergrens; //Je kunt 'this' ook weglaten. Java weet dat je impliciet naar het veld van de klasse verwijst.
	}
	
	public int getBovengrens() {
		return bovengrens;	
	}
	
	/**
	 * @post De ondergrens van het gegeven interval is gelijk aan de gegeven ondergrens
	 * 		| this.getOndergrens() == ondergrens
	 * @post De breedte van het gegeven interval blijft ongewijzigd
	 * 		| this.getWidth() == old(this.getWidth())
	 */
	public void setOndergrens(int ondergrens) {
		int breedte = bovengrens - this.ondergrens;
		this.ondergrens = ondergrens; // Hier mag je 'this' niet weglaten, aangezien we ook een parameter 'ondergrens' hebben.
		bovengrens = ondergrens + breedte;
	}
	
	//Pre-condities moet voldaan worden door de client-code
	/**
	 * @pre De gegegeven bovengrens mag niet kleiner zijn dan de ondergrens.
	 * 		| getOndergrens() <= bovengrens
	 * @post De bovengrens van het gegeven interval is gelijk aan de gegeven bovengrens
	 * 		| this.getBovengrens() == bovengrens
	 * @post De ondergrens van het gegeven interval blijft ongewijzigd
	 * 		| this.getOndergrens() == old(this.getOndergrens())
	 */
	public void setBovengrens(int bovengrens) {
		this.bovengrens = bovengrens;
	}
}
