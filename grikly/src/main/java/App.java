
import java.io.File;

import com.grikly.Grikly;
import com.grikly.exception.GriklyException;
import com.grikly.model.AccessToken;
import com.grikly.model.NewUser;
import com.grikly.model.UserCredential;

public class App 
{
	public App()
	{
		String email = "mario@xormis.com";
		String password = "computer876";
		String apiKey = "c049dbe3-c9e6-4176-9984-27c0119db2d0";
		
		UserCredential userCredential = new UserCredential();
		userCredential.setEmail(email);
		userCredential.setPassword(password);
		try {
			AccessToken accessToken = Grikly.getAccessToken(apiKey, userCredential);
			Grikly grikly = new Grikly(apiKey);
			

			grikly.setAccessToken(accessToken);
			//File file = new File("/home/mario/Pictures/assassins_creed_3_connor_ice_wallpaper_by_h_thomson-d54pr9l.jpg");
			//grikly.uploadProfileImage(file);
			System.out.println(grikly.getUserInfo(userCredential));
			//System.out.println(grikly.register(user));
		} catch (GriklyException e) {
			e.printStackTrace();
		}
		
		
	}
	
    public static void main( String[] args ) 
    {
    	new App ();
    }

    
}
