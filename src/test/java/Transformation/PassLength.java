package Transformation;

import cucumber.api.Transformer;

public class PassLength extends Transformer<Integer>{
	
	int test=6;
	
	@Override
	public Integer transform(String pass)
	{
		if (pass.length() == test)
		{
		System.out.print("Correct number ");
			return 6;
		}else
		{
			System.out.print("INcorrect number ");
			return 0;
		}
		
	}

}
