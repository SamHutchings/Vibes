package com.vibes.services;

import com.vibes.domain.*;

import java.util.Collection;

/**
 * Interface for the vibes API
 */
public interface IVibesAPI {

    /*
    Sends a list of contacts to the web service
     */
    Collection<Friend> sendContactList(Collection<Integer> phoneNumbers);

    /*
    Send the given vibe to the contact mentioned
     */
    Boolean sendVibe(Vibe vibe);
}
