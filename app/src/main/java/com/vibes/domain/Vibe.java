package com.vibes.domain;

import com.vibes.enums.VibeType;

/**
 * Represents a vibe sent or received by the user
 */
public class Vibe {
    private VibeType Type;
    private Contact ContactId;
    private Boolean Sent;

    public VibeType getVibeType() {
        return Type;
    }

    public void setVibeType(VibeType type) {
        this.Type = type;
    }

    public Contact getContact(){
        return ContactId;
    }

    public void setContact(Contact contactId){
        this.ContactId = contactId;
    }

    public Boolean getSent(){
        return Sent;
    }

    public void setSent(Boolean sent){
        this.Sent = sent;
    }
}
