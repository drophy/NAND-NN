package neuralNetwork;

public class TestZone {

	public static void main(String[] args) {
		// Objects to test it with
		TestCase[] epoch = new TestCase[8];
		epoch[0] = new TestCase(new byte[]{1, 0, 0}, (byte) 1);
		epoch[1] = new TestCase(new byte[]{1, 0, 1}, (byte) 1);
		epoch[2] = new TestCase(new byte[]{1, 1, 0}, (byte) 1);
		epoch[3] = new TestCase(new byte[]{1, 1, 1}, (byte) 0);
//		epoch[4] = new TestCase(new byte[]{0, 0, 0}, (byte) 1);
//		epoch[5] = new TestCase(new byte[]{0, 0, 1}, (byte) 1);
//		epoch[6] = new TestCase(new byte[]{0, 1, 0}, (byte) 1);
//		epoch[7] = new TestCase(new byte[]{0, 1, 1}, (byte) 1);
		
		// We create the network
		Network NAND = new Network(3);
		
		// And teach it stuff
		boolean error = true;
		int counter = 0; 
		while(error && counter < 10_000) {
			error = false;
			for(TestCase t : epoch) {
				counter++;
				if(t.getOutput() - NAND.train(t) != 0) {
					error = true;
					System.out.println("WRONG! D:");
				}
			}
		}
		
		System.out.println("Counter: " + counter);
	}

}
