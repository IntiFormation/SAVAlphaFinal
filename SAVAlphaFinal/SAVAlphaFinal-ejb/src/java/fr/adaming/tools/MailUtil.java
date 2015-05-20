/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.tools;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author INTI-0205
 */
public class MailUtil {

    private static final boolean DEBUG = true;

    private static final String SMTP_HOST = "smtp.orange.fr";
    private static final String MAIL_FROM = "sav.server@alpha.fr";
    private static final String MAIL_HEADER = "MaillingApplication";

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", SMTP_HOST);
        properties.put("mail.smtp.auth", "true");
        return properties;
    }

    private static Message prepareMessage(Session session, InternetAddress addressFrom,
            InternetAddress addressTo, String subject, String message)
            throws MessagingException {

        Message msg = new MimeMessage(session);

        msg.setFrom(addressFrom);
        msg.setRecipient(Message.RecipientType.TO, addressTo);

        msg.addHeader(MAIL_HEADER, MAIL_HEADER);
        msg.setSubject(subject);
        msg.setContent(message, "text/html");

        return msg;
    }

    private static Message prepareMessage(Session session, InternetAddress addressFrom,
            InternetAddress[] addressTo, String subject, String message)
            throws MessagingException {

        Message msg = new MimeMessage(session);

        msg.setFrom(addressFrom);
        msg.setRecipients(Message.RecipientType.TO, addressTo);

        msg.addHeader(MAIL_HEADER, MAIL_HEADER);
        msg.setSubject(subject);
        msg.setContent(message, "text/html");

        return msg;
    }

    private static void displayDebugInformations(String recipient, String subject, String message) {
        System.out.println("MailUtil.java - sendMail() : Entering...");
        System.out.println("MailUtil.java - sendMail() : SMTP = " + SMTP_HOST);
        System.out.println("MailUtil.java - sendMail() : From = " + MAIL_FROM);
        System.out.println("MailUtil.java - sendMail() : To = " + recipient);
        System.out.println("MailUtil.java - sendMail() : Subject = " + subject);
        System.out.println("MailUtil.java - sendMail() : Message = " + message);
    }

    private static void displayDebugInformations(String[] recipients, String subject, String message) {
        System.out.println("MailUtil.java - sendMail() : Entering...");
        System.out.println("MailUtil.java - sendMail() : SMTP = " + SMTP_HOST);
        System.out.println("MailUtil.java - sendMail() : From = " + MAIL_FROM);
        for (int i = 0; i < recipients.length; i++) {
            System.out.println("MailUtil.java - sendMail() : To = " + recipients[i]);
        }
        System.out.println("MailUtil.java - sendMail() : Subject = " + subject);
        System.out.println("MailUtil.java - sendMail() : Message = " + message);
    }

    /**
     *
     * @param recipient
     * @param subject
     * @param message
     * @throws javax.mail.internet.AddressException
     */
    public static void sendMail(String recipient, String subject,
            String message) throws Exception {

        if (DEBUG) {
            displayDebugInformations(recipient, subject, message);
        }

        Properties properties = getProperties();
        Session session = Session.getDefaultInstance(properties);

        // Addresse d'expéditeur, pas sécurisé car on peut mettre l'adresse que l'on souhaite
        // Pour protéger cette partie il faut acheter des certificats (très chers)
        // Exemple : les certificats X509
        InternetAddress addressFrom = new InternetAddress(MAIL_FROM);
        InternetAddress addressTo = new InternetAddress(recipient);

        Message msg = prepareMessage(session, addressFrom, addressTo, subject, message);

        Transport.send(msg);
    }

    /**
     *
     * @param recipients
     * @param subject
     * @param message
     * @throws javax.mail.internet.AddressException
     */
    public static void sendMail(String[] recipients, String subject,
            String message) throws Exception {

        if (DEBUG) {
            displayDebugInformations(recipients, subject, message);
        }

        Properties properties = getProperties();
        Session session = Session.getDefaultInstance(properties);

        // Addresse d'expéditeur, pas sécurisé car on peut mettre l'adresse que l'on souhaite
        // Pour protéger cette partie il faut acheter des certificats (très chers)
        // Exemple : les certificats X509
        InternetAddress addressFrom = new InternetAddress(MAIL_FROM);
        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++) {
            addressTo[i] = new InternetAddress(recipients[i]);
        }

        Message msg = prepareMessage(session, addressFrom, addressTo, subject, message);

        Transport.send(msg);
    }

}
