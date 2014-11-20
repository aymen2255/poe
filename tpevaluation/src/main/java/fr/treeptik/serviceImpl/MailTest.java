package fr.treeptik.serviceImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.treeptik.model.User;

@Stateless
public class MailTest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(lookup = "java:jboss/mail/Default")
    private  Session mailSession;
    
    public void service(HttpServletRequest req, HttpServletResponse res, User user)
        throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        try {
            MimeMessage m = new MimeMessage(mailSession);
            Address from = new InternetAddress("stagiairetreeptik@gmail.com");
            Address[] to = new InternetAddress[] { new InternetAddress(
                user.getEmail()) };
            m.setFrom(from);
            m.setRecipients(Message.RecipientType.TO, to);
            m.setSubject("Google JavaMail Test");
            m.setContent("Test from inside JBoss AS7 Server", "text/plain");
            Transport.send(m);

            out.println("Mail Sent Successfully.");
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace(out);
        }
    }
 
    
}
