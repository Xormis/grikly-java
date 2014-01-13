import com.grikly.AccessTokenManager;
import com.grikly.Grikly;
import com.grikly.model.AccessToken;
import com.grikly.model.UserCredential;



public class App 
{
	public App() 
	{
		String email = "shawn@xormis.com";
		String password = "usertest";
		
		Grikly grikly = new Grikly("C049DBE3-C9E6-4176-9984-27C0119DB2D0");
		grikly.addValidUserCredential(email, password);
		System.out.println(grikly.getUser(1));
	}
	
    public static void main( String[] args )
    {
    	new App ();
    }

    
}
