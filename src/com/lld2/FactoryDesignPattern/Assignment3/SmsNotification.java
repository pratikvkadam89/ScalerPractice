package com.lld2.FactoryDesignPattern.Assignment3;

public class SmsNotification extends Notification {


    public SmsNotification(String recipient,  String message) {
        super(recipient, message);
    }

    @Override
    public String getRecipient() {
        return recipient;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void sendNotification() {
        // Logic to send an SMS
        System.out.println("SMS sent to " + recipient);
        System.out.println("Message: " + message);
    }

    public NotificationType notificationType() {
        return NotificationType.SMS;
    }
}
