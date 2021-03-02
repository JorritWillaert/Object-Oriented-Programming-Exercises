package instructionprogram.tests;

abstract class Instructions {}

class LoadConstant extends Instructions {
	int index;
	int constant;
	
	LoadConstant(int index, int constant) {
		this.index = index;
		this.constant = constant;
	}
}

class Decrement extends Instructions {
	int index;
	
	Decrement(int index) {
		this.index = index;
	}
}

class Multiply extends Instructions {
	int index1;
	int index2;
	
	Multiply(int index1, int index2) {
		this.index1 = index1;
		this.index2 = index2;
	}
}

class JumpIfZero extends Instructions {
	int index;
	int pcToGo;
	
	JumpIfZero(int index, int pcToGo) {
		this.index = index;
		this.pcToGo = pcToGo;
	}
}

class Jump extends Instructions {
	int pcToGo;
	
	Jump(int pcToGo) {
		this.pcToGo = pcToGo;
	}
}

class Halt extends Instructions {
	Halt() {}
}

class InstructionProgram {
	
	private InstructionProgram(){}
	
	static void execute(int[] registers, Instructions[] instructions) {
		int pc = 0;
		while (pc >= 0) {
			Instructions instruction = instructions[pc];
			if (instruction instanceof LoadConstant) {
				LoadConstant lci = (LoadConstant) instruction;
				registers[lci.index] = lci.constant;
				pc++;
			} else if (instruction instanceof Decrement) {
				Decrement di = (Decrement) instruction;
				registers[di.index]--;
				pc++;
			} else if (instruction instanceof Multiply) {
				Multiply mi = (Multiply) instruction;
				registers[mi.index1] *= registers[mi.index2];
				pc++;
			} else if (instruction instanceof JumpIfZero) {
				JumpIfZero jiz = (JumpIfZero) instruction;
				if (registers[jiz.index] == 0)
					pc = jiz.pcToGo;
				else
					pc++;
			} else if (instruction instanceof Jump) {
				Jump ji = (Jump) instruction;
				pc = ji.pcToGo;
			} else if (instruction instanceof Halt)
				break;
			else 
				throw new AssertionError();
		}
	}
}