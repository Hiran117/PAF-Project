package com;
import model.Users;

//For REST Service
	import javax.ws.rs.*;
	import javax.ws.rs.core.MediaType;

	//For JSON
	import com.google.gson.*;

	//For XML
	import org.jsoup.*;
	import org.jsoup.parser.*;
	import org.jsoup.nodes.Document;

@Path("/Users")
public class UserService {

	Users UsersObj = new Users();
	//read
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readFunders()
	{
	return UsersObj.readUsers();
	}
	
	
}
