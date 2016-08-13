package com.sisapp.sisapp.login.interactors;

import com.sisapp.sisapp.login.repositories.LoginRepositoryImpl;
import com.sisapp.sisapp.login.repositories.LoginRepository;

/**
 * Created by Elmost on 9/08/2016.
 */
public class LoginInteractorImpl implements LoginInteractor {

    private LoginRepository mLoginRepository = null;

    public LoginInteractorImpl() {
        this.mLoginRepository = new LoginRepositoryImpl();
    }

    @Override
    public void doCheckAlreadyAuthenticated() {
        this.mLoginRepository.checkAlreadyAuthenticated();
    }

    @Override
    public void doSignUpSisApp(final String email, final String password) {
        this.mLoginRepository.signUpSisApp(email, password);
    }

    @Override
    public void doSignInSisApp(final String email, final String password) {
        this.mLoginRepository.signInSisApp(email, password);
    }
}
