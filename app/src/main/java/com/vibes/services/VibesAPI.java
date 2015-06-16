package com.vibes.services;

import com.vibes.domain.Contact;
import com.vibes.domain.Vibe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Implementation of IVibesAPI using the real web service
 */
public class VibesAPI implements IVibesAPI {

    private static final String serviceUrl = "";

    public Collection<Contact> sendContactList(Collection<Integer> phoneNumbers) {
        return new ArrayList<Contact>();
    }

    public Boolean sendVibe(Vibe vibe) {
        return true;
    }
}
