package instructionprogram.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

abstract class Instructions {
	public abstract void executeInstruction();
}

class LoadConstant extends Instructions {
	private int index;
	private int constant;
	
	public LoadConstant(int index, int constant) {
		this.index = index;
		this.constant = constant;
	}
	
	public void executeInstruction() {
		throw new AssertionError("Not yet implemented");
	}
}

class Decrement extends Instructions {
	private int index;
	
	public Decrement(int index) {
		this.index = index;
	}
	
	public void executeInstruction() {
		throw new AssertionError("Not yet implemented");
	}
}

class Multiply extends Instructions {
	private int index1;
	private int index2;
	
	public Multiply(int index1, int index2) {
		this.index1 = index1;
		this.index2 = index2;
	}
	
	public void executeInstruction() {
		throw new AssertionError("Not yet implemented");
	}
}

class JumpIfZero extends Instructions {
	private int index;
	private int pcToGo;
	
	public JumpIfZero(int index, int pcToGo) {
		this.index = index;
		this.pcToGo = pcToGo;
	}
	
	public void executeInstruction() {
		throw new AssertionError("Not yet implemented");
	}
}

class Jump extends Instructions {
	private int pcToGo;
	
	public Jump(int pcToGo) {
		this.pcToGo = pcToGo;
	}
	
	public void executeInstruction() {
		throw new AssertionError("Not yet implemented");
	}
}

class Halt extends Instructions {
	public Halt() {}
	
	public void executeInstruction() {
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
