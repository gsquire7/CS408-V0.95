

import java.util.Random;

public class RandomGen {

	private int x;
	
	public int GenerateNumber(int y)
	{
		Random numberGenerator = new Random();
		x = numberGenerator.nextInt(y);
//		System.out.println("NUMBER GENERATED IS " + x);
		return x;
		
	}
}
