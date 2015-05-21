/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.tools;

import fr.adaming.models.Mail;
import org.apache.log4j.Logger;

/**
 *
 * @author INTI-0205
 */
public class MailManager {
    
    private static final Logger LOG = Logger.getLogger(MailManager.class.getName());

    public static boolean send(Mail mail) {

        LOG.debug("Entering...");
        
        String subject = mail.getSubject();
        String message = mail.getMessage();
        
        try {
            LOG.debug("Trying to send message...");
            if (mail.getMailTo().contains(";")) {
                MailUtil.sendMail(mail.getMailTo().split(";"), subject, message);
            } else {
                MailUtil.sendMail(mail.getMailTo(), subject, message);
            }
            LOG.debug("Message sent !");
        } catch (Exception e) {
            LOG.error("=======> Exception <=======");
            LOG.error(e.getLocalizedMessage());
            return false;

        }
        return true;
    }
}
