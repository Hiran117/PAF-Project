package com;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.*;
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document;

import com.google.gson.*;

import model.Innovator;

@Path("/Innovator") 
public class InnovatorService {
	
	
	
	 
		private static final int String = 0;
		Innovator innoobj = new Innovator(); 
		
		@GET
		@Path("/Innovator") 
		@Produces (MediaType.TEXT_HTML) 
		public String readInnovator() 
		{ 
			return innoobj.readInnovator();  
		}
		
		//insert operation
		@POST
		@Path("/Innovator") 
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String insertInnovator(@FormParam("id") int id, 
									@FormParam("name") String name, 
									@FormParam("projname") String projname,
									@FormParam("pprice") String pprice, 
									@FormParam("pproject") String pproject)
							
		{ 
			String output = innoobj.insertInnovator(id, name,  projname,  pprice,  pproject); 
			return output; 
		}
		
		
		//update
		@PUT
		@Path("/Innovator") 
		@Consumes(MediaType.APPLICATION_JSON) 
		@Produces(MediaType.TEXT_PLAIN) 
		
		
		public String updateInnovator(String innovatorData) 
		{ 
			//Convert the input string to a JSON object 
			JsonObject innovatorObj = new JsonParser().parse(innovatorData).getAsJsonObject(); 
		
			//Read the values from the JSON object
			int innovatorID = innovatorObj.get("innovatorID").getAsInt(); 
			String innovatorName = innovatorObj.get("innovatorName").getAsString(); 
			String projName = innovatorObj.get("projName").getAsString(); 
			String price = innovatorObj.get("price").getAsString(); 
			String project = innovatorObj.get("project").getAsString(); 
			
			
			String output = innoobj.updateInnovator(innovatorID, innovatorName, projName, price, project); 
			
			return output; 
		}
		
		//delete
		
		@DELETE
		@Path("/") 
		@Consumes(MediaType.APPLICATION_XML) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String deleteInnovator(String innovatorData) 
		{ 
			//Convert the input string to an XML document
			Document doc = Jsoup.parse(innovatorData, "", Parser.xmlParser()); 
		 
			//Read the value from the element <itemID>
			String innovatorID = doc.select("innovatorID").text(); 
			String output = innoobj.deleteInnovator(innovatorID); 
			return output; 
		}


		
				
		
}



