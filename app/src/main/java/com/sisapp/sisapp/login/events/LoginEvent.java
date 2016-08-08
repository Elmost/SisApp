package com.sisapp.sisapp.login.events;

/**
 * Created by Elmost on 5/08/2016.
 */
public class LoginEvent {

    /**
     * Inicio de sesión con SisApp.
     */
    public final static int onSignInSisAppError = 101;
    public final static int onSignInSisAppSuccess = 102;

    /**
     * Inicio de sesión con Google.
     */
    public final static int onSignInGoogleError = 201;
    public final static int onSignInGoogleSuccess = 202;

    /**
     * Crear cuenta de usuario en SisApp.
     */
    public final static int onCreateUserSisAppError = 301;
    public final static int onCreateUserSisAppSuccess = 302;

    /**
     * Recuperar sesión de usuario en SisApp.
     */
    public final static int onFailedToRecoverSessionSisApp = 401;
    public final static int onSuccessToRecoverSessionSisApp = 402;

    /**
     * Recuperar sesión de usuario en Google.
     */
    public final static int onFailedToRecoverSessionGoogle = 501;
    public final static int onSuccessToRecoverSessionGoogle = 502;

    /**
     * Opcionales.
     */
    public final static int onSignInError = 0;
    public final static int onSignUpError = 1;
    public final static int onSignInSuccess = 2;
    public final static int onSignUpSuccess = 3;
    public final static int onFailedToRecoverSession = 4;

    private int eventType;
    private String errorMesage;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getErrorMesage() {
        return errorMesage;
    }

    public void setErrorMesage(String errorMesage) {
        this.errorMesage = errorMesage;
    }
}
