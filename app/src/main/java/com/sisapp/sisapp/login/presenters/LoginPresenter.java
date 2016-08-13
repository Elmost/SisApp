package com.sisapp.sisapp.login.presenters;


import com.sisapp.sisapp.login.events.LoginEvent;

/**
 * Created by Elmost on 5/08/2016.
 */
public interface LoginPresenter {

    /**
     * Iniciar proceso.
     */
    void onCreate();

    /**
     * Destruir proceso.
     */
    void onDestroy();

    /**
     * Para comprobar si hay usuario autenticado.
     */
    void toCheckForAuthenticatedUser();

    /**
     * @param event
     */
    void toReceiveEvents(LoginEvent event);

    /**
     * Para firmar en SisApp.
     *
     * @param email    correo electrónico
     * @param password contraseña
     */
    void toSignInSisApp(final String email, final String password);

    /**
     * Para inscribirse en SisApp.
     *
     * @param email    correo electrónico
     * @param password contraseña
     */
    void toSignUpSisApp(final String email, final String password);

    /**
     * Eventos de error.
     *
     * @param error error
     */
    void evetError(String error);

    /**
     * Eventos de éxito.
     */
    void eventSucces();
}
