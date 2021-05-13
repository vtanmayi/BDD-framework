package Transformation;

import cucumber.api.Transformer;

public class CorrectCredentials extends Transformer<Boolean>{

	String login = "mngr312054";
	String password = "yjabYvA";
	

	@Override
	public Boolean transform(String _password)
	{
		if ((password.equals(_password)))
		{
		System.out.print("Correct Credentials ");
			return true;
		}else
		{
			System.out.print("INcorrect Credentials - try again next time");
			return false;
		}
		
	}

	
	
	
	
}
