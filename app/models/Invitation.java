package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * @author: emtee
 * @date: 5/15/12 2:42 PM
 */
@Entity
public class Invitation extends Model {

    @ManyToOne
    public Contact contact;
    public boolean invitationAccepted;
    public Date timestamp;

    public Invitation(boolean invitationAccepted, Date timestamp, Contact contact) {
        this.contact = contact;
        this.invitationAccepted = invitationAccepted;
        this.timestamp = timestamp;
    }
}
