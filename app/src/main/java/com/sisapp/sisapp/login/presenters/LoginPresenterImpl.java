package com.sisapp.sisapp.login.presenters;

import com.sisapp.sisapp.libs.eventbus.EventBus;
import com.sisapp.sisapp.libs.eventbus.GreenRobotEventBus;
import com.sisapp.sisapp.login.events.LoginEvent;
import com.sisapp.sisapp.login.interactors.LoginInteractorImpl;
import com.sisapp.sisapp.login.interactors.LoginInteractor;
import com.sisapp.sisapp.login.views.LoginActivity;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Elmost on 5/08/2016.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private EventBus mEventBus;
    private LoginActivity mActivity;
    private LoginInteractor mInteractor;

    public LoginPresenterImpl(LoginActivity mLoginActivity) {
        this.mEventBus = GreenRobotEventBus.getInstance();
        this.mActivity = mLoginActivity;
        this.mInteractor = new LoginInteractorImpl();
    }


    @Override
    public void onCreate() {
        this.mEventBus.register(this);
    }

    @Override
    public void onDestroy() {
        mActivity = null;
        mEventBus.unregister(this);
    }

    @Override
    public void toCheckForAuthenticatedUser() {
        if (mActivity != null) {
            mActivity.disableInputs();
            mActivity.showProgress();
            mInteractor.doCheckAlreadyAuthenticated();
        }
    }

    @Override
    @Subscribe
    public void toReceiveEvents(LoginEvent event) {
        switch (event.getEventType()) {
            case LoginEvent.onSignInSisAppError:
                evetError(event.getMessage());
                break;
            case LoginEvent.onSignInSisAppSuccess:
                eventSucces();
                break;
            case LoginEvent.onSignUpSisAppError:
                evetError(event.getMessage());
                break;
            case LoginEvent.onSignUpSisAppSuccess:
                eventSucces();
                break;
            case LoginEvent.onFailedToRecoverSession:
                evetError(event.getMessage());
                break;
        }
    }

    @Override
    public void toSignInSisApp(final String email, final String password) {
        if (mActivity != null) {
            mActivity.disableInputs();
            mActivity.showProgress();
            mInteractor.doSignInSisApp(email, password);
        }
    }

    @Override
    public void toSignUpSisApp(final String email, final String password) {
        if (mActivity != null) {
            mActivity.disableInputs();
            mActivity.showProgress();
            mInteractor.doSignUpSisApp(email, password);
        }
    }

    @Override
    public void evetError(String error) {
        if (mActivity != null) {
            mActivity.hideProgress();
            mActivity.enableInputs();
            mActivity.onError(error);
        }
    }

    @Override
    public void eventSucces() {
        if (mActivity != null) {
            mActivity.hideProgress();
            mActivity.enableInputs();
            mActivity.onSucces();
        }
    }
}
