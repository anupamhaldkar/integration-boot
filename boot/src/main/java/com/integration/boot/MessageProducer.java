package com.integration.boot;

import java.util.concurrent.CompletableFuture;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MessageProducer {

    @Gateway(requestChannel = "inputChannel", replyChannel = "outputChannel")
    public String sendMessage(String message);

    @Gateway(requestChannel = "inputExternalChannel", replyChannel = "outputExternalChannel")
    public String externalCall(String payload);

    @Gateway(requestChannel = "notifyChannel")
    public CompletableFuture<String> notify(String message);

    @Gateway(requestChannel = "notifyDBChannel", replyChannel = "notifyDBReplyChannel")
    public CompletableFuture<String> notificationSaveDB(String message);
}
