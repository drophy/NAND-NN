package neuralNetwork;

import java.util.Arrays;

public class Network {
	private byte inputs[];
	private double weights[];
	private byte output;
	private final static double THRESHOLD = 0.5;
	private final static double LEARNING_RATE = 0.1;
	
	public Network(int inputQuantity) {
		inputs = new byte[inputQuantity];
		weights = new double[inputQuantity];
		Arrays.fill(weights, 0.0);
	}
	
	public byte evaluate(byte[] inputs) {
		// Enter inputs
		this.inputs = Arrays.copyOf(inputs, inputs.length);
		
		// Calculate output
		double dotproduct = 0;
		for(int i = 0; i < inputs.length; i++) {
			dotproduct += (inputs[i]*weights[i]);
		}
		System.out.println("i.w: " + dotproduct);
		output = dotproduct > Network.THRESHOLD? (byte)1 : (byte)0;
		
		System.out.println("output: " + output + "\n");
		return output;
	}
	
	public byte train(TestCase t) {
		// Enter inputs
		inputs = Arrays.copyOf(t.getInputs(), t.getInputs().length);
		
		// Calculate output
		double dotproduct = 0;
		for(int i = 0; i < inputs.length; i++) {
			dotproduct += (inputs[i]*weights[i]);
		}
		System.out.println("i.w: " + dotproduct);
		output = dotproduct > Network.THRESHOLD? (byte)1 : (byte)0;
		
		// See how wrong we are >w<
		double error = t.getOutput() - output;
		double correction = error*Network.LEARNING_RATE;
		
		// Tweak the weights
		for(int i = 0; i < inputs.length; i++) {
			weights[i] += (inputs[i]*correction);
		}
		System.out.println("weights: " + weights[0]+","+weights[1]+","+weights[2]);
		
		System.out.println("output: " + output + "\n");
		return output;
	}
	
	public String toString() {
		return "nvm";
	}
}
