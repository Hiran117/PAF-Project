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
		Innovator innovatorObj = new Innovator(); 
		
		@GET
		@Path("/Innovator") 
		@Produces (MediaType.TEXT_HTML) 
		public String readInnovator() 
		{ 
			return innovatorObj.readInnovator();  
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
			String output = innovatorObj.insertInnovator(id, name,  projname,  pprice,  pproject); 
			return output; 
		}
		
		
		
				
		
}



