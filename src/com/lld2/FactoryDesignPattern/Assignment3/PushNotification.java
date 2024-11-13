package com.lld2.FactoryDesignPattern.Assignment3;

public class PushNotification extends Notification {

    public PushNotification(String recipient, String message) {
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
        // Logic to send a push notification
        System.out.println("Push notification sent to device " + recipient);
        System.out.println("Message: " + message);
    }

    @Override
    public NotificationType notificationType() {
        return NotificationType.PUSH;
    }
}
