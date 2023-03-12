package pl.betterteam.chatgpt.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Choice {
    private Message message;
    @JsonProperty("finish_reason")
    private String finishReason;
    private int index;

    public Message getMessage() {
        return message;
    }

    public String getFinishReason() {
        return finishReason;
    }

    public int getIndex() {
        return index;
    }
}
