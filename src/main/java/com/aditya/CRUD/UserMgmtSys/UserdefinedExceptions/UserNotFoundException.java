package com.aditya.CRUD.UserMgmtSys.UserdefinedExceptions;


public class UserNotFoundException extends Exception {


	public UserNotFoundException(String message) {
		
		//super is used to invoke parent class constructor.
		super(message);
	}

	
}
