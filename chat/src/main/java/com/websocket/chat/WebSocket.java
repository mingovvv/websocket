package com.websocket.chat;

import org.springframework.web.bind.annotation.RestController;

import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;

@RestController
@ServerEndpoint(value = "/chat")
public class WebSocket {
    private static final List<Session> SESSION_LIST = new ArrayList<>();

    public WebSocket() {
        System.out.println("웹소켓 객체 생성");
    }


}
