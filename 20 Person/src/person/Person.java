package person;

import java.util.HashSet;
import java.util.Set;
import logicalcollections.*; //https://github.com/btj/logicalcollections

/**
 * @invar | getChildren() != null
 * @invar | getChildren().stream().allMatch(c -> c != null)
 * @invar | getChildren().stream().allMatch(c -> c.getFather() == getFather())
 * @invar | getChildren().stream().allMatch(c -> c.getChildren().contains(this))
 */
public class Person {

	/**
	 * @invar | children != null
	 * @invar | children.stream().allMatch(c -> c != null)
	 * @invar | children.stream().allMatch(c -> c.getFather() == father)
	 * @invar | children.stream().allMatch(c -> c.getChildren().contains(this))
	 * 
	 * @peerObject
	 */
	private Person father;
	/**
	 * @representationObject
	 * @peerObjects
	 */
	private final Set<Person> children = new HashSet<>();
	
	/**
	 * @post | getFather() == null
	 * @post | getChildren().isEmpty()
	 */
	public Person() {}
	
	/**
	 * @basic
	 * @peerObject
	 */
	public Person getFather() {
		return father;
	}
	
	/**
	 * @basic
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
	 * @post | child.getFather() == this
	 * @post | getChildren().equals(LogicalSet.plus(old(getChildren()), this))
	 */
	public void addChild(Person child) {
		child.father = this;
		children.add(child);
	}
	
	/**
	 * @mutates | this
	 * @post | getFather() == null
	 * @post | old(getFather()).getChildren().equals(LogicalSet.minus(old(getFather().getChildren()), this))
	 */
	public void removeFather() {
		father.children.remove(this);
		father = null;
	}
	
	/**
	 * @mutates | this
	 * @pre | child != null
	 * @pre | getChildren().contains(child)
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
	public Set<Person> getSiblings() {
		return Set.copyOf(father.getChildren());
	}
	
}
