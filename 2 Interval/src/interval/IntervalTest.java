package interval;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntervalTest {
	@Test
	void test() {
		Interval myInterval = new Interval(0, 0);
		myInterval.setOndergrens(3);
		myInterval.setBovengrens(7);
		assert myInterval.getWidth() == 4; //Als het een instantiemethode is
		//assert Interval.getWidth(myInterval) == 4; //Als het een statische methode is
	}

}
