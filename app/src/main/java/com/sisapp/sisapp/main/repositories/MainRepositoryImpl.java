package com.sisapp.sisapp.main.repositories;

import android.provider.Settings;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.sisapp.sisapp.helpers.firebase.FirebaseHelper;
import com.sisapp.sisapp.helpers.firebase.FirebaseHelperImpl;
import com.sisapp.sisapp.libs.eventbus.EventBus;
import com.sisapp.sisapp.libs.eventbus.GreenRobotEventBus;
import com.sisapp.sisapp.main.events.UserEvent;
import com.sisapp.sisapp.pojos.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Elmost on 11/08/2016.
 */
public class MainRepositoryImpl implements MainRepository {

    private FirebaseHelper mHelper;
    private ValueEventListener userEventListener;
    private DatabaseReference mUserReference;

    public MainRepositoryImpl() {
        mHelper = FirebaseHelperImpl.getInstance();
        this.mUserReference = this.mHelper.getMyUserReference();
    }


    @Override
    public void toSubscribeUserUpdates() {
        userEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                Log.i("USER :: ", user.toString());
                postEvent(UserEvent.onUserUpdate, user);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        mUserReference.addValueEventListener(userEventListener);
    }

    @Override
    public void onUpdateUser(User user) {
        if (mUserReference != null) {
            mUserReference.setValue(user);
        }
    }

    private void postEvent(int type, User user) {
        UserEvent userEvent = new UserEvent();
        userEvent.setEventType(type);
        userEvent.setUser(user);
        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(userEvent);
    }
}
