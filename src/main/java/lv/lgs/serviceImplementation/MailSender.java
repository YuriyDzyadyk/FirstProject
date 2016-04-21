package lv.lgs.serviceImplementation;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class MailSender {
//спробувати зробити щоб лист йшов зі сторінки мені, а не від мене
    final static String USERNAME = "yuraa_@ukr.net";
    final static String PASSWORD = "yura8459";
    final static String EMAILFROM = "yuraa_@ukr.net"; 

    public synchronized void sendMail(String content, String email, String path) {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.starttls.enable", "true");//??
        properties.setProperty("mail.smtp.auth", "true");//??
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.host", "smtp.ukr.net");
        properties.setProperty("mail.smtp.socketFactory.port", "465");//??
        properties.setProperty("mail.smtp.socketFactory.class",//??
                "javax.net.ssl.SSLSocketFactory");
        Session session = Session.getDefaultInstance(properties,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email)); //можна прописати тут від кого
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
//                    EMAILFROM)); //лист приходить мені
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    email)); //лист приходить людині яка вписана з сайту
            message.setSubject(content, "UTF-8");
            message.setText(path);
            Transport.send(message);
            System.out
                    .println("Message sent without attachment successfully...");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            System.out.println("You have some problems with connection!");
        }
    }	
}
