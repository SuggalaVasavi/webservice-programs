package restlog1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import restlog1.SecurityManager;
import restlog1.User;
 
@Path("/WebService")
public class Service {
 
@POST
 @Path("/login")
 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
 public String login(@FormParam("username") String username,
 @FormParam("password") String password) {
 
return getAllUsersList(username, password);
 
}
 
public String getAllUsersList(String username,String password)
 {
 String userListData = null;
 try 
 {
 ArrayList<User> userList = null;
 SecurityManager securityManager= new SecurityManager();
 userList = securityManager.getAllUsersList();
 for (User user : userList) {
 if(user.getUsername().equals(username))
 {
 if(user.getPassword().equals(password))
 {
 return "Logged in User:"+username;
 }
 }
 }
 
} catch (Exception e)
 {
 System.out.println("error");
 }
 return "You are not a Valid User";
 }
@POST
@Path("/register")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public String reg(@FormParam("firstname") String firstname,
		@FormParam("lastname") String lastname,
		@FormParam("email") String email,
		@FormParam("username") String username,
		@FormParam("password") String password,
@FormParam("confirmpassword") String confirmpassword){
	String result="false";
	int x=0;
	try 
	 {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		ArrayList<User> userList = null;
		 SecurityManager securityManager= new SecurityManager();
		PreparedStatement ps = connection.prepareStatement("INSERT INTO user(username,password,firstname,email,lastname)VALUES(?,?,?,?,?)");
		ps.setString(1,username);
		ps.setString(2, password);
		ps.setString(3,firstname);
		ps.setString(4,email);
		ps.setString(5,lastname);

		
		
	 userList = securityManager.getAllUsersList();
		 String EMAIL_PATTERN = 
				 "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				 + "+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				 Pattern pattern = Pattern.compile(EMAIL_PATTERN);
if( email == null || email.trim().equals("")&& !pattern.matcher(email).matches()&& username == null || username.trim().equals("")&& firstname == null || firstname.trim().equals("")&& lastname == null || lastname.trim().equals(""))
{
					  
						  System.out.println("please enter valid details");
					  }
					  else{
					   x=ps.executeUpdate();
					   result="Successfully Registered";
					   connection.close();
				 }
				 
	
				 
	} catch (Exception e)
	 {
	 e.printStackTrace();
	 }

	 return result;
}
@PUT
@Path("/register")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public String update(@FormParam("firstname") String firstname,
		@FormParam("lastname") String lastname,
		@FormParam("email") String email,
		@FormParam("username") String username,
		@FormParam("password") String password,
@FormParam("confirmpassword") String confirmpassword){
	String result="false";
	int x=0;
	try 
	 {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		ArrayList<User> userList = null;
		 SecurityManager securityManager= new SecurityManager();
		PreparedStatement ps = connection.prepareStatement("UPDATE user SET username=?,password=?,firstname=?,lastname=? WHERE email=?");
		ps.setString(1,username);
		ps.setString(2, password);
		ps.setString(3,firstname);
		
		ps.setString(4,lastname);
		ps.setString(5,email);
		
		
	 userList = securityManager.getAllUsersList();
	
					  
					   x=ps.executeUpdate();
					   result="Successfully Registered";
					   connection.close();
				 
				 
	
				 
	} catch (Exception e)
	 {
	 e.printStackTrace();
	 }

	 return result;
}
@DELETE
@Path("/delete")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public String delete(
@FormParam("email") String email,
@FormParam("username") String username){
	String result="false";
	 int status=0;
		try{
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		ArrayList<User> userList = null;
		 SecurityManager securityManager= new SecurityManager();

			PreparedStatement ps =connection.prepareStatement("delete from user where email=?");
			
		ps.setString(1,email);
		
		 userList = securityManager.getAllUsersList();
		 
					   status=ps.executeUpdate();
					   result="Successfully Deleted";
					   connection.close();
				 
				 

				 
	} catch (Exception e)
	 {
	 e.printStackTrace();
	 }

	 return result;
	}
}