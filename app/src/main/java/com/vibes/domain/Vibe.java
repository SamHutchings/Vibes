package com.vibes.domain;

import com.vibes.enums.VibeType;

/**
 * Represents a vibe sent or received by the user
 */
public class Vibe {
    private VibeType Type;

    public VibeType getVibeType(){
        return Type;
    }

    public void setVibeType(VibeType type){
        this.Type = type;
    }
}
