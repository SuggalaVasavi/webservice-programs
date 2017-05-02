package restlog1;



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

 

public class DbConnection {
private static DbConnection instance;
private static Connection connection;
	private String url="jdbc:mysql://localhost:3306/form";
private String username="root";
private String password="1234";
DbConnection() throws SQLException{
try

{

Class.forName("com.mysql.jdbc.Driver");

this.connection = DriverManager.getConnection(url,username,password);
}

catch (ClassNotFoundException e)

{

	System.out.println("Databsae connection failed"+e.getMessage());
}
}

public static  Connection getConnection(){
return connection;

}
public static DbConnection getInstance()throws SQLException{
	if(instance == null){
		instance = new DbConnection();
	
	}else 
			if(instance.getConnection().isClosed()){
			instance = new DbConnection();
		}
		return instance;
		}
}
