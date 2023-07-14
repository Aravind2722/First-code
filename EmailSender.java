import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
    public static void main(String[] args) {
        // Sender's email credentials
        String senderEmail = "aravindofficial2722@gmail.com";
        String senderPassword = "Aravind@chrome.com";

        // Recipient's email address
        String recipientEmail = "rajdweepmondal@gmail.com";

        // Email subject and content
        String emailSubject = "Test Email";
        String emailContent = "This is a test email sent from Java.";

        // SMTP server configuration (e.g., for Gmail)
        String smtpHost = "smtp.gmail.com";
        int smtpPort = 587;

        // Set the properties for the SMTP server
        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create an authenticator object to authenticate the sender's email
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        };

        // Create a session with the SMTP server
        Session session = Session.getInstance(properties, authenticator);

        try {
            // Create a MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set the sender, recipient, subject, and content of the email
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject(emailSubject);
            message.setText(emailContent);

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

