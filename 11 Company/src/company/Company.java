package company;

public abstract class Company {
	
	//Opgeloste methode (bepaald voordat waardes van uitdrukkingen gekend zijn)
	/**
	 * @post | result != null
	 */
	public abstract String[] getLocations();
}

// Basisaanpak modulair redeneren:
// - Redeneer over oproepen obv specificaties opgeroepen methodes
// Verfijnde aanpak:
// - Redeneer over oproepen obv specificatie opgeloste methode
// - Overschrijvende methode moet voldoen aan specificatie overschreven methode
// e.g. Company A and B both return a result != null