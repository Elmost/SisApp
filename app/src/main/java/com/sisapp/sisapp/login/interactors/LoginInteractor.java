package com.sisapp.sisapp.login.interactors;

/**
 * Created by Elmost on 9/08/2016.
 */
public interface LoginInteractor {

    void doCheckAlreadyAuthenticated();

    void doSignUpSisApp(final String email, final String password);

    void doSignInSisApp(final String email, final String password);
}
