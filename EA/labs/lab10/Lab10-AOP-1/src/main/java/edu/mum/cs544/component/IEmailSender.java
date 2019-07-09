package edu.mum.cs544.component;

public interface IEmailSender {
	public void sendEmail(String email, String message);
	public String getOutgoingMailServer();
}