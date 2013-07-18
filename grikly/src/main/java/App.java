

import java.util.Date;

import com.grikly.Grikly;
import com.grikly.ResponseListener;
import com.grikly.model.Card;
import com.grikly.model.Contact;
import com.grikly.model.LoginModel;
import com.grikly.model.User;


public class App 
{
	public App() 
	{
		String email = "mdennis876@gmail.com";
		String password = "computer";
		Card card = new Card ();
		card.setFirstName("Mario");
		card.setLastName("Dennis");
		card.setEmail("mario_leif2000@yahoo.com");
		
		Contact contact = new Contact();
		contact.setCardId(2);
		contact.setComment("Test");
		contact.setDateMet(new Date());
		contact.setPlaceMet("Jamaica");
		
		Grikly grikly = new Grikly("C049DBE3-C9E6-4176-9984-27C0119DB2D0");
		grikly.addValidUserCredential(email, password);
		//User response = grikly.getUser(1);
		//Card response = grikly.createCard(card);
		//Card response = grikly.getCard(3018);
		//Card response = grikly.deleteCard(3019);
		//System.out.println(response);
		//System.out.println(grikly.getContact("mdennis876@gmail.com", 1));
	}
	
    public static void main( String[] args )
    {
    	new App ();
    }

    
}
