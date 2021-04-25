package com;

import model.Payment;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 

//For JSON
import com.google.gson.*; 

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 


@Path("/payment_details")
public class PaymentService {

	Payment paymentObj = new Payment(); 
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	
	public String readpayment_details() 
	 { 
		return paymentObj.readpayment_details();
	 }
	//Insertion
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		
		public String insertPayment_details(@FormParam("name") String name, @FormParam("address") String address, @FormParam("email") String email, @FormParam("contact_number") String contact_number, @FormParam("card_name") String card_name, @FormParam("card_number") String card_number, @FormParam("expiry_date") String expiry_date, @FormParam("cvc_number") String cvc_number)
		{
			String output = paymentObj.insertPayment_details(name, address, email, contact_number, card_name, card_number, expiry_date, cvc_number);
			return output;
		}

		//Updation
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		
		public String updatePayment_details(String paymentData) 
		{		
			
	// Convert the input string to a JSON object
		JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject();
		
	// Read the values from the JSON object
		String payment_ID = paymentObject.get("payment_ID").getAsString();
		String name = paymentObject.get("name").getAsString();
		String address = paymentObject.get("address").getAsString();
		String email = paymentObject.get("email").getAsString();
		String contact_number = paymentObject.get("contact_number").getAsString();
		String card_name = paymentObject.get("card_name").getAsString();
		String card_number = paymentObject.get("card_number").getAsString();
		String expiry_date = paymentObject.get("expiry_date").getAsString();
		String cvc_number = paymentObject.get("cvc_number").getAsString();
		
		String output = paymentObj.updatePayment_details(payment_ID, name, address, email, contact_number, card_name, card_number, expiry_date, cvc_number);
		return output;
	}
		//Deletion
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deletePayment_details(String paymentData) 
		
		{
			// Convert the input string to an XML document
			Document doc = Jsoup.parse(paymentData, "", Parser.xmlParser());
			

			// Read the value from the element <payment_ID>
			String payment_ID = doc.select("payment_ID").text();
			String output = paymentObj.deletePayment_details(payment_ID);
			return output;
		}
		
	}

		
