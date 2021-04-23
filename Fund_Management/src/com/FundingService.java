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
		
		
	
}
