package com.vibes.services;

import com.vibes.domain.Contact;
import com.vibes.domain.Vibe;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Test version of IVibesAPI, will return ideal values
 */
public class DisconnectedVibesAPI {

    public Collection<Contact> sendContactList(Collection<Integer> phoneNumbers) {
        return new ArrayList<Contact>();
    }

    public Boolean sendVibe(Vibe vibe) {
        return true;
    }
}
