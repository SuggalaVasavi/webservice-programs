package restlog1;

import java.sql.Connection;
import java.util.ArrayList;
 
import restlog1.User;
 
import restlog1.DbConnection;
 
import restlog1.Handler;
;
public class SecurityManager {
public ArrayList<User> getAllUsersList()throws Exception {
ArrayList<User> userList = null;
try {
DbConnection database= new DbConnection();
Connection connection = database.getConnection();
Handler Handler= new Handler();
userList= Handler.getAllUsers(connection);

} catch (Exception e) {
throw e;
}
return userList;
}
}