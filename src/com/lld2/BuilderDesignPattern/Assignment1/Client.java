package com.lld2.BuilderDesignPattern.Assignment1;

public class Client {

    public static void main(String[] args) {

        MessageBuilder mb = MessageBuilder.getBuilder()
                .setMessageType(MessageType.TEXT)
                .setContent("slkdf")
                .setRecipient("slkdjfd").build();

        System.out.println(mb);
    }
}
