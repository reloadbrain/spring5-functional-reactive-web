package com.spring5.reactive.playground;

import java.io.Serializable;

public class Message implements Serializable {

    private String id;
    private String messageContent;

    public Message(String id, String messageContent){
        this.id = id;
        this.messageContent = messageContent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (!id.equals(message.id)) return false;
        return messageContent.equals(message.messageContent);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + messageContent.hashCode();
        return result;
    }


}
