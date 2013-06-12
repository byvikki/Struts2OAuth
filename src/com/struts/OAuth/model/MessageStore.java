package com.struts.OAuth.model;

public class MessageStore {

	/**
	 * Model Class For OAuth
	 */
	
	private String message;
	
	public MessageStore(){
		setMessage("Hello World !@#$");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
