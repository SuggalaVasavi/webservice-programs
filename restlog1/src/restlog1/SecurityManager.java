package restlog1;

import java.sql.Connection;
import java.util.ArrayList;
 
import restlog1.User;
 
import restlog1.DbConnection;
 
import restlog1.UserDao;
;
public class SecurityManager {
public ArrayList<User> getAllUsersList()throws Exception {
ArrayList<User> userList = new ArrayList<User>();
try {
DbConnection database= new DbConnection();
Connection connection = database.getConnection();
UserDao UserDao= new UserDao();
userList= UserDao.getAllUsers(connection);

} catch (Exception e) {
throw e;
}
return userList;
}
}
