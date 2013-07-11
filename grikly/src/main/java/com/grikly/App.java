package com.grikly;

import com.grikly.model.Card;
import com.grikly.model.User;


public class App 
{
	public App() 
	{
		Grikly grikly = new Grikly("C049DBE3-C9E6-4176-9984-27C0119DB2D0");
		/*grikly.fetchCard(1, new ResponseListener<Card>() {
			
			public void response(Card result) {
				System.out.println(result);
				
			}
		});
		*/
		Card card = new Card();
		card.setFirstName("Mario");
		card.setLastName("Dennis");
		card.setEmail("mdennis876@gmail.com");
		
		grikly.createCard(card, new ResponseListener<Card>() {
			
			public void response(Card result) {
				System.out.println(result);
				
			}
		});
	}
	
    public static void main( String[] args )
    {
    	new App ();
    }

    
}
