package com.vibes.services;

import com.vibes.domain.Contact;
import com.vibes.domain.Vibe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Test version of IVibesAPI, will return ideal values
 */
public class DisconnectedVibesAPI {

    /*
    Will return a contact for each phone number provided
     */
    public Collection<Contact> sendContactList(Collection<String> phoneNumbers) {
        List<Contact> contactsToReturn = new ArrayList<Contact>();

        for (String number : phoneNumbers) {
            Contact newContact = new Contact();
            newContact.setPhoneNumber(number);
            newContact.setUsername("Contact" + number);
            contactsToReturn.add(newContact);
        }

        return contactsToReturn;
    }

    /*
    Will return success from each vibe
     */
    public Boolean sendVibe(Vibe vibe) {
        return true;
    }
}
