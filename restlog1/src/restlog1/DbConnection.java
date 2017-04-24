package restlog1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DbConnection {

 
public Connection getConnection()
{
		Connection connection=null;	
try
{
String connectionURL = "jdbc:mysql://localhost:3306/form";
Class.forName("com.mysql.jdbc.Driver").newInstance();
connection = DriverManager.getConnection(connectionURL, "root", "1234");

}
catch (Exception e)
{
	System.out.println(e);
e.printStackTrace();
}

return connection;
}
}

