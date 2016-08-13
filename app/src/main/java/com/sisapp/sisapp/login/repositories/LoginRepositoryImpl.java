package com.sisapp.sisapp.login.repositories;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.sisapp.sisapp.helpers.firebase.FirebaseHelper;
import com.sisapp.sisapp.helpers.firebase.FirebaseHelperImpl;
import com.sisapp.sisapp.libs.eventbus.EventBus;
import com.sisapp.sisapp.libs.eventbus.GreenRobotEventBus;
import com.sisapp.sisapp.login.events.LoginEvent;
import com.sisapp.sisapp.pojos.User;

/**
 * Created by Elmost on 9/08/2016.
 */
public class LoginRepositoryImpl implements LoginRepository {

    private FirebaseHelper mHelper;
    private DatabaseReference mUserReference;

    public LoginRepositoryImpl() {
        this.mHelper = FirebaseHelperImpl.getInstance();
        this.mUserReference = this.mHelper.getMyUserReference();
    }

    @Override
    public void signInSisApp(final String email, final String password) {
        try {
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            mUserReference = mHelper.getMyUserReference();
                            mUserReference.addListenerForSingleValueEvent(
                                    new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            initSignIn(dataSnapshot);
                                        }

                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {
                                            postEvent(LoginEvent.onSignInSisAppError, LoginEvent.showMessageSignInSisAppError);
                                        }
                                    }
                            );
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            postEvent(LoginEvent.onSignInSisAppError, LoginEvent.showMessageSignInSisAppError);
                        }
                    });
        } catch (Exception e) {
            postEvent(LoginEvent.onSignInSisAppError, LoginEvent.showMessageSignInSisAppError);
        }
    }

    @Override
    public void signUpSisApp(final String email, final String password) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        signInSisApp(email, password);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        postEvent(LoginEvent.onSignUpSisAppError, LoginEvent.showMessageSignUpSisAppError);
                    }
                });
    }

    @Override
    public void signInGoogle() {

    }


    @Override
    public void checkAlreadyAuthenticated() {
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            mUserReference = mHelper.getMyUserReference();
            mUserReference.addListenerForSingleValueEvent(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            initSignIn(dataSnapshot);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            postEvent(LoginEvent.onSignInSisAppError, LoginEvent.showMessageSignInSisAppError);
                        }
                    }
            );
        } else {
            postEvent(LoginEvent.onFailedToRecoverSession, LoginEvent.showMessageSignInSisAppError);
        }
    }

    /**
     * Registrar usuario.
     */
    private void registerNewUser() {
        String mEmail = mHelper.getMyEmailAuth();
        if (mEmail != null) {
            User currentUser = new User(mEmail, User.DEFAULT_CLICKS, User.DEFAULT_CASH, User.ONLINE);
            mUserReference.setValue(currentUser);
            postEvent(LoginEvent.onSignUpSisAppSuccess);
        } else {
            postEvent(LoginEvent.onSignUpSisAppError, LoginEvent.showMessageSignUpSisAppError);
        }
    }

    /**
     * Iniciar sesión.
     *
     * @param snapshot datos actuales {@link DataSnapshot}
     */
    private void initSignIn(DataSnapshot snapshot) {
        User mUser = snapshot.getValue(User.class);
        if (mUser == null) {
            registerNewUser();
        }
        mHelper.changeUserStatusToOnline();
        postEvent(LoginEvent.onSignInSisAppSuccess);
    }

    /**
     * Publicar evento.
     *
     * @param eventType    tipo de evento
     * @param errorMessage mensaje de error
     */
    private void postEvent(int eventType, String errorMessage) {
        LoginEvent mLoginEvent = new LoginEvent();
        mLoginEvent.setEventType(eventType);
        if (errorMessage != null) {
            mLoginEvent.setMessage(errorMessage);
        }
        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(mLoginEvent);
    }

    /**
     * Publicar evento.
     *
     * @param eventType tipo de evento
     */
    private void postEvent(int eventType) {
        postEvent(eventType, null);
    }
}
