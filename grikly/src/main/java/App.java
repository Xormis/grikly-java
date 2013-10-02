

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.grikly.Grikly;
import com.grikly.ResponseListener;
import com.grikly.model.Card;
import com.grikly.model.Contact;
import com.grikly.model.LoginModel;
import com.grikly.model.NewUser;
import com.grikly.model.User;


public class App 
{
	public App() 
	{
		String email = "mario@xormis.com";
		String password = "1234";
	
		Contact contact = new Contact();
		contact.setCardId(2);
		contact.setComment("Test1");
		contact.setDateMet(new Date());
		contact.setPlaceMet("Jamaica");
		
		final Grikly grikly = new Grikly("C049DBE3-C9E6-4176-9984-27C0119DB2D0");
		grikly.addValidUserCredential(email, password);
		/*
		Card card = new Card();
		card.setEmail("mario@xormis.com");
		card.setFirstName("Mario");
		card.setLastName("Dennis");
		card.setUserId(11063);/*
		grikly.createCard(card, new ResponseListener<Card>() {
			public void response(Card result) {
				// TODO Auto-generated method stub
				System.out.println(result);
			}
		});
	
		
		NewUser newUser = new NewUser();
		newUser.setFirstName("Mario");
		newUser.setLastName("Dennis");
		newUser.setPassword("1234");
		newUser.setEmail("mario@xormis.com");
		grikly.register(newUser,new ResponseListener<User>() {
			public void response(User result) {
				System.out.println(result);
				
			}
		});
		
		grikly.setUserDefaultCard(11063, 10057, new ResponseListener<Card>() {
			public void response(Card result) {
				System.out.println(result);
				
			}
		});*/
		System.out.println(grikly.getUser(11063));
		//System.out.println(grikly.getValidUser(new LoginModel("mdennis876@gmail.com", "computer")));
	}
	
    public static void main( String[] args )
    {
    	new App ();
    }

    
}
