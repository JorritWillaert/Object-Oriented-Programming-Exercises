package instructionprogram.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

abstract class Instructions {
	public abstract int executeInstruction(int[] registers, int pc);
}

class LoadConstant extends Instructions {
	private int index;
	private int constant;
	
	public LoadConstant(int index, int constant) {
		this.index = index;
		this.constant = constant;
	}
	
	public int executeInstruction(int[] registers, int pc) {
		registers[index] = constant;
		return pc + 1;
	}
}

class Decrement extends Instructions {
	private int index;
	
	public Decrement(int index) {
		this.index = index;
	}
	
	public int executeInstruction(int[] registers, int pc) {
		registers[index]--;
		return pc + 1;
	}
}

class Multiply extends Instructions {
	private int index1;
	private int index2;
	
	public Multiply(int index1, int index2) {
		this.index1 = index1;
		this.index2 = index2;
	}
	
	public int executeInstruction(int[] registers, int pc) {
		registers[index1] *= registers[index2];
		return pc + 1;
	}
}

class JumpIfZero extends Instructions {
	private int index;
	private int pcToGo;
	
	public JumpIfZero(int index, int pcToGo) {
		this.index = index;
		this.pcToGo = pcToGo;
	}
	
	public int executeInstruction(int[] registers, int pc) {
		if (registers[index] == 0)
			return pcToGo;
		else
			return pc + 1;
	}
}

class Jump extends Instructions {
	private int pcToGo;
	
	public Jump(int pcToGo) {
		this.pcToGo = pcToGo;
	}
	
	public int executeInstruction(int[] registers, int pc) {
		return pcToGo;
	}
}

class Halt extends Instructions {
	public Halt() {}
	
	public int executeInstruction(int[] registers, int pc) {
		return -1;
	}
}

class InstructionProgram {
	
	private InstructionProgram(){}
	
	public static void execute(int[] registers, Instructions[] instructions) {
		int pc = 0;
		while (pc >= 0)
			pc = instructions[pc].executeInstruction(registers, pc);
	}
}

class InstructionProgramTest {
	
	@Test
	void test() {
		assertEquals(1, 1);
		int[] registers = new int[32];
		registers[0] = 4; //Base
		registers[1] = 5; //Exponent
		
		Instructions[] instructions = new Instructions[] {new LoadConstant(2, 1), new JumpIfZero(1, 5), 
									  new Multiply(2, 0), new Decrement(1), new Jump(1), new Halt()};
		
		InstructionProgram.execute(registers, instructions); //Calculate 4 to the power of 5
		assertEquals(1024, registers[2]);
	}
}
