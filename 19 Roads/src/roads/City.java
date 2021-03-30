package roads;

import java.util.HashSet;
import java.util.Set;
import logicalcollections.*; //https://github.com/btj/logicalcollections

/**
 * @invar | getConnectedCities() != null
 * @invar | getConnectedCities().stream().allMatch(c -> c != null)
 * @invar | getConnectedCities().stream().allMatch(c ->
 * 		  |			c.getConnectedCities().contains(this))
 */
public class City {

	/**
	 * @invar | connectedCities != null
	 * @invar | connectedCities.stream().allMatch(c -> c != null)
	 * @invar | connectedCities.stream().allMatch(c -> 
	 * 		  |			c.connectedCities.contains(this))
	 * 
	 * @representationObject
	 * @peerObjects
	 */
	private final Set<City> connectedCities = new HashSet<>();
	//RepresentationObject: client does not know that we use HashSet for storing different cities (encapsulate).
	//PeerObjects: Client knows that different cities are connected with each other.
	
	/**
	 * @post | getConnectedCities().isEmpty()
	 */
	public City() {}
	
	/**
	 * @peerObjects
	 */
	public Set<City> getConnectedCities() {
		return Set.copyOf(connectedCities);
	}
	
	//@mutates | this, other --> This and other not in the same peergroup yet. Mutates clause to both.
	/**
	 * @mutates | this, other
	 * @pre | other != null
	 * @post | getConnectedCities().equals(LogicalSet.plus(old(getConnectedCities()), other))
	 * @post | other.getConnectedCities().equals(LogicalSet.plus(old(other.getConnectedCities()), this))
	 */
	public void registerRoad(City other) {//LogicalSet.plus() --> Returns a set object which is the union of the two sets.
		connectedCities.add(other);
		other.connectedCities.add(this);
	}
	
	//@mutates | this --> This and other in the same peergroup. Mutates clause only to this!
	/**
	 * @mutates | this
	 * @pre | getConnectedCities().contains(other)
	 * @post | getConnectedCities().equals(LogicalSet.minus(old(getConnectedCities()), other))
	 * @post | other.getConnectedCities().equals(LogicalSet.minus(old(other.getConnectedCities()), this))
	 */
	public void registerRoadRemoved(City other) {
		connectedCities.remove(other);
		other.connectedCities.remove(this);
	}
	
}
