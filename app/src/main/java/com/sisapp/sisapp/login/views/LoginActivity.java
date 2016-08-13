package com.sisapp.sisapp.login.views;

import com.sisapp.sisapp.login.views.LoginActivityImpl;

/**
 * Interface {@link LoginActivityImpl}
 * Created by Elmost on 5/08/2016.
 */
public interface LoginActivity {

    Boolean ENABLE = true;
    Boolean DISABLE = false;

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
     * Encargarse del registro en SisApp.
     */
    void handleSignUpSisApp();

    /**
     * Encargarce del inicio de sesión en SisApp.
     */
    void handleSignInSisApp();

    /**
     * Encargarce del inicio de sesión con google.
     */
    void handleSignInGoogle();

    /**
     * en caso de error.
     *
     * @param error
     */
    void onError(String error);

    /**
     * en caso de éxito.
     */
    void onSucces();


}
