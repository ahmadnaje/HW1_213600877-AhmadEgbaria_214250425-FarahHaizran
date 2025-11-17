import java.util.Date;

public class ChatMessage extends Message implements IDigital {

    private String chatRoomName;

    public ChatMessage(String sender, String content, Date sendDate, boolean isRead,
                       String chatRoomName) throws ChatRoomException {
        super(sender, content, sendDate, isRead);
        setChatRoomName(chatRoomName);
    }

    public ChatMessage(String sender, String content, boolean isRead,
                       String chatRoomName) throws ChatRoomException {
        super(sender, content, isRead);
        setChatRoomName(chatRoomName);
    }

    public String getChatRoomName() {
        return chatRoomName;
    }

    public void setChatRoomName(String chatRoomName) throws ChatRoomException {
        if (chatRoomName == null || chatRoomName.trim().isEmpty()) {
            throw new ChatRoomException("Chat room name cannot be empty");
        }
        this.chatRoomName = chatRoomName;
    }

    @Override
    public String printCommunicationMethod() {
        return "Sent via Chat Server";
    }

    @Override
    public String generatePreview() {
        String shortContent = getContent();
        if (shortContent.length() > 10) {
            shortContent = shortContent.substring(0, 10) + "...";
        }
        return "[Chat] " + getSender() + ": " + shortContent;
    }

    @Override
    public String toString() {
        return "[ChatMessage] "
             + super.toString()
             + ", Chat Room: " + chatRoomName;
    }
}