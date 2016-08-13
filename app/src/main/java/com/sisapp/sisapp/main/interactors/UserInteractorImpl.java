package com.sisapp.sisapp.main.interactors;

import com.sisapp.sisapp.main.repositories.MainRepository;
import com.sisapp.sisapp.main.repositories.MainRepositoryImpl;
import com.sisapp.sisapp.pojos.User;

/**
 * Created by Elmost on 13/08/2016.
 */
public class UserInteractorImpl implements UserInteractor {

    private MainRepository repository;

    public UserInteractorImpl() {
        this.repository = new MainRepositoryImpl();
    }

    @Override
    public void toSubscribeUserUpdates() {
        this.repository.toSubscribeUserUpdates();
    }

    @Override
    public void onUpdateUser(User user) {
        this.repository.onUpdateUser(user);
    }
}
