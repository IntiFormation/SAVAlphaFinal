    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.managedBeans;

import fr.adaming.dao.ReparationsFacadeLocal;
import fr.adaming.models.Mail;
import fr.adaming.tools.Etats;
import fr.adaming.tools.MailContent;
import fr.adaming.tools.MailManager;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;

/**
 *
 * @author INTI-0205
 */
@Named(value = "gestionReparateur")
@SessionScoped
public class GestionReparateur implements Serializable {

    private boolean colisRecu;
    private boolean devisEffectue;
    private boolean produitRepare;
    private boolean colisRenvoye;

    String etat;
    Date date;

    @EJB
    ReparationsFacadeLocal reparation;
    
    @Inject
    GestionClients gestionClients;

    /**
     * Creates a new instance of GestionReparateur
     */
    public GestionReparateur() {
    }

    public void majEtat(AjaxBehaviorEvent event) {
        SelectBooleanCheckbox checkedBox = (SelectBooleanCheckbox) event.getSource();
        String idCheckedBox = checkedBox.getId();
        
        Calendar currentDate = Calendar.getInstance();
        date = currentDate.getTime();
        Mail mail;

        if (null != idCheckedBox) {
            switch (idCheckedBox) {
                case "colis_recu":
                    this.etat = Etats.PRODUIT_RECU;
                    mail = new Mail("mailClient", MailContent.MAJ_ETAT_SUBJ
                            + MailContent.PRODUIT_RECU_SUBJ , MailContent.PRODUIT_RECU);
                    MailManager.send(mail);
                    break;
                case "devis_effectue":
                    this.etat = Etats.DEVIS_EFFECTUE;
                    mail = new Mail("mailClient", MailContent.MAJ_ETAT_SUBJ
                            + MailContent.DEVIS_EFFECTUE_SUBJ , MailContent.DEVIS_EFFECTUE);
                    MailManager.send(mail);
                    break;
                case "produit_repare":
                    this.etat = Etats.PRODUIT_REPARE;
                    break;
                case "colis_renvoye":
                    this.etat = Etats.PRODUIT_RENVOYE;
                    break;
            }
        }

        int idReparation = 1;
        reparation.updateEtat(etat, date, idReparation);
    }

    public boolean isColisRecu() {
        return colisRecu;
    }

    public void setColisRecu(boolean colisRecu) {
        this.colisRecu = colisRecu;
    }

    public boolean isProduitRepare() {
        return produitRepare;
    }

    public void setProduitRepare(boolean produitRepare) {
        this.produitRepare = produitRepare;
    }

    public boolean isColisRenvoye() {
        return colisRenvoye;
    }

    public void setColisRenvoye(boolean colisRenvoye) {
        this.colisRenvoye = colisRenvoye;
    }

    public boolean isDevisEffectue() {
        return devisEffectue;
    }

    public void setDevisEffectue(boolean devisEffectue) {
        this.devisEffectue = devisEffectue;
    }

}
