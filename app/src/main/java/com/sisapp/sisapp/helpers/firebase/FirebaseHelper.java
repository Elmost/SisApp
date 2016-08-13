package com.sisapp.sisapp.helpers.firebase;

import com.google.firebase.database.DatabaseReference;
import com.sisapp.sisapp.pojos.User;

/**
 * Created by Elmost on 9/08/2016.
 */
public interface FirebaseHelper {

    String PUNTO = ".";
    String GUIONBAJO = "_";
    String USERS_PATH = "users";
    String APPCONFIG_PATH = "appconfig";

    /**
     * Obtener mi correo electrónico de autenticación.
     *
     * @return email mi correo electrónico de autenticación
     */
    String getMyEmailAuth();

    /**
     * Obtener referencia de usuario.
     *
     * @return DatabaseReference
     */
    DatabaseReference getUserReference(final String email);

    /**
     * Obtener mi referencia de usuario.
     *
     * @return DatabaseReference
     */
    DatabaseReference getMyUserReference();

    /**
     * Cambiar estado del usuario a conectado (Online).
     */
    void changeUserStatusToOnline();

    /**
     * Cambiar estado del usuario a desconectado (Offline).
     */
    void changeUserStatusToOffline();

    /**
     * Notificar cambio de estado.
     *
     * @param status  nuevo estado de usuario puede ser ONLINE o OFFLINE
     * @param signoff true para cerrar la sesión, en caso contrario false.
     */
    void notifyOfConnectionChange(final Boolean status, final Boolean signoff);

    /**
     * Para cerrar la sesión.
     */
    void signOff();


}
