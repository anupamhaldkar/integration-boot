package com.integration.boot.controller;

import com.integration.boot.MessageProducer;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class IntegrationController {

    @Autowired
    MessageProducer messageProducer;

    @PostMapping("/test-integration")
    public ResponseEntity<Object> testIntegrationMessaging(@RequestBody String message) {
        return new ResponseEntity<>(messageProducer.sendMessage(message), HttpStatus.OK);
    }

    @GetMapping("/integration-external-call")
    public ResponseEntity<Object> externalCall(@RequestParam String message) {
        return ResponseEntity.ok(messageProducer.externalCall(message));
    }

    @GetMapping("/asynchronous-call")
    public ResponseEntity<Object> asynchronousCall(@RequestParam String message){
        //notify method is getting executed parallely.
        //make use of debugger to test 
        messageProducer.notify(message);
    
        messageProducer.notificationSaveDB(message);
        
        return ResponseEntity.ok("Parallel execution completed");
    }
}
