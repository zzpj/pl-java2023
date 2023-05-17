package pl.betterteam.chatgpt.model;

public class Message {
    private String role;
    private String content;

    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public Message() {
    }

    public String getRole() {
        return role;
    }

    public String getContent() {
        return content;
    }
}
