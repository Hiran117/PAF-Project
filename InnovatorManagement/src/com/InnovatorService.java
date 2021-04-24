package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Innovator;

//create path 
@Path("/inn") 




public class InnovatorService {
	
	
	
	 
	private static final int String = 0;
	Innovator innoobj = new Innovator(); 
	
	@GET
	@Path("/") 
	@Produces (MediaType.TEXT_HTML) 
	public String readInnovator() 
	{ 
		return innoobj.readInnovator();  
	}
	
	//insert operation
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertInovator( 
								@FormParam("innovatorName") String innovatorName, 
								@FormParam("projName") String projname,
								@FormParam("price") String price, 
								@FormParam("project") String project)
						
	{ 
		String output = innoobj.insertInnovator(innovatorName, projname,  price,  project); 
		return output; 
	}
	
	
	//update
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	
	
	public String updateInnovator(String innovatorData) 
	{ 
		//Convert the input string to a JSON object 
		JsonObject innovatorObj = new JsonParser().parse(innovatorData).getAsJsonObject(); 
	
		//Read the values from the JSON object
		String innovatorID = innovatorObj.get("innovatorID").getAsString(); 
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



