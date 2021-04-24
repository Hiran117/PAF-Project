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
	
	//Insertion
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String insertUser(@FormParam("name") String name, @FormParam("email") String email, @FormParam("userType") String userType, @FormParam("pw") String pw)
	{
		String output = UsersObj.insertUser(name, email, userType, pw);
		return output;
	}
	
}
