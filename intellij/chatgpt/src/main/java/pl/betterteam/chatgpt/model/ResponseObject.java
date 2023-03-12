package pl.betterteam.chatgpt.model;

import java.util.List;

public class ResponseObject {
    private String id;
    private String object;
    private int created;
    private String model;
    private Usage usage;
    private List<Choice> choices;

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public int getCreated() {
        return created;
    }

    public String getModel() {
        return model;
    }

    public Usage getUsage() {
        return usage;
    }

    public List<Choice> getChoices() {
        return choices;
    }
}
