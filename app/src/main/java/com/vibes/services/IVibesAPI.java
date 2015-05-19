package com.vibes.services;

import com.vibes.domain.*;

import java.util.Collection;

/**
 * Interface for the vibes API
 */
public interface IVibesAPI {

    Collection<Contact> sendContactList(Collection<Integer> phoneNumbers);

    Boolean sendVibe(Vibe vibe);
}
