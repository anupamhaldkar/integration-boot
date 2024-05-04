package com.integration.boot.transform;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.integration.boot.RequestDTO;

@Component("transformer")
public class Transform {
    
    public Message<RequestDTO> transformToSecondCall(Message<String> message){
        
        RequestDTO dto = new RequestDTO();
        dto.setMessage(message.getPayload());
        
        return MessageBuilder.withPayload(dto).copyHeaders(message.getHeaders()).build();
    } 
}
