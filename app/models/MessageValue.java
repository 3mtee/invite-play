package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * @author: emtee
 * @date: 5/15/12 3:05 PM
 */
@Entity
public class MessageValue extends Model {
    public String language;
    public String value;
}
