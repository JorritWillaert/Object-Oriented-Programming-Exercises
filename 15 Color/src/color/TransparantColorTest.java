package color;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TransparantColorTest {

	@Test
	void test() {
		TransparantColor color1 = new TransparantColor(1, 2, 3, 4);
		TransparantColor color2 = new TransparantColor(1, 2, 3, 4);
		Color color3 = new Color(1, 2, 3);
		assertTrue(color1.equals(color2));
		assertFalse(color1.equals(color3));
		assertFalse(color3.equals(color1));
		assertTrue(color1.getClass() == TransparantColor.class);
		assertTrue(color3.getClass() == Color.class);
		
		assertEquals(2, color1.red);
		assertEquals(1, ((Color)color1).red); //!!! Field in Color is not gone! If you explicitly ask for ((Color)color1).red then you get the field of Color!
		assertEquals("rgba(2, 2, 3, 4)", color1.toString());
	}

}
