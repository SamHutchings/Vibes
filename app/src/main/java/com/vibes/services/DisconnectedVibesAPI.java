package com.vibes.services;

import com.vibes.domain.Friend;
import com.vibes.domain.Vibe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Test version of IVibesAPI, will return ideal values
 */
public class DisconnectedVibesAPI implements IVibesAPI {

    /*
    Will return a contact for each phone number provided
     */
    public Collection<Friend> sendContactList(Collection<String> phoneNumbers) {
        List<Friend> contactsToReturn = new ArrayList<Friend>();

        for (String number : phoneNumbers) {
            Friend newContact = new Friend();
            newContact.setPhoneNumber(number);
            newContact.setUsername("Friend" + number);
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
