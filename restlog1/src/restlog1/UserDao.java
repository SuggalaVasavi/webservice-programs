package restlog1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Pattern;
import restlog1.DbUtil;
import restlog1.User;
import restlog1.DbConnection;
import restlog1.ApplicationException;
public class UserDao {
 private static Connection connection;
	/*static DbConnection database= new DbConnection();
	static Connection connection=database.getConnection();*/
 public UserDao(){}
public static  int reg(User user)throws ApplicationException{
	ArrayList<User> userList = new ArrayList<User>();
	int status=0;
	try{
	
		connection=DbConnection.getConnection();
		PreparedStatement ps =connection.prepareStatement("INSERT INTO user(username,password,firstname,email,lastname)VALUES(?,?,?,?,?)");
		ps.setString(1,user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3,user.getFirstname());
		ps.setString(4,user.getEmail());
		ps.setString(5, user.getLastname());
	status=ps.executeUpdate();
	SQLWarning warning =ps.getWarnings();
	if(warning != null)
		throw new ApplicationException(warning.getMessage(), warning);
	}catch(SQLException e)
	{
		ApplicationException exception = new ApplicationException(e.getMessage(),e);
		throw exception;
	}
	finally{
		DbUtil.close(connection);
	}
	return status;
}
public static int update(User user){
	ArrayList<User> userList = new ArrayList<User>();
	int status=0;
	try{
	connection=DbConnection.getConnection();
		PreparedStatement ps =connection.prepareStatement("UPDATE user SET username=?,password=?,firstname=?,lastname=? WHERE email=?");
		ps.setString(1,user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3,user.getFirstname());
		ps.setString(4, user.getLastname());
		ps.setString(5,user.getEmail());
	status=ps.executeUpdate();
		SQLWarning warning =ps.getWarnings();
	if(warning != null)
		throw new ApplicationException(warning.getMessage(), warning);
	}catch(SQLException e)
	{
		ApplicationException exception = new ApplicationException(e.getMessage(),e);
		throw exception;
	}
	finally{
		DbUtil.close(connection);
	}
	return status;
}
public static int delete(User user){
	ArrayList<User> userList = new ArrayList<User>();
	int status=0;
	try{
	connection=DbConnection.getConnection();
		PreparedStatement ps =connection.prepareStatement("delete from user where email=?");
		
		ps.setString(1,user.getEmail());
	
	status=ps.executeUpdate();
	SQLWarning warning =ps.getWarnings();
	if(warning != null)
		throw new ApplicationException(warning.getMessage(), warning);
	}catch(SQLException e)
	{
		ApplicationException exception = new ApplicationException(e.getMessage(),e);
		throw exception;
	}
	finally{
		DbUtil.close(connection);
	}
	return status;
}
public ArrayList<User> getAllUsers(Connection connection){
ArrayList<User> userList = new ArrayList<User>();

try {
connection=DbConnection.getConnection();
PreparedStatement ps = connection.prepareStatement("SELECT * FROM user");

ResultSet rs = ps.executeQuery();
while (rs.next()) {
User user = new User();
user.setUsername(rs.getString("username"));
user.setPassword(rs.getString("password"));
userList.add(user);
}
} catch (SQLException e) {
System.out.println(e);
}
return userList;
}
 
}
