package com.sisapp.sisapp.main.events;

import com.sisapp.sisapp.pojos.User;

/**
 * Created by Elmost on 13/08/2016.
 */
public class UserEvent {

    public static final int onUserUpdate = 0;

    private User user;
    private int eventType;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }
}
