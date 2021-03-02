package instructionprogram.tests;

abstract class Instructions {
	abstract void executeInstruction(InstructionProgram program);
}

class LoadConstant extends Instructions {
	private int index;
	private int constant;
	
	LoadConstant(int index, int constant) {
		this.index = index;
		this.constant = constant;
	}
	
	void executeInstruction(InstructionProgram program) {
		program.registers[index] = constant;
		program.pc++;
	}
}

class Decrement extends Instructions {
	private int index;
	
	Decrement(int index) {
		this.index = index;
	}
	
	void executeInstruction(InstructionProgram program) {
		program.registers[index]--;
		program.pc++;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Decrement))
			return false;
		Decrement otherDi = (Decrement) other;
		return otherDi.index == index;
	}
	
	@Override
	public String toString() {
		return "Decrement(" + index + ")";
	}
}

class Multiply extends Instructions {
	private int index1;
	private int index2;
	
	Multiply(int index1, int index2) {
		this.index1 = index1;
		this.index2 = index2;
	}
	
	void executeInstruction(InstructionProgram program) {
		program.registers[index1] *= program.registers[index2];
		program.pc++;
	}
}

class JumpIfZero extends Instructions {
	int index;
	int pcToGo;
	
	JumpIfZero(int index, int pcToGo) {
		this.index = index;
		this.pcToGo = pcToGo;
	}
	
	public void executeInstruction(InstructionProgram program) {
		if (program.registers[index] == 0)
			program.pc = pcToGo;
		else
			program.pc++;
	}
}

class Jump extends Instructions {
	int pcToGo;
	
	Jump(int pcToGo) {
		this.pcToGo = pcToGo;
	}
	
	void executeInstruction(InstructionProgram program) {
		program.pc = pcToGo;
	}
}

class Halt extends Instructions {
	public Halt() {}
	
	void executeInstruction(InstructionProgram program) {
		program.stop = true;
	}
	
	@Override
	public boolean equals(Object other) { //Override the 'equals' method of Object
		return other instanceof Halt;
	}
}

class InstructionProgram {
	boolean stop;
	int pc;
	int[] registers;
	Instructions[] instructions;
	
	private InstructionProgram(int[] registers, Instructions[] instructions){
		this.registers = registers;
		this.instructions = instructions;
	}
	
	void run() {
		while (!stop) {
			Instructions instruction = instructions[pc];
			instruction.executeInstruction(this);
		}
	}
	
	public static void execute(int[] registers, Instructions[] instructions) {
		new InstructionProgram(registers, instructions).run();
	}
}
