package com.niit.restcontroller;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.niit.FriendsAdda.model.Message;
import com.niit.FriendsAdda.model.OutputMessage;

@RestController
 public class ChatController
 {
        @MessageMapping("/chat")
        @SendTo("/topic/message")
        public OutputMessage sendMessage(Message message)
        {
        	System.out.println("Message Recieved");
            return new OutputMessage(message,new Date());
        }
}