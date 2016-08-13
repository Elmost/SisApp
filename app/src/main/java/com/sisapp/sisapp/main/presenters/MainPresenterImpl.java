package com.sisapp.sisapp.main.presenters;

import com.sisapp.sisapp.libs.eventbus.EventBus;
import com.sisapp.sisapp.libs.eventbus.GreenRobotEventBus;
import com.sisapp.sisapp.main.events.UserEvent;
import com.sisapp.sisapp.main.interactors.UserInteractor;
import com.sisapp.sisapp.main.interactors.UserInteractorImpl;
import com.sisapp.sisapp.main.views.MainActivity;
import com.sisapp.sisapp.pojos.User;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Elmost on 11/08/2016.
 */
public class MainPresenterImpl implements MainPresenter {

    private EventBus mEventBus;
    private MainActivity mActivity;
    private UserInteractor mUserInteractor;

    public MainPresenterImpl(MainActivity mainActivity) {
        this.mEventBus = GreenRobotEventBus.getInstance();
        this.mActivity = mainActivity;
        this.mUserInteractor = new UserInteractorImpl();
    }


    @Override
    public void onCreate() {
        mEventBus.register(this);
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onDestroy() {
        mEventBus.unregister(this);
        mActivity = null;
    }

    @Override
    public void signOff() {
    }

    @Override
    @Subscribe
    public void toReceiveEvents(UserEvent userEvent) {
        switch (userEvent.getEventType()) {
            case UserEvent.onUserUpdate:
                onUserUpdate(userEvent.getUser());
                break;
        }
    }

    @Override
    public void toSubscribeUserUpdates() {
        if (mActivity != null) {
            mUserInteractor.toSubscribeUserUpdates();
        }
    }

    @Override
    public void onUpdateUser(User user) {
        if (mActivity != null){
            mUserInteractor.onUpdateUser(user);
        }
    }

    private void onUserUpdate(User user) {
        if (mActivity != null) {
            mActivity.userUpdate(user);
        }
    }
}
