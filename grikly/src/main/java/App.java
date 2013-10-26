

import java.util.ArrayList;

import com.grikly.Grikly;
import com.grikly.ResponseListener;
import com.grikly.exception.NotFoundException;
import com.grikly.model.Card;
import com.grikly.model.LoginModel;
import com.grikly.model.User;


public class App 
{
	public App() 
	{
		String email = "mdennis876@gmail.com";
		String password = "computer";
		
		Grikly grikly = new Grikly("C049DBE3-C9E6-4176-9984-27C0119DB2D0");
		grikly.addValidUserCredential(email, password);
		User user = grikly.getValidUser(new LoginModel(email,password));

		System.out.println(grikly.getValidUser(new LoginModel(email,password)));
	}
	
    public static void main( String[] args )
    {
    	new App ();
    }

    
}
