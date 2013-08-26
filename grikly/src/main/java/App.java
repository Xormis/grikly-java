

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
		Contact contact = new Contact();
		contact.setCardId(2);
		contact.setComment("Test1");
		contact.setDateMet(new Date());
		contact.setPlaceMet("Jamaica");
		
		Grikly grikly = new Grikly("C049DBE3-C9E6-4176-9984-27C0119DB2D0");
		grikly.addValidUserCredential(email, password);
		grikly.fetchCard(2,new ResponseListener<Card>() {
			public void response(Card result) {
				System.out.println(result);
				
			}
		});
		User user = grikly.getValidUser(new LoginModel(email,password));
		System.out.println(user);
		
	}
	
    public static void main( String[] args )
    {
    	new App ();
    }

    
}
