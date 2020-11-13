package ru.grigoreva.springserver;

import org.springframework.stereotype.Component;


public class Response {
     private Message message;

    public Response(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
