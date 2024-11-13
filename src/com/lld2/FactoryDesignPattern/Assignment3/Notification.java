package com.lld2.FactoryDesignPattern.Assignment3;

public abstract class Notification {

    protected String recipient;
    protected String message;


    Notification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }
    public abstract String getRecipient();
    public abstract String getMessage();
    public abstract void sendNotification();
    public abstract NotificationType notificationType();

}
