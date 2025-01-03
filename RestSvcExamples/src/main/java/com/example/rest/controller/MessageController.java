package com.example.rest.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.domain.Message;
import com.example.rest.domain.MessageList;

@RestController
@RequestMapping("/message")
public class MessageController {

	@GetMapping("/get-in-xml")
	public MessageList getMsgsInXml() {
		List<Message> messages = Arrays.asList(
			new Message(1, "메시지1", new Date()),
			new Message(2, "메시지2", new Date())
		);
		return new MessageList(messages);
	}

	@PostMapping("/post-in-xml")
	public MessageList postMsgsInXml(@RequestBody MessageList messageList) {
		System.out.println(messageList.toString());
		messageList.getMessages().get(0).setContent("수정된 메시지1");
		return messageList;
	}
	
	@GetMapping("/get-in-json")
	public List<Message> getMsgsInJson() {
		List<Message> messages = Arrays.asList(
			new Message(1, "메시지1", new Date()),
			new Message(2, "메시지2", new Date())
		);
		return messages; // new MessageList2(messages);
	}

	@PostMapping("/post-in-json")
	public List<Message> postMsgsInJson(@RequestBody List<Message> messages) {
		System.out.println(messages.toString());
		messages.get(1).setContent("수정된 메시지2");
		return messages;
	}
}
