package com.sisapp.sisapp.helpers.firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sisapp.sisapp.app.SisAppApplication;
import com.sisapp.sisapp.pojos.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Elmost on 9/08/2016.
 */
public class FirebaseHelperImpl implements FirebaseHelper {

    private DatabaseReference mDatabaseReference;

    private static class SingletonHolder {
        private static final FirebaseHelperImpl INSTANCE = new FirebaseHelperImpl();
    }

    public static FirebaseHelperImpl getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public FirebaseHelperImpl() {
        this.mDatabaseReference = FirebaseDatabase.getInstance().getReference();
    }

    /**
     * Obtener mi correo electrónico de autenticación.
     *
     * @return email mi correo electrónico de autenticación
     */
    @Override
    public String getMyEmailAuth() {
        FirebaseUser mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String email = null;
        if (mFirebaseUser != null) {
            email = mFirebaseUser.getEmail();
        }
        return email;
    }

    /**
     * Obtener referencia de usuario.
     *
     * @param email
     * @return DatabaseReference
     */
    @Override
    public DatabaseReference getUserReference(String email) {
        DatabaseReference databaseReference = null;
        if (email != null) {
            String emailKey = email.replace(PUNTO, GUIONBAJO);
            databaseReference = this.mDatabaseReference.getRoot().child(USERS_PATH).child(emailKey);
        }
        return databaseReference;
    }

    /**
     * Obtener mi referencia de usuario.
     *
     * @return DatabaseReference
     */
    @Override
    public DatabaseReference getMyUserReference() {
        return getUserReference(getMyEmailAuth());
    }

    /**
     * Cambiar estado del usuario a conectado (Online).
     */
    @Override
    public void changeUserStatusToOnline() {
        notifyOfConnectionChange(User.ONLINE, false);
    }

    /**
     * Cambiar estado del usuario a desconectado (Offline).
     */
    @Override
    public void changeUserStatusToOffline() {
        notifyOfConnectionChange(User.OFFLINE, false);
    }

    @Override
    public void notifyOfConnectionChange(final Boolean status, final Boolean signoff) {
        final String mEmail = getMyEmailAuth();
        if (getMyUserReference() != null) {
            Map<String, Object> updates = new HashMap<>();
            updates.put("online", status);
            getMyUserReference().updateChildren(updates);
            if (signoff) {
                FirebaseAuth.getInstance().signOut();
            }
        }

    }

    @Override
    public void signOff() {
        notifyOfConnectionChange(User.OFFLINE, true);
    }
}
