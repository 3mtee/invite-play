package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author: emtee
 * @date: 5/15/12 3:05 PM
 */
@Entity
public class MessageValue extends Model {
    public String language;
    public String value;

    @ManyToOne
    public Message message;

    public MessageValue() {
    }

    public MessageValue(String language, String value, Message message) {
        this.message = message;
        this.language = language;
        this.value = value;
    }
}
