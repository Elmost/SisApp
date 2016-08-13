package com.sisapp.sisapp.login.repositories;

/**
 * Created by Elmost on 9/08/2016.
 */
public interface LoginRepository {

    /**
     * Iniciar sesión con SisApp.
     *
     * @param email    correo electrónico
     * @param password contraseña
     */
    void signInSisApp(final String email, final String password);

    /**
     * Registrarse con SisApp.
     *
     * @param email    correo electrónico
     * @param password contraseña
     */
    void signUpSisApp(final String email, final String password);

    /**
     * Iniciar sesión con google.
     */
    void signInGoogle();

    /**
     * comprobar que ha sido autenticado.
     */
    void checkAlreadyAuthenticated();
}
