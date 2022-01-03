package com.dhia.springsocialmediaapi.controllers;

import com.dhia.springsocialmediaapi.domain.Message;
import com.dhia.springsocialmediaapi.domain.User;
import com.dhia.springsocialmediaapi.exceptions.ResourceNotFoundException;
import com.dhia.springsocialmediaapi.payload.SendMessageRequest;
import com.dhia.springsocialmediaapi.repositories.MessageRepository;
import com.dhia.springsocialmediaapi.repositories.UserRepository;
import com.dhia.springsocialmediaapi.services.WSService;
import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.simp.annotation.SendToUser;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//import java.time.LocalDateTime;
//
//@CrossOrigin
//@RestController
//public class MessageController {
//
//    private final MessageRepository messageRepository;
//    private final UserRepository userRepository;
//    private final WSService wsService;
//
//    @Autowired
//    private WSService service;
//
//    public MessageController(MessageRepository messageRepository, UserRepository userRepository, WSService wsService) {
//        this.messageRepository = messageRepository;
//        this.userRepository = userRepository;
//        this.wsService = wsService;
//    }
//
//    @CrossOrigin
//    @ApiOperation("save a message")
//    @PostMapping("/messages/")
//    public String sendMessage(@RequestBody SendMessageRequest message) {
//
//        User sender = userRepository.findById(message.getSenderId()).orElseThrow(() -> new ResourceNotFoundException("sender not found"));
//        User receiver = userRepository.findById(message.getReceiverId()).orElseThrow(() -> new ResourceNotFoundException("receiver not found"));
//        Message messageToSave = new Message();
//        messageToSave.setSender(sender);
//        messageToSave.setReceiver(receiver);
//        messageToSave.setDateTimeSent(LocalDateTime.now());
//        messageToSave.setContent(message.getContent());
//        wsService.notifyUser("1", "test");
//        messageRepository.save(messageToSave);
//        return "saved";
//    }
//
//    @CrossOrigin
//    @PostMapping("/send-private-message/{id}")
//    public void sendPrivateMessage(@PathVariable final String id,
//                                   @RequestBody final Message message) {
//        service.notifyUser(id, "test");
//    }
//
//    @CrossOrigin
//    @MessageMapping("/private-message")
//    @SendToUser("/topic/private-messages")
//    public String getPrivateMessage(final Message message,
//                                             final Principal principal) throws InterruptedException {
//        Thread.sleep(1000);
////        notificationService.sendPrivateNotification(principal.getName());
//        System.out.println(principal);
//        return "test2";
//
//    }
//
//}
