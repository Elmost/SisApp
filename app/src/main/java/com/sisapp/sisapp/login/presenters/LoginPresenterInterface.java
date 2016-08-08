package com.sisapp.sisapp.login.presenters;

/**
 * Created by Elmost on 5/08/2016.
 */
public interface LoginPresenterInterface {

    void onCreate();

    void onDestroy();

    void checkForAuthenticatedUser();

    //void onEventMainThread(LoginEvent event);

    void validateLogin(String email, String password);

    void registerNewUser(String email, String password);
}
