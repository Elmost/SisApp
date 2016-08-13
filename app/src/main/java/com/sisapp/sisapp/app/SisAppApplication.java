package com.sisapp.sisapp.app;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;
import com.sisapp.sisapp.pojos.User;

/**
 * Created by Elmost on 9/08/2016.
 */
public class SisAppApplication extends Application {

    private User mUser;

    @Override
    public void onCreate() {
        super.onCreate();
        setupFirebase();
    }

    /**
     * Preparar Firebase.
     */
    private void setupFirebase() {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

    public User getmUser() {
        return mUser;
    }

    public void setmUser(User mUser) {
        this.mUser = mUser;
    }
}
