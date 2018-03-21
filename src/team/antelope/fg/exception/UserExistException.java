package team.antelope.fg.exception;

public class UserExistException extends Exception {
	public UserExistException(){
		super();
	}
	public UserExistException(String msg){
		super(msg);
	}
}
