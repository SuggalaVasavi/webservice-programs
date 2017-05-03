package model;
import java.sql.Connection;
import java.util.ArrayList;
import dto.User;
import dao.DbConnection;
import dao.UserDao;
public class SecurityManager {

public ArrayList<User> getAllUsersList()throws Exception {

ArrayList<User> userList = new ArrayList<User>();

try {

DbConnection database= new DbConnection();

Connection connection = database.getConnection();

UserDao userdao= new UserDao();

userList= userdao.getAllUsers(connection);



} catch (Exception e) {

throw e;

}

return userList;

}

}