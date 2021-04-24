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

@Path("/Funding")
public class FundingService {
	
		Funders FundObj = new Funders();
		//read
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
	
		//Updation
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		
		public String updateFunder(String funderData) 
		{
			// Convert the input string to a JSON object
			JsonObject fundObject = new JsonParser().parse(funderData).getAsJsonObject();

			// Read the values from the JSON object
			String funderID = fundObject.get("funderID").getAsString();
			String fundAmount = fundObject.get("fundAmount").getAsString();
			String name = fundObject.get("name").getAsString();
			String email = fundObject.get("email").getAsString();
			String cardNumber = fundObject.get("cardNumber").getAsString();
			String fundReqDate = fundObject.get("fundReqDate").getAsString();
			
			String output = FundObj.updateFunder(funderID, fundAmount, name, email, cardNumber, fundReqDate);
			return output;
		}
		

		//Deletion
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteFunder(String funderData) 
		{
			// Convert the input string to an XML document
			Document doc = Jsoup.parse(funderData, "", Parser.xmlParser());

			// Read the value from the element <innovationID>
			String funderID = doc.select("funderID").text();
			String output = FundObj.deleteFunder(funderID);
			return output;
		}
}
