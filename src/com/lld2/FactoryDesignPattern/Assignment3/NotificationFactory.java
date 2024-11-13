package com.lld2.FactoryDesignPattern.Assignment3;

public class NotificationFactory {

    public static Notification createNotification(NotificationType notificationType, String message, String recipient, String sender) {

        switch (notificationType) {
            case EMAIL:
                return new EmailNotification(recipient, sender, message);
            case SMS:
                return new SmsNotification(recipient, message);
            case PUSH:
                return new PushNotification(recipient, message);
            default:
                return null;
        }


    }
}
