package com.example.demo.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Date;

/**
 * Created by Administrator on 2018/10/19.
 */
@ServerEndpoint("/testWebSocket")
@Component
public class MyWebSocket {

    static int sleepTime = 1000;
    Object lock = new Object();

    @OnOpen
    public void onOpen(Session session){
        new Thread(new Runnable() {// 异步推送数据
            @Override
            public void run() {
                while(null != session){
                    //session.getBasicRemote().sendText(message);
                    session.getAsyncRemote().sendText(new Date().toString());
                    try {
                        synchronized (lock) {
                            lock.wait(sleepTime);
                        }
//						 Thread.sleep(sleepTime);
                    } catch (Exception e) {
                        System.out.println("22");
                    }
                }
            }
        }).start();
    }

    @OnMessage
    public void onMessage(String message,Session session){

    }

    @OnClose
    public void onClose(){

    }
}
