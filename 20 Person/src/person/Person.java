package person;

import java.util.HashSet;
import java.util.Set;
import logicalcollections.*; //https://github.com/btj/logicalcollections

/**
 * Each instance of this class represents a person in an is-father-of graph.
 * 
 * @invar | getChildren() != null
 * @invar | getFather() == null || getFather().getChildren().contains(this)
 * @invar | getChildren().stream().allMatch(c -> c != null)
 * @invar | getChildren().stream().allMatch(c -> c.getFather() == this)
 */
public class Person {

	/**
	 * @invar | children != null
	 * @invar | father == null || father.children.contains(this)
	 * @invar | children.stream().allMatch(c -> c != null)
	 * @invar | children.stream().allMatch(c -> c.father == this)
	 * 
	 * @peerObject
	 */
	private Person father;
	/**
	 * @representationObject
	 * @peerObjects
	 */
	private final Set<Person> children = new HashSet<>();
	 
	//@mutates_properties --> Everything stays unchanged from all the peerobjects. Only the children of father change.
	/**
	 * Initializes this person to have the given father.
	 * 
	 * @mutates_properties | father.getChildren()
	 * @post | getFather() == father
	 * @post | father == null || father.getChildren().equals(LogicalSet.plus(old(father.getChildren()), this))
	 */
	public Person(Person father) {
		this.father = father;
		if (father != null)
			father.children.add(this);
	}
	
	/**
	 * @basic
	 * @peerObject
	 */
	public Person getFather() {
		return father;
	}
	
	/**
	 * @basic
	 * @creates | result
	 * @peerObjects
	 */
	public Set<Person> getChildren() {
		return Set.copyOf(children);
	}
	
	/**
	 * @mutates | this, father
	 * @pre | father != null
	 * @post | getFather() == father
	 * @post | father.getChildren().equals(LogicalSet.plus(old(father.getChildren()), this))
	 */
	public void setFather(Person father) {
		this.father = father;
		father.children.add(this);
	}
	
	/**
	 * @mutates | this, child
	 * @pre | child != null
	 * @pre | child.getFather() == null
	 * @post | child.getFather() == this
	 * @post | getChildren().equals(LogicalSet.plus(old(getChildren()), child))
	 */
	public void addChild(Person child) {
		child.father = this;
		children.add(child);
	}
	
	/**
	 * @mutates | this
	 * @pre | getFather() != null
	 * @pre | getFather().getChildren().contains(this)
	 * @post | getFather() == null
	 * @post | old(getFather()).getChildren().equals(LogicalSet.minus(old(getFather()).getChildren(), this))
	 */
	public void removeFather() {
		father.children.remove(this);
		father = null;
	}
	
	/**
	 * @mutates | this
	 * @pre | child != null
	 * @pre | getChildren().contains(child)
	 * @pre | child.getFather() == this
	 * @post | child.getFather() == null
	 * @post | getChildren().equals(LogicalSet.minus(old(getChildren()), child))
	 */
	public void removeChild(Person child) {
		children.remove(child);
		child.father = null;
	}
	
	/**
	 * @pre | getFather() != null
	 * @post | result.equals(getFather().getChildren())
	 */
	public Set<Person> getSiblingsInclusiveMe() {
		return Set.copyOf(father.getChildren());
	}
	
}
