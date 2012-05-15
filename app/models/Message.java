package models;

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
    public String key;

    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL)
    public List<MessageValue> values;

    public Message() {
        this.key = "";
        this.values = new ArrayList<MessageValue>();
    }

    public Message(String key, List<MessageValue> values) {
        this.key = key;
        this.values = values;
    }

    public String getTranslation(String language) {
        //not sure if there's a way to use persistence instead of loop
        for (MessageValue value : values) {
            if (value.language.equals(language)) {
                return value.value;
            }
        }
        return "";
    }
}
