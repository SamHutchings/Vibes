package com.vibes.domain;

import com.vibes.enums.VibeType;

/**
 * Represents a vibe sent or received by the user
 */
public class Vibe {
    private VibeType Type;
    private String ContactId;
    private Boolean Sent;

    public VibeType getVibeType(){
        return Type;
    }

    public void setVibeType(VibeType type){
        this.Type = type;
    }

    public String getContactId(){
        return ContactId;
    }

    public void setContactId(String contactId){
        this.ContactId = contactId;
    }

    public Boolean getSent(){
        return Sent;
    }

    public void setSent(Boolean sent){
        this.Sent = sent;
    }
}
