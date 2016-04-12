package com.vibes.domain;

import com.vibes.enums.VibeType;

import java.util.Date;

/**
 * Represents a vibe sent or received by the user
 */
public class Vibe {
    private long id;
    private VibeType Type;
    private long ContactId;
    private long Date;
    private Boolean Sent;
    private Friend friend;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public VibeType getVibeType() {
        return Type;
    }

    public void setVibeType(VibeType type) {
        this.Type = type;
    }

    public long getContactId() {
        return ContactId;
    }

    public void setContact(long contactId) {
        this.ContactId = contactId;
    }

    public Boolean getSent() {
        return Sent;
    }

    public void setSent(Boolean sent) {
        this.Sent = sent;
    }

    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }

    public Date getDate() {
        return new Date(Date);
    }

    public void setDate(Date date) {
        this.Date = date.getTime();
    }

    @Override
    public String toString() {
        if(this.friend != null) {
            return this.Type + " vibe " + this.id + " to " + this.getFriend().toString();
        }

        return this.Type + " vibe " + this.id;
    }
}
