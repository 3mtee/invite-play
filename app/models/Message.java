package models;

import play.db.jpa.GenericModel;
import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: emtee
 * @date: 5/15/12 3:04 PM
 */
@Entity
public class Message extends Model {
    public String messageKey;

    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL)
    public List<MessageValue> values;

    public Message() {
        this.messageKey = "";
        this.values = new ArrayList<MessageValue>();
    }

    public Message(String messageKey, List<MessageValue> values) {
        this.messageKey = messageKey;
        this.values = values;
    }

    public Message addValue(String language, String value) {
        final MessageValue messageValue = new MessageValue(language, value, this);
        this.values.add(messageValue);
        this.save();
        return this;
    }

    public Message addValue(MessageValue value) {
        this.values.add(value);
        this.save();
        return this;
    }

    public static String getTranslation(String language, String key) {
        //TODO: replace with JPA
        final Message message = Message.find("byMessageKey", key).first();

        for (MessageValue value : message.values) {
            if (value.language.equals(language)) {
                return value.value;
            }
        }
        return "";
    }

    @Override
    public String toString() {
        return messageKey;
    }
}
