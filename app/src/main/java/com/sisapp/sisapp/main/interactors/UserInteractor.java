package com.sisapp.sisapp.main.interactors;

import com.sisapp.sisapp.pojos.User;

/**
 * Created by Elmost on 13/08/2016.
 */
public interface UserInteractor {

    void toSubscribeUserUpdates();

    void onUpdateUser(User user);
}
