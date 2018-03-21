package team.antelope.fg.exception;

public class UserPasswordErrorException extends Exception {
	public UserPasswordErrorException(){
		super();
	}
	public UserPasswordErrorException(String msg){
		super(msg);
	}
}
