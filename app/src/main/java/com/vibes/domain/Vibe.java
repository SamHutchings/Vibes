package com.vibes.domain;

import com.vibes.enums.VibeType;

/**
 * Represents a vibe sent or received by the user
 */
public class Vibe {
    private long id;
    private VibeType Type;
    private long ContactId;
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

    public void sentFriend(Friend friend) {
        this.friend = friend;
    }

    @Override
    public String toString() {
        return this.Type + " vibe " + this.id + " to " + this.getFriend().toString();
    }
}
