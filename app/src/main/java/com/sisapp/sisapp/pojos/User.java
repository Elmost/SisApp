package com.sisapp.sisapp.pojos;

import com.google.firebase.auth.FirebaseUser;

import java.util.Map;

/**
 * Created by Elmost on 8/08/2016.
 */
public class User {

    public final static int DEFAULT_CLICKS = 0;
    public final static double DEFAULT_CASH = 0.0;
    public final static boolean ONLINE = true;
    public final static boolean OFFLINE = false;
    public final static String USER_EMAIL = "email";
    public final static String USER_CURRENT_CLICKS = "currentClicks";
    public final static String USER_CURRENT_CASH = "currentCash";
    public final static String USER_ONLINE = "online";

    private String email = null;

    private int currentClicks;

    private double currentCash;

    private boolean online;

    public User() {
    }

    public User(String email, int currentClicks, double currentCash, boolean online) {
        this.email = email;
        this.currentClicks = currentClicks;
        this.currentCash = currentCash;
        this.online = online;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCurrentClicks() {
        return currentClicks;
    }

    public void setCurrentClicks(int currentClicks) {
        this.currentClicks = currentClicks;
    }

    public double getCurrentCash() {
        return currentCash;
    }

    public void setCurrentCash(double currentCash) {
        this.currentCash = currentCash;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof User) {
            User mUser = (User) obj;
            equal = this.email.equals(mUser.getEmail());
        }
        return equal;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", currentClicks=" + currentClicks +
                ", currentCash=" + currentCash +
                ", online=" + online +
                '}';
    }
}
