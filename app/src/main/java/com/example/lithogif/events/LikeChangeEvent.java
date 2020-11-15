package com.example.lithogif.events;

import com.facebook.litho.annotations.Event;

@Event
public class LikeChangeEvent {
    public boolean isLiked;
    public String gifId;
}
