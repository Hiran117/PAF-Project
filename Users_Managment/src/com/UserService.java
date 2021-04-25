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

@Path("/User")
public class UserService {

	Users UsersObj = new Users();
	//read users
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	
	public String readUsers()
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
	
	//Updation
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String updateUser(String UserData) 
	{
		// Convert the input string to a JSON object
		JsonObject fundObject = new JsonParser().parse(UserData).getAsJsonObject();

		// Read the values from the JSON object
		String userID = fundObject.get("userID").getAsString();
		String name = fundObject.get("name").getAsString();
		String email = fundObject.get("email").getAsString();
		String userType = fundObject.get("userType").getAsString();
		String pw = fundObject.get("pw").getAsString();
		
		String output = UsersObj.updateUser(userID, name, email, userType, pw);
		return output;
	}
	
	//Deletion
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUSer(String UserData) 
	{
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(UserData, "", Parser.xmlParser());

		// Read the value from the element <innovationID>
		String userID = doc.select("userID").text();
		String output = UsersObj.deleteUser(userID);
		return output;
	}
	
}
