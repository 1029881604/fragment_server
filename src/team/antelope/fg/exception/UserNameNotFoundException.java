package team.antelope.fg.exception;

public class UserNameNotFoundException extends Exception {
	public UserNameNotFoundException(){
		super();
	}
	public UserNameNotFoundException(String msg){
		super(msg);
	}
}
