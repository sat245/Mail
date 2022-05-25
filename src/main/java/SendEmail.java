import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;

public class SendEmail {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter smtp host: ");
        String host = scanner.next();
        System.out.println("Enter mail receiver address: ");
        String to = scanner.next();
        System.out.println("Enter mail sender address: ");
        String from = scanner.next();

        //Get the session object
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        //compose the message
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Coldfusion test mail");
            message.setText("Hello,if you received this mail, your smtp server is working good.");
            // Send message
            Transport.send(message);
            System.out.println("message sent successfully....");
        }catch (MessagingException mex) {
            System.out.println("Failed to send message");
            mex.printStackTrace();
        }
    }
}
