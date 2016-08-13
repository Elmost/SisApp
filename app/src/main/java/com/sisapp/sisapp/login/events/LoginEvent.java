package com.sisapp.sisapp.login.events;

/**
 * Eventos relacionados en el login.
 * <p>
 * Created by Elmost on 5/08/2016.
 */
public class LoginEvent {

    // Código constante de error al iniciar sesión con usuario de SisApp.
    public final static int onSignInSisAppError = 101;
    // Mensaje constante de error al iniciar sesión con usuario de SisApp.
    public final static String showMessageSignInSisAppError = "Ocurrió un error al iniciar sesion en SisApp, por favor verifique sus credenciales.";

    // Código constante de éxito al iniciar sesión con usuario de SisApp.
    public final static int onSignInSisAppSuccess = 102;

    // Código constante de inicio de sesión con Google.
    public final static int onSignInGoogle = 200;
    // Código constante de error al iniciar sesión con usuario de Google.
    public final static int onSignInGoogleError = 201;
    // Mensaje constante de error al iniciar sesión con usuario de Google.
    public final static String showMessageSignInGoogle = "Ocurrió un error al iniciar sesion con Google, por favor verifique su cuenta de Google.";
    // Código constante de éxito al iniciar sesión con usuario de Google.
    public final static int onSignInGoogleSuccess = 202;

    // Código constante de error al registrarse en SisApp.
    public final static int onSignUpSisAppError = 301;
    // Mensaje constante de error al iniciar sesión con usuario de Google.
    public final static String showMessageSignUpSisAppError = "Ocurrió un error al registrarse, por favor intentelo de nuevo.";
    // Código constante de éxito al registrarse en SisApp.
    public final static int onSignUpSisAppSuccess = 302;

    // Código constante de falla al intentar recuperar la sesión del usuario
    public final static int onFailedToRecoverSession = 401;
    // Mensaje constante de fallo de recuperación de sesión.l
    public final static String showMessageFailedToRecoverSession = "Por favor, iniciar sesión";

    private int eventType;
    private String message;

    public LoginEvent() {
    }

    public final int getEventType() {
        return eventType;
    }

    public void setEventType(final int eventType) {
        this.eventType = eventType;
    }

    public final String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}
