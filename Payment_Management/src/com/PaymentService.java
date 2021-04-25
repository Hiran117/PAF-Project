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