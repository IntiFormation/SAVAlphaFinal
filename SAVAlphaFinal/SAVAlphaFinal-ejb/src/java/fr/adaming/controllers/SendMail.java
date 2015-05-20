/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.controllers;

import fr.adaming.models.Mail;
import fr.adaming.tools.MailUtil;
import org.apache.log4j.Logger;

/**
 *
 * @author INTI-0205
 */
public class SendMail {

    private Mail mailForm;
    
    private static final Logger LOG = Logger.getLogger(SendMail.class.getName());
    

    /**
     * Se déclenche à chaque fois qu'on arrive sur la page
     *
     * @return a mail
     */
    public Mail getModel() {
        mailForm = new Mail();
        return mailForm;
    }


    public boolean execute(Mail mail) {

        LOG.debug("Entering...");

        String subject = mailForm.getSubject();
        String message = mailForm.getMessage();
        
        try {
            LOG.debug("Trying to send message...");
            if (mailForm.getMailTo().contains(";")) {
                MailUtil.sendMail(mailForm.getMailTo().split(";"), subject, message);
            } else {
                MailUtil.sendMail(mailForm.getMailTo(), subject, message);
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
