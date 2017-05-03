package exception;

import java.sql.SQLException;

public class ApplicationException extends Exception {
	public ApplicationException(String message, Exception e){
		super(message);
		message="Invalid";
	}
}
