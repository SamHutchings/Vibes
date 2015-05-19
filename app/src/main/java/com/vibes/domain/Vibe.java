package com.vibes.domain;

import com.vibes.enums.VibeType;

/**
 * Represents a vibe sent or received by the user
 */
public class Vibe {
    private VibeType Type;
    private int ContactId;
    private Boolean Sent;

    public VibeType getVibeType(){
        return Type;
    }

    public void setVibeType(VibeType type){
        this.Type = type;
    }

    public int getContactId(){
        return ContactId;
    }

    public void setContactId(int contactId){
        this.ContactId = contactId;
    }

    public Boolean getSent(){
        return Sent;
    }

    public void setSent(Boolean sent){
        this.Sent = sent;
    }
}
