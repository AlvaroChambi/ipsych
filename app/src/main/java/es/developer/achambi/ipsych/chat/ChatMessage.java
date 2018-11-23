package es.developer.achambi.ipsych.chat;

import java.util.Date;

public class ChatMessage {
    private static final int NOT_DEFINED = -1;

    private long id;
    private String message;
    private String user;
    private Date messageDate;

    public ChatMessage() {
        id = NOT_DEFINED;
        message = "";
        user = "";
        messageDate = null;
    }

    public ChatMessage(String message, String user, Date messageDate) {
        this.message = message;
        this.user = user;
        this.messageDate = messageDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }
}
