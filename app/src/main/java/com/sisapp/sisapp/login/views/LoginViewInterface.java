package com.sisapp.sisapp.login.views;

/**
 * Interface {@link LoginActivity}
 * Created by Elmost on 5/08/2016.
 */
public interface LoginViewInterface {

    /**
     * Habilitar de entradas.
     */
    void enableInputs();

    /**
     * Desactivar las entradas.
     */
    void disableInputs();

    /**
     * Mostrar barra de progreso.
     */
    void showProgress();

    /**
     * Ocultar barra de progreso.
     */
    void hideProgress();

    /**
     * Encargarse del registro.
     */
    void handleSignUp();

    /**
     * Encargarce del inicio de sesión.
     */
    void handleSignIn();

    /**
     * Encargarce del inicio de sesión con google.
     */
    void handleSignInGoogle();

    /**
     * Ir a la pantalla principal.
     */
    void goToMainScreen();

    /**
     * Encargarce de los errores.
     *
     * @param error mensaje de error
     */
    void handleErrors(String error);

    /**
     * Encargarce de los exitos.
     */
    void handleSuccess();
}
