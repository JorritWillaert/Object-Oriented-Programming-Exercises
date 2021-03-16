package translator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EvaluateTest {

	@Test
	void test() {
		assertEquals(5, ((IntValue) Value.evaluate(new IntValue(2), '+', new IntValue(3))).value);
		assertEquals("Hello world", ((StringValue) Value.evaluate(new StringValue("Hello "), '+', new StringValue("world"))).value);
		
		assertEquals(2, ((IntValue) Value.evaluate(new IntValue(2), '&', new IntValue(3))).value);
		assertEquals(false, ((BooleanValue) Value.evaluate(new BooleanValue(true), '&', new BooleanValue(false))).value);
	}

}
