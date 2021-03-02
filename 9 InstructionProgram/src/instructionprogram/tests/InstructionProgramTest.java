package instructionprogram.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class InstructionProgramTest {
	
	/**
	 * @pre | 0 <= y
	 */
	static int power(int x, int y) {
		Instructions[] powerProgram = new Instructions[] {new LoadConstant(2, 1), new JumpIfZero(1, 5), 
				  new Multiply(2, 0), new Decrement(1), new Jump(1), new Halt()};
		int[] registers = new int[32];
		registers[0] = x; //Base
		registers[1] = y; //Exponent
		InstructionProgram.execute(registers, powerProgram); //Calculate x to the power of y
		return registers[2];
	}
	
	@Test
	void test() {
		assertEquals(1024, power(4, 5));
		assertEquals(1, power(5, 0));
	}
}
