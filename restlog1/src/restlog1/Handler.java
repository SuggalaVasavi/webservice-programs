package restlog1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
import restlog1.User;
import restlog1.DbConnection;
public class Handler {
 
	static DbConnection database= new DbConnection();
	static Connection connection=database.getConnection();
public static int reg(User user){
	int status=0;
	try{
	

		PreparedStatement ps =connection.prepareStatement("INSERT INTO user(username,password,firstname,email,lastname)VALUES(?,?,?,?,?)");
		ps.setString(1,user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3,user.getFirstname());
		ps.setString(4,user.getEmail());
		ps.setString(5, user.getLastname());
	status=ps.executeUpdate();
	}catch(Exception e)
	{
		System.out.println(e);
	}
	return status;
}
public static int update(User user){
	int status=0;
	try{
	
		PreparedStatement ps =connection.prepareStatement("UPDATE user SET username=?,password=?,firstname=?,lastname=? WHERE email=?");
		ps.setString(1,user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3,user.getFirstname());
		ps.setString(4,user.getEmail());
		ps.setString(5, user.getLastname());
	status=ps.executeUpdate();
	}catch(Exception e)
	{
		System.out.println(e);
	}
	return status;
}
public static int delete(User user){
	int status=0;
	try{
	
		PreparedStatement ps =connection.prepareStatement("delete from user where email=?");
		
		ps.setString(1,user.getEmail());
		ps.setString(2, user.getLastname());
	status=ps.executeUpdate();
	}catch(Exception e)
	{
		System.out.println(e);
	}
	return status;
}
public ArrayList<User> getAllUsers(Connection connection){
ArrayList<User> userList = new ArrayList<User>();

try {
// String uname = request.getParameter("uname");
PreparedStatement ps = connection
.prepareStatement("SELECT * FROM user");
// ps.setString(1,uname);
ResultSet rs = ps.executeQuery();
while (rs.next()) {
User user = new User();
user.setUsername(rs.getString("username"));
user.setPassword(rs.getString("password"));
userList.add(user);
}
} catch (Exception e) {
System.out.println(e);
}
return userList;
}
 
}