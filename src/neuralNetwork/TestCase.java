package neuralNetwork;

import java.util.Arrays;

public class TestCase {
	private byte inputs[];
	private byte output;
	
	public TestCase(byte inputs[], byte output) {
		this.inputs = Arrays.copyOf(inputs, inputs.length);
		this.output = output;
	}

	public byte[] getInputs() {
		return inputs;
	}

	public byte getOutput() {
		return output;
	}
}
