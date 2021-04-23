package com;

import model.Funders;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Funders")
public class FundingService {
	
		Funders FundObj = new Funders();
		
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String readFunders()
		{
		return FundObj.readFunders();
		}
		
		//Insertion
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		
		public String insertFunder(@FormParam("fundAmount") String fundAmount, @FormParam("name") String name, @FormParam("email") String email, @FormParam("cardNumber") String cardNumber, @FormParam("fundReqDate") String fundReqDate)
		{
			String output = FundObj.insertFunder(fundAmount, name, email, cardNumber, fundReqDate);
			return output;
		}
	
}
