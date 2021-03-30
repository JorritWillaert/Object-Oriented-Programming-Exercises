package person;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void test() {
		Person albert = new Person();
		Person laurent = new Person();
		Person filip = new Person();
		Person elisabeth = new Person();
		
		assertEquals(Set.of(), filip.getChildren());
		assertEquals(null, filip.getFather());
		
		albert.addChild(laurent);
		assertEquals(albert, laurent.getFather());
		assertEquals(Set.of(laurent), albert.getChildren());
		
		filip.setFather(albert);
		assertEquals(albert, filip.getFather());
		assertEquals(Set.of(laurent, filip), albert.getChildren());
		
		filip.addChild(elisabeth);
		assertEquals(filip, elisabeth.getFather());
		assertEquals(Set.of(elisabeth), filip.getChildren());
		
		assertEquals(Set.of(filip, laurent), filip.getSiblingsInclusiveMe());
		assertEquals(Set.of(elisabeth), elisabeth.getSiblingsInclusiveMe());
		
		albert.removeChild(laurent);
		assertEquals(Set.of(filip), albert.getChildren());
		assertEquals(null, laurent.getFather());
		
		filip.removeFather();
		assertEquals(Set.of(), albert.getChildren());
		assertEquals(null, filip.getFather());
	}

}
