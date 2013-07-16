

import com.grikly.Grikly;
import com.grikly.ResponseListener;
import com.grikly.model.Card;
import com.grikly.model.LoginModel;
import com.grikly.model.User;


public class App 
{
	public App() 
	{
		Card card = new Card ();
		card.setFirstName("Mario");
		card.setLastName("Dennis");
		card.setEmail("mario_leif2000@yahoo.com");
		
		Grikly grikly = new Grikly("C049DBE3-C9E6-4176-9984-27C0119DB2D0");
		grikly.addValidUserCredential("mdennis876@gmail.com", "computer");
	
	}
	
    public static void main( String[] args )
    {
    	new App ();
    }

    
}
