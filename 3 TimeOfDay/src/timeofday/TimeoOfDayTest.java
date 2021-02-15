package timeofday;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeoOfDayTest {

	@Test
	void test() {
		TimeOfDay myTimeOfDay = new TimeOfDay(54, 9);
		assertEquals(9, myTimeOfDay.getHours());
		assertEquals(54, myTimeOfDay.getMinutes());
		assertEquals(9 * 60 + 54, myTimeOfDay.getMinutesSinceMidnight());
		myTimeOfDay.setHours(8);
		myTimeOfDay.setMinutes(30);
		myTimeOfDay.setMinutes(40);
		myTimeOfDay.setHours(21);
		assert myTimeOfDay.getHours() == 21;
		assert myTimeOfDay.getMinutes() == 40;
	}
}
