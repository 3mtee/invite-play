package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Contact extends Model {
	public Contact(String email, String name) {
        this.invitations = new ArrayList<Invitation>();
		this.email = email;
		this.name = name;
	}
	public String email;
	public String name;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    public List<Invitation> invitations;

    public Contact addInvitation() {
        final Invitation invitation = new Invitation(false, new Date(), this);
        this.invitations.add(invitation);
        this.save();
        return this;
    }

}
