public class NotificationManager {
    private final MessageService messageService;

    // Constructor Injection
    public NotificationManager(MessageService messageService) {
        this.messageService = messageService;
    }

    public void notify(String message) {
        messageService.sendMessage(message);
    }
}