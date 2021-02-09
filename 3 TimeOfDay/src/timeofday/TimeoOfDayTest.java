package timeofday;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeoOfDayTest {

	@Test
	void test() {
		TimeOfDay myTimeOfDay = new TimeOfDay(0, 0);
		myTimeOfDay.setHours(8);
		myTimeOfDay.setMinutes(30);
		assert myTimeOfDay.getHours() == 8;
		assert myTimeOfDay.getMinutes() == 30;
	}
}
