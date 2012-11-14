package net.clearwaterproject.app.users;

public final class UserServiceFactory {
	
	private UserServiceFactory(){}
	
	public static UserService getUserService(){
		return new UserService();
	}

}
