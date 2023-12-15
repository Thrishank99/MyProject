package com.org.java.designpattern;

public class FactoryNotification {

	public static Notification getNotification(String str){
		if(str.equals("sms")){
		 return new SmsNotification();
		}
		else if(str.equals("mail")){
			return new MailNotification();
		}
		else if(str.equals("whatsup")){
			return new WhatsupNotification();
			
		}
		else{
			
			return new OtherNotification();
		}
		
	}
}
