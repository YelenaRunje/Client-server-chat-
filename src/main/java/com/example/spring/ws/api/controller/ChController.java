package com.example.spring.ws.api.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.example.spring.ws.api.model.Message;

@Controller
public class ChController {
	
	
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public Message register (@Payload Message msg, SimpMessageHeaderAccessor headerAccesor ) {
		headerAccesor.getSessionAttributes().put("username",msg.getSender());
		return msg;
	}
	
	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	
	public Message sendMessage(@Payload Message msg){
		return msg;	
	}
}
