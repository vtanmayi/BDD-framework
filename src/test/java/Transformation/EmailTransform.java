package Transformation;

import cucumber.api.Transformer;

public class EmailTransform extends Transformer<String>{
	
	@Override	
	public String transform(String email)
	{
		return email.concat("@gajdzio.com");
	}
	
	
	

}
