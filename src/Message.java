import java.util.ArrayList;
import java.util.Date;

public abstract class Message {

    private String sender;
    private String content;
    private Date sendDate;
    private boolean isRead;

    public Message(String sender, String content, Date sendDate, boolean isRead) {
        setSender(sender);
        setContent(content);
        this.sendDate = sendDate;
        this.isRead = isRead;
    }

    public Message(String sender, String content, boolean isRead) {
        this(sender, content, new Date(), isRead);
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        if (sender == null || sender.trim().isEmpty()) {
            throw new IllegalArgumentException("Sender cannot be empty");
        }
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Content cannot be empty");
        }
        this.content = content;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public boolean isRead() {
        return isRead;
    }

    public void markAsRead() {
        this.isRead = true;
    }

    public boolean find(ArrayList<String> words) {
        for (String w : words) {
            if (content.toLowerCase().contains(w.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Sender: " + sender +
               ", Content: " + content +
               ", Date: " + sendDate +
               ", Read: " + isRead;
    }

    public abstract String generatePreview();
}
