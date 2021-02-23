package instructionprogram.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

abstract class Instructions {}

class LoadConstant extends Instructions {
	public LoadConstant(int index, int constant) {
		throw new AssertionError("Not yet implemented");
	}
}

class Decrement extends Instructions {
	public Decrement(int index) {
		throw new AssertionError("Not yet implemented");
	}
}

class Multiply extends Instructions {
	public Multiply(int index1, int index2) {
		throw new AssertionError("Not yet implemented");
	}
}

class JumpIfZero extends Instructions {
	public JumpIfZero(int index, int pcToGo) {
		throw new AssertionError("Not yet implemented");
	}
}

class Jump extends Instructions {
	public Jump(int pcToGo) {
		throw new AssertionError("Not yet implemented");
	}
}

class Halt extends Instructions {
	public Halt() {
		throw new AssertionError("Not yet implemented");
	}
}

class InstructionProgram {
	private InstructionProgram(int[] registers){};
	
	public static void execute(int[] registers, Instructions[] instructions) {
		throw new AssertionError("Not yet implemented");
	}
}

class InstructionProgramTest {
	
	@Test
	void test() {
		int[] registers = new int[32];
		registers[0] = 4; //Base
		registers[1] = 5; //Exponent
		
		Instructions[] instructions = {new LoadConstant(2, 1), new JumpIfZero(1, 5), new Multiply(2, 0), new Decrement(1), new Jump(1), new Halt()};
		
		InstructionProgram.execute(registers, instructions); //Calculate 4 to the power of 5
		assertEquals(1024, registers[2]);
	}

}
