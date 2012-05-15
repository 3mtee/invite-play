package controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import models.Contact;
import play.db.jpa.JPABase;
import play.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    public static void index() {
        final List<Contact> contacts = Contact.findAll();
        render(contacts);
    }

    public static void index(List<Contact> contacts) {
        render(contacts);
    }

    public static void sendInvitations() {
        render();
    }

    public static void contacts(String term) {
        JsonArray array = new JsonArray();
        List<String> result = new ArrayList<String>();
        final List<Contact> contacts = Contact.find("byEmailLike", term + "%").fetch();
        for (Contact contact : contacts) {
            JsonObject obj = new JsonObject();
            final String email = contact.email;
            result.add(email);
            obj.addProperty("label", email);
            obj.addProperty("value", contact.id);
            array.add(obj);
        }
//        renderJSON(result);
        renderText(array.toString());
    }

    public static void inviteCallback() {
        if (Contact.count() == 0) {
            new Contact("jwermuth@gmail.com", "Jesper").save();
            new Contact("whabula@gmail.com", "Whabula").save();
            new Contact("wrinkle@gmail.com", "John Smith").save();
        }

        // return rv;
        List<Contact> contacts = Contact.findAll();
        render("@index", contacts);
    }

}