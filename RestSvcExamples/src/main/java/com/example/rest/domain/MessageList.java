package com.example.rest.domain;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message-list")
public class MessageList {
	
	@XmlElement(name="message")
	private List<Message> messages;

	public MessageList() {
	}

	public MessageList(List<Message> messages) {
		this.messages = messages;
	}

	public List<Message> getMessages() {
		return messages;
	}
	
	@Override
	public String toString() {
		return "MessageList [messages=" + messages + "]";
	}
}
