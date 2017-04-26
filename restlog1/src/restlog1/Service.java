package restlog1;

import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import restlog1.SecurityManager;
import restlog1.User;
 
@Path("/WebService")
public class Service {
 
@POST
 @Path("/login")
//@Produces(MediaType.APPLICATION_JSON)
 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
 public String login(@FormParam("username") String username,
 @FormParam("password") String password) {
 
return getAllUsersList(username, password);
 
}
 
public String getAllUsersList(String username,String password)
 {
 String userListData = null;
 ArrayList<User> userList = new ArrayList<User>();
 try 
 {
 
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
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public String reg(@FormParam("firstname") String firstname,
		@FormParam("lastname") String lastname,
		@FormParam("email") String email,
		@FormParam("username") String username,
		@FormParam("password") String password,
@FormParam("confirmpassword") String confirmpassword) throws ApplicationException{
	 User user = new User(username, password,firstname,lastname,email);
     int result = UserDao.reg(user);
     String users=null;
     ArrayList<User> userList = new ArrayList<User>();
     try
 {
	 SecurityManager securityManager= new SecurityManager();
	 userList = securityManager.getAllUsersList();
	 
	// for (User user1 : userList) {
		 String EMAIL_PATTERN = 
				 "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				 + "+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				 Pattern pattern = Pattern.compile(EMAIL_PATTERN);
if( user.getEmail() == null || user.getEmail().trim().equals("")&& !pattern.matcher(email).matches()&& user.getUsername() == null || user.getUsername().trim().equals("")&& user.getFirstname() == null || user.getFirstname().trim().equals("")&& user.getLastname() == null || user.getLastname().trim().equals(""))
{
					  
						  System.out.println("please enter valid details");
					  }
else{
	userList.add(user);
	Gson gson =new Gson();
	 users =gson.toJson(user);
}
	 
	 }
	 catch (Exception e)
	 {
	 System.out.println("error");
	 }
     if(result != 1){
         return "Invalid Details";
      }
      return "successfully Registered values"+users;
    
}
	 
@PUT
@Path("/update")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public String update(@FormParam("firstname") String firstname,
		@FormParam("lastname") String lastname,
		@FormParam("email") String email,
		@FormParam("username") String username,
		@FormParam("password") String password,
@FormParam("confirmpassword") String confirmpassword){
	 User user = new User(username, password,firstname,lastname,email);
     int result = UserDao.update(user);
     String users=null;
     ArrayList<User> userList = new ArrayList<User>();
     try 
	 {
	 
	 SecurityManager securityManager= new SecurityManager();
	 userList = securityManager.getAllUsersList();
	// for (User user2 : userList) {
		 String EMAIL_PATTERN = 
				 "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				 + "+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				 Pattern pattern = Pattern.compile(EMAIL_PATTERN);
if( user.getEmail() == null || user.getEmail().trim().equals("")&& !pattern.matcher(email).matches())
{
	System.out.println("please enter valid email");
		 
}
else{
	if(user.getEmail().equals(email))	{			  
		userList.add(user);
		Gson gson =new Gson();
		 users =gson.toJson(user);
	  }
	

}
	 
	 }
	 catch (Exception e)
	 {
	 System.out.println("error");
	 }
	 
     if(result != 1){
        return "Invalid";
     }
     return "successfully updated values"+users;
}
@DELETE
@Path("/delete")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public String delete(
		@FormParam("firstname") String firstname,
		@FormParam("lastname") String lastname,
		@FormParam("email") String email,
		@FormParam("username") String username,
		@FormParam("password") String password,
@FormParam("confirmpassword") String confirmpassword){
	 User user = new User(username, password,firstname,lastname,email);
     int result= UserDao.delete(user);
     String users=null;
     ArrayList<User> userList = new ArrayList<User>();
     try 
	 {
	 
	 SecurityManager securityManager= new SecurityManager();
	 userList = securityManager.getAllUsersList();
	 
	 //for (User user3 : userList) {
		 String EMAIL_PATTERN = 
				 "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				 + "+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				 Pattern pattern = Pattern.compile(EMAIL_PATTERN);
if( user.getEmail() == null || user.getEmail().trim().equals("")&& !pattern.matcher(email).matches())
{
	System.out.println("please enter valid email");
		 
}
else{
	if(user.getEmail().equals(email))	{			  
		userList.add(user);
		Gson gson =new Gson();
		 users =gson.toJson(user);
	  }
	

}
	 
	 }
	 catch (Exception e)
	 {
	 System.out.println("error");
	 }
	 if(result != 1){
        return "Invalid email";
     }
     return "Successfully Deleted "+users;
}
}
				 
