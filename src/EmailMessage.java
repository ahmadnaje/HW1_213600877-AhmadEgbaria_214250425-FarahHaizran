import java.util.ArrayList;
import java.util.Date;

public class EmailMessage extends Message implements IDigital {

    private String subject;
    private ArrayList<File> attachments;

    public EmailMessage(String sender, String content, Date sendDate, boolean isRead,
                        String subject, ArrayList<File> attachments) {
        super(sender, content, sendDate, isRead);
        setSubject(subject);

        if (attachments != null)
            this.attachments = attachments;
        else
            this.attachments = new ArrayList<>();
    }

    public EmailMessage(String sender, String content, boolean isRead, String subject) {
        super(sender, content, isRead);
        setSubject(subject);
        this.attachments = new ArrayList<>();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        if (subject == null || subject.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject cannot be empty");
        }
        this.subject = subject;
    }

    public ArrayList<File> getAttachments() {
        return attachments;
    }

    public void addAttachment(File file) {
        attachments.add(file);
    }

    public void removeAttachment(File file) throws AttachmentException {
        boolean removed = attachments.removeIf(f -> f.equals(file));
        if (!removed)
            throw new AttachmentException("Attachment not found: " + file.getFileName());
    }

    @Override
    public String printCommunicationMethod() {
        return "Sent via Email Server";
    }

    @Override
    public String generatePreview() {
        return "[Email] Subject: " + subject + " | From: " + getSender();
    }

    @Override
    public String toString() {
        return "[EmailMessage] "
             + super.toString()
             + ", Subject: " + subject
             + ", Attachments: " + attachments;
    }
}