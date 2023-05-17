package pl.betterteam.chatgpt.model;

import java.util.List;

public class RequestObject {
    private String model;
    private List<Message> messages;

    public RequestObject(String model, List<Message> messages) {
        this.model = model;
        this.messages = messages;
    }

    public String getModel() {
        return model;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
