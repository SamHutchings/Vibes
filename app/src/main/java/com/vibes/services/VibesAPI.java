package com.vibes.services;

import com.vibes.domain.Friend;
import com.vibes.domain.Vibe;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Implementation of IVibesAPI using the real web service
 */
public class VibesAPI implements IVibesAPI {

    private static final String serviceUrl = "";

    public Collection<Friend> sendContactList(Collection<String> phoneNumbers) {
        return new ArrayList<Friend>();
    }

    public Boolean sendVibe(Vibe vibe) {
        return true;
    }
}
