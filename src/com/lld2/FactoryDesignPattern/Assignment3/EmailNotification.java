package com.lld2.FactoryDesignPattern.Assignment3;

public class EmailNotification extends Notification {

    private String sender;
    public EmailNotification(String recipient, String sender, String message) {
        super(recipient, message);
        this.sender = sender;
    }

    @Override
    public String getRecipient() {
        return recipient;
    }

    public String getSender() {
        return sender;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void sendNotification() {
        // Logic to send an email
        System.out.println("Email sent to " + recipient + " from " + sender);
        System.out.println("Message: " + message);
    }

    @Override
    public NotificationType notificationType() {
        return NotificationType.EMAIL;
    }
}
