package ru.grigoreva.springserver;

import org.springframework.stereotype.Component;

 //Bean
public class Message {

    private String body;
    private String timestamp;


    public Message(String body, String timestamp) {
        this.body = body;
        this.timestamp = timestamp;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
