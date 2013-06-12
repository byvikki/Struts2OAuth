package com.struts.OAuth.Action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.OAuth.model.*;

import com.struts.OAuth.AcessToken.*;

public class HelloWorldAction extends ActionSupport {

	/**
	 * Hello World Action Class
	 */
	private static final long serialVersionUID = 4998184821896955861L;
	
	private MessageStore messageStore;
	
	private String code;

	public String execute() throws Exception{
		messageStore = new MessageStore();		
		this.code =  ServletActionContext.getRequest().getParameter("code");
		String login_with = ServletActionContext.getRequest().getParameter("with");
		if(login_with.equals("google")){
			this.code = GoogleAcess.readFromUrl("https://accounts.google.com/o/oauth2/token", this.code);
		}
		else if(login_with.equals("fb")){
			this.code = fbAccess.readFromUrl("https://graph.facebook.com/oauth/access_token", this.code);
			
			this.code = fbAccess.getUserInfo("https://graph.facebook.com/me",this.code);
		}
		
		return SUCCESS;
	}
	
	public MessageStore getMessageStore() {
		return messageStore;
	}

	public void setMessageStore(MessageStore messageStore) {
		this.messageStore = messageStore;
	}
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		//this.code = code;
	}
	
	
	
	
	
}
