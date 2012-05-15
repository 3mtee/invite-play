package controllers;

import models.Contact;
import play.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

	public static void index() {
		render();
	}

	public static void index(List<Contact> contacts) {
		render(contacts);
	}

    public static void sendInvitations() {

    }

    public static void contacts(String term) {
        List<String> result = new ArrayList<String>();
        final List<Contact> contacts = Contact.find("byEmailLike", "%" + term + "%").fetch();
        for (Contact contact : contacts) {
            final String email = contact.email;
            result.add(email);
        }
        renderJSON(result);
    }

	public static void inviteCallback() {

		new Contact("jwermuth@gmail.com", "Jesper").save();
		new Contact("whabula@gmail.com", "Whabula").save();
		new Contact("wrinkle@gmail.com", "John Smith").save();

		// return rv;
		List<Contact> contacts = Contact.findAll();
		render("@index", contacts);
	}


}