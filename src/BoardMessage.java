import java.util.Date;

public class BoardMessage extends Message {

    private Priority priority;
    private String category;

    public BoardMessage(String sender, String content, Date sendDate, boolean isRead,
                        Priority priority, String category) {
        super(sender, content, sendDate, isRead);

        setPriority(priority);
        setCategory(category);
    }

    public BoardMessage(String sender, String content, boolean isRead, String category) {
        super(sender, content, isRead);
        this.priority = Priority.REGULAR;
        setCategory(category);
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        if (priority == null) {
            throw new IllegalArgumentException("Priority cannot be null");
        }
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty");
        }
        this.category = category;
    }

    @Override
    public String toString() {
        return "[BoardMessage] " +
               super.toString() +
               ", Priority: " + priority +
               ", Category: " + category;
    }

    public boolean isUrgent() {
        return priority == Priority.URGENT;
    }

    @Override
    public String generatePreview() {
        String shortContent = getContent();
        if (shortContent.length() > 15) {
            shortContent = shortContent.substring(0, 15) + "...";
        }
        return "[Board] " + getSender() + ": " + shortContent;
    }
}
