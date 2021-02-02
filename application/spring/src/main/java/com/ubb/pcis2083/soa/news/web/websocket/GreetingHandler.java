package com.ubb.pcis2083.soa.news.web.websocket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class GreetingHandler extends TextWebSocketHandler {
    private final Logger log = LogManager.getLogger(this.getClass());
    private WebSocketSession currentSession;

    public void sendMessage (String message)  {
        if (currentSession!=null) {
            try {
                TextMessage msg = new TextMessage(message);
                currentSession.sendMessage(msg);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("Connection established !!");
        currentSession = session;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("Trying to send message...");

        TextMessage msg = new TextMessage("Hello, " + message.getPayload() + "!");
        session.sendMessage(msg);

        log.info("Message sent !!");
    }
}