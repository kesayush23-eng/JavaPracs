



// Step 2: Dependent class that needs MessageService


// Step 3: Usage
public class Main {
    public static void main(String[] args) {
        // Inject dependency via constructor
        MessageService emailService = new EmailService();
        NotificationManager manager = new NotificationManager(emailService);

        manager.notify("Hello, Constructor Injection!");
    }
}