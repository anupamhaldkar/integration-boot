package com.integration.boot;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MessageProducer {

    @Gateway(requestChannel = "inputChannel", replyChannel = "outputChannel")
    public String sendMessage(String message);
}
